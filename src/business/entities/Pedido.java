package business.entities;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	private int id_pedido;
	private Date fecha_pedido;
	private Date fecha_entregado;
	private Date fecha_requerido;
	private Date fecha_anulado;
	private float precio_sub_total;
	private float precio_total;
	private float iva;
	private Persona persona;
	private ArrayList<Detalles_Pedido> lineaDeDetalles;



	public Pedido() {	
	}
	
	public Pedido(int id_pedido, Date fecha_pedido, Date fecha_entregado, Date fecha_requerido, Date fecha_anulado,
			float precioSubTotal, float precioTotal, float iva, Persona persona,
			ArrayList<Detalles_Pedido> lineaDeDetalles) {
		super();
		this.id_pedido = id_pedido;
		this.fecha_pedido = fecha_pedido;
		this.fecha_entregado = fecha_entregado;
		this.fecha_requerido = fecha_requerido;
		this.fecha_anulado = fecha_anulado;
		this.precio_sub_total = precioSubTotal;
		this.precio_total = precioTotal;
		this.iva = iva;
		this.persona = persona;
		this.lineaDeDetalles = lineaDeDetalles;
	}





	public int getId_pedido() {
		return id_pedido;
	}



	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}



	public Date getFecha_pedido() {
		return fecha_pedido;
	}



	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}



	public Date getFecha_entregado() {
		return fecha_entregado;
	}



	public void setFecha_entregado(Date fecha_entregado) {
		this.fecha_entregado = fecha_entregado;
	}



	public Date getFecha_requerido() {
		return fecha_requerido;
	}



	public void setFecha_requerido(Date fecha_requerido) {
		this.fecha_requerido = fecha_requerido;
	}



	public Date getFecha_anulado() {
		return fecha_anulado;
	}



	public void setFecha_anulado(Date fecha_anulado) {
		this.fecha_anulado = fecha_anulado;
	}



	public float getPrecioSubTotal() {
		return precio_sub_total;
	}



	public void setPrecioSubTotal(float precioSubTotal) {
		this.precio_sub_total = precioSubTotal;
	}



	public float getPrecioTotal() {
		return precio_total;
	}



	public void setPrecioTotal(float precioTotal) {
		this.precio_total = precioTotal;
	}



	public float getIva() {
		return iva;
	}



	public void setIva(float iva) {
		this.iva = iva;
	}



	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public ArrayList<Detalles_Pedido> getLineaDeDetalles() {
		return lineaDeDetalles;
	}



	public void setLineaDeDetalles(ArrayList<Detalles_Pedido> lineaDeDetalles) {
		this.lineaDeDetalles = lineaDeDetalles;
	}

	
	
	
}
