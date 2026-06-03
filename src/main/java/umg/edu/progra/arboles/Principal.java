package umg.edu.progra.arboles;

public class Principal {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) arbol.insertar(v);

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio: " + arbol.tamanio());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());
        System.out.println("\n--- Representacion visual ---");
        arbol.imprimirArbol();
        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");    arbol.inOrden();
        System.out.print("PreOrden   (raiz primero): ");  arbol.preOrden();
        System.out.print("PostOrden  (raiz al final): "); arbol.postOrden();
        System.out.print("Por niveles (BFS):         ");  arbol.recorridoPorNiveles();
        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));
        System.out.println("\n--- Eliminacion ---");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: "); arbol.inOrden();
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: "); arbol.inOrden();
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar 50: "); arbol.inOrden();
        System.out.println("Estado final:"); arbol.imprimirArbol();
        System.out.println("Tamanio: " + arbol.tamanio() + "  Altura: " + arbol.altura());

        System.out.println("\n========================================");
        System.out.println("PROBLEMA 1 - contarNodos() recursivo");
        System.out.println("========================================");
        ArbolBinarioBusqueda a1 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) a1.insertar(v);
        System.out.println("contarNodos(): " + a1.contarNodos() + "  |  tamanio(): " + a1.tamanio());
        System.out.println("Son iguales: " + (a1.contarNodos() == a1.tamanio()));
        a1.insertar(5);
        a1.insertar(90);
        System.out.println("Tras insertar 5 y 90 -> contarNodos(): " + a1.contarNodos() + "  |  tamanio(): " + a1.tamanio());
        a1.eliminar(5);
        System.out.println("Tras eliminar 5      -> contarNodos(): " + a1.contarNodos() + "  |  tamanio(): " + a1.tamanio());

        System.out.println("\n========================================");
        System.out.println("PROBLEMA 2 - esBalanceado()");
        System.out.println("========================================");
        ArbolBinarioBusqueda balanceado = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) balanceado.insertar(v);
        System.out.println("Arbol {50,30,70,20,40,60,80,10}:");
        balanceado.imprimirArbol();
        System.out.println("esBalanceado(): " + balanceado.esBalanceado());
        ArbolBinarioBusqueda desbalanceado = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 1, 2, 3, 4, 5 }) desbalanceado.insertar(v);
        System.out.println("Arbol desbalanceado {1,2,3,4,5}:");
        desbalanceado.imprimirArbol();
        System.out.println("esBalanceado(): " + desbalanceado.esBalanceado());

        System.out.println("\n========================================");
        System.out.println("PROBLEMA 3 - esBSTValido()");
        System.out.println("========================================");
        ArbolBinarioBusqueda bstBueno = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) bstBueno.insertar(v);
        System.out.println("BST correcto -> esBSTValido(): " + bstBueno.esBSTValido());
        ArbolBinarioBusqueda bstRoto = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) bstRoto.insertar(v);
        bstRoto.getRaiz().izquierdo.dato = 99;
        System.out.println("BST roto (izq de 50 = 99) -> esBSTValido(): " + bstRoto.esBSTValido());

        System.out.println("\n========================================");
        System.out.println("PROBLEMA 4 - ancestroComunMasBajo (LCA)");
        System.out.println("========================================");
        ArbolBinarioBusqueda lca = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) lca.insertar(v);
        System.out.println("LCA(10, 40) = " + lca.ancestroComunMasBajo(10, 40) + "  (esperado: 30)");
        System.out.println("LCA(10, 80) = " + lca.ancestroComunMasBajo(10, 80) + "  (esperado: 50)");
        System.out.println("LCA(60, 80) = " + lca.ancestroComunMasBajo(60, 80) + "  (esperado: 70)");
        System.out.println("LCA(30, 70) = " + lca.ancestroComunMasBajo(30, 70) + "  (esperado: 50)");
        try {
            lca.ancestroComunMasBajo(10, 99);
        } catch (IllegalArgumentException e) {
            System.out.println("LCA(10, 99) -> excepcion: " + e.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("PROBLEMA 5 - invertir() espejo");
        System.out.println("========================================");
        ArbolBinarioBusqueda espejo = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) espejo.insertar(v);
        System.out.println("ANTES de invertir:");
        espejo.imprimirArbol();
        System.out.print("InOrden antes: ");
        espejo.inOrden();
        espejo.invertir();
        System.out.println("DESPUES de invertir:");
        espejo.imprimirArbol();
        System.out.print("InOrden despues (descendente): ");
        espejo.inOrden();

        System.out.println("\n========================================");
        System.out.println("EXTRA E1 - kEsimoMenor(k)");
        System.out.println("========================================");
        ArbolBinarioBusqueda e1 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) e1.insertar(v);
        System.out.print("InOrden: ");
        e1.inOrden();
        System.out.println("1er menor: " + e1.kEsimoMenor(1) + "  (esperado: 10)");
        System.out.println("3er menor: " + e1.kEsimoMenor(3) + "  (esperado: 30)");
        System.out.println("5to menor: " + e1.kEsimoMenor(5) + "  (esperado: 50)");
        System.out.println("8vo menor: " + e1.kEsimoMenor(8) + "  (esperado: 80)");
        try {
            e1.kEsimoMenor(0);
        } catch (IllegalArgumentException e) {
            System.out.println("kEsimoMenor(0) -> excepcion: " + e.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("EXTRA E2 - imprimirRangoOrdenado(min, max)");
        System.out.println("========================================");
        ArbolBinarioBusqueda e2 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) e2.insertar(v);
        System.out.print("Rango [20, 60]: ");
        e2.imprimirRangoOrdenado(20, 60);
        System.out.print("Rango [10, 80]: ");
        e2.imprimirRangoOrdenado(10, 80);
        System.out.print("Rango [35, 65]: ");
        e2.imprimirRangoOrdenado(35, 65);

        System.out.println("\n========================================");
        System.out.println("EXTRA E3 - diametro()");
        System.out.println("========================================");
        ArbolBinarioBusqueda e3 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) e3.insertar(v);
        System.out.println("Diametro: " + e3.diametro() + "  (esperado: 6)");

        System.out.println("\n========================================");
        System.out.println("EXTRA E4 - desdeArreglo(int[])");
        System.out.println("========================================");
        int[] entrada;
        if (args.length > 0) {
            entrada = new int[args.length];
            for (int i = 0; i < args.length; i++) entrada[i] = Integer.parseInt(args[i]);
            System.out.println("Arbol desde args de consola:");
        } else {
            entrada = new int[]{ 15, 8, 22, 4, 12, 18, 25 };
            System.out.println("Arbol desde arreglo {15,8,22,4,12,18,25}:");
        }
        ArbolBinarioBusqueda e4 = ArbolBinarioBusqueda.desdeArreglo(entrada);
        e4.imprimirArbol();
        System.out.print("InOrden: ");
        e4.inOrden();
        System.out.println("Tamanio: " + e4.tamanio() + "  Altura: " + e4.altura());
    }
}