package Punto4;

public class Test 
{
	public static void main(String[] args) 
	{
		Juan juan = new Juan(); //Creamos a Juan inicializa lista de perros vacía y un Perchero vacío.
		
		Perchero perchero = new Perchero(); //Creamos un perchero, inicializa la lista de collares colgados vacía.
		
		Collar collarPichi = new Collar(NOMBRE_PERRO.PICHICHUS); //Creamos un collar con el nombre de Pichichus
		Collar collarSultan = new Collar(NOMBRE_PERRO.SULTAN); //Creamos un collar con el nombre de Sultan.
		
		Perro pichi = new Perro(NOMBRE_PERRO.PICHICHUS, juan); //Creamos a los dos perros de juan asignandoles nombre y su dueño (el)
		Perro sultan = new Perro(NOMBRE_PERRO.SULTAN, juan);
		
		juan.añadirPerro(pichi);
		juan.añadirPerro(sultan);
		
		juan.añadirCollar(collarPichi); //Mediante Juan añadimos los collares a la lista de la clase Perchero
		juan.añadirCollar(collarSultan);
		
		juan.tomarCollarYponerAlPerro(collarSultan, sultan);
		
		System.out.println(juan);
	}
}
