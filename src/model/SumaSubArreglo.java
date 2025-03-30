package model;

import structures.TablaHash;

public class SumaSubArreglo {
    private TablaHash<Integer, Integer> tablaHash;

    public SumaSubArreglo(int capacidad) {
        tablaHash = new TablaHash<>(capacidad);
    }


    public int[] encontrarSubArregloConSuma(int[] nums, int sumaObjetivo) {
        tablaHash.clear(); // Limpiamos la tabla hash antes de comenzar
        int sumaParcial = 0;
        // Recorrer todos los elementos del arreglo
        for (int i = 0; i < nums.length; i++) {
            sumaParcial += nums[i];
            if (sumaParcial == sumaObjetivo) { // Si la suma parcial es igual a la suma objetivo, devolver el subarreglo desde el inicio hasta el índice actual
                return new int[]{0, i};
            }
            int complemento = sumaParcial - sumaObjetivo; // se calcula el complemento necesario para alcanzar la suma objetivo
            // Buscamos el complemento en la tabla hash
            Integer indice = tablaHash.get(complemento);
            // Si se encuentra el complemento, se devuelve el subarreglo desde el índice siguiente al complemento hasta el índice actual
            if (indice != null) {
                return new int[]{indice + 1, i};
            }
            tablaHash.add(sumaParcial, i);// Agregar la suma parcial actual a la tabla hash con su índice correspondiente
        }
        // Si no se encuentra ningún subarreglo que cumpla con la suma objetivo, devolver [-1, -1]
        return new int[]{-1, -1};
    }
}