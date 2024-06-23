package Punto7;

public class Test 
{
	public static void main(String[] args) 
	{
		MusicApp app = new MusicApp();
		
		Cancion cancionUno = new Cancion("CancionUno", "Freddy", GENEROS.ROCK);
		Cancion cancionDos = new Cancion("CancionDos", "Freddy", GENEROS.ROCK);
		Cancion cancionTres = new Cancion("CancionUno", "Freddy", GENEROS.POP);
		
		app.agregarCancion(cancionUno);
		app.agregarCancion(cancionDos);
		app.agregarCancion(cancionTres);
		
		//El combo entre agregarCancion() y buscarCancion() funciona correctamente.
	}
}
