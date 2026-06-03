# Árbol Binario de Búsqueda (BST) — Java

## Cómo compilar y ejecutar

Desde la carpeta `arboles/`:

```bash
mvn compile
java -cp target/classes umg.edu.progra.arboles.Principal
```
## Estructura del proyecto
arboles/

├── pom.xml

└── src/main/java/umg/edu/progra/arboles/

├── Nodo.java

├── ArbolBinarioBusqueda.java

└── Principal.java
---

## Métodos implementados

### Problema 1 — contarNodos()
Cuenta todos los nodos del árbol usando recursividad pura, sin usar el campo tamanio.

Ejemplo:
- Árbol: 50, 30, 70, 20, 40, 60, 80, 10
- contarNodos() → 8
- tamanio() → 8
- Son iguales: true

---

### Problema 2 — esBalanceado()
Verifica que para cada nodo la diferencia de altura entre su subárbol izquierdo y derecho sea menor o igual a 1.

Ejemplo:
- Árbol {50,30,70,20,40,60,80,10} → esBalanceado(): true
- Árbol {1,2,3,4,5} → esBalanceado(): false

---

### Problema 3 — esBSTValido()
Verifica que el árbol cumple la propiedad BST en cada nodo, pasando un rango permitido (min, max) en cada llamada recursiva.

Ejemplo:
- BST construido correctamente → esBSTValido(): true
- BST con nodo roto (izq de 50 = 99) → esBSTValido(): false

---

### Problema 4 — ancestroComunMasBajo(int a, int b)
Devuelve el ancestro común más bajo (LCA) de dos valores. Aprovecha la propiedad del BST para navegar eficientemente. Lanza IllegalArgumentException si alguno de los valores no existe.

Ejemplo:
- LCA(10, 40) → 30
- LCA(10, 80) → 50
- LCA(60, 80) → 70
- LCA(30, 70) → 50
- LCA(10, 99) → IllegalArgumentException

---

### Problema 5 — invertir()
Invierte el árbol completo (espejo): intercambia el subárbol izquierdo y derecho en cada nodo. El recorrido InOrden pasa de ascendente a descendente.

Ejemplo:
- InOrden antes:   10 20 30 40 50 60 70 80
- InOrden después: 80 70 60 50 40 30 20 10

---

## Ejercicios extra

### E1 — kEsimoMenor(int k)
Devuelve el k-ésimo valor más pequeño usando recorrido InOrden.

Ejemplo:
- kEsimoMenor(1) → 10
- kEsimoMenor(3) → 30
- kEsimoMenor(5) → 50
- kEsimoMenor(8) → 80

---

### E2 — imprimirRangoOrdenado(int min, int max)
Imprime en orden todos los valores en el rango [min, max], podando ramas que no pueden contener valores en ese rango.

Ejemplo:
- Rango [20, 60] → 20 30 40 50 60
- Rango [35, 65] → 40 50 60

---

### E3 — diametro()
Devuelve el número de aristas del camino más largo entre dos nodos cualesquiera del árbol.

Ejemplo:
- Árbol {50,30,70,20,40,60,80,10} → diametro(): 6

---

### E4 — desdeArreglo(int[] valores)
Método estático que construye un BST insertando todos los valores de un arreglo. Si se pasan valores por consola como argumentos los usa; de lo contrario usa un arreglo de ejemplo.

Ejemplo:
- Entrada: {15, 8, 22, 4, 12, 18, 25}
- InOrden: 4 8 12 15 18 22 25
- Tamanio: 7  Altura: 2
