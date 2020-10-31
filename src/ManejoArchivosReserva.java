import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ManejoArchivosReserva {
public void modificarArchivo(String nombreArchivo, String contenido) {
		
		File archivo = new File(nombreArchivo);
		
		try {
			PrintWriter escritura = new PrintWriter(new FileWriter(archivo,true));
			escritura.println(contenido);
			escritura.close();
			System.out.println("Archivo guardado..");
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		
	}

public List<Reservas> leerArchivo(String nombreArchivo) {
	
	List<Reservas> reservas = new ArrayList<Reservas>();
	
	File archivo = new File(nombreArchivo);
	
	try {
		BufferedReader lectura = new BufferedReader(new FileReader(archivo));
		String archivoLeido = lectura.readLine();
		while (archivoLeido != null) {
			Reservas reserva = new Reservas();
			String datosReservas[] = archivoLeido.split(" & ");
			reserva.setDPI(Long.parseLong(datosReservas[0]));
			reserva.setNombre(datosReservas[1]);
			reserva.setMarca(datosReservas[2]);
			reserva.setColor(datosReservas[3]);
			reserva.setPlaca(Float.parseFloat(datosReservas[4]));
			reservas.add(reserva);
			archivoLeido = lectura.readLine();
		}
		lectura.close();
	} catch (FileNotFoundException e) {
		System.out.println("Archivo reserva no encontrado");
	} catch (IOException e) {
		e.printStackTrace(System.out);
	}
	
	return reservas;
	
}

public void modificarReserva(String nombreArchivo, List<Reservas> reserva) {
	
	File archivo = new File(nombreArchivo);
	
	try {
		PrintWriter escritura = new PrintWriter(archivo);
		for (Reservas reserva1 : reserva)
			escritura.println(reserva1.toString());
		escritura.close();
		System.out.println("Archivo generado..");
	} catch (FileNotFoundException e) {
		e.printStackTrace(System.out);
	}
}
	
}

