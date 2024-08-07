package org.example.graalvm.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("PersonDocument")
public class PersonDocument {

	private String name;
	private String surname;

	public PersonDocument() {
	}

	public PersonDocument(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "PersonDocument{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}
}
