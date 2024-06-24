package Punto7;

public class Test 
{
	public static void main(String[] args) 
	{
		Aplicacion app = new Aplicacion();
		
		Cancion cancionUno = new Cancion("CancionUno", "Freddy", GENERO.ROCK);
		Cancion cancionDos = new Cancion("CancionDos", "Freddy", GENERO.ROCK);
		Cancion cancionTres = new Cancion("CancionUno", "Freddy", GENERO.POP);
		
		app.altaCancion("CancionUno", "Freddy");
		app.altaCancion("CancionDos", "Freddy");
		app.altaCancion("CancionUno", "Freddy");
		
		//El combo entre agregarCancion() y buscarCancion() funciona correctamente.
	}
}
