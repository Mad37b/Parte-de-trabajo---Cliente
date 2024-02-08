import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente implements Serializable {

	/** JavaDoc **/

	/**
	 * @author ULISES III
	 * 
	 * @version 1.1
	 * 
	 * @Descripcion:
	 * 
	 *               En esta clase Cliente se Realiza y que genere un fichero con la
	 *               lista de partes realizados y tenga la posibilidad de Generar,
	 *               Consultar, Ver con detalle la lista de clientes
	 *               
	 *              // NIF/Documento identidad (Validado)
					// b. Nombre
					// c. Correo electrónico (validado)
					// d. Teléfono de contacto
	 * 
	 */

	static // Atributos

	

	// Lista Array

	static ArrayList<String> NIF = new ArrayList<String>();
	static ArrayList<String> Nombre = new ArrayList<String>();
	static ArrayList<String> Correo = new ArrayList<String>();
	static ArrayList<String> Teléfono = new ArrayList<String>();

	static String nombre;
	static String nif;
	static String correo;
	static String telefonoString;

	static // Scanner

	Scanner teclado = new Scanner(System.in);

	static // validador Regex

	Pattern Nif = Pattern.compile("^\\d{8}\\w[TRWAGMYFPDXBNJZSQVHLCKE]{1}$");
	Pattern telefonoPattern = Pattern.compile("^\\d{3}\\s\\d{3}\\s\\d{3}$");
String text;
	
	

	// insertar datos por consola

	// metodo ingresar
	public static void insertarDatos() {
		System.out.println("Introduce los datos del cliente : Nombre, Nif, Correo, Telefono");

		while (true) {
			System.out.println("Nombre : ");
			nombre = teclado.nextLine();
			if (Nombre.equals("fin")) {
				break;
			}
			Nombre.add(nombre);

			System.out.println(" Nif : ");
			nif = teclado.nextLine();
			NIF.add(nif);
			
			//Quitar CharSecuence 
			Matcher matcherNif = Nif.matcher((CharSequence) NIF);
			System.out.println(" Correo : ");
			correo = teclado.nextLine();
			Correo.add(correo);

			System.out.println(" Telefono : ");
			telefonoString = teclado.nextLine();
			Matcher matcherTelefono = telefonoString.matcher((CharSequence) Teléfono)
			Teléfono.add(telefonoString);
			

		}
	}
	public  Cliente(InputStream in) {
		try (ObjectInputStream miFichero = new ObjectInputStream(new FileInputStream("clientes.ddr"))) {
			// Cuando no haya mas objetos saltara la excepcion EOFException
			while (true) {
				Cliente aux = (Cliente)ois.readObject();
				// Cada aux tendria los datos del Usuario

				System.out.println(aux.getNombre());
				System.out.print(aux.getApellido());
				System.out.print(aux.getEdad());
				System.out.print(aux.getNIF());
			}
		} catch (ClassNotFoundException e) {
		} catch (EOFException e) {
		} catch (IOException e) {
		}

	}
            
	// Metodo fichero
	static String ficheroCliente;

	public static void crearFichero(String nuevoCliente) {
		try (FileWriter fichero = new FileWriter("clientes.txt", true)) {
			fichero.write(nuevoCliente);
			System.out.println("Cliente agregado al fichero.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}

	public void getNIF() {
		// TODO Auto-generated method stub
		return;
	}

	public void getEdad() {
		// TODO Auto-generated method stub
		return;
	}

	public void getApellido() {
		// TODO Auto-generated method stub
		return;
	}

	// getters

	public void getNombre() {

	}

	public static void main(String[] arg) {
		insertarDatos();
		try {
			crearFichero(ficheroCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
