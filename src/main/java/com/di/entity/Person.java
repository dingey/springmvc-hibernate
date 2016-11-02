package com.di.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQueries({ @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
		@NamedQuery(name = "Person.findAllCount", query = "SELECT count(0) FROM Person p") })
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private int age;

	private String name;

	private int sex;

}