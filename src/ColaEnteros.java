public class ColaEnteros {
    private nodo frente;
    private nodo fin;

    public ColaEnteros() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(int dato) {
        nodo nuevo = new nodo(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public int desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("❌ La cola está vacía.");
        }
        int dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return dato;
    }

    public int verFrente() {
        if (estaVacia()) {
            throw new RuntimeException("❌ La cola está vacía.");
        }
        return frente.dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void imprimirCola() {
        nodo actual = frente;
        if (actual == null) {
            System.out.println("🌀 Cola vacía.");
            return;
        }

        System.out.print("🌀 Cola actual: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
