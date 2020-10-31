import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class ClasePrincipal {
	public static List<Reservas> listaReservas = new ArrayList<Reservas>();
   
	public static ManejoArchivosReserva modificar = new ManejoArchivosReserva();
        
	public static Scanner scanner = new Scanner(System.in);
        
	public static Reservas reservas = new Reservas();
        
	public static Integer main = 0 ;
	
	public static Long opc;
	
	public static void main(String[] args) {
		llenardata();
		do {
			limpiarPantalla();
			System.out.println("_BIENVENIDO AL SISTEMA -Taller de reparacion de carros_");
			System.out.println("    1. Registrar Reserva");
			System.out.println("    2. Buscar Reserva");
			System.out.println("    3. Lista Reservas");
			System.out.println("    4: Salir");
			System.out.println();
			
			main = tryint();
			
			switch (main) {
			case 1:
				registroReservas();
				break;
			case 2:
				buscar();	
				break;

			case 3:
				listaReservas();
				break;
			case 4:
				System.out.println("------------- FIN -------------");
				break;
			}

		} while (main != 4);

	}
	
	public static void registroReservas() {
		limpiarPantalla();
		scanner.nextLine();
		System.out.println("Datos del usuario:");
		System.out.println("-DPI: ");
		Long DPI= trylong();
		if (ValidarDuplicado(DPI)) 
		registrarReservas(DPI);
		else {System.out.println("DPI duplicado");}
                System.out.println("Presione '0'  para continuar...");
		scanner.next();
		
	}
	
	public static void buscar() {
		limpiarPantalla();
		System.out.println("DPI del usuario a buscar: ");
		opc = trylong();
		reservas = buscarReserva(opc);
		if (reservas != null) {
		System.out.println("DPI: "+reservas.getDPI());
		System.out.println("Nombre: "+reservas.getNombre());
		System.out.println("Marca: "+reservas.getMarca());
		System.out.println("Color: "+reservas.getColor());
		System.out.println("Placa: "+reservas.getPlaca());
		}
		else {System.out.println("Usuario no existente");}
                System.out.println("Presione '0'  para continuar...");
		scanner.next();
		
	}
	
	public static void listaReservas() {
		limpiarPantalla(); 
		llenardata();
		for (Reservas reservas : listaReservas) {
					System.out.println("DPI: " + reservas.getDPI());
                    System.out.println("Nombre: " + reservas.getNombre());
                    System.out.println("Marca: " + reservas.getMarca());
                    System.out.println("Color: " + reservas.getColor());
                    System.out.println("Placa: " + reservas.getPlaca());
                    System.out.println(" ");
                    
		}
                System.out.println("Presione '0'  para continuar...");
		scanner.next();
	}
	
	
	
	public static void limpiarPantalla() {
		for (int i = 0; i <= 20; i++)
			System.out.println();
	}
	
	public static void llenardata() {
		listaReservas = modificar.leerArchivo("C:\\Users\\usuarios\\Desktop\\GuarDatProyecto2\\Reservas.txt");
		}
	
	public static void registrarReservas(Long DPI) {
		
		String pos;
		
		reservas.setDPI(DPI);
		
		System.out.println("-Nombre: ");
		reservas.setNombre(trystring());
		
		System.out.println("Datos coche de "+reservas.getNombre()+": ");
		
		System.out.println("-Marca: ");
		reservas.setMarca(trystring());
		
		System.out.println("-Color: ");
		reservas.setColor(trystring());
		
		System.out.println("-Placa: ");
		reservas.setPlaca(tryfloat());
        
       
	}
	
	public static Reservas transReserva(Long DPI) {
		llenardata();
		for (int i = 0; i<=listaReservas.size()-1;i++)
			{Reservas reservas = listaReservas.get(i);
			if (reservas.getDPI().equals(DPI)){
				listaReservas.remove(i);
				return reservas;}}
		return null;
		
	}
	
	public static Boolean ValidarDuplicado(Long DPI) {
		for (Reservas reserva: listaReservas)
			if (reserva.getDPI().equals(DPI)) {
				return false;}
		return true;
}
	
	public static Reservas buscarReserva(Long DPI) {
		for (Reservas reservas : listaReservas)
			if (reservas.getDPI().equals(DPI))
				return reservas;

		return null;
	}

	public static int tryint() {
		int opc;
		do {	
		
			try {
			opc = 0;
			scanner = new Scanner(System.in);
			opc = scanner.nextInt();
			} catch (InputMismatchException e) {
			opc = 0;
			System.out.println("Incorrecto, Intente de nuevo");}
			}
			while(opc==0);
	return opc;	 
		}

	public static String trystring() {
		String opc;
		do {	
		
			try {
			opc = "";
			scanner = new Scanner(System.in);
			opc = scanner.nextLine();
			} catch (InputMismatchException e) {
			opc = "";
			System.out.println("Incorrecto, intente de nuevo: ");}
			}
			while(opc=="");
	return opc;	 
		}
	
	public static Float tryfloat() {
		Float opc;
		do {	
		
			try {
			opc = 0f;
			scanner = new Scanner(System.in);
			opc = scanner.nextFloat();
			} catch (InputMismatchException e) {
			opc = 0f;
			System.out.println("Incorrecto, intente de nuevo: ");}
			}
			while(opc==0f);
	return opc;	 
		}
	
	public static Double trydouble() {
		Double opc;
		do {	
		
			try {
			opc = 0d;
			scanner = new Scanner(System.in);
			opc = scanner.nextDouble();
			} catch (InputMismatchException e) {
			opc = 0d;
			System.out.println("Incorrecto, intente de nuevo: ");}
			}
			while(opc==0d);
	return opc;	 
		}
	
	public static Long trylong() {
		Long opc;
		do {	
		
			try {
			opc = 0l;
			scanner = new Scanner(System.in);
			opc = scanner.nextLong();
			} catch (InputMismatchException e) {
			opc = 0l;
			System.out.println("Incorrecto, intente de nuevo: ");}
			}
			while(opc==0l);
	return opc;	 
		}
}
