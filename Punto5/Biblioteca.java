package Punto5;
import java.util.Date;
import java.util.ArrayList;

public class Biblioteca 
{
	private ArrayList<Lector> lectoresLista;
	private ArrayList<Libro> librosLista;
	private ArrayList<Ejemplar> ejemplaresLista;
	
	public Biblioteca() 
	{
		this.lectoresLista = new ArrayList<>();
		this.librosLista = new ArrayList<>();
		this.ejemplaresLista = new ArrayList<>();
	}
	
	public RESULTADO_PRESTAMO prestar(Libro libro, Lector lector) //Para realizar un prestamo necesitamos un lector y un libro.
	{
		//Corroboramos datos del lector para ver si puede pedir un prestamo.
		
		//Verificamos multas, si no tiene continuamos el prestamo, si tiene, no le podemos dar prestamo.
		if(lector.getDiasDeMulta() > 0) 
		{
			return RESULTADO_PRESTAMO.MULTA_VIGENTE;
		}
		
		//Verificamos si el lector alcanzó la cantidad máxima de prestamos
		if(lector.getPrestamosVigentes().size() >= 3) {
			return RESULTADO_PRESTAMO.TOPE_PRESTAMOS_ALCANZADO;
		}
		
		
		//Variable que representará al ejemplar del libro.
		Ejemplar ejemplarDisponible = null; 
		int i = 0;
		
		//Buscamos los ejemplares del libro con un while
		while(i < libro.getEjemplares().size() && ejemplarDisponible == null)
		{
			Ejemplar ejemplarIterado = libro.getEjemplares().get(i);
			
			if(ejemplarIterado.getEstado() == ESTADO.EN_BIBLIOTECA) //Si el estado del ejemplar es "EN_BIBLIOTECA"
			{
				ejemplarDisponible = ejemplarIterado; //Encontramos un ejemplar y lo asignamos a la variable correspondiente.
			}
			
			i++;
		}
		
		//Si no se encontraron ejemplares en el anterior while
		if(ejemplarDisponible == null) 
		{
			return RESULTADO_PRESTAMO.NO_HAY_EJEMPLARES; //Retornamos que no hay ejemplares para el libro buscado.
		}
		
		//Si no se ejecutó el return de la línea 54, significa que ejemplarDisponible != null, por lo tanto hay ejemplar y registramos el prestamo.
		ejemplarDisponible.setEstado(ESTADO.PRESTADO); //Le modificamos el estado al ejemplar para indicar que lo estamos prestando.
		ejemplarDisponible.setFechaPrestamo(new Date());
		Prestamo prestamo = new Prestamo(new Date(), null, ejemplarDisponible); //Creamos el nuevo prestamo con el ejemplar encontrado en el foreach.
		lector.agregarPrestamo(prestamo); //Le agregamos el prestamo creado al lector.
		return RESULTADO_PRESTAMO.PRESTAMO_EXITOSO;
	}
	
	
	public void agregarLibro(Libro libro) 
	{
		this.librosLista.add(libro);
	}
	
	public void agregarLector(Lector lector) 
	{
		this.lectoresLista.add(lector);
	}
}
