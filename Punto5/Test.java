package Punto5;
import java.util.Date;
import java.util.ArrayList;

public class Test 
{
	public static void main(String[] args) 
	{
		Biblioteca biblioteca = new Biblioteca();
		
		Lector agustin = new Lector(43030679, "Agustin", "Conesa", "1150400943", 0);
		Editorial editorial = new Editorial("Leo Messi Docu", "Argentina");
		Autor william = new Autor("Shakespeare", "Alemania", 30101430);
		
		Libro primerLibro = new Libro("Messi", GENERO.POESÍA, editorial, 2022, william);
		Ejemplar primerEjemplar = new Ejemplar(1);
		primerLibro.agregarEjemplar(primerEjemplar);
		
		Date fechaRetiro = new Date();
		Date fechaDevolucion = null;
		
		Prestamo prestamo = new Prestamo(fechaRetiro, fechaDevolucion, primerEjemplar);
		
		biblioteca.agregarLibro(primerLibro); //para que prestar() funcione debemos agregarle a sus lista al menos un objeto
		biblioteca.agregarLector(agustin); // para poder usar el metodo ya que los requerirán como parámetros a recibir.
		
		System.out.println(biblioteca.prestar(primerLibro, agustin));
		System.out.println(biblioteca.prestar(primerLibro, agustin)); //No hay ejemplares del libro.  
		Ejemplar segundoEjemplar = new Ejemplar(1); //Creamos un nuevo ejemplar ya que reutilizar primerEjemplar no serviría.
		primerLibro.agregarEjemplar(segundoEjemplar); // le agregamos un nuevo ejemplar al libro creado para poder realizar otro prestamo 
		System.out.println(biblioteca.prestar(primerLibro, agustin));
		
		
	}
}
