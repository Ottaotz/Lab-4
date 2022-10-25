import paciente.Paciente;
import paciente.PacienteComparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        Comparator<Paciente> comparadorPoridade = new PacienteComparator();
        PriorityQueue<Paciente> filaDePacientes = new PriorityQueue<>(10, comparadorPoridade);

        Paciente p2 = new Paciente("Festa", 19, "02");
        Paciente p5 = new Paciente("Festa", 19, "05");
        Paciente p1 = new Paciente("Otto", 18, "01");
        Paciente p3 = new Paciente("Thomaz", 26, "03");
        Paciente p4 = new Paciente("aaa", 22, "04");

        filaDePacientes.add(p1);
        filaDePacientes.add(p2);
        filaDePacientes.add(p3);
        filaDePacientes.add(p4);
        filaDePacientes.add(p5);

        System.out.println(filaDePacientes);

//        Fila fila = new Fila(filaDePacientes);
//
//        System.out.println(fila.fila);
//        System.out.println(fila.lista);


    }
}
