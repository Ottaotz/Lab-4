package postoDeSaude;

import paciente.Paciente;

import java.util.List;
import java.util.PriorityQueue;

public class PostoDeSaude {
    private Fila fila;
    private Lista lista = new Lista();

    public PostoDeSaude(Fila fila) {
        this.fila = fila;
    }

    public void receberPacientes(List<Paciente> pacientes) {
        fila.adicionarPaciente(pacientes);
    }

    public void receberPacientes(Paciente paciente) {
        fila.adicionarPaciente(paciente);
    }

    public void vacinar(int quantidade) {
        for (int i = 0; i < quantidade; i++){
            adicionaLista(fila.getFirst());
        }
    }

    private void adicionaLista(Paciente paciente) {
        lista.adicionar(paciente);
    }

    public void mostraFila() {
        fila.printFila();
    }

    public void mostraLista() {
        lista.print();
    }

    public PriorityQueue<Paciente> retornaFila() {
        return fila.getFila();
    }

    public List<Paciente> retornaLista() {
        return lista.getLista();
    }

    public int buscarPosicaoPorNome(String nome) {
        return fila.posicaoPorNome(nome);
    }

    public boolean jaFoiVacinado(String nome) {
        return lista.verificaPacientes(nome);
    }
}
