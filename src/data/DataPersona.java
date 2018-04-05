package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Categoria_Persona;
import business.entities.Persona;
import tools.AppDataException;

public class DataPersona {
	
	
	public ArrayList<Persona> getAll() throws SQLException,AppDataException{
		Statement stmt = null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
	//	DataCategoriaPersona dc = new DataCategoriaPersona();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			
			rs = stmt.executeQuery("select p.id_persona, p.razon_social, p.dni, p.cuil, p.nombre, p.apellido, p.direccion, p.ciudad, p.telefono, p.celular, p.email, p.usuario, p.contrasenia, p.latitud, p.longitud "
								+ " cp.id_categoria_persona, cp.descripcion" 
								+ " from persona p"
								+ " left join categoria_persona cp 	on p.id_categoria_persona=cp.id_categoria_persona"); 
				
			if(rs!=null){
						while(rs.next()){
							Persona p= new Persona();
							p.setId_persona(rs.getInt("p.id_persona"));
							p.setRazonSocial(rs.getString("p.razon_social"));
							p.setNombre(rs.getString("p.nombre"));
							p.setApellido(rs.getString("p.apellido"));
							p.setDni(rs.getString("p.dni"));
							p.setCuil(rs.getString("p.cuil"));
							p.setUsuario(rs.getString("p.usuario"));		
							p.setContrasenia(rs.getString("p.contrasenia"));								
							p.setEmail(rs.getString("p.email"));
							p.setCelular(rs.getString("p.celular"));
							p.setTelefono(rs.getString("p.telefono"));
							p.setCiudad(rs.getString("p.ciudad"));
							p.setDireccion(rs.getString("p.direccion"));
							p.setLatitud(rs.getString("p.latitud"));
							p.setLongitud(rs.getString("p.longitud"));
							
							//p.setHabilitado(rs.getBoolean("habilitado"));		
							Categoria_Persona cat=new Categoria_Persona();
							cat.setId_categoria_persona(rs.getInt("cp.id_categoria_persona"));
							cat.setDescripcion(rs.getString("cp.descripcion"));
							p.setCategoriaPersona(cat);
							pers.add(p);
						}
					}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al recuperar todas las personas");
		}
		    finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
			}
		}
		return pers;
	}
	
	public Persona getByDni(Persona per) throws SQLException,AppDataException{
		Persona p = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	//	DataCategoriaPersona dc = new DataCategoriaPersona();
		try {
			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					" select p.id_persona, p.razon_social, p.dni, p.cuil, p.nombre, p.apellido, p.direccion, p.ciudad, p.telefono, p.celular, p.email, p.usuario, p.contrasenia, p.latitud, p.longitud, " 
					+ " cp.id_categoria_persona, cp.descripcion" 
					+ " from persona p" 
					+ " left join categoria_persona cp 	on p.id_categoria_persona=cp.id_categoria_persona"
					+ " where p.dni=?");
			pstmt.setString(1, per.getDni());
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				p= new Persona();
				p.setId_persona(rs.getInt("p.id_persona"));
				p.setRazonSocial(rs.getString("p.razon_social"));
				p.setNombre(rs.getString("p.nombre"));
				p.setApellido(rs.getString("p.apellido"));
				p.setDni(rs.getString("p.dni"));
				p.setCuil(rs.getString("p.cuil"));
				p.setUsuario(rs.getString("p.usuario"));		
				p.setContrasenia(rs.getString("p.contrasenia"));								
				p.setEmail(rs.getString("p.email"));
				p.setCelular(rs.getString("p.celular"));
				p.setTelefono(rs.getString("p.telefono"));
				p.setCiudad(rs.getString("p.ciudad"));
				p.setDireccion(rs.getString("p.direccion"));
				p.setLatitud(rs.getString("p.latitud"));
				p.setLongitud(rs.getString("p.longitud"));
				
				//p.setHabilitado(rs.getBoolean("habilitado"));		
				Categoria_Persona cat=new Categoria_Persona();
				cat.setId_categoria_persona(rs.getInt("cp.id_categoria_persona"));
				cat.setDescripcion(rs.getString("cp.descripcion"));
				p.setCategoriaPersona(cat);

			
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al buscar una persona por dni.");
		}
		finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
			}
		}
		return p;
	}	

	

	public void add(Persona p)throws SQLException,AppDataException{
		PreparedStatement pstmt = null;
		ResultSet keyResultSet = null;
		try {
			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"INSERT INTO pedidos.persona (dni, razon_social, cuil, nombre, apellido, direccion, ciudad, telefono, celular, email, usuario, contrasenia, latitud, longitud, id_categoria_persona) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			pstmt.setString(1, p.getDni());
			pstmt.setString(2, p.getRazonSocial());
			pstmt.setString(3, p.getCuil());
			pstmt.setString(4, p.getNombre());
			pstmt.setString(5, p.getApellido());
			pstmt.setString(6, p.getDireccion());
			pstmt.setString(7, p.getCiudad());
			pstmt.setString(8, p.getTelefono());
			pstmt.setString(9, p.getCelular());
			pstmt.setString(10, p.getEmail());
			pstmt.setString(11, p.getUsuario());
			pstmt.setString(12, p.getContrasenia());
			pstmt.setString(13, p.getLatitud());
			pstmt.setString(14, p.getLongitud());
			pstmt.setInt(15, p.getCategoriaPersona().getId_categoria_persona());
						
			pstmt.execute();
			keyResultSet = pstmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId_persona(keyResultSet.getInt(1));				
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex,"Error al agregar persona.\n"
					+ " Verifique que el usuario y/o DNI no existan, dichos registros deben ser unicos.");
		}
		finally{
			try {
				if(keyResultSet!=null) keyResultSet.close();
				if(pstmt!=null) pstmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
			}
		}
	}


	public void update(Persona p) throws SQLException,AppDataException{
	PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE pedidos.persona " + 
					"SET razon_social=?, dni=?, cuil=?, nombre=?, apellido=?, direccion=?, ciudad=?, telefono=?, celular=?, email=?, usuario=?, contrasenia=?, latitud=?, longitud=? " + 
					"WHERE dni=?");
			
			stmt.setString(1, p.getRazonSocial());
			stmt.setString(2, p.getDni());
			stmt.setString(3, p.getCuil());
			stmt.setString(4, p.getNombre());
			stmt.setString(5, p.getApellido());
			stmt.setString(6, p.getDireccion());
			stmt.setString(7, p.getCiudad());
			stmt.setString(8, p.getTelefono());
			stmt.setString(9, p.getCelular());
			stmt.setString(10, p.getEmail());
			stmt.setString(11, p.getUsuario());	
			stmt.setString(12, p.getContrasenia());
			stmt.setString(13, p.getLatitud());
			stmt.setString(14, p.getLongitud());
			stmt.setInt(15, p.getCategoriaPersona().getId_categoria_persona());

			stmt.setString(16, p.getDni());
			
			int rowsAffected=stmt.executeUpdate();
			if(rowsAffected==0){throw new AppDataException(new Exception("Persona Inexistente, no se pudo actualizar"),"Error");}
			
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex,"Error al modificar persona. "
					+ " Verifique que el usuario y/o DNI no existan, dichos registros deben ser unicos. "
					+ " En caso de no poder resolverlo contactese con Gentilnucleo");
		} 
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion de update, statement");
			} 
		}	
	}

}
