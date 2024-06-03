package Punto1;

public class Persona 
{
	//Atributos privados.
	private String nombre;
	private String apellido;
	private int DNI;
	private Domicilio domicilio;
	
	
	//Constructor por defecto
	public Persona() 
	{
		nombre = "";
		apellido = "";
	}
	
	public Persona(String nombre, String apellido) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	//Constructor pedido por la CuentaBancaria en el punto 9.
	public Persona(String nombre, String apellido, int DNI) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
	}
	
	//Setters
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	
	public void setDni(int dni) 
	{
		this.DNI = dni;
	}
	
	public void setDomicilio(Domicilio domicilio) 
	{
		this.domicilio = domicilio;
	}
	
	//Getters
	public String obtenerNombreCompleto() 
	{
		return nombre + " " + apellido;
	}
	
	public int obtenerDNI() 
	{
		return DNI;
	}
	
	
	//To String
	@Override
	public String toString() {
		return "" + nombre + " " + apellido;
	}
}
