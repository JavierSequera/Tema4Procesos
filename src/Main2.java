import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main2 {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre, contraseña, combinación, resumen;
        System.out.println("Introduzca su nombre de usuario");
        nombre = s.next();
        System.out.println("Introduzca la contraseña");
        contraseña = s.next();
        combinación = nombre + " " + contraseña;

        resumen = CalculoHash.getDigest(combinación);
        lectura(resumen);
    }

    private static void lectura(String resumen) {
        File archivo;
        String linea = "";
        boolean encontrado = false;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner s = null;

        try {

            archivo = new File("credenciales.cre");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            s = new Scanner(br);

            while (s.hasNextLine() && !encontrado) {
                linea = s.nextLine();
                CalculoHash.compararArrayBytes(linea.getBytes(), resumen.getBytes());
                if (linea.equals(resumen)){
                    encontrado = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
