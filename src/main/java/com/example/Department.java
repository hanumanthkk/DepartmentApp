package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Min(4)
	private long id;
	@Size(min=4, max=30)
	@NotNull
	@Column
	private String name;
	@Column
	private double salar_min_range;
	@Column
	private double salar_max_range;

	public Department() {
	}

	public Department(String name, double salar_min_range, double salar_max_range) {
		this.name = name;
		this.salar_min_range = salar_min_range;
		this.salar_max_range = salar_max_range;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalar_min_range() {
		return salar_min_range;
	}

	public void setSalar_min_range(double salar_min_range) {
		this.salar_min_range = salar_min_range;
	}

	public double getSalar_max_range() {
		return salar_max_range;
	}

	public void setSalar_max_range(double salar_max_range) {
		this.salar_max_range = salar_max_range;
	}

}
