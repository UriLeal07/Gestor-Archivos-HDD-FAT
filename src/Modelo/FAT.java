package Modelo;

import java.util.ArrayList;

public class FAT
{
    private int bloquesFree;
    private ArrayList<Object> bloques;
    
    public FAT()
    {
        bloques = new ArrayList<>();
        bloquesFree = 100;
        //Ponemos todos los bloques libres por default
        for(int i = 0; i < 100; i++)
            bloques.add("FREE");
    }
    
    public boolean existeBloqueLibre(int x) { return (bloques.get(x).equals("FREE")); }
    
    public int getBloquesFree(){ return bloquesFree;  }
    public ArrayList<Object> getBloques() { return bloques; }
    
    public void setBloquesFree(int bloquesFree){ this.bloquesFree = bloquesFree; }
    
    public void setBloques(int pos, Object valor)
    {
        bloques.remove(pos);
        bloques.add(pos, valor);
    }
    
    public void free(int pos)
    {
        bloques.remove(pos);
        bloques.add(pos, "FREE");
    }
    
    public void eof(int pos)
    {
        bloques.remove(pos);
        bloques.add(pos, "EOF");
    }
}