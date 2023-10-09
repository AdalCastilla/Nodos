package nodos;
public class App {
    public static void main (String[]args) throws Exception {
        
        Node x = null; 
        Node raiz = new Node ('a');
        Node b = new Node ('b');
        Node c = new Node ('c');
        Node d = new Node ('d');
        Node e = new Node ('e');
        Node f = new Node ('f');
        Node g = new Node ('g');
        Node h = new Node ('h');
        Node i = new Node ('i');
        Node j = new Node ('g');

        raiz.left = b;
        raiz.right = c;
        b.left = d;
        b.right = e;
        c.right =f;
        f.left = g;
        f.right = h;
        g.left = i;
        g.right = j;

        // Carácter a buscar
        char caracterBuscado = 'i';

        // Verificar si el árbol contiene el carácter
        boolean resultado = contieneCaracter(x, caracterBuscado);

        // Imprimir el resultado
        System.out.println("¿El árbol contiene el carácter " + caracterBuscado + "? " + resultado);
    }

    // Método para verificar si el árbol contiene un carácter específico
    public static boolean contieneCaracter(Node nodo, char caracter) {
        // Caso base: el nodo es nulo
        if (nodo == null)
            return false;

        // Verificar si el carácter está en el nodo actual
        if (nodo.value == caracter)
            return true;

        // Recorrer recursivamente el subárbol izquierdo y derecho
        return contieneCaracter(nodo.left, caracter) || contieneCaracter(nodo.right, caracter);
    }
}

        

        

    

