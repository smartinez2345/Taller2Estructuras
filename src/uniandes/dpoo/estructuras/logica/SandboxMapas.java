package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        List<String> valores = new java.util.ArrayList<>(mapaCadenas.values());
        java.util.Collections.sort(valores);
        return valores;
    }

    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> llaves = new java.util.ArrayList<>(mapaCadenas.keySet());
        java.util.Collections.sort(llaves, java.util.Collections.reverseOrder());
        return llaves;
    }

    public String getPrimera( )
    {
        if (mapaCadenas.isEmpty()) return null;
        List<String> llaves = new java.util.ArrayList<>(mapaCadenas.keySet());
        java.util.Collections.sort(llaves);
        return llaves.get(0);
    }

    public String getUltima( )
    {
        if (mapaCadenas.isEmpty()) return null;
        List<String> valores = new java.util.ArrayList<>(mapaCadenas.values());
        java.util.Collections.sort(valores);
        return valores.get(valores.size() - 1);
    }
    
    public Collection<String> getLlaves( )
    {
        List<String> mayusculas = new java.util.ArrayList<>();
        for (String llave : mapaCadenas.keySet()) {
            mayusculas.add(llave.toUpperCase());
        }
        return mayusculas;
    }

    public int getCantidadCadenasDiferentes( )
    {
        java.util.Set<String> valoresUnicos = new java.util.HashSet<>(mapaCadenas.values());
        return valoresUnicos.size();
    }
    
    public void agregarCadena( String cadena )
    {
        StringBuilder sb = new StringBuilder(cadena);
        String llave = sb.reverse().toString();
        mapaCadenas.put(llave, cadena);
    }

    public void eliminarCadenaConLLave( String llave )
    {
        mapaCadenas.remove(llave);
    }

    public void eliminarCadenaConValor( String valor )
    {
        // Buscamos la llave asociada a ese valor para borrarla
        StringBuilder sb = new StringBuilder(valor);
        String llave = sb.reverse().toString();
        mapaCadenas.remove(llave);
    }
    
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();
        for (Object obj : objetos) {
            agregarCadena(obj.toString());
        }
    }

    public void volverMayusculas( )
    {
        Map<String, String> nuevoMapa = new HashMap<>();
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
            nuevoMapa.put(entry.getKey().toUpperCase(), entry.getValue());
        }
        this.mapaCadenas = nuevoMapa;
    }

    public boolean compararValores( String[] otroArreglo )
    {
        Collection<String> valores = mapaCadenas.values();
        for (String s : otroArreglo) {
            if (!valores.contains(s)) return false;
        }
        return true;
    }

}
