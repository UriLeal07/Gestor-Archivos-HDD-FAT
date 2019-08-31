package Modelo;

import java.io.File;

public class Archivo
{
    private File archivo;
    private String nombre;
    private String contenido;
    private int[] bloques;
    
    public Archivo(File archivo, String contenido)
    {
        this.archivo = archivo;
        this.nombre = archivo.getName();
        this.contenido = contenido;
        bloques = null;
    }
    
    public File getFile() {return archivo;}
    public String getContenido() {return contenido;}
    
    public void setNumBloques(int[] bloques){
        this.bloques=bloques;
    }

    public int[] getBloques() {
        return bloques;
    }
    
    public String getNombre(){ return nombre; }
}