package Punto1;

import java.util.ArrayList;

public class Agenda 	
{
	private ArrayList<Persona> personasList;
	
	//Constructor objeto agenda. Contiene un ArrayList que almacena objetos de la clase Persona.
	public Agenda() 
	{
		this.personasList = new ArrayList<Persona>();
	}
	
	//Metodo que busca a la persona. 																				(select)
	private Persona buscarPersona(int dni) 
	{
		int i = 0; //Índice.
		int sizeListArray = this.personasList.size(); //Obtenemos el size de la lista (la cantidad natural de elementos que posee)
		Persona personaEncontrada = null; //Variable que almacenará a la persona buscada.
		
		while(i < sizeListArray && personaEncontrada == null) //Mientras aún haya elementos en la lista y no hayamos encontrado a la persona la seguimos buscando..
		{
			Persona personaIterada = this.personasList.get(i); //Obtenemos el primer elemento de la lista [0], lo almacenamos. En la siguiente iteración (si la hay) se obtendrá el elemento de la posición [1]
			
			if(personaIterada.obtenerDNI() == dni) //Si la persona getteada coincide con el DNI argumentado en el metodo la encontramos.
			{
				personaEncontrada = personaIterada; //Asignamos a la persona encontrada en la iteración en la variable correspondiente.
			}
			else //Si no coincide con el DNI 
			{
				i++; //Aumentamos el valor del índice para en la siguiente iteración obtener el siguiente elemento de la lista, ahora en la posición [1]
			}
		}
		//Una vez salido del while significa que encontramos a la persona o que iteramos todo el ListArray sin encontrarla.
		return personaEncontrada; //Devuelve a la persona encontrada o null, según si se encontró una persona con el DNI argumentado.
	}
	
	//Metodo publico que devuelve un valor bool. 														(insert)
	public boolean agregarPersona(String nombre, String apellido, int dni) 
	{
		Persona personaEncontrada = buscarPersona(dni); //Buscamos si existe la persona con el dni argumentado.
		
		if(personaEncontrada == null) //Si no existe, la creamos con los 3 argumentos recibidos.
		{
			Persona agustin = new Persona("Agustin", "Dahbar", 43030679); 
			this.personasList.add(agustin); //Agregamos la persona a la ArrayList mediante su argumentación en el metodo add().
			return true; //Devolvemos true ya que se cumplió el nombre del metodo.
		}
		
		return false; //Devolvemos false ya que no se cumplió el nombre del metodo por ya existir la persona.
	}
	
	
	//Buscamos una persona para eliminarla. Si no existe, devolvemos null. 									(delete)
	public Persona removerPersona(int dni) 
	{
		Persona personaEliminada = null;
		
		Persona personaEncontrada = buscarPersona(dni); //Buscamos la persona a eliminar.
		
		if(personaEncontrada != null) //Si la encontramos
		{
			personaEliminada = personaEncontrada; //Antes de eliminarla, guardamos sus datos en una variable que funcionará de "papelera de reciclaje".
			this.personasList.remove(personaEncontrada); // Eliminamos a la persona encontrada.
		}
		
		return personaEliminada; //Retornamos a la persona eliminada o null, según se haya encontrado o no.
	}
	
	//Modificamos el domicilio 																			(update)
	public boolean modificarDomicilio(int dni, Domicilio domicilio) 
	{
		Persona persona = this.buscarPersona(dni); //Buscamos a la persona con el metodo correspondiente.
		
		if(persona != null) //Si encontramos a la persona..
		{
			persona.setDomicilio(domicilio); //Setteamos su domicilio.
			return true; //Devolvemos true ya que se llevo a cabo la acción que pretendía el metodo.
		}
		
		System.out.println("El DNI ingresado no corresponde a ningúna persona registrada.");
		return false; 
	}
	
	//Devolvemos a la ultima persona de la lista. 															(select)
	public Persona devolverUltimo() 
	{
		Persona ultimaPersona = null; //Variable que almacenará a la última persona.
	
		int sizeListArray = this.personasList.size(); //Obtenemos la posición indexada NATURALMENTE (comenzando en 1)
	
		if(sizeListArray != 0) //Si el ListArray tiene contenido, obtenemos a la ultima persona con el metodo get() y cierta lógica. 
		{
			ultimaPersona = this.personasList.get(sizeListArray - 1);
			//Para obtener la última persona le restamos a la indexación natural una unidad. Ya que la indexación de acceso a 
			//ListArrays comienza en 0.	
		}
	
		return null; //Si el ListArray tiene 0 elementos devolvemos null.
	}
	
	//Con un while eliminamos todos los elementos de la lista. (Uno por uno) Sin el clear(). 					(delete)
	public void eliminarTodosLosElementosAMano() 
	{
		//While que comprueba si la lista no esta vacia. Si no lo está da true y se realiza el remove del primer elemento en el índice 0, y así hasta que sea null. Una vez sea null, la condición dará false y no se ejecutará más.
		while(!this.personasList.isEmpty()) //Mientras la lista tenga contenido... (Diferente a Empty)
		{
			this.personasList.remove(0); //Se eliminará el primer elemento del ArrayList de personas. (Ya que no sabemos si existen dos o es el único. Solo sabemos que al menos hay un elemento.
		}
		
		System.out.println("Se vació el ListArray de personas."); //personasList.isEmpty() == TRUE;
	}
	
	//Otra condición podría ser while(this.personasList.size > 0). Si el listArray tiene más de 0 elementos.
	
	
}
