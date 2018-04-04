package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Persona;
import tools.AppDataException;

public class DataPersona {
	
	
	public ArrayList<Persona> getAll() throws SQLException,AppDataException{
		Statement stmt = null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
	//	DataCategoria dc = new DataCategoria();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			
			rs = stmt.executeQuery("select * from persona"); 	
					if(rs!=null){
						while(rs.next()){
							Persona p= new Persona();
							p.setId_persona(rs.getInt("id_persona"));
							p.setRazonSocial(rs.getString("razon_social"));
							p.setNombre(rs.getString("nombre"));
							p.setApellido(rs.getString("apellido"));
							p.setDni(rs.getString("dni"));
							p.setUsuario(rs.getString("usuario"));		
							p.setContrasenia(rs.getString("contrasenia"));								
							p.setEmail(rs.getString("email"));
							p.setCelular(rs.getString("celular"));
							p.setTelefono(rs.getString("telefono"));
							p.setCiudad(rs.getString("ciudad"));
							p.setDireccion(rs.getString("direccion"));
							p.setLatitud(rs.getString("latitud"));
							p.setLongitud(rs.getString("longitud"));
							
							//p.setHabilitado(rs.getBoolean("habilitado"));		
							//int idCat= rs.getInt("id_categoria");
							//p.setCategoria(dc.getOne(idCat));
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
	//	DataCategoria dc = new DataCategoria();
		try {
			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from persona where dni=?");
			pstmt.setString(1, per.getDni());
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				p= new Persona();
				p.setId_persona(rs.getInt("id_persona"));
				p.setRazonSocial(rs.getString("razon_social"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				p.setUsuario(rs.getString("usuario"));		
				p.setContrasenia(rs.getString("contrasenia"));								
				p.setEmail(rs.getString("email"));
				p.setCelular(rs.getString("celular"));
				p.setTelefono(rs.getString("telefono"));
				p.setCiudad(rs.getString("ciudad"));
				p.setDireccion(rs.getString("direccion"));
				p.setLatitud(rs.getString("latitud"));
				p.setLongitud(rs.getString("longitud"));
				
				//p.setHabilitado(rs.getBoolean("habilitado"));
				//int idCat= rs.getInt("id_categoria");
				//p.setCategoria(dc.getOne(idCat));
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
					"INSERT INTO pedidos.persona (dni, razon_social, cuil, nombre, apellido, direccion, ciudad, telefono, celular, email, usuario, contrasenia, latitud, longitud) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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
						
			//pstmt.setBoolean(7, p.isHabilitado());
			//pstmt.setInt(8, p.getCategoria().getId());
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

	

}
