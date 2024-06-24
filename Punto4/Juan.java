package Punto4;
import java.util.ArrayList;

public class Juan 
{
	private ArrayList<Perro> listaPerros;
	private Perchero perchero;
	
	public Juan() 
	{
		this.listaPerros = new ArrayList<>();
		this.perchero = new Perchero();
	}  
	
	//Buscamos al perro en la lista por su nombre.
	public Perro buscarPerro(NOMBRE_PERRO nombrePerro) 
	{
		int i = 0;
		Perro perroEncontrado = null;
		
		while(i < this.listaPerros.size() && perroEncontrado == null) 
		{
			Perro perroIterado = this.listaPerros.get(i);
			
			if(perroIterado.getNombre().equals(nombrePerro)) 
			{
				perroEncontrado = perroIterado;
			}
			
			i++;
		}
		
		return perroEncontrado; //Retornará al perro o null.
	}
	
	//Tomamos el collar del perchero y se lo ponemos al perro. (Heredamos metodos de Perchero y Perro)
	public void tomarCollarYponerAlPerro(Collar collar, Perro perro) 
	{	
		if(perchero.descolgarCollar(collar)) //Comprobamos que el collar recibido esté en el perchero, si lo está ..
		{
			perro.ponerCollar(collar); //Se lo ponemos al perro.
		}
	}
	
	
	//Metodo que realiza un paseo. Desde tomar el collar y ponerselo al perro, salir a pasear, volver y colgar el
	public void prepararPaseo(NOMBRE_PERRO nombrePerro, Collar collar) 
	{
		Perro perro = buscarPerro(nombrePerro); //Buscamos al perro para validar su existencia
		
		if(perro != null) //Si Existe 
		{
			Collar collarEncontrado = perchero.buscarCollar(collar); //También validamos la existencia del collar y lo buscamos. (A)
			
			if(collarEncontrado != null) //Si existe
			{
				System.out.println("¡A pasear " + collarEncontrado.getNombre() + "!"); //Llamamos al perro a pasear (B)
				
				tomarCollarYponerAlPerro(collar, perro); //Lo tomamos del perchero y se lo ponemos al perro (C)
				perro.moverCola();//El perro mueve la cola por la felicidad que esto le genera
				
				//Comienza el paseo
				System.out.println("Juan sale a pasear con " + perro.getNombre());
				
				//Regreso del paseo
				perro.sacarCollar(); //Le sacamos el collar al perro
				perchero.colgarCollar(collar); //Lo colgamos del perchero (D)
				
			}
			else 
			{
				System.out.println("No se encontró el collar de " + nombrePerro);
			}
		}
		else 
		{
			System.out.println("No se realiza el paseo ya que el perro no respondió al llamado.");
		}
	}

	public void añadirPerro(Perro perroNuevo) 
	{
		//Antes de añadir al perro debemos validar que no este ya en la lista.
		boolean perroEncontrado = false; //En esta variable almacenaremos la info de si se encontró o no.
	    int i = 0; //Índice a usar para iterar por la lista
	    
	    while (i < listaPerros.size() && !perroEncontrado) //Mientras el perro no se haya encontrado en la lista y aún haya continuamos
	    {
	        Perro perroIterado = this.listaPerros.get(i); //Obtenemos un perro de la lista
	        
	        if (perroIterado.getNombre().equals(perroNuevo.getNombre())) //Comparamos su nombre con el recibido para ver si está
	        {
	            perroEncontrado = true; //Encontramos al perro y almacenamos la info, no se cumplirá más la segunda condición del while, por tanto saldremos del bucle
	        }
	        
	        i++; //Aumentamos el valor del índice para que la iteración sea exitosa y no se obtenga al mismo elemento de la lista.
	    }
	    
	    if (!perroEncontrado) //Si no encontramos al perro, lo agregaremos (perroEncontrado == false)
	    {
	        this.listaPerros.add(perroNuevo); // Añadir el perro a la lista si no está presente
	        System.out.println("Se ha añadido al perro " + perroNuevo.getNombre() + " a la lista.");
	    } 
	    else //Si lo encontramos
	    {
	        System.out.println("El perro " + perroNuevo.getNombre() + " ya está en la lista.");
	    }

	}
	
	//Añadimos collar al perchero
	public void añadirCollar(Collar collarNuevo) 
	{
		if(!(collarNuevo.estaColgado())) //Si el collar no está colgado..  Ya que ! implica inversa, es decir collar.estaColgado() == false
		{
			perchero.colgarCollar(collarNuevo); //Lo colgamos del perchero
		}
	}
	
	
	//ToString()
	@Override
	public String toString() 
	{
		return "Juan [listaPerros=" + this.listaPerros + ", perchero=" + this.perchero + "]";
	}
}

