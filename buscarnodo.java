package nodos;

import java.util.ArrayList;
import java.util.List;

class App2 {
    class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private List<Integer> findMaxPrimePath(Node root) {
        List<Integer> currentPath = new ArrayList<>();
        List<Integer> maxPrimePath = new ArrayList<>();

        findMaxPrimePathHelper(root, currentPath, maxPrimePath);

        return maxPrimePath;
    }

    private void findMaxPrimePathHelper(Node node, List<Integer> currentPath, List<Integer> maxPrimePath) {
        if (node == null) {
            return;
        }

        currentPath.add(node.value);

        if (node.left == null && node.right == null) {
            // Es una hoja, verifica si la concatenación forma un número primo
            int concatenatedValue = concatenateValues(currentPath);
            System.out.println(concatenatedValue);
            if (isPrime(concatenatedValue)) {
                System.out.println("Prime path found: " + currentPath);
                if (concatenatedValue > concatenateValues(maxPrimePath)) {
                    maxPrimePath.clear();
                    maxPrimePath.addAll(currentPath);
                }
            }
        } else {
            // Búsqueda en profundidad en los subárboles
            findMaxPrimePathHelper(node.left, new ArrayList<>(currentPath), maxPrimePath);
            findMaxPrimePathHelper(node.right, new ArrayList<>(currentPath), maxPrimePath);
        }
    }

    private int concatenateValues(List<Integer> values) {
        int result = 0;
        for (int value : values) {
            result = result * 10 + value;
        }
        return result;
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        App2 app = new App2();
        Node raiz = app.new Node(7);
        Node b = app.new Node(3);
        Node c = app.new Node(2);
        Node d = app.new Node(1);
        Node e = app.new Node(5);
        Node f = app.new Node(4);
        Node g = app.new Node(9);

        raiz.left = b;
        raiz.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        c.left = g;

        List<Integer> maxPrimePath = app.findMaxPrimePath(raiz);

        if (!maxPrimePath.isEmpty()) {
            System.out.println("Ruta con el número primo más grande: " + maxPrimePath);
        } else {
            System.out.println("No hay rutas válidas.");
        }
    }
}
