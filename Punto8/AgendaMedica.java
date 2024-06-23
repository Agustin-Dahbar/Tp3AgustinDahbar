package Punto8;

import java.util.ArrayList;

public class AgendaMedica 
{
	private ArrayList<Turno> turnosLista;
	private int cantTurnos;
	
	//Constructor de la AgendaMedica
	public AgendaMedica(int cantTurnos) 
	{
		this.turnosLista = new ArrayList<Turno>();
		
		//Validamos que haya turnos en el día. Si la cantidad es 0 o negativa se asigna a 0.
		if(cantTurnos > 0) 
		{
			this.cantTurnos = cantTurnos;	
		}
		else 
		{
			this.cantTurnos = 0;
		}
	}
	
	private Turno buscarTurno(int dni) 
	{
		Turno turnoEncontrado = null;
		int i = 0;
		
		while(i < this.turnosLista.size() && turnoEncontrado == null) 
		{
			Turno turnoIterado = this.turnosLista.get(i);
			
			if(turnoIterado.getPaciente().getDNI() == dni) 
			{
				turnoEncontrado = turnoIterado;
			}
			
			i++;
		}
		
		return turnoEncontrado;
	}
	
	public ESTADO registrarTurno(Paciente paciente) 
	{
		
		if(!(this.cantTurnos > 0)) //Si la cant turnos es 0 o menos
		{
			return ESTADO.MEDICO_SIN_TURNOS;
			
		}
		if(tieneTurnoPaciente(paciente.getDNI())) //si el paciente ya tiene turno
		{
		return ESTADO.PACIENTE_YA_TIENE_TURNO;	
		}
		else //Si hay turnos disponibles y el paciente no tiene turno, se lo registramos.
		{
			Turno nuevoTurno = new Turno(paciente); // lo creamos 
	 	    agregarTurno(nuevoTurno); // lo agregamos a la lista mediante un metodo secundario
	 	    this.cantTurnos--; // reducimos la cantidad de turnos disponibles
	        return ESTADO.TURNO_CONFIRMADO;
		}
		
    }
	
	//Metodos secundarios usados en el metodo principal anterior.
	//Nos informa si el paciente registrado por el dni recibido tiene turno en la lista de la agenda.
	public boolean tieneTurnoPaciente(int dni) 
	{
		int i = 0; //indice a usar para iterar por la lista, funciona como contador.
		boolean turnoEncontrado = false; //la variable a devolver con el valor bool correspondiente
		
		while(i < this.turnosLista.size() && !turnoEncontrado) //mientras aun haya turnos en la lista y el turno no se haya encontrado
		{
			Turno turnoIterado = this.turnosLista.get(i); // obtenemos el turno iterado
			
			if(turnoIterado.getPaciente().getDNI() == dni) //comparamos el dni de la persona del turno iterado con el dni recibido si son iguales indica que ya tiene turno
			{
				turnoEncontrado = true; // tiene turno, le damos el valor que corresponde a la variable a retornar.
			}

			i++; //aumentamos el índice para que la iteración sea exitosa.
        }
        
		return turnoEncontrado; //devolvemos la variable booleana pedida.
    }
	
	//metodo que agrega un turno a la lista de turnos de la agenda médica. 
	public void agregarTurno(Turno turno) 
	{
		this.turnosLista.add(turno);
		System.out.println("Se agrego el turno correctamente.");
	}
	
	public void listarTurnosAsignados() 
	{
		for(Turno turnoIterado : this.turnosLista) 
		{
			System.out.println(turnoIterado);
			Paciente paciente = turnoIterado.getPaciente();
			System.out.println("Paciente que reservó el turno: " + paciente);
		}
	}
	
	public boolean darPresente(int dni) 
	{
		int i = 0;
		boolean estaPresente = false;
		
		while(i < this.turnosLista.size() && !estaPresente) 
		{
			Turno turnoIterado = this.turnosLista.get(i);
			
			if(turnoIterado.getPaciente().getDNI() == dni) 
			{
				estaPresente = true; //Devolvemos si se encontró un turno con un paciente con el dni recibido por parámetro.
				turnoIterado.setSePresento(true); //Damos el presente
				System.out.println("El paciente esta presente.");
			}
			
			i++;
		}
		
		return estaPresente;
	}
	
	public boolean anularTurno(int dni) 
	{
		int i = 0;
		boolean anulacionExitosa = false;
		
		while(i < this.turnosLista.size() && !anulacionExitosa) 
		{
			Turno turnoIterado = this.turnosLista.get(i);
			
			if(turnoIterado.getPaciente().getDNI() == dni) 
			{
				this.turnosLista.remove(turnoIterado);
				anulacionExitosa = true;
			}
			
			i++;
		}
		
		return anulacionExitosa;
	}
	
	public ArrayList<Paciente> obtenerAusentes()
	{
		int i = 0;
		ArrayList<Paciente> pacientesAusentes = new ArrayList<>();
		
		while(i < this.turnosLista.size()) 
		{
			Turno turnoIterado = this.turnosLista.get(i);
			
			if(!(turnoIterado.sePresento()))
			{
				pacientesAusentes.add(turnoIterado.getPaciente());
			}
			
		  i++;
		}
		
		return pacientesAusentes;
	}
	
	
}
