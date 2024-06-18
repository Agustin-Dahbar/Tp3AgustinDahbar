package Punto3;
import java.util.ArrayList;

public class Inmobiliaria 
{
	private ArrayList<Barrio> listaBarrios;
	
	
	public Inmobiliaria() 
	{
		listaBarrios = new ArrayList<Barrio>();
	}
	
	//Mostramos las propiedades de la inmobiliaria, para eso primero y cada uno de ellos mostrara la lista de sus propiedades.
	public void mostrarPropiedades() 
	{
		for(Barrio barrioIterado: this.listaBarrios) //iteramos por todos los barrios 
		{
			barrioIterado.mostrarPropiedades(); // y cada uno de ellos mostrará su lista de propiedades. 
		}
	}
	
	public ArrayList<Barrio> obtenerBarrioMaxProp() 
	{
		ArrayList<Barrio> barriosGanadores = new ArrayList<>();	//Declaramos la lista que almacenará al/ los barrio/s con mas propiedades.
		int maximasPropiedades = Integer.MIN_VALUE; //La inicializamos con el valor mínimo para asegurarnos que en la primera iteración se cumpla el if y pueda funcionar el programa correctamente.
		//Recién en la segunda iteración habrá suficientes barrios para comparar y que cumpla su fin original.
		
		//Iteramos por la lista de barrios
		for(Barrio barrio : this.listaBarrios) 
		{
			int propiedades = barrio.contamosPropiedades(); //Obtenemos su cantidad de propiedades.
			
			if(propiedades > maximasPropiedades) //si tiene mas que la maxima cantidad encontramos un nuevo barrio con mas propiedades
			{
				maximasPropiedades = propiedades; //actualizamos la variable de evaluación
				barriosGanadores.clear(); //eliminamos el o los barrios ganadores hasta ahora
				barriosGanadores.add(barrio); //añadimos al actual ganador
			}
			else if(propiedades == maximasPropiedades) 
			{
				barriosGanadores.add(barrio); //si el barrio iterado empata lo agregamos y tendremos múltiples ganadores.
			}
		}
		
		return barriosGanadores; //Devolvemos la lista con el/los ganador/es.
	}
	
	
	public void cambiarPropiedadDeBarrio(String domicilioPropiedad, Barrio nuevoBarrio) 
	{
		Propiedad propiedadEncontrada = null; //variable que buscará a la propiedad a modificar
		int i = 0;
		
		while(i < this.listaBarrios.size() && propiedadEncontrada == null) //Iteramos por los barrios mientras hayan y no se encuentre la propiedad
		{
			Barrio barrioIterado = this.listaBarrios.get(i); //Obtenemos un barrio de la lista
			
			int cantidadPropiedades = barrioIterado.getListaPropiedades().size(); //Calculamos su cantidad de propiedades para iterar por ellas.
			int j = 0;
			
			while(j < cantidadPropiedades && propiedadEncontrada == null) //Iteramos por las propiedades mientras no se haya encontrado
			{
				Propiedad propiedadIterada = barrioIterado.getListaPropiedades().get(j); //Obtenemos una propiedad de la lista.
				
				if(propiedadIterada.getDomicilio().equals(domicilioPropiedad)) //Evaluamos si la propiedad es la recibida a la que se desea cambiar de barrio.
				{
					propiedadEncontrada = propiedadIterada; //Si lo es la almacenamos en la variable para cambiarle el barrio.
					//Ya que propiedadEncontrada != null saldremos de los bucles.
					
	                barrioIterado.getListaPropiedades().remove(propiedadEncontrada); // Remover la propiedad del barrio actual
	                
	                nuevoBarrio.getListaPropiedades().add(propiedadEncontrada); // Agregar la propiedad al nuevo barrio.
				}
				
				j++;
			}
			
			i++;	
		}	
	}
	
	
	public void borrarPropiedad(String domicilio) 
	{	
		int i = 0;
		
		while(i < this.listaBarrios.size()) 
		{
			Barrio barrioIterado = this.listaBarrios.get(i); //variable donde obtendremos a los barrios en las iteraciones
			int cantPropiedades = barrioIterado.getListaPropiedades().size(); //condición del while para iterar por las propiedades del barrio
			
			int j = 0;

			Propiedad propiedadEncontrada = null;
			
			while(j < cantPropiedades && propiedadEncontrada == null) //Iteramos por la cantidad de propiedades del barrio actual.
			{
				Propiedad propiedadIterada = barrioIterado.getListaPropiedades().get(j); //Obtenemos una propiedad de la lista
				
				if(propiedadIterada.getDomicilio().equals(domicilio)) //Evaluamos si es la misma que recibimos por parametro mediante su atributo.
				{
					propiedadEncontrada = propiedadIterada; //Asignamos esta variable para que se salga del bucle while.
					barrioIterado.getListaPropiedades().remove(propiedadIterada); //Si lo es la encontramos y la borramos.
					System.out.println("Propiedad borrada exitosamente.");
				}
				
				j++;
			}
		}
		
		System.out.println("No se ha encontrado la propiedad indicada.");
	}

	
	
	//Metodo para agregarle barrios a la inmobiliaria.
	public void agregarBarrios(Barrio barrio) 
	{
		this.listaBarrios.add(barrio);
	}
	
	//Mostramos todos los barrios de la lista.
	public void mostrarBarrios() 
	{
		for(Barrio barrioIterado : this.listaBarrios) 
		{
			System.out.println(barrioIterado);
		}
	}
	
}