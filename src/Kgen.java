import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kgen {

	private String data = "";

	public String leerFichero(String nombreFichero) {
		data = "";
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
        	System.out.println(ioe.getMessage());        	
        } finally {
            if (in != null) {
                in.close();
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ioe) {
                	System.out.println(ioe.getMessage());
                }
            }
        }
		return data;
    }

    public Map <String,Integer> getKgenMap(int size) {
        Map <String, Integer> KgenMap = new HashMap<>();

        for (int i = 0; i <= data.length() - size; i++) {
        	String conjunto = data.substring(i, i + size);

            if (KgenMap.containsKey(conjunto)) {
                KgenMap.put(conjunto, KgenMap.get(conjunto) + 1);
            } else {
                KgenMap.put(conjunto, 1);
            }
        }
        return KgenMap;
    }

	public String getData() {
		return data;
	}
}
