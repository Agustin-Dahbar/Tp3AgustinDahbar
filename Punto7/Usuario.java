package Punto7;
import java.util.ArrayList;

public class Usuario 
{
	private String email;
	private String apellido;
	private int edad;
	private CATEGORIA categoria;
	private ArrayList<Cancion> historialDelUsuario;
	private int limiteDiario;
	
	public Usuario(String email, String apellido, int edad, CATEGORIA categoria) 
	{
		this.email = email;
		this.apellido = apellido; 
		this.edad = edad;
		this.categoria = categoria;
		this.historialDelUsuario = new ArrayList<>();
	}

	//Comprobamos si el usuario puede seguir escuando musica según su membresía..
	public void agregarCancionAlHistorial(Cancion cancion) 
	{
		if((this.categoria == CATEGORIA.GRATUITO || this.categoria == CATEGORIA.REGISTRADO)) //Si el usuario no es premium y la cancion es restringida
		{
			if(cancion.esRestringida()) 
			{
				System.out.println("La canción " + cancion.getNombre() + " está restringida para el usuario gratuito.");
			}
			else if(historialDelUsuario.size() >= 50) 
			{
				System.out.println("Se ha alcanzado el maximo de 50 visitas diarias para tu membresia.");
			}
		}
		else 
		{
			this.historialDelUsuario.add(cancion);
		}
	}
	
	public boolean limiteAlcanzado() 
	{
		if(this.categoria == CATEGORIA.GRATUITO && limiteDiario >= 50) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public ArrayList<Cancion> getHistorial()
	{
		return this.historialDelUsuario;
	}
	
	public String getEmail() 
	{
		return this.email;
	}
	
	public CATEGORIA getCategoria() 
	{
		return this.categoria;
	}
}
