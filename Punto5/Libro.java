package Punto5;
import java.util.ArrayList;

public class Libro 
{
	private String titulo;
	private GENERO genero;
	private Editorial editorial;
	private int año;
	private Autor autor;
	private ArrayList<Ejemplar> ejemplaresLista;
	
	
	public Libro(String titulo, GENERO genero, Editorial editorial, int año, Autor autor) 
	{
		this.titulo = titulo;
		this.genero = genero; 
		this.editorial = editorial;
		this.año = año;
		this.autor = autor;
		this.ejemplaresLista = new ArrayList<>();
	}
	
	public ArrayList<Ejemplar> getEjemplares(){
		return this.ejemplaresLista;
	}
	
	public void agregarEjemplar(Ejemplar ejemplar) 
	{
		this.ejemplaresLista.add(ejemplar);
	}
		
}
