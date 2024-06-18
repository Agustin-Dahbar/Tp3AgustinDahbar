package Punto3;

public class Propiedad 
{
	private String domicilio;
	private int precio;
	private TIPO_PROPIEDAD tipo;
	
	public Propiedad(String domicilio, int precio, TIPO_PROPIEDAD tipo)
	{
		this.domicilio = domicilio;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	
	public int getPrecio() 
	{
		return this.precio;
	}
	
	public String getDomicilio() 
	{
		return this.domicilio;
	}
	
	public TIPO_PROPIEDAD getTipo() 
	{
		return this.tipo;
	}
	
	@Override
	public String toString() 
	{
		return "Propiedad =" + this.domicilio  + " cuesta " + this.precio + "$" + " es " + this.tipo;
	}
	
}
