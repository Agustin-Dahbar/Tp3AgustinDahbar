package Punto6;
import java.util.ArrayList;

public class ORTFlix 
{
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Cliente> listaNegra;
	private ArrayList<Pelicula> listaPeliculas;
	
	public ORTFlix() 
	{
		this.listaClientes = new ArrayList<>();
		this.listaNegra = new ArrayList<>();
		this.listaPeliculas = new ArrayList<>();
	}
	
	private Cliente buscarCliente(int dni) 
	{
		int i = 0;
		Cliente clienteEncontrado = null;
		
		while(i < this.listaClientes.size() && clienteEncontrado == null) 
		{
			Cliente clienteIterado = this.listaClientes.get(i);
			
			if(clienteIterado.getDni() == dni) 
			{
				clienteEncontrado = clienteIterado;
			}
			
			i++;
		}
		
		return clienteEncontrado;
	}
	
	private Pelicula buscarPelicula(String peliculaDeseada) 
	{
		int i = 0;
		Pelicula peliculaEncontrada = null;
		
		while(i < this.listaPeliculas.size() && peliculaEncontrada == null) 
		{
			Pelicula peliculaIterada = this.listaPeliculas.get(i);
			
			if(peliculaIterada.getNombre().equals(peliculaDeseada)) 
			{
				peliculaEncontrada = peliculaIterada;
			}
			
			i++;
		}
		
		return peliculaEncontrada;
	}
	
	public RESULTADOS verPelicula(int dni, String nombrePelicula) 
	{
		Cliente clienteEncontrado = buscarCliente(dni);
		RESULTADOS resultado = RESULTADOS.CLIENTE_DEUDOR;
		
		if(clienteEncontrado == null) 
		{
			System.out.println("Dni no encontrado");
			resultado = RESULTADOS.CLIENTE_INEXISTENTE;
		}
		else if(clienteEncontrado.esDeudor()) //Que se evalúe este else if implica que clienteEncontrado != null. Por lo tanto no es necesario escribir eso.
		{
			System.out.println("El cliente posee deuda");
			resultado =  RESULTADOS.CLIENTE_DEUDOR;
		}
		
		Pelicula peliculaEncontrada = buscarPelicula(nombrePelicula);
		
		if(peliculaEncontrada == null) 
		{
			System.out.println("La película no existe.");
			resultado = RESULTADOS.CONTENIDO_INEXISTENTE;
		}
		else if(clienteEncontrado.getServicio() == SERVICIOS.PREMIUM) 
		{
			System.out.println("La pelicula está disponible.");
			clienteEncontrado.agregarPeliculaAlHistorial(peliculaEncontrada);
			resultado = RESULTADOS.OK;
		}
		else if(clienteEncontrado.getServicio() == SERVICIOS.STANDAR && peliculaEncontrada.getServicio() == SERVICIOS.PREMIUM) 
		{
			System.out.println("La pelicula no es accesible para tu membresía.");
			resultado = RESULTADOS.CONTENIDO_NO_DISPONIBLE;
		}
		
		return resultado;
		
	}
	
	public void darDeBaja(int dni) 
	{
		Cliente clienteEncontrado = buscarCliente(dni);
		
		if(clienteEncontrado != null) 
		{
			this.listaClientes.remove(clienteEncontrado);
			System.out.println("Cliente eliminado.");
			
			if(clienteEncontrado.esDeudor()) 
			{
				this.listaNegra.add(clienteEncontrado);
			}
		}
		else 
		{
			System.out.println("No se encontró cliente con ese DNI.");
		}
	}
	
	public ESTADO_CLIENTE darDeAlta(int dni, SERVICIOS servicio) 
	{
		Cliente clienteEncontrado = buscarCliente(dni);
		ESTADO_CLIENTE resultado = ESTADO_CLIENTE.CLIENTE_DEUDOR;
		
		if(clienteEncontrado == null) 
		{
			Cliente nuevoCliente = new Cliente(dni, servicio);
			this.listaClientes.add(nuevoCliente);
			resultado = ESTADO_CLIENTE.ALTA_OK;
			System.out.println("Cliente dado de alta..");
		}
		else 
		{
			resultado = ESTADO_CLIENTE.CLIENTE_EXISTENTE;
			System.out.println("Ya existe un cliente registrado con este DNI.");
			
			if(clienteEncontrado.esDeudor()) 
			{
				resultado = ESTADO_CLIENTE.CLIENTE_DEUDOR;
			}
		}
		
		return resultado;
	}
	
	
	public void depurarListaNegra(int importe) 
	{
		int i = 0;
		
		while(i < this.listaNegra.size()) 
		{
			Cliente clienteIterado = this.listaNegra.get(i);
			
			if(clienteIterado.getImporteDeuda() <= importe) 
			{
				this.listaNegra.remove(i);
				System.out.println("Cliente eliminado de la lista negra.");
			}
			else 
			{
				System.out.println("El cliente adeuda mas. No se puede eliminar de la lista negra.");
				i++;//Ahora si iteramos y no saltearemos a nadie.
			}
			
			//i++; //Esto esta MAL. Ya que al realizar el remove se elimina un elemento, por lo que se les resta un valor del índice si además aumentamos el valor de i vamos a saltearnos un elemento cada vez que se realice un remove.
			//Ej: 3 elementos [0,1,2] eliminamos 0. Ahora 1 vale 0 y 2 vale 1. Si aumentamos i y ahora vale uno vamos a eliminar al último elemento, salteando al segundo que ahora esta primero por el remove.
			
		}
	}
	
	public void agregarPelicula(Pelicula pelicula) 
	{
		this.listaPeliculas.add(pelicula);
	}
	
}
