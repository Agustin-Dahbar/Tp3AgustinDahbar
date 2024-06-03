package Punto1;

public class Test 
{
	public static void Main(String[] args) 
	{
		Persona yo = new Persona("Agustin", "Dahbar", 43030679);
		Persona profesor = new Persona("Ruben", "Gutierrez", 37987465);
		Persona messi = new Persona("Lionel", "Messi", 35067890);
		
		Agenda agenda = new Agenda();
		
		boolean rta = agenda.agregarPersona("Agustin", "Dahbar", 43030679);
		
		if(rta) 
		{
			System.out.println("Agregado correctamente");
		}
		else 
		{
			System.out.println("Esta persona ya existe.");
		}
	}

}
