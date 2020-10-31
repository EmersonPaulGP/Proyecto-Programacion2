public class Reservas {
	private String nombre;
	private Long DPI;
	private String color;
	private Float placa;
	private String marca;

public Reservas() {
	this ("",0l,"",0f,"");
}

public Reservas(String nombre, Long DPI, String color, Float placa, String marca) {
	super();
	this.nombre = nombre;
	this.DPI = DPI;
	this.marca = marca;
	this.color = color;
	this.placa = placa;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Long getDPI() {
	return DPI;
}
public void setDPI(Long dPI) {
DPI = dPI;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public Float getPlaca() {
	return placa;
}
public void setPlaca(Float placa) {
	this.placa = placa;
}

@Override
public String toString() {
    return  DPI+" & "+nombre+" & "+marca+" & "+color+" & "+placa;
}

}
