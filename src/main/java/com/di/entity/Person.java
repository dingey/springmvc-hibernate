package com.di.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p") })
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private int age;

	private String name;

	private int sex;

	public Person() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

}