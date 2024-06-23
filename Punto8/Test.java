package Punto8;

public class Test 
{
	public static void main(String[] args) 
	{
		AgendaMedica primerDia = new AgendaMedica(5);
		Paciente agustin = new Paciente(43030679, "Agustin", "Dahbar");
		Paciente ruben = new Paciente(38456987, "Ruben", "Gutierrez");
		
		System.out.println(primerDia.registrarTurno(agustin));
		System.out.println(primerDia.tieneTurnoPaciente(43030679));
		
		System.out.println(" ");
		
		Turno nuevoTurno = new Turno(ruben);
		primerDia.agregarTurno(nuevoTurno);//Agregamos el turno en la lista de la agenda.
		primerDia.listarTurnosAsignados(); // 
		
		System.out.println(" ");
		System.out.println("Ausentes: "+ primerDia.obtenerAusentes());
		
		System.out.println("Anulamos el turno de Agustin.");
		primerDia.darPresente(43030679); //Damos el presente y setteamos el valor a true del atributo sePresento del turno relacionado
		//primerDia.anularTurno(43030679); //Se anula correctamente el turno
		System.out.println("Ausentes: " + primerDia.obtenerAusentes());
		
		System.out.println(" ");
		primerDia.darPresente(38456987);
		System.out.println("Ausentes: " + primerDia.obtenerAusentes());
		//Todos los metodos funcionan correctamente. Descomentar anularTurno y comentar darPresente() para comprobar ese. 
		
		
		
	}
}
