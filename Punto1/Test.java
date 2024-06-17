package Punto1;

import Punto1.Agenda;
import Punto1.Persona;

public class Test 
{
	public static void main(String[] args) 
	{
		//Crear la clase Test con su función main(). En esta función se creará una instancia de
		//la clase Agenda y se pide, por lo menos, comprobar el correcto funcionamiento de
		//los 4 métodos a desarrollar citados previamente en los siguientes casos: agregar 3
		//personas, eliminación no exitosa, eliminación exitosa, modificación de dirección no
		//exitosa, modificación de dirección satisfactoria y listado de personas.
		
		Agenda agendaPersonas = new Agenda();
		
		//1. Agregamos personas a la lista.
		agendaPersonas.agregarPersona("Agustin", "Dahbar", 43030679);
		agendaPersonas.agregarPersona("Lionel", "Messi", 30506987);
		agendaPersonas.agregarPersona("Stephen", "Curry", 35609548);
		
		System.out.println(agendaPersonas);//Mostramos la lista
		
		System.out.println(" ");
		
		//2. Eliminación exitosa y no exitosa
		agendaPersonas.removerPersona(35609547); //Eliminación no exitosa.
		System.out.println(agendaPersonas); //Curry sigue.
		agendaPersonas.removerPersona(35609548); //Eliminación exitosa.
		System.out.println(agendaPersonas); //Curry se fue.
		
		System.out.println(" ");
		
		//Lo mismo que buscar persona pero público para poder usarlo en test.
		Persona agustin = agendaPersonas.getPersona(43030679);
		System.out.println(agustin);
		
		System.out.println(" ");
		
		//Creamos un domicilio y luego lo setteamos a agustin nuestro objeto de la clase Persona.
		Domicilio agustinDomicilio = new Domicilio("Conesa", 1200, "CABA");
		agustin.setDomicilio(agustinDomicilio);
		System.out.println(agustin);
		
		System.out.println(" ");
		
		//3. Modificación de domicilios exitosos y no.
		Domicilio nuevoDomi = new Domicilio("Av Street", 39, "San Francisco");
		agendaPersonas.modificarDomicilio(43030679, nuevoDomi);
		agendaPersonas.modificarDomicilio(43030677, agustinDomicilio);
		
		System.out.println(" ");
		
		//4. Listado de las personas en la lista (menos curry que fue eliminado) :( 
		agendaPersonas.listarPersonas();	
	}
}
