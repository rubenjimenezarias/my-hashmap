import java.util.ArrayList;

/**
 * Write a description of class MyHashMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyHashMap
{
    // instance variables - replace the example below with your own
    private ArrayList<String> claves;
    private int[] contenidos;

    /**
     * Constructor for objects of class MyHashMap
     */
    public MyHashMap()
    {
        claves = new ArrayList<String>();
        contenidos = new int[999999];
    }

    /**
     * Asociamos una clave con un contenido a la siguiente posicion
     * 
     * @clave String de la clave
     * @contenido int 
     */
    public int put(String clave, int contenido)
    {
        int devolver = -1;
        int cont = 0;
        String elemento = null;
        boolean encontrado = false;
        while (cont < claves.size() && !encontrado)
        {
            elemento = claves.get(cont);
            if (elemento == clave)
            {
                devolver = contenidos[cont];
                claves.set(cont, clave);
                contenidos[cont] = contenido;
                encontrado = true;
            }
            cont++;
        }
        if (!encontrado)
        {
            claves.add(clave);
            contenidos[claves.size()-1]= contenido;
        }
        return devolver;
    }
    
    /**
     * Devuelve el contenido de la clave que indiquemos
     * @clave String clave del contenido
     */
    public int get(String clave)
    {
        int devolver = -1;
        int cont = 0;
        String elemento = null;
        boolean encontrado = false;
        while (cont < claves.size() && !encontrado)
        {
            elemento = claves.get(cont);
            if (elemento == clave)
            {
                devolver = contenidos[cont];
                encontrado = true;
            }
            cont++;
        }
        return devolver;
    }
}