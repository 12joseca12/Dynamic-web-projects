package com.JCSG.cocheModelos;

import java.util.Date;

public class Modelos {
	
	private int id;
	private String marca;
	private String modelo;
	private String motor;
	private int potencia;
	private Date fecha_registro;
	
	
	public Modelos(int id, String marca, String modelo, String motor, int potencia, Date fecha_registro) {
		this.id=id;
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
		this.potencia = potencia;
		this.fecha_registro=fecha_registro;
	}
	
	
	
	public Modelos(String marca, String modelo, String motor, int potencia, Date fecha_registro) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
		this.potencia = potencia;
		this.fecha_registro = fecha_registro;
	}



	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public Date getFecha() {
		return fecha_registro;
	}
	public void setFecha(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Modelo: [ id="+id+", marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", potencia=" + potencia + " cv, Fecha registro= "+fecha_registro+" ]";
	}
	
	

}
