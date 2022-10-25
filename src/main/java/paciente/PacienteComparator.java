package paciente;

import java.util.Comparator;

public class PacienteComparator implements Comparator<Paciente> {
    @Override
    public int compare(Paciente o1, Paciente o2) {
        if (o1.getIdade() > o2.getIdade())
            return -1;
        if (o1.getIdade() < o2.getIdade())
            return 1;
        return 0;
    }
}
