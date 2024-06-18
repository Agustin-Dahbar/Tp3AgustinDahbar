package Punto3;

public class Test 
{
	public static void main(String[] args) 
	{
		Inmobiliaria inmobiliaria = new Inmobiliaria();

		Barrio belgrano = new Barrio("Belgrano");
		Barrio colegiales = new Barrio("Colegiales");
		
		inmobiliaria.agregarBarrios(belgrano);
		inmobiliaria.agregarBarrios(colegiales);
		
		Propiedad depto = new Propiedad("Ciudad de la paz", 500, TIPO_PROPIEDAD.DEPARTAMENTO);
		Propiedad deptoDos = new Propiedad("Zapiola", 400, TIPO_PROPIEDAD.DEPARTAMENTO);
		Propiedad casa = new Propiedad("Olleros", 800, TIPO_PROPIEDAD.CASA);
		
		//Metodos Barrio
		System.out.println("Metodos de la clase BARRIO: ");
		System.out.println("Mostramos propiedades de un tipo especifico");
		belgrano.añadirPropiedad(depto);
		belgrano.mostrarPropiedades(TIPO_PROPIEDAD.DEPARTAMENTO);
		colegiales.añadirPropiedad(deptoDos);
		colegiales.añadirPropiedad(casa);
		colegiales.mostrarPropiedades(TIPO_PROPIEDAD.CASA);
		
		System.out.println(" ");
		
		System.out.println("Mostramos todas las propiedades del barrio");
		colegiales.mostrarPropiedades();
		System.out.println(colegiales.contamosPropiedades()); //2
		System.out.println(colegiales.getListaPropiedades()); //Obtenemos la lista de propiedades del barrio Colegiales
		
		//METODOS CLASE INMOBILIARIA
		System.out.println(" ");
		System.out.println("Metodos de la clase INMOBILIARIA: ");
		System.out.println(inmobiliaria.obtenerBarrioMaxProp()); //Mostramos el barrio con mas propiedades de la inmobiliaria
		//inmobiliaria.mostrarPropiedades(); //No se muestran nada.
		System.out.println(" ");
		System.out.println("Cambiamos de barrio una propiedad.");
		inmobiliaria.cambiarPropiedadDeBarrio("Ciudad de la paz", colegiales); // no se llevo a cabo esto tampoco, en la proxima linea se comprueba que no se cambio de barrio.
		colegiales.mostrarPropiedades(); //Ahora se mostrarán 3..
		//Le devolvemos la propiedad a Belgrano:
		inmobiliaria.cambiarPropiedadDeBarrio("Ciudad de la paz", belgrano);
		
		//inmobiliaria.borrarPropiedad("Ciudad de la paz"); //este metodo no me deja imprimir en consola nada mas.
		System.out.println(" ");
		
		System.out.println("Propiedades 'Departamento' en Colegiales:");
		colegiales.mostrarPropiedades(TIPO_PROPIEDAD.DEPARTAMENTO); // no se llevo a cabo este metodo tamb
		
		System.out.println(" ");
		System.out.println("Propiedades 'Casa' en Colegiales: ");
		colegiales.mostrarPropiedades(TIPO_PROPIEDAD.CASA);
		
		System.out.println("FIN");
		
		Barrio caballito = new Barrio("Caballito");
		inmobiliaria.agregarBarrios(caballito);
		inmobiliaria.mostrarBarrios();
		
		
	}
}
