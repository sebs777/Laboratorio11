import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidadEstudiantes = Integer.parseInt(br.readLine());
        String[] arregloCadenas = new String[cantidadEstudiantes];
        int[][] todasLasNotas = new int[cantidadEstudiantes][4]; // Arreglo para las notas de todos los estudiantes

        for (int i = 0; i < arregloCadenas.length; i++) {
            System.out.print("Ingresa el nombre del estudiante: ");
            String value = br.readLine();
            GuardarValor(arregloCadenas, i, value);

            System.out.println("Debes ingresar las 4 notas del estudiante:");
            for (int j = 0; j < 4; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                int nota = Integer.parseInt(br.readLine());
                while (nota < 0 || nota > 20) { // Validar que la nota esté entre 0 y 20
                    System.out.print("Nota inválida. Ingrese una nota entre 0 y 20: ");
                    nota = Integer.parseInt(br.readLine());
                }
                todasLasNotas[i][j] = nota;
            }

            int promedio = CalcularPromedio(todasLasNotas[i]);
            System.out.println("El promedio de notas del estudiante " + value + " es: " + promedio);
        }


        CalcularEstadisticas(todasLasNotas);
        ImprimirObjetos(arregloCadenas);
    }

    private static int CalcularPromedio(int[] notas) {
        int sumaTotal = 0;
        for (int nota : notas) {
            sumaTotal += nota;
        }
        return sumaTotal / notas.length;
    }

    private static void GuardarValor(String[] arreglo, int position, String value) {
        if (arreglo.length <= position) return;
        arreglo[position] = value;
    }

    private static void ImprimirObjetos(String[] arreglo) {
        for (String value : arreglo) {
            System.out.println(value);
        }
    }

    private static void CalcularEstadisticas(int[][] notas) {
        int sumaTotal = 0;
        int maxNota = Integer.MIN_VALUE;
        int minNota = Integer.MAX_VALUE;
        int totalNotas = 0;
        int aprobados = 0;
        int reprobados = 0;

        for (int[] alumnoNotas : notas) {
            for (int nota : alumnoNotas) {
                sumaTotal += nota;
                totalNotas++;
                if (nota > maxNota) maxNota = nota;
                if (nota < minNota) minNota = nota;
            }
        }

        double media = (double) sumaTotal / totalNotas;


        for (int[] alumnoNotas : notas) {
            int promedio = CalcularPromedio(alumnoNotas);
            if (promedio >= 10) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        System.out.println("Nota más alta: " + maxNota);
        System.out.println("Nota más baja: " + minNota);
        System.out.println("Media de todas las notas: " + media);
        System.out.println("Total de aprobados: " + aprobados);
        System.out.println("Total de reprobados: " + reprobados);
    }
}
