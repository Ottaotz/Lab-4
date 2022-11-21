package testePostoDeSaude;

import org.junit.Before;
import org.junit.Test;
import paciente.Paciente;
import paciente.PacienteComparator;
import postoDeSaude.Fila;
import postoDeSaude.PostoDeSaude;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class TestePostoDeSaude {
    private PostoDeSaude posto;

    @Before
    public void inicial() {
        Comparator<Paciente> comparadorPoridade = new PacienteComparator();
        PriorityQueue<Paciente> filaDePacientes = new PriorityQueue<>(6, comparadorPoridade);

        filaDePacientes.add(new Paciente("Otto", 18, "01"));
        filaDePacientes.add(new Paciente("Festa", 19, "02"));
        filaDePacientes.add(new Paciente("Thomaz", 22, "03"));
        filaDePacientes.add(new Paciente("Beatriz", 19, "04"));
        filaDePacientes.add(new Paciente("Festa", 19, "05"));
        filaDePacientes.add(new Paciente("Ma", 14, "06"));
        filaDePacientes.add(new Paciente("Augusto", 67, "07"));
        filaDePacientes.add(new Paciente("Turing", 110, "08"));
        filaDePacientes.add(new Paciente("Jay Mello", 40, "09"));
        filaDePacientes.add(new Paciente("Akko", 16, "10"));

        Fila fila = new Fila(filaDePacientes);

        posto = new PostoDeSaude(fila);
    }

    @Test
    public void deveVacinarTodos() {
        posto.vacinar(posto.retornaFila().size());

        int expectedFila = 0, expectedLista = 10;
        int actualFila = posto.retornaFila().size(), actualLista = posto.retornaLista().size();

        assertEquals(expectedFila, actualFila);
        assertEquals(expectedLista, actualLista);
    }

    @Test
    public void deveRetirarDoisDaFilaEPassarParaLista() {
        posto.vacinar(2);

        int expectedFila = 8, expectedLista = 2;
        int actualFila = posto.retornaFila().size(), actualLista = posto.retornaLista().size();

        assertEquals(expectedFila, actualFila);
        assertEquals(expectedLista, actualLista);
    }

    @Test
    public void deveAdicionarNovoPacienteObjetoCorretamente() {
        Paciente novoPaciente = new Paciente("Novo Paciente", 36, "11");
        posto.receberPacientes(novoPaciente);

        int expected = 11;
        int actual = posto.retornaFila().size();

        assertEquals(expected, actual);
    }

    @Test
    public void deveAdicionarNovoPacienteListCorretamente() {
        List<Paciente> novosPacientes = new ArrayList<>();
        novosPacientes.add(new Paciente("Novo Paciente1", 36, "11"));
        novosPacientes.add(new Paciente("Novo Paciente2", 28, "12"));
        novosPacientes.add(new Paciente("Novo Paciente3", 12, "13"));
        posto.receberPacientes(novosPacientes);

        int expected = 13;
        int actual = posto.retornaFila().size();

        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarPrimeiraPosicao() {
        int expected = 1;
        int actual = posto.buscarPosicaoPorNome("Turing");

        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarQuintaPosicao() {
        int expected = 5;
        int actual = posto.buscarPosicaoPorNome("Beatriz");

        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarUltimaPosicao() {
        int expected = 10;
        int actual = posto.buscarPosicaoPorNome("Ma");

        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarMenosUm() {
        int expected = -1;
        int actual = posto.buscarPosicaoPorNome("Viniccius13");

        assertEquals(expected, actual);
    }

    @Test
    public void deveEstarNaListaDeVacinados() {
        posto.vacinar(1);

        boolean actual = posto.jaFoiVacinado("Turing");

        assertTrue(actual);
    }

    @Test
    public void deveNaoEstarNaListaDeVacinados() {
        posto.vacinar(9);

        boolean actual = posto.jaFoiVacinado("Ma");

        assertFalse(actual);
    }

}
