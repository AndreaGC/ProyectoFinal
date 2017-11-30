package logica;

import java.util.*;

public class Norma {
	private String direccionImagen;
	private int articulo;
	private int cantidadDenuncias;
	private ArrayList <Comentario> comentarios;
	
	public Norma() {
		this.direccionImagen = "";
		this.articulo = 0;
		this.cantidadDenuncias = 0;
	}
	
	public Norma(int articulo) {
		this.direccionImagen = "img/codigo/" + articulo + ".jpg";
		this.articulo = articulo;
		this.cantidadDenuncias = 0;
	}
	
	public void aumentarDenuncias() {
		this.cantidadDenuncias++;
	}
	
	public int getArticulo() {
		return this.articulo;
	}

	public void setArticulo(int articulo) {
		this.articulo = articulo;
	}
	
	public String getDireccionImagen() {
		return direccionImagen;
	}

	public void setDireccionImagen(String direccionImagen) {
		this.direccionImagen = direccionImagen;
	}

	public int getCantidadDenuncias() {
		return cantidadDenuncias;
	}

	public void setCantidadDenuncias(int cantidadDenuncias) {
		this.cantidadDenuncias = cantidadDenuncias;
	}
	
	
}
