package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        return arregloEnteros.clone();
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        return arregloCadenas.clone();
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }	

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        int[] nuevo = new int[arregloEnteros.length + 1];
        for (int i = 0; i < arregloEnteros.length; i++) {
            nuevo[i] = arregloEnteros[i];
        }
        nuevo[nuevo.length - 1] = entero;
        this.arregloEnteros = nuevo;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
        String[] nuevo = new String[arregloCadenas.length + 1];
        for (int i = 0; i < arregloCadenas.length; i++) {
            nuevo[i] = arregloCadenas[i];
        }
        nuevo[nuevo.length - 1] = cadena;
        this.arregloCadenas = nuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        int cont = 0;
        // 1. Contamos cuántos elementos NO son el valor
        for( int i : arregloEnteros )
        {
            if( i != valor ) cont++;
        }
        
        // 2. Nuevo arreglo con el tamaño justo
        int[] nuevo = new int[cont];
        int posicion = 0;
        
        // 3. Solo pasamos los que NO queremos eliminar
        for( int i : arregloEnteros )
        {
            if( i != valor )
            {
                nuevo[posicion] = i;
                posicion++;
            }
        }
        this.arregloEnteros = nuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        // 1. Contar cuántas cadenas son diferentes a la recibida
        int contador = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (!arregloCadenas[i].equals(cadena)) {
                contador++;
            }
        }

        // 2. Crear el nuevo arreglo con el tamaño justo
        String[] nuevoArreglo = new String[contador];
        int j = 0;

        // 3. Pasar solo las que queremos conservar
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (!arregloCadenas[i].equals(cadena)) {
                nuevoArreglo[j] = arregloCadenas[i];
                j++;
            }
        }
        this.arregloCadenas = nuevoArreglo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
        // Ajustar la posición según las reglas del enunciado
        if (posicion < 0) posicion = 0;
        if (posicion > arregloEnteros.length) posicion = arregloEnteros.length;

        int[] nuevo = new int[arregloEnteros.length + 1];
        
        // Copiar los elementos antes de la posición de inserción
        for (int i = 0; i < posicion; i++) {
            nuevo[i] = arregloEnteros[i];
        }
        
        // Insertar el nuevo valor
        nuevo[posicion] = entero;
        
        // Copiar el resto desplazándolos una posición a la derecha
        for (int i = posicion; i < arregloEnteros.length; i++) {
            nuevo[i + 1] = arregloEnteros[i];
        }
        
        this.arregloEnteros = nuevo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        // Solo actuamos si la posición es válida
        if (posicion >= 0 && posicion < arregloEnteros.length) 
        {
            int[] nuevo = new int[arregloEnteros.length - 1];
            int j = 0;
            for (int i = 0; i < arregloEnteros.length; i++) {
                if (i != posicion) {
                    nuevo[j++] = arregloEnteros[i];
                }
            }
            this.arregloEnteros = nuevo;
        }
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
        this.arregloEnteros = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            this.arregloEnteros[i] = (int) valores[i]; // Esto trunca el decimal
        }
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
        this.arregloCadenas = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            this.arregloCadenas[i] = objetos[i].toString();
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] = arregloEnteros[i] * -1;
            }
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
        int n = arregloEnteros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Si el de la izquierda es mayor al de la derecha, se intercambian
                if (arregloEnteros[j] > arregloEnteros[j + 1]) {
                    int temp = arregloEnteros[j];
                    arregloEnteros[j] = arregloEnteros[j + 1];
                    arregloEnteros[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
        int n = arregloCadenas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // compareTo devuelve > 0 si la cadena es mayor lexicográficamente
                if (arregloCadenas[j].compareTo(arregloCadenas[j + 1]) > 0) {
                    String temp = arregloCadenas[j];
                    arregloCadenas[j] = arregloCadenas[j + 1];
                    arregloCadenas[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int cont = 0;
        for( int i : arregloEnteros )
        {
            if( i == valor ) cont++;
        }
        return cont;
    }
    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int cont = 0;
        for( String s : arregloCadenas )
        {
            if( s.equalsIgnoreCase( cadena ) ) cont++;
        }
        return cont;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
        // 1. Primero contamos cuántas veces aparece para saber el tamaño del nuevo arreglo
        int cantidad = contarApariciones( valor );
        
        // 2. Creamos el arreglo de posiciones
        int[] posiciones = new int[cantidad];
        int j = 0;
        
        // 3. Recorremos el original y guardamos el índice (i) cuando coincida
        for( int i = 0; i < arregloEnteros.length; i++ )
        {
            if( arregloEnteros[i] == valor )
            {
                posiciones[j] = i;
                j++;
            }
        }
        return posiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
        if( arregloEnteros.length == 0 ) return new int[]{};

        int minimo = arregloEnteros[0];
        int maximo = arregloEnteros[0];

        for( int i = 1; i < arregloEnteros.length; i++ )
        {
            if( arregloEnteros[i] < minimo ) minimo = arregloEnteros[i];
            if( arregloEnteros[i] > maximo ) maximo = arregloEnteros[i];
        }

        return new int[]{ minimo, maximo };
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        HashMap<Integer, Integer> histograma = new HashMap<>();
        for( int i : arregloEnteros )
        {
            if( histograma.containsKey( i ) )
            {
                histograma.put( i, histograma.get( i ) + 1 );
            }
            else
            {
                histograma.put( i, 1 );
            }
        }
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        HashMap<Integer, Integer> histograma = calcularHistograma();
        int repetidos = 0;
        for( int conteo : histograma.values() )
        {
            if( conteo > 1 ) repetidos++;
        }
        return repetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        // 1. Si los tamaños son diferentes, no pueden ser iguales
        if( this.arregloEnteros.length != otroArreglo.length ) return false;

        // 2. Comparamos posición por posición
        for( int i = 0; i < arregloEnteros.length; i++ )
        {
            if( this.arregloEnteros[i] != otroArreglo[i] ) return false;
        }

        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        if( this.arregloEnteros.length != otroArreglo.length ) return false;

        // Creamos copias para no alterar los originales al ordenar
        int[] copia1 = this.arregloEnteros.clone();
        int[] copia2 = otroArreglo.clone();

        // Los ordenamos (puedes usar Arrays.sort para simplificar aquí)
        java.util.Arrays.sort(copia1);
        java.util.Arrays.sort(copia2);

        for( int i = 0; i < copia1.length; i++ )
        {
            if( copia1[i] != copia2[i] ) return false;
        }
        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        // 1. Creamos el arreglo con la cantidad solicitada
        this.arregloEnteros = new int[cantidad];
        
        // 2. Llenamos cada posición con un número aleatorio en el rango
        for( int i = 0; i < cantidad; i++ )
        {
            // Fórmula: (random * (max - min + 1)) + min
            int aleatorio = (int) ( Math.random( ) * ( maximo - minimo + 1 ) ) + minimo;
            this.arregloEnteros[ i ] = aleatorio;
        }
    }

}
