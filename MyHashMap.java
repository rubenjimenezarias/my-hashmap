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
    public int put(String clave, int valor)
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
                contenidos[cont] = valor;
                encontrado = true;
            }
            cont++;
        }
        if (!encontrado)
        {
            claves.add(clave);
            contenidos[claves.size()-1]= valor;
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
    
    /**
     * Devuelve un boolean dependiendo si la lista esta llena o vacia
     */
    public boolean isEmpty()
    {
        return (claves.size() == 0);
    }
    
    /**
     * Devuelve el numero de elementos de la lista
     */
    public int size()
    {
        return claves.size();
    }
    
    /**
     * Borra un elemento con la clave que indiquemos y devuelve su valor
     * Si no hay ese elemento devuelve -1
     */
    public int remove(String clave)
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
                //Indicamos lo que vamos a devolver
                devolver = contenidos[cont];
                //Ya hemos encontrado lo que tenemos que borrar y queremos salir del bucle
                encontrado = true;
                //Borramos clave de la arraylist claves
                claves.remove(cont);
                //Borramos contenido de la array contenidos
                int nuevocont = 0;
                int[] nuevalista = new int[contenidos.length - 1];
                boolean borrado = false;
                while (nuevocont < cont)
                {
                    nuevalista[nuevocont] = contenidos[nuevocont];
                    nuevocont++;
                }
                while (nuevocont < nuevalista.length)
                {
                    nuevalista[nuevocont]=contenidos[nuevocont+1];
                    nuevocont++;
                }
                contenidos = nuevalista;
            }
            cont++;
        }
        return devolver;
    }
    
    /**
     * Vacia las dos listas.
     */
    public void clear()
    {
        claves.removeAll(claves);
        contenidos = new int[999999];
    }
    
    /**
     * Devuelve true o false segun si contiene la clave que le indicamos
     * @clave String clave del contenido
     */
    public boolean containsKey(String clave)
    {
        boolean devolver = false;
        int cont = 0;
        String elemento = null;
        boolean encontrado = false;
        while (cont < claves.size() && !encontrado)
        {
            elemento = claves.get(cont);
            if (elemento == clave)
            {
                encontrado = true;
                devolver = true;
            }
            cont++;
        }
        return devolver;
    }
    
    /**
     * Devuelve true o false segun si la lista contine el contenidos que le indicamos
     * @contenido int contenido de la clave
     */
    public boolean containsValue(int valor)
    {
        boolean devolver = false;
        int cont = 0;
        boolean encontrado = false;
        while (cont < claves.size() && !encontrado)
        {
            if (valor == contenidos[cont])
            {
                encontrado = true;
                devolver = true;
            }
            cont++;
        }
        return devolver;
    }
}
