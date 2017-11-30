package logica;

public class Comentario {
	private String autor;
	private String mensaje;
	
	public Comentario(CuentaUsuario usuario, String mensaje) {
		this.autor = usuario.getApodo();
		this.mensaje = "None";
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
