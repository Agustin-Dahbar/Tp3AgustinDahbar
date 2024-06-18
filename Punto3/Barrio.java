package Punto3;
import java.util.ArrayList;

public class Barrio 
{
	private String nombre;
	private ArrayList<Propiedad> listaPropiedadesEnVenta;
	
	public Barrio(String nombre) 
	{
		this.nombre = nombre;
		listaPropiedadesEnVenta= new ArrayList<>();
	}
	
	//Mostramos propiedades de un TIPO ESPECÍFICO
	public void mostrarPropiedades(TIPO_PROPIEDAD tipo) 
	{
		//Iteramos por la lista de propiedades.
        for (Propiedad propiedad : listaPropiedadesEnVenta) 
        {
            if (propiedad.getTipo() == tipo) //Si el tipo de propiedad coincide con el recibido se mostrará
            {
                System.out.println(propiedad.getDomicilio() + " cuesta " + propiedad.getPrecio() + "$"); //Mostamos dos atributos de ella..
            }
        }
    }
	
	//Mostramos todas las propiedades
	public void mostrarPropiedades() 
	{
		for(Propiedad propiedadIterada : this.listaPropiedadesEnVenta)//Iteramos por la lista con un bucle foreach 
		{
			System.out.println(propiedadIterada); //Printeamos cada instancia/objeto iteado/a.
		}
	}
	
	//Obtenemos la cantidad de propiedades del barrio.
	public int contamosPropiedades() 
	{
		return this.listaPropiedadesEnVenta.size();
		
	}
	
	public ArrayList<Propiedad> getListaPropiedades()
	{
		return this.listaPropiedadesEnVenta;
	}
	
	public void añadirPropiedad(Propiedad propiedad) 
	{
		this.listaPropiedadesEnVenta.add(propiedad);
	}
	
	@Override
	public String toString() {
		return "Barrio [nombre=" + nombre + ", listaPropiedadesEnVenta=" + listaPropiedadesEnVenta + "]";
	}
}
