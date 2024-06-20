package Punto1;
import java.util.ArrayList;

public class Agenda 
{
	//Atributo de la agenda que es una ArrayList tipo persona.
	private ArrayList<Persona> listaDePersonas;
	
	//Constructor
	public Agenda() 
	{
		this.listaDePersonas = new ArrayList<Persona>();
	}
	
	
	//SOLICITUDES HTTPS (POST-GET-PUT-DELETE)-- CRUD(INSERT, SELECT, UPDATE, DELETE) Query´s database.
	//Query select solicitud get.
	//Metodo privado que devuelve un objeto Persona o null según si se encontró la persona mediante el while que iterará la lista y en cada iteración obtendrá una persona diferente de la lista	
	private Persona buscarPersona(int dni) 
	{
		int i = 0;
		Persona personaEncontrada = null;
		
		while(i < this.listaDePersonas.size() && personaEncontrada == null) 
		{
			Persona personaIterada = this.listaDePersonas.get(i);
			
			if(personaIterada.getDNI() == dni) 
			{
				personaEncontrada = personaIterada;
			}
			
			i++;
		}
		
		return personaEncontrada;
	}
	
	//Query Insert (base datos) solicitud post.
	public Persona agregarPersona(String nombre, String apellido, int dni) 
	{	
		Persona personaAgregada = buscarPersona(dni); //Validamos si el dni ya existe en la lista de personas de la clase Agenda.
		
		if(personaAgregada == null) //Si no esta registrado, creamos a la persona..
		{
			personaAgregada = new Persona(nombre,apellido,dni); //Instanciamos la clase con los parámetros recibidos.
			this.listaDePersonas.add(personaAgregada); //La añadimos a la lista
			System.out.println("Persona agregada exitosamente [DNI " + dni + "]");
		}
		
		return personaAgregada; //Devuelve a la persona creada o null depende del resultado de la línea 42.
	}
	

	//Metodo que devuelve un objeto tipo persona o null. 
	public Persona removerPersona(int DNI) 													//DELETE
	{
		 Persona personaEliminada = buscarPersona(DNI);
		 
		 if(personaEliminada == null) 
		 {
			 System.out.println("No existe persona con tal DNI.");
		 }
		 else 
		 {
			 this.listaDePersonas.remove(personaEliminada);
			 System.out.println("Se ha eliminado la persona.");
		 }	 
		 
		 return personaEliminada;
	}
	
	//Metodo que devuelve un valor booleano según si se realizó el objetivo del metodo.
	public boolean modificarDomicilio(int DNI, Domicilio domicilio) 
	{																																//UPDATE
		Persona personaEncontrada = buscarPersona(DNI); //Buscamos la persona a la que le queremos cambiar el domicilio.
		boolean resultado = false;
		
		if(personaEncontrada != null)//Si la encontramos 
		{ 
			personaEncontrada.setDomicilio(domicilio); //Le setteamos el domicilio con el metodo correspondiente.
			System.out.println("Cambio de domicilio exitoso");
			resultado = true;
		}
		
		return resultado;
	}

	//listarPersonas();
	public void listarPersonas() 
	{
		for(Persona personaIterada: this.listaDePersonas) //Iteramos por toda la lista
		{
			System.out.println(personaIterada); //Print cada elemento de la lista.
		}
	}

	
	//Metodo que imprime todas las personas de la ListArray. Una por cada iteración via bucle while.
	public void listarPersonasWhile() 											//SELECT
	{
		int i = 0; //Indice usado en la condición del while, y para obtener a las personas del ArrayList.
		Persona personaIterada = null; //Variable que almacenará en diferentes iteraciones a todas las personas de la lista para imprimirlas.
		
		while(i < this.listaDePersonas.size()) //Iterará por la lista.
		{
			personaIterada = this.listaDePersonas.get(i); //Obtenemos la persona iterada.
			System.out.println(personaIterada); //La mostramos
			i++; //Continuamos las iteraciones aumentando la variable de conteo correspondiente.
		}
	}
	
	//Método público devolverUltimo() que no recibe parámetros y devuelve el
	//último elemento de la lista (si es que ésta contiene elementos).
	public Persona devolverUltimo() 									//SELECT
	{
		Persona ultimaPersona = null; //Variable que almacenará a la última persona del ListArray.
		
		if(this.listaDePersonas.size() != 0) //Si la lista tiene elementos.
		{
			ultimaPersona = this.listaDePersonas.get(this.listaDePersonas.size() - 1); //Encontramos a la última persona mediante indexación en 0, por eso le debemos restar uno al size del list, ya que ese valor si es indexado natural (1-10)
			System.out.println("Ultima persona registrada: " + ultimaPersona);
			
		}
		else 
		{
			System.out.println("La lista no posee personas registradas.");
		}
		
		return ultimaPersona;
	}
	
	//Metodo que elimina todos los elementos de la lista de a uno mediante un bucle while 				DELETE
	public void eliminarTodosElementosAmano() 
	{
		while(!(this.listaDePersonas.isEmpty())) //Mientras el listArray no este vació..
		{
			this.listaDePersonas.remove(0);//Removemos su primer elemento (siempre lo tendrá hasta quedar vacío.
		}
		
		System.out.println("Se han eliminado todos los elementos de la lista, uno por uno.");
	}
	
	//Mismo metodo que buscarPersona() pero publico ya que precise usarlo en el test.
	public Persona getPersona(int dni) 
	{
		Persona personaEncontrada = null;
		int i = 0;
		
		while(i < this.listaDePersonas.size() && personaEncontrada == null) 
		{
			Persona personaIterada = this.listaDePersonas.get(i);
			
			if(personaIterada.getDNI() == dni) 
			{
				personaEncontrada = personaIterada;
			}
		}
		
		return personaEncontrada;
	}
	
	//ToString
	@Override
	public String toString() 
	{
		return "Agenda [Lista = " + this.listaDePersonas + "]";
	}
	
}
