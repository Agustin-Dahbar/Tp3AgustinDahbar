package Punto4;
import java.util.ArrayList;

public class Perchero 
{
	private ArrayList<Collar> collaresColgados;
	
	public Perchero() 
	{
		this.collaresColgados = new ArrayList<>();
	}
	
	//Limite de collares colgados:
	public void colgarCollar(Collar collar) 
	{
		if(this.collaresColgados.size() < 3) //Si la lista de collares colgados es menor a 3 == true y se ejecuta el bloque de código. 
		{
			collar.colgar(); //Colgamos el collar recibido.
			this.collaresColgados.add(collar); // Y lo añadimos a la lista.
			System.out.println("Colgamos el collar. (P)");
		}
		else 
		{
			System.out.println("No hay espacio para colgar más collares.");
		}
	}
	
	public boolean descolgarCollar(Collar collar) 
	{
		int i = 0;
		boolean collarEsta = false;
		
		while(i < this.collaresColgados.size() && !collarEsta) //Iteramos por la lista mientras no hayamos encontrado al collar y aún queden. 
		{
			Collar collarIterado = this.collaresColgados.get(i); //Obtenemos el collar iterado por el bucle
			
			if(collarIterado.getNombre().equals(collar.getNombre())) //Comparamos su nombre con el recibido para comprobar que coincidan y efectivamente exista el collar que se desea sacar.
			{
				collarEsta = true; //Si coinciden almacenamos la información en la var bool.
			}
			
			i++; //Aumentamos el valor de i para en la próxima iteración obtener el próximo elemento (ya la usamos como indice en el get (línea 35)
		}
		
		if(collarEsta) //Finalizado el bucle comprobamos que se haya encontrado el collar a descolgar
		{
			collar.descolgar(); //Lo descolgamos
			this.collaresColgados.remove(collar); //Lo eliminamos de la lista de collares colgados
			System.out.println("Descolgamos el collar");
		}
		
		return collarEsta; //Devuelve true o false según si se encontró o no el collar
	}
	
	
	public Collar buscarCollar(Collar collar) 
	{
		Collar collarEncontrado = null;
		int i = 0;
		
		while(i < this.collaresColgados.size() && collarEncontrado == null) 
		{
			Collar collarIterado = this.collaresColgados.get(i);
			
			if(collarIterado.getNombre().equals(collar.getNombre()))
			{
				collarEncontrado = collar;
				System.out.println("Collar encontrado (P)");
			}
			
			i++;
		}
		
		if(collarEncontrado == null) 
		{
			System.out.println("No se encontró el collar (P)");
		}
		
		return collarEncontrado;
		
	}

	@Override
	public String toString() 
	{
		return "Perchero [collaresColgados=" + collaresColgados + "]";
	}
	
}
