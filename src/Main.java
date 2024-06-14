import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub		
		Scanner sc = new Scanner(System.in);
		String opcion = "", nombreFichero = "";
		int size = 0;
		boolean bcontinuar = true;
		
		while (bcontinuar) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. Abrir fichero FASTA");
			System.out.println("2. Calcular y mostrar mapa de palabras de tamaño...");	
			System.out.println("\n(Cualquier otra cosa). Salir");
			System.out.println("---------------------------------------------------");
			
			opcion = sc.nextLine();
			
			if (opcion.equals("1")) {
				System.out.print("\nIntroduzca ahora la ruta o nombre del fichero FASTA a leer: ");
				nombreFichero = sc.nextLine();
				Kgen.leerFichero(nombreFichero);
				
			} else if (opcion.equals("2")) {
				if (nombreFichero.equals("")) {
					System.out.println("\nPor favor, realice primero la primera opción.");					
				} else {
					System.out.print("\nIntroduzca ahora el tamaño de palabra: ");
					try {
						size = Integer.valueOf(sc.nextLine());
					} catch (NumberFormatException e) {
						e.printStackTrace();
						size = 0;
					}
					
					if (size > 0) {
						Map <String, Integer> kgenMap = Kgen.getKgenMap(size);
				        for (String palabra : kgenMap.keySet()) {
				        	if (kgenMap.get(palabra) == 1) {
				        		System.out.println("\nPalabra \"" + palabra + "\" repetida " + kgenMap.get(palabra) + " vez");			        		
				        	} else {
				        		System.out.println("\nPalabra \"" + palabra + "\" repetida " + kgenMap.get(palabra) + " veces");
				        	}
				        }
					} else {
						System.out.println("\nEl tamaño de palabra tiene que ser un número entero positivo.");
					}					
				}
				
			} else {
				bcontinuar = false;
			}
		}
		sc.close();
	}
}
