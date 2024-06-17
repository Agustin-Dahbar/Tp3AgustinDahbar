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
	
	//Mismo metodo que buscarPersona pero público para poder usarlo en el metodo main de Test.java .
	public Persona getPersona(int dni) 
	{
		Persona personaEncontrada = null;
		
		for(Persona personaIterada:this.listaDePersonas) 
		{
			if(personaIterada.getDNI() == dni) 
			{
				personaEncontrada = personaIterada;
				return personaEncontrada;
			}
		}
		
		return null;
	}
	
	//Metodo privado que devuelve un objeto Persona o null según si se encontró la persona mediante el while que iterará la lista y en cada iteración obtendrá una persona diferente de la lista
	private Persona buscarPersona(int dni)												//SELECT 
	{									
		//Iteramos por la lista de personas con un bucle foreach.
		for(Persona personaIterada: this.listaDePersonas) 
		{
			Persona personaEncontrada = null; // Incializamos con este valor para utilizarlo en la condición del bucle while, además será su valor final 
			
			if(personaIterada.getDNI() == dni) //Evalúamos si la persona iterada coincide en DNI con el recibido. (Lógica para encontrar la persona)
			{ 
				personaEncontrada = personaIterada;
				return personaEncontrada;
			}
		}
		
		//Salidos del bucle foreach significa que se iteró toda la ArrayList y no se encontró a la persona, por lo tanto devolvemos null.
		return null;
	}
	
	
	//Metodo que devuelve un valor bool que indicará si se agregó la persona o no por ya estar registrado su DNI parametrizado.
	public boolean agregarPersona(String nombre, String apellido, int DNI) 						//INSERT
	{
		Persona personaEncontrada = buscarPersona(DNI); //Validamos si existe una persona con los datos recibidos 
		
		boolean resultado = false;
		
		if(personaEncontrada == null) //Si no encontramos la persona, el DNI está disponibles y procedemos a crearla.
		{
			Persona persona = new Persona(nombre, apellido, DNI); //Usamos los 3 parametros para instanciar su clase, por lo tanto crear el objeto.
			this.listaDePersonas.add(persona); //Lo añadimos a la lista de la clase Agenda.
			System.out.println("Se creó la persona correctamente");
			resultado = true;
		}
		else //Si encontramos a una persona con ese DNI..
		{
			System.out.println("Este DNI ya está registrado.");
		}
		
		return resultado;
	}
	
	//Metodo que devuelve un objeto tipo persona o null. 
	public Persona removerPersona(int DNI) 													//DELETE
	{
		 Persona personaEliminada = null;
		 Persona personaBuscada= buscarPersona(DNI);
		 
		 if(personaBuscada == null) 
		 {
			 System.out.println("No existe persona con tal DNI.");
			 return null;
		 }
		 else 
		 {
			 personaEliminada = personaBuscada;
			 this.listaDePersonas.remove(personaBuscada);
			 System.out.println("Se ha eliminado la persona.");
			 return personaEliminada;
		 }	 
	}
	
	//Metodo que devuelve un valor booleano según si se realizó el objetivo del metodo.
	public boolean modificarDomicilio(int DNI, Domicilio domicilio) 
	{																																//UPDATE
		Persona personaEncontrada = buscarPersona(DNI); //Buscamos la persona a la que le queremos cambiar el domicilio.
		
		if(personaEncontrada != null)//Si la encontramos 
		{ 
			personaEncontrada.setDomicilio(domicilio); //Le setteamos el domicilio con el metodo correspondiente.
			System.out.println("Cambio de domicilio exitoso");
			return true;
		}
		
		System.out.println("No se encontró a esa persona");
		return false;
	}

	//listarPersonas();
	public void listarPersonas() 
	{
		for(Persona personaIterada: this.listaDePersonas) 
		{
			System.out.println(personaIterada);
		}
	}

	
	//Metodo que imprime todas las personas de la ListArray. Una por cada iteración via bucle while.
	public void listarPersonasWhile() 											//SELECT
	{
		int i = 0; //Indice usado en la condición del while, y para obtener a las personas del ArrayList.
		int sizeList = listaDePersonas.size(); //Obtenemos la cantidad de elemenetos que posee la lista.
		Persona personaIterada = null; //Variable que almacenará en diferentes iteraciones a todas las personas de la lista para imprimirlas.
		
		while(i < sizeList) //Se ejecutará hasta que i tenga el valor anterior a sizeList
		{
			personaIterada = listaDePersonas.get(i); //Obtenemos una persona de la lista.
			System.out.println(personaIterada);
			i++;
		}
	}
	
	//Método público devolverUltimo() que no recibe parámetros y devuelve el
	//último elemento de la lista (si es que ésta contiene elementos).
	
	public Persona devolverUltimo() 									//SELECT
	{
		int sizeList = this.listaDePersonas.size(); //Obtenemos la cantidad de elementos de la lista.
		Persona ultimaPersona = null; //Variable que almacenará a la última persona del ListArray.
		
		if(sizeList != 0) //Si la lista tiene elementos.
		{
			ultimaPersona = this.listaDePersonas.get(sizeList - 1); //Encontramos a la última persona mediante indexación en 0, por eso le debemos restar uno al size del list, ya que ese valor si es indexado natural (1-10)
			System.out.println("Ultima persona registrada: " + ultimaPersona);
			return ultimaPersona;
			
		}
		else 
		{
			System.out.println("La lista no posee personas registradas.");
		}
		
		//Ya que usamos dos returns el else es innecesario, debido a que si se ejecuta el anterior, se corta el metodo.
		return null;
	}
	
	//Metodo que elimina todos los elementos de la lista de a uno mediante un bucle while 				DELETE
	public void eliminarTodosElementosAmano() 
	{
		while(!(this.listaDePersonas.isEmpty())) //Mientras el listArray no este vació..
		{
			this.listaDePersonas.remove(0);//Removemos su primer elemento
		}
		
		System.out.println("Se han eliminado todos los elementos de la lista, uno por uno.");
	}
	
	//ToString
	@Override
	public String toString() {
		return "Agenda [Lista = " + this.listaDePersonas + "]";
	}
	
}
