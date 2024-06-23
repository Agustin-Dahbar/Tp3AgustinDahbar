package Punto4;

public class Test 
{
	public static void main(String[] args) 
	{
		Juan juan = new Juan(); //Creamos a Juan inicializa lista de perros vacía y un Perchero vacío.
		
		Perchero perchero = new Perchero(); //Creamos un perchero, inicializa la lista de collares colgados vacía.
		
		Collar collarPichi = new Collar(PERROS.PICHICHUS); //Creamos un collar con el nombre de Pichichus
		Collar collarSultan = new Collar(PERROS.SULTAN); //Creamos un collar con el nombre de Sultan.
		
		Perro pichi = new Perro(PERROS.PICHICHUS, juan); //Creamos a los dos perros de juan asignandoles nombre y su dueño (el)
		Perro sultan = new Perro(PERROS.SULTAN, juan);
		
		juan.añadirPerro(pichi);
		juan.añadirPerro(sultan);
		
		juan.añadirCollar(collarPichi); //Mediante Juan añadimos los collares a la lista de la clase Perchero
		juan.añadirCollar(collarSultan);
		
		juan.tomarCollarYponerAlPerro(collarSultan, sultan);
		
		System.out.println(juan);
	}
}
