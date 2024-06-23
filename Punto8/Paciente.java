package Punto8;

public class Paciente 
{
	private int DNI;
	private String nombre;
	private String apellido;
	private int telefono;
	
	//Constructor.
	public Paciente(int DNI, String nombre, String apellido) 
	{
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = 0;
	}


	public int getDNI() {
		return this.DNI;
	}

	public void setDNI(int dni) {
		this.DNI = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Paciente [DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ "]";
	}
}
