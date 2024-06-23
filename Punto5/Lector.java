package Punto5;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Lector 
{
	private int DNI;
	private String nombre;
	private String direccion;
	private String telefono;
	private int diasDeMulta;
	private ArrayList<Prestamo> prestamos;
		
	
	public Lector(int DNI, String nombre, String direccion, String telefono, int diasDeMulta) 
	{
	        this.DNI = DNI;
	        this.nombre = nombre;
	        this.direccion = direccion;
	        this.telefono = telefono;
	        this.diasDeMulta = diasDeMulta;
	        this.prestamos = new ArrayList<>();
    }

	
	public ArrayList<Prestamo> getPrestamosVigentes() 
	{
	        return this.prestamos;
    }

	public void agregarPrestamo(Prestamo prestamo)
	{
		this.prestamos.add(prestamo);
	}
	
	public int getDiasDeMulta() 
	{
		return this.diasDeMulta;
	}
}

