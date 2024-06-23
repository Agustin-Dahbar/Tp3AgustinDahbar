package Punto5;
import java.util.Date;

public class Ejemplar 
{
	private int id;
	private ESTADO estado; 
	private Date fechaPrestamo; 
	
	public Ejemplar(int id) 
	{
		this.id = id;
		this.estado = ESTADO.EN_BIBLIOTECA;
		this.fechaPrestamo = null;
	}
	
	public ESTADO getEstado() 
	{
		return this.estado;
	}
	
	public void setEstado(ESTADO estado) 
	{
		this.estado = estado; 
	}

	public void setFechaPrestamo(Date date) 
	{
		this.fechaPrestamo = date;
		
	}
}
