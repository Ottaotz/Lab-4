package postoDeSaude;

import paciente.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    private List<Paciente> lista = new ArrayList<>();

    public void adicionar(Paciente paciente) {
        lista.add(paciente);
    }

    public void print() {
        for (Paciente paciente : lista)
            System.out.println(paciente);
    }

    public List<Paciente> getLista() {
        return lista;
    }

    public boolean verificaPacientes(String nome) {
        for (Paciente paciente : lista)
            if (paciente.getNome().equalsIgnoreCase(nome))
                return true;
        return false;
    }
}
