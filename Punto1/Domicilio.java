package Punto1;

public class Domicilio {

	//Atributos privados.
	private String calle;
	private int numero;
	private String ciudad;
	
	//Constructor por defecto.
	public Domicilio() 
	{
		this.calle = "";
		this.numero = 0;
		this.ciudad = "";
	}
	
	//Constructor parametrizado (usado en CuentaBancaria punto 9)
	public Domicilio(String calle, int numero, String ciudad) 
	{
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
	}
	
	
	//Setters
	public void setCalle(String calle) 
	{
		this.calle = calle;
	}
	
	public void setNumero(int numero) 
	{
		this.numero = numero;
	}
	
	public void setCiudad(String ciudad) 
	{
		this.ciudad = ciudad;
	}
	
	
	//Getters
	public String getCalle() {
		return calle;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getCiudad() 
	{
		return ciudad;
	}
	
	//ToString
	@Override
	public String toString() {
		return ""+ calle + " " + numero + " "+ ciudad + "";
	}
	
}
