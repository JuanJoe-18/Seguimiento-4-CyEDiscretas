### **Tabla de costos:**

| Línea | Código                                           | Veces que se ejecuta |
| ------ | ------------------------------------------------- | -------------------- |
| 1      | `tablaHash.clear();`                            | 1                    |
| 2      | `int sumaParcial = 0;`                          | 1                    |
| 3      | `for (int i = 0; i < nums.length; i++) {`       | n + 1                |
| 4      | `sumaParcial += nums[i];`                       | n                    |
| 5      | `if (sumaParcial == sumaObjetivo) {`            | n                    |
| 6      | `return new int[]{0, i};`                       | ≤ 1                 |
| 7      | `int complemento = sumaParcial - sumaObjetivo;` | n                    |
| 8      | `Integer indice = tablaHash.get(complemento);`  | n                    |
| 9      | `if (indice != null) {`                         | n                    |
| 10     | `return new int[]{indice + 1, i};`              | ≤ 1                 |
| 11     | `tablaHash.add(sumaParcial, i);`                | n                    |
| 12     | `return new int[]{-1, -1};`                     | 1                    |

$T_n = 1 + 1 + 1 + 1 + 1 + 1 + n + n + n + n + n + n + n $

$T_n = 7n + 6$

## **Algoritmo (Sub arreglo con suma objetivo)**

### Sabemos que:

$T_n = 7n + 6$

##### Queremos probar que:

$7n + 6 = O(n)$

Siguiendo el procedimiento de la cota asintótica:

$7n+6 \leq c \cdot n,\quad \forall n \geq n_0$

Dividimos por $n$:

$7 + \frac{6}{n} \leq c$

Para $n \geq 1$, tomamos $c = 13$, $n_0 = 1$, por lo que:

$T(n) = O(n)$

## **Análisis de Complejidad Espacial**

### Código:

```java
public int[] encontrarSubArregloConSuma(int[] nums, int sumaObjetivo) {
tablaHash.clear();
int sumaParcial = 0;
for (int i = 0; i < nums.length; i++) {
    sumaParcial += nums[i];
    if (sumaParcial == sumaObjetivo) {
        return new int[]{0, i};
    }
    int complemento = sumaParcial - sumaObjetivo;
    Integer indice = tablaHash.get(complemento);
    if (indice != null) {
        return new int[]{indice + 1, i};
    }
    tablaHash.add(sumaParcial, i);
}
return new int[]{-1, -1};
```

### Tabla de memoria utilizada:

| Tipo     | Variable     | Tamaño de 1 valor atómico | Cantidad de valores atómicos |
| -------- | ------------ | --------------------------- | ----------------------------- |
| Entrada  | nums         | 32 bits                     | n                             |
|          | sumaObjetivo | 32 bits                     | 1                             |
| Auxiliar | sumaParcial  | 32 bits                     | 1                             |
|          | i            | 32 bits                     | 1                             |
|          | complemento  | 32 bits                     | 1                             |
|          | indice       | 32 bits                     | 1                             |
|          | tablaHash    | 64 bits                     | n                             |
| Salida   | int[]        | 32 bits                     | 2                             |

### Complejidad Espacial Total:

$$+ \text{Entrada} + \text{Auxiliar} + \text{Salida} =(2n) + (7)= \Theta(n)$$

### Complejidad Espacial Auxiliar 

$$\text{Auxiliar} = (n) + (4) = \Theta(n)$$

### Complejidad Espacial Auxiliar + Salida:

$$\text{Auxiliar} + \text{Salida} = (n) + (6) = \Theta(n)$$

---
