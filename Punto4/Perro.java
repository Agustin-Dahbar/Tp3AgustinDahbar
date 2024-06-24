package Punto4;

public class Perro
{
	private NOMBRE_PERRO nombre;
	private Juan dueño;
	private Collar collar;
	private boolean pichichusCreado; 
	private boolean sultanCreado;
	//Las anteriores var bools comprobarán si ya se creó a los NOMBRE_PERROs de Juan, nos permitirá denegar la creación de más de un Sultan o Pichichus, es decir solo podremos crear los dos NOMBRE_PERROs indicados por el enunciado.
	
	//Constructor de NOMBRE_PERRO
	public Perro(NOMBRE_PERRO nombrePerro, Juan juan) 
	{
		this.dueño = juan;
		
		switch (nombrePerro) 
		{
         case PICHICHUS:
             if (!pichichusCreado) 
             {
                 this.nombre = NOMBRE_PERRO.PICHICHUS;
                 this.pichichusCreado = true;
             } 
             else 
             {
                 System.out.println("Ya existe una instancia de Pichichus. No se puede crear otro.");
             }
             break;
         case SULTAN:
             if (!sultanCreado) 
             {
                 this.nombre = NOMBRE_PERRO.SULTAN;
                 this.sultanCreado = true;
             } 
             else 
             {
                 System.out.println("Ya existe una instancia de Sultan. No se puede crear otro.");
             }
             break;
         default:
             System.out.println("Nombre de NOMBRE_PERRO inválido.");
             break;
     }
		
		this.collar = null;
	}
	
	//Nota 2:
	//El NOMBRE_PERRO pide el paseo mediante un ladrido, luego del ladrido ejecutamos el metodo de Juan que inicia el paseo
	public void pedirPaseo(Juan dueño) 
	{
		System.out.println("Woohoo!");
		dueño.prepararPaseo(this.nombre, this.collar);
	}

	//Mueve la cola si lleva el collar
	public void moverCola() 
	{
		if(this.collar != null) //Si el NOMBRE_PERRO tiene un collar
		{
			System.out.println(this.nombre + " mueve la cola de alegría por tener su collar.");
		}
	}
	
	//Setters del atributo collar para ponerselo y sacarselo.
	public void ponerCollar(Collar collar) 
	{
		if(collar.getNombre().equals(this.nombre)) //Validamos si el nombre del collar es el del NOMBRE_PERRO al que se le quiere poner.
		{
			this.collar = collar;
		}
	}
	
	public void sacarCollar() 
	{
		this.collar = null;
	}
	
	//Getters
	public NOMBRE_PERRO getNombre() 
	{
		return this.nombre;
	}
}
