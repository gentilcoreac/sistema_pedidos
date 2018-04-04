package business.entities;

public class Producto {

	private int id_producto;
	private String nombre;
	private String codigo;
	private int estado;
	private float precio;

	private Categoria categoria;

	//private Precio precioActual;
	//private Persona usuario;
	
	public Producto() {
		
	}
	
	public Producto(int id_producto, String nombre, String codigo, int estado, Categoria categoria,
			float precio) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.codigo = codigo;
		this.estado = estado;
		this.categoria = categoria;
		this.precio = precio;
	}
	

	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public float getPrecioActual() {
		return precio;
	}
	public void setPrecioActual(float precio) {
		this.precio = precio;
	}
	
}
