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

        Paciente p1 = new Paciente("Otto", 18, "01");
        Paciente p2 = new Paciente("Festa", 19, "02");
        Paciente p3 = new Paciente("Thomaz", 22, "03");
        Paciente p4 = new Paciente("Beatriz", 19, "04");
        Paciente p5 = new Paciente("Festa", 19, "05");
        Paciente p6 = new Paciente("Ma", 14, "06");
        Paciente p7 = new Paciente("Augusto", 67, "07");
        Paciente p8 = new Paciente("Turing", 110, "08");
        Paciente p9 = new Paciente("Jay Mello", 40, "09");
        Paciente p10 = new Paciente("Akko", 16, "10");

        filaDePacientes.add(p1);
        filaDePacientes.add(p2);
        filaDePacientes.add(p3);
        filaDePacientes.add(p4);
        filaDePacientes.add(p5);
        filaDePacientes.add(p6);
        filaDePacientes.add(p7);
        filaDePacientes.add(p8);
        filaDePacientes.add(p9);
        filaDePacientes.add(p10);


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
