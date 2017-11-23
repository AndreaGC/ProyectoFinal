package controlador;

import java.io.Serializable;

public class CuentaUsuario implements Serializable{
	private String apodo;
	private String correo;
	private String contrasenia;
	private int puntos;
	
	public CuentaUsuario(String usuario, String correo, String contrasenia) {
		this.apodo = usuario;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	
	public boolean iniciarSesion(String usuario, String contrasenia){
		return this.apodo.equals(usuario) && this.contrasenia.equals(contrasenia);
	}

	public boolean cambiarContrasenia(String contrasenia1, String contrasenia2){
		if (contrasenia1.equals(contrasenia2)){
			this.contrasenia = contrasenia1;
			return true;
		} else {
			return false;
		}
	}
	
	public void aumentarPuntaje() {
		this.puntos++;
	}
	
	@Override
	public String toString() {
		return "CuentaUsuario [apodo=" + apodo + ", correo=" + correo + ", contrasenia=" + contrasenia + ", puntos="
				+ puntos + ", estado=" + estado + "]";
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
