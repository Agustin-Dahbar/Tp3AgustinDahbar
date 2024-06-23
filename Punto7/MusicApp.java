package Punto7;
import java.util.ArrayList;

public class MusicApp 
{
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Cancion> listaCanciones;
	
	public MusicApp() 
	{
		this.listaUsuarios = new ArrayList<>();
		this.listaCanciones = new ArrayList<>();
	}
	
	private Cancion buscarCancion(Cancion cancion) 
	{
		int i = 0;
		Cancion cancionBuscada = null;
		
		while(i < this.listaCanciones.size() && cancionBuscada == null) 
		{
			Cancion cancionIterada = this.listaCanciones.get(i);
			
			if(cancionIterada.getNombre().equals(cancion.getNombre()) && cancionIterada.getAutor().equals(cancion.getAutor())) 
			{
				cancionBuscada = cancionIterada;
			}
			
			i++;
		}
		
		return cancionBuscada;
	}
	
	public Cancion agregarCancion(Cancion cancion) 
	{
		Cancion cancionExistente = buscarCancion(cancion);
		
		if(cancionExistente == null) 
		{
			this.listaCanciones.add(cancion);
			System.out.println("Cancion agregada");
		}
		else 
		{
		 System.out.println("Ya existe una cancion con el nombre " +  cancion.getNombre() + " y con el autor " + cancion.getAutor());
		}
		
		return cancionExistente;
	}
	
	//Buscamos usuario con el email.
	private Usuario buscarUsuario(String emailRecibido) 
	{
		int i = 0;
		Usuario usuarioBuscado = null;
		
		while(i < this.listaUsuarios.size() && usuarioBuscado == null) 
		{
			Usuario usuarioIterado = this.listaUsuarios.get(i);
			
			if(usuarioIterado.getEmail().equals(emailRecibido)) 
			{
				usuarioBuscado = usuarioIterado;
				System.out.println("Se encontró al usuario con este dni.");
			}
			
			i++;
		}
		
		return usuarioBuscado;
	}
	
	
	//Getters de las listas
	public ArrayList<Usuario> getListaUsuarios()
	{
		return this.listaUsuarios;
	}
	
	public ArrayList<Cancion> getListaCanciones()
	{
		return this.listaCanciones;
	}
	
}
