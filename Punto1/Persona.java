package Punto1;

public class Persona 
{
	private String nombre;
	private String apellido;
	private int DNI;
	private Domicilio domicilio;
	
	//Constructores (defecto, parametrizado)
	public Persona(String nombre, String apellido,int DNI) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
	}
	
	//Getters
	public int getDNI() {
		return this.DNI;
	}
	
	public void setDomicilio(Domicilio domicilio) 
	{
		this.domicilio = domicilio;
	}
	
	//ToString
	@Override
	public String toString() 
	{
		return "Persona [nombre=" + this.nombre + ", apellido=" + this.apellido + ", DNI=" + this.DNI + " " + this.domicilio;
	}
}
