package Punto7;
import java.util.ArrayList;

public class Aplicacion 
{
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Cancion> listaCanciones;
	
	public Aplicacion() 
	{
		this.listaUsuarios = new ArrayList<>();
		this.listaCanciones = new ArrayList<>();
	}
	
	private Cancion buscarCancion(String nombreCancion, String nombreAutor) 
	{
		int i = 0;
		Cancion cancionBuscada = null;
		
		while(i < this.listaCanciones.size() && cancionBuscada == null) 
		{
			Cancion cancionIterada = this.listaCanciones.get(i);
			
			if(cancionIterada.getNombre().equals(nombreCancion) && cancionIterada.getAutor().equals(nombreAutor)) 
			{
				cancionBuscada = cancionIterada;
			}
			
			i++;
		}
		
		return cancionBuscada;
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
	
	//3.
	public boolean altaCancion(String nombreCancion, String nombreAutor) 
	{
		Cancion existeCancion = buscarCancion(nombreCancion, nombreAutor);
		boolean resultado = false;
			
		if(existeCancion == null) //Si esta nueva canción no está en la lista..
		{
			Cancion nuevaCancion = new Cancion(nombreCancion, nombreAutor);
			this.listaCanciones.add(nuevaCancion); //se añade a la lista
			resultado = true;
			System.out.println("Cancion agregada");
		}
		else 
		{
			System.out.println("Ya existe una cancion con el nombre " +  nombreCancion + " y con el autor " + nombreAutor);
		}

		return resultado;
	}
	
	//4. 
	public boolean altaUsuario(String email, String apellido, int edad, CATEGORIA categoria) 
	{
		Usuario seEncontro = buscarUsuario(email);
		boolean resultado = false;
		
		if(seEncontro == null) 
		{
			Usuario usuarioNuevo = new Usuario(email, apellido, edad, categoria);
			this.listaUsuarios.add(usuarioNuevo);
			resultado = true;
			System.out.println("Usuario agregado");
		}
		
		return resultado;
	}
	
	
	public RESULTADO escucharCancion(String email, String nombreCancion, String autor) 
	{
		Usuario seEncontroUser = buscarUsuario(email);
		Cancion seEncontroSong = buscarCancion(nombreCancion, autor);
		RESULTADO resultado = RESULTADO.USUARIO_INEXISTENTE;
		
		if(seEncontroUser != null && seEncontroSong != null) 
		{
			seEncontroUser.agregarCancionAlHistorial(seEncontroSong); //Escuchamos la canción. Es decir, la agregamos al historial del usuario.
			seEncontroSong.incrementarVisitas(); //Aumentamos el conteo de visitas de la canción.
			resultado = RESULTADO.CANCION_ESCUCHADA;
		}
		if(seEncontroSong == null) 
		{
			resultado = RESULTADO.CANCION_INEXISTENTE;
		}
		if(seEncontroUser == null) 
		{
			resultado = RESULTADO.USUARIO_INEXISTENTE;
		}
		if(seEncontroUser.limiteAlcanzado()) 
		{
			resultado = RESULTADO.LIMITE_ALCANZADO;
		}
		if(seEncontroUser.getCategoria() != CATEGORIA.PREMIUM) 
		{
			resultado = RESULTADO.CANCION_NO_DISPONIBLE;
		}
		
		return resultado;
	}

	
	public void listarUsuarios() 
	{
		for(Usuario usuarioIterado: this.listaUsuarios) 
		{
			System.out.println("Usuarios " + usuarioIterado);
			System.out.println("Historial " + usuarioIterado.getHistorial());
		}
	}
	
	public void listarCancionesPorUsuario(String emailUsuario) 
	{
		Usuario seEncontro = buscarUsuario(emailUsuario);
		
		if(seEncontro != null) 
		{
			for(Cancion cancionIterada: seEncontro.getHistorial()) 
			{
				System.out.println(cancionIterada);
			}
			
			System.out.println("Listado exitoso");
		}
		else 
		{
			System.out.println("Usuario inexistente");
		}
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
