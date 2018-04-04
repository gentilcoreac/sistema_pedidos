package business.entities;

public class Persona {
	private int id_persona;
	private String razonSocial;
	private int dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private String ciudad;
	private String telefono;
	private String  celular;
	private String email;
	private String usuario;
	private String contrasenia;
	private String latitud;		
	private String longitud;	
	
	//private Categoria categoria;
	

	public Persona(){	
	}
	
	public Persona(int id_persona, String razonSocial, int dni, String nombre, String apellido, String direccion,
			String ciudad, String telefono, String celular, String email, String usuario, String contrasenia, String latitud,
			String longitud) {
		super();
		this.id_persona = id_persona;
		this.razonSocial = razonSocial;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.celular = celular;
		this.email = email;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
		
	
}
