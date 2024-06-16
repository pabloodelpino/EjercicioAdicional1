import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String opcion;
		boolean bcontinuar = true;

		Kgen miKgen = new Kgen();

		while (bcontinuar) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. Abrir fichero FASTA");
			System.out.println("2. Calcular y mostrar mapa de palabras de tamaño...");
			System.out.println("\n(Cualquier otra cosa). Salir");
			System.out.println("---------------------------------------------------");

			opcion = sc.nextLine();

			if (opcion.equals("1")) {
				System.out.print("\nIntroduzca el nombre o ruta del fichero FASTA a leer: ");
				String nombreFichero = sc.nextLine();

				miKgen.leerFichero(nombreFichero);

			} else if (opcion.equals("2")) {
				if (miKgen.getData().equals("")) {
					System.out.println("\nEl fichero está vacío o no se ha leído aún.");
				} else {
					System.out.print("\nIntroduzca ahora el tamaño de palabra: ");

					try {
						int size = Integer.valueOf(sc.nextLine());

						if (size > 0) {
							Map <String, Integer> kgenMap = miKgen.getKgenMap(size);

					        for (String palabra : kgenMap.keySet()) {
					        	if (kgenMap.get(palabra) == 1) {
					        		System.out.println("\nPalabra \"" + palabra + "\" repetida " + kgenMap.get(palabra) + " vez.");
					        	} else {
					        		System.out.println("\nPalabra \"" + palabra + "\" repetida " + kgenMap.get(palabra) + " veces.");
					        	}
					        }
						} else {
							System.out.println("\nEl tamaño de palabra tiene que ser positivo.");
						}

					} catch (NumberFormatException e) {
						System.out.println("\nEl tamaño de palabra tiene que ser un número entero.");
					}
				}
			} else {
				bcontinuar = false;
			}
		}
		sc.close();
	}
}
