import java.math.BigInteger;
import java.security.MessageDigest;

public class CalculoHash
{
    public static String getDigest(String cadena){

        byte[] mensajeBytes;
        byte[] resumen = null;
        String resumenHexagecimal = "";

        try{

            // Convierto el mensaje introducido por el usuario en un array de bytes
            mensajeBytes = cadena.getBytes("UTF-8");

            // Creo una instancia de MessageDigest con el algoritmo SHA-256
            MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");

            // Reiniciamos el objeto por si contiene datos
            algoritmo.reset();

            // Añado el mensaje del cual quiero calcular su hash
            algoritmo.update(mensajeBytes);

            // Generamos el resumen
            resumen = algoritmo.digest();

            resumenHexagecimal = String.format("%064x", new BigInteger(1, resumen));


        }catch (Exception e){
            System.out.println(e);
        }

        return resumenHexagecimal;

    }

    public static void compararArrayBytes(byte[] array1, byte[] array2){

        if (MessageDigest.isEqual(array1, array2)){
            System.out.println("Sesión iniciada correctamente");
        }
        else{
            System.out.println("No se ha podido iniciar sesión");
        }

    }




}
