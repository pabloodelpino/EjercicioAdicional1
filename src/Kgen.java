import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kgen {

	static String data = "";
	
    public static void leerFichero(String nombreFichero) {
    	Scanner in = null;
        FileReader fr = null;
        boolean comenzarLectura = false;
          	
        try {
            fr = new FileReader(nombreFichero);
            in = new Scanner(fr);
            
            while (in.hasNextLine()) {
            	String linea = in.nextLine();
                if (comenzarLectura) {
                	data += linea;
                } else if (!linea.trim().isEmpty()) {
                    comenzarLectura = true;
                }
            }

        } catch (IOException ioe) {            
            ioe.printStackTrace();
            
        } finally {
            if (in != null) {
                in.close();
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static Map<String,Integer> getKgenMap(int size) {
        Map <String, Integer> KgenMap = new HashMap<>();        
        for (int i = 0; i <= data.length() - size; i++) {
        	String grupo = data.substring(i, i + size);
            if (KgenMap.containsKey(grupo)) {
                KgenMap.put(grupo, KgenMap.get(grupo) + 1);
            } else {
                KgenMap.put(grupo, 1);
            }
        }
        
        return KgenMap;
    }
}
