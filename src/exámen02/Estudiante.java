package exámen02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Estudiante {

    private Object código;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String PrimerNombre;
    private String SegundoNombre;
    private String CarreraProfesional;
    private int módulo;
    private char turno;
    private String FechaNacimiento;

//    public static void main(String[] args) {
//        InstitutoTrujillo instituto = new InstitutoTrujillo();
//    }

    public void GuardarDatos(Object código, String ApellidoPaterno, String ApellidoMaterno, String PrimerNombre,
            String SegundoNombre, String CarreraProfesional, int módulo, char turno, String FechaNacimiento) {

        this.código = código;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.CarreraProfesional = CarreraProfesional;
        this.módulo = módulo;
        this.turno = turno;
        this.FechaNacimiento = FechaNacimiento;

        JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
    }

    //Calculamos la edad del estudiante, sólo considerando los años de nacimiento y del sistema
    public int CalcularEdad() {

        DateTimeFormatter FormatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
        LocalDate FechaNac = LocalDate.parse(FechaNacimiento, FormatoFecha);

        int AñoActual = LocalDate.now().getYear(); //Obtenemos el año actual del sistema
        int AñoNacimiento = FechaNac.getYear(); //Obtenemos el año de la FechaNac

        return AñoActual - AñoNacimiento;
    }

    public int PagoCarrera() {

        int PagoCarrera = 0;

        switch (CarreraProfesional) {

            case "COMPUTACIÓN E INFORMÁTICA":
                PagoCarrera = 120;
                break;
            case "CONTABILIDAD":
                PagoCarrera = 100;
                break;
            case "ENFERMERÍA TÉCNICA":
                PagoCarrera = 100;
                break;
            case "GUIA OFICIAL DE TURISMO":
                PagoCarrera = 80;
                break;
            case "LABORATORIO CLÍNICO":
                PagoCarrera = 80;
                break;
            case "SECRETARIADO EJECUTIVO":
                PagoCarrera = 100;
                break;
            case "RELACIONES PÚBLICAS":
                PagoCarrera = 80;
                break;
        }
        return PagoCarrera;
    }

    public int DescuentoTurno() {

        int DescuentoTurno = 0;

        switch (turno) {
            case 'D':
                DescuentoTurno = 0;
                break;
            case 'V':
                DescuentoTurno = (int) (PagoCarrera() * 0.10);
                break;
            case 'N':
                DescuentoTurno = (int) (PagoCarrera() * 0.20);
                break;
        }
        return DescuentoTurno;
    }

    public int TotalPagar() {         
        return PagoCarrera() - DescuentoTurno();
    }   
}
