package com.Examen03.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="JefeTienda")
public class JefeTienda {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidoPaterno")
	private String apellidoPaterno;
	@Column(name = "apellidoMaterno")
	private String apellidoMaterno;
	@Column(name = "dni")
	private String dni;
	
	public JefeTienda() {}
	
	
	public JefeTienda(int codigo, String nombre, String apellidoPaterno, String apellidoMaterno, String dni) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.dni = dni;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
}
