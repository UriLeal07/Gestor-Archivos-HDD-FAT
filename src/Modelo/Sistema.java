package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Sistema
{
    private int numArchivosEnDisco;
    private ArrayList<Archivo> archivos;
    private FAT tablaFAT;
    private DiscoDuro HDD;
    private final File directorioRaiz;
    private final int maxArchivos, tamMax;;
    
    public Sistema()
    {
        archivos = new ArrayList <>();
        numArchivosEnDisco = 0;
        tablaFAT = new FAT();
        HDD = new DiscoDuro();
        directorioRaiz = new File("src/Raiz");
        directorioRaiz.mkdirs();
        maxArchivos = 10;
        tamMax = 100;
    }
    
    public boolean agregarArchivo(Archivo nuevo)
    {
        if(numArchivosEnDisco < maxArchivos)
        {
            if(escribirArchivo(nuevo))
            {
                archivos.add(nuevo);
                numArchivosEnDisco++;
                return true;
            }
        }
        
        else
            JOptionPane.showMessageDialog(null,
                "Numero maximo de archivos excedido.\nElimine uno o mas archivos para liberar espacio.",
                "Error", JOptionPane.WARNING_MESSAGE);
        
        return false;
    }
    
    private boolean escribirArchivo(Archivo nuevo)
    {
        try
        (
            FileWriter fw = new FileWriter(nuevo.getFile().getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter p = new PrintWriter(bw)
        )
        {
            // Separamos el contenido del archivo en palabras
            String palabras[] = separaPalabras(nuevo.getContenido());
            
            //Validamos que el número de palabras esté entre 3 y 10
            if(palabras.length >= 3 && palabras.length <= 10)
            {
                //Verificamos si tenemos bloques libres suficientes en FAT
                if(tablaFAT.getBloquesFree() < palabras.length)
                    JOptionPane.showMessageDialog(null, "No hay suficiente espacio en disco para almacenar el archivo", "Espacio Insuficiente", JOptionPane.WARNING_MESSAGE);
                
                // Procedemos a insertar las palabras en el HDD
                else
                {
                    int bloquesOcupados[] = new int[palabras.length];
                    int palabrasInsertadas = 0;
                    int k = 0, i;
                                        
                    for(i=0; i<tamMax; i++)
                    {
                        if(palabrasInsertadas < palabras.length)
                        {
                            // Si tenemos un espacio libre en la pos i
                            if(tablaFAT.existeBloqueLibre(i))
                            {
                                // Insertamos la palabra en el disco duro
                                HDD.agregarAlDisco(palabras[palabrasInsertadas++], i);
                                // Guardamos la posicion que se ocupo del disco duro
                                bloquesOcupados[k++] = i;
                                //Actualizamos el contador de bloques libres en FAT
                                tablaFAT.setBloquesFree(tablaFAT.getBloquesFree()-1);
                            }
                        }
                        
                        // Terminamos de insertar todas las palabras del archivo en los bloques libres
                        else 
                            break;
                    }
                    
                    // Llenamos la tabla FAT con los bloques ocupados.
                    for(i = 0; i < bloquesOcupados.length-1; i++)
                        tablaFAT.setBloques(bloquesOcupados[i], bloquesOcupados[i+1]);
                    
                    // Ponemos la leyenda EOF para el ultimo bloque que ocupa el archivo
                    tablaFAT.setBloques(bloquesOcupados[bloquesOcupados.length-1], "EOF");
                    //Actualizamos el atributo bloquesOcupados del nuevo Archivo
                    nuevo.setNumBloques(bloquesOcupados);
                    // Escribimos al archivo
                    p.printf(nuevo.getContenido());
                    
                    return true;
                }
            }
            
            else
                JOptionPane.showMessageDialog(null, 
                    "El archivo excede los limites de palabras.\n*# Palabras min=3\n*# Palabras max=10",
                    "Limite de palabras excedido", JOptionPane.WARNING_MESSAGE);
        }
        catch(IOException e) { JOptionPane.showMessageDialog(null, "El archivo no se cerro correctamente", "Error de I/O", JOptionPane.ERROR_MESSAGE); }
        
        return false;
    }
    
    public String leerFile(File archivo)
    {
        String contenido = "";
        int i;
        
        for(i = 0; i < numArchivosEnDisco; i++)
            if(archivos.get(i).getNombre().equals(archivo.getName()))
                break;
        
	try
	(
            FileReader fw = new FileReader(archivo.getAbsoluteFile());
            BufferedReader bw = new BufferedReader(fw)
	)
	{
            String linea;
            
            while((linea = bw.readLine()) != null)
		contenido += linea;
	}
	catch(IOException e) { JOptionPane.showMessageDialog(null, "El archivo no se cerro correctamente", "Error de I/O", JOptionPane.ERROR_MESSAGE); }
        
        return contenido;
    }
    
    public boolean eliminarFile(File archivo)
    {
        int k = 0;
        
        for(int i = 0; i < numArchivosEnDisco; i++)
        {
            if(archivos.get(i).getNombre().equals(archivo.getName()))
            {
                while(k < archivos.get(i).getBloques().length)
                {
                    tablaFAT.free(archivos.get(i).getBloques()[k]);
                    HDD.agregarAlDisco("", archivos.get(i).getBloques()[k++]);
                }
                
                archivos.remove(i);
                numArchivosEnDisco--;
                
                if(!archivo.delete())
                    JOptionPane.showMessageDialog(null, "El archivo no se elimino",
                                                "Error de Archivo", JOptionPane.ERROR_MESSAGE);
                
                return true;
            }
        }
        
        return false;       
    }
    
    public boolean modificarArchivo(Archivo archivo)
    {
        String palabras[];
        
        for(int i = 0; i < numArchivosEnDisco; i++)
        {
            if(archivos.get(i).getNombre().equals(archivo.getNombre()))
            {
                palabras = separaPalabras(archivo.getContenido());
                int bloquesLibres = tablaFAT.getBloquesFree()-archivos.get(i).getBloques().length;
                
                if(bloquesLibres > palabras.length)
                {
                    if(eliminarFile(archivos.get(i).getFile()))
                    {
                        if(agregarArchivo(archivo))
                            return true;
                        
                        else
                            JOptionPane.showMessageDialog(null, "El archivo no se modifico.",
                                                "Error de Archivo", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else
                        JOptionPane.showMessageDialog(null, "El archivo no se modifico.",
                                                "Error de Archivo", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        return false;
    }
    
    private String[] separaPalabras(String contenido)
    {
        StringTokenizer tokens = new StringTokenizer(contenido, "\n");
        int i = 0;
        String cadena = "";
        
        while(tokens.hasMoreTokens())
        {
            if(i < tokens.countTokens()-1)
                cadena += tokens.nextToken()+" ";
            
            else
                cadena += tokens.nextToken();
        }
        
        StringTokenizer tokens2 = new StringTokenizer(cadena, " ");
        String palabras[] = new String[tokens2.countTokens()];
        i = 0;
    
        while(tokens2.hasMoreTokens())
            palabras[i++] = tokens2.nextToken();
        
        
        return palabras;
    }
    
    public boolean existeArchivo(String nombre)
    {
        for(Archivo actual : archivos)
            if(actual.getNombre().equals(nombre))
                return true;
        
        return false;
    }

    public void setArchivos(ArrayList<Archivo> archivos) { this.archivos = archivos; }
    
    public ArrayList<Archivo> getArchivos() { return archivos; }
    public File getFile(String nombre)
    {
        for(Archivo actual : archivos)
            if(actual.getNombre().equals(nombre))
                return actual.getFile();
        
        return null;
    }
    public int getNumArchivosEnDisco() { return numArchivosEnDisco; }
    public File getDirectorioRaiz() { return directorioRaiz; }
    public int getTamMax () { return tamMax; }
    public FAT getFAT() { return tablaFAT; }
    public DiscoDuro getHDD() { return HDD; }
}
