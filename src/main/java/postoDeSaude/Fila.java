package postoDeSaude;

import paciente.Paciente;

import java.util.*;

public class Fila {
    private PriorityQueue<Paciente> fila;
    private PriorityQueue<Paciente> aux;

    public Fila(PriorityQueue<Paciente> fila) {
        this.fila = fila;
    }

    public void adicionarPaciente(List<Paciente> pacientes) {
        for (Paciente paciente : pacientes)
            fila.add(paciente);
    }

    public void adicionarPaciente(Paciente paciente) {
        fila.add(paciente);
    }

    public Paciente getFirst() {
        return fila.poll();
    }

    public void printFila() {
        aux = new PriorityQueue<>(fila);
        while (!aux.isEmpty())
            System.out.println(aux.poll());
    }

    public PriorityQueue<Paciente> getFila() {
        return fila;
    }

    public int posicaoPorNome(String nome) {
        aux = new PriorityQueue<>(fila);
        while (!aux.isEmpty())
            if (aux.poll().getNome().equalsIgnoreCase(nome))
                return fila.size() - aux.size();
        return -1;
    }
}
