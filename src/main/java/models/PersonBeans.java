package models;

import java.util.ArrayList;

import models.Person;

public class PersonBeans {
	
	private Person person = new Person();
	
	private ArrayList<Person> liste = new ArrayList<Person>();
	
	public Person getPerson() {
		return this.person;
	}
	
	
	public void setPerson(Person person) {
		this.person = person;
	}


	public ArrayList<Person> getListe() {
		return liste;
	}


	public void setListe(ArrayList<Person> liste) {
		this.liste = liste;
	}
	
	

}
