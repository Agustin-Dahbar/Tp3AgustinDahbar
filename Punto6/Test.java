package Punto6;

public class Test 
{
	public static void main(String[] args) 
	{
		ORTFlix ortflix= new ORTFlix();
		Cliente clienteUno = new Cliente(43030679, SERVICIOS.STANDAR);
		Pelicula titanic = new Pelicula("Titanic", 2000, SERVICIOS.PREMIUM);
		Cliente clienteDos = new Cliente(3054, SERVICIOS.PREMIUM);
		
		ortflix.agregarCliente(clienteUno);
		ortflix.agregarCliente(clienteDos);
		ortflix.agregarPelicula(titanic);
		System.out.println(" ");
		
		ortflix.verPelicula(43030679, "Titanic");//No disponible
		ortflix.verPelicula(3054, "Titanic"); //Disponible
		
		System.out.println(" ");
		
		System.out.println(ortflix.getClientes());
		ortflix.darDeBaja(43030679); //Delete correcto
		System.out.println(ortflix.getClientes());
		
		System.out.println(" ");
		ortflix.darDeAlta(43030679, SERVICIOS.STANDAR); //Insert correcto
		System.out.println(ortflix.getClientes());
		
		System.out.println(" ");
		System.out.println(clienteDos.esDeudor()); //No es deudor
		clienteDos.aumentarDeuda(400);
		ortflix.agregarClienteListaNegra(clienteDos);
		
		System.out.println(" ");
		System.out.println(ortflix.getListaNegra());
		
		System.out.println(" ");
		ortflix.depurarListaNegra(399);
		ortflix.depurarListaNegra(400);
		//Funciona todo.
		
	}
}
