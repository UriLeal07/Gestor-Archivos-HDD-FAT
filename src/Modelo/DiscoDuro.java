package Modelo;

import java.util.ArrayList;

public class DiscoDuro
{
    private ArrayList<Object> bloques;
    
    public DiscoDuro()
    {
        bloques = new ArrayList<>();
        
        for(int i = 0; i < 100; i++)
            bloques.add(i, "");
    }
    
    public void agregarAlDisco(String palabra, int pos)
    {
        bloques.remove(pos);
        bloques.add(pos, palabra);
    }
    
    public ArrayList<Object> getBloques() { return bloques; }
}