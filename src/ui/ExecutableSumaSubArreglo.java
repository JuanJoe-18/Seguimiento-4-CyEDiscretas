package ui;

import java.util.Scanner;
import model.SumaSubArreglo;

public class ExecutableSumaSubArreglo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo de lo numeros: ");
        int tamanio = scanner.nextInt();
        int[] nums= new int[tamanio];

        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < tamanio; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Ingrese la suma objetivo S: ");
        int sum = scanner.nextInt();

        SumaSubArreglo sumArreglo = new SumaSubArreglo(tamanio);
        int[] result= sumArreglo.encontrarSubArregloConSuma(nums, sum);

        System.out.println("(" + result[0] + ", " + result[1] + ")");

    }
}
