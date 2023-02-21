import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        String nombre, contraseña, combinación, resumen;
        System.out.println("Introduzca su nombre de usuario");
        nombre = s.next();
        System.out.println("Introduzca la contraseña");
        contraseña = s.next();
        combinación = nombre+" "+contraseña;
        resumen = CalculoHash.getDigest(combinación);
        escritura(resumen);

    }

    private static String escritura(String resumen) {
        String lectura = "";
        File archivo;
        FileWriter fr = null;
        try {
            archivo = new File("credenciales.cre");
            fr = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fr);
            bw.write(resumen);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            return "Error al insertar el alumno";
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        lectura = "Persona insertada correctamente";
        return lectura;
    }
}