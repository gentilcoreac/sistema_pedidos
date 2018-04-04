package business.entities;

import java.util.Date;

public class Precio {

	private float precio;
	private Date fecha;
	
	
	public Precio() {
		
	}
	public Precio(float precio, Date fecha) {
		super();
		this.precio = precio;
		this.fecha = fecha;
	}	
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
