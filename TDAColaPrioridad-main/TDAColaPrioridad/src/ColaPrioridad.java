import javax.swing.*;

public class ColaPrioridad {
    public Nodo frente;

    public ColaPrioridad() {
        frente = null;
    }

    public void añadir(String nombre, int prioridad) {
        Nodo nuevoNodo = new Nodo(nombre, prioridad);
        if (estaVacia() || prioridad < frente.prioridad) {

            nuevoNodo.siguiente = frente;
            frente = nuevoNodo;
        } else {

            Nodo actual = frente;
            while (actual.siguiente != null && actual.siguiente.prioridad <= prioridad) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    }

    public String mostrar(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La cola está vacía.");
            return null;
        }
        String mensajeAtendido = frente.dato + " ha sido atendido (prioridad " + frente.prioridad + ").";
        frente = frente.siguiente;
        textArea.append(mensajeAtendido + "\n");
        return mensajeAtendido;
    }

    public boolean estaVacia() {
        return frente == null;
    }

}
