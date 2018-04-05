package business.entities;

public class Categoria_Persona {
	
	private int id_categoria_persona;
	private String descripcion;
	
	public Categoria_Persona() {
		
	}
	
	public Categoria_Persona(int id_categoria_persona, String descripcion) {
		super();
		this.id_categoria_persona = id_categoria_persona;
		this.descripcion = descripcion;
	}
	
	public int getId_categoria_persona() {
		return id_categoria_persona;
	}
	public void setId_categoria_persona(int id_categoria_persona) {
		this.id_categoria_persona = id_categoria_persona;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
