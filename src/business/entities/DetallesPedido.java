package business.entities;

import java.util.ArrayList;

public class DetallesPedido {
	
	private int cantidad;
	private double descuento = 0;
	private Producto producto;
	private Pedido pedido;
	
	
	
	
	public DetallesPedido(){
		
	}

	public DetallesPedido(int cantidad, double descuento, Producto producto, Pedido pedido) {
		super();
		this.cantidad = cantidad;
		this.descuento = descuento;
		this.producto = producto;
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
		
}
