package Punto8;

public class Turno 
{
	private Paciente paciente;
	private boolean sePresento;
	
	public Turno(Paciente paciente) 
	{
		this.paciente = paciente;
		this.sePresento = false;
	}
	
	
	public Paciente getPaciente() 
	{
		return this.paciente;
	}
	
	public boolean sePresento() 
	{
		return this.sePresento;
	}
	
	public void setSePresento(boolean resultado) 
	{
		this.sePresento = resultado;
	}
	
}
