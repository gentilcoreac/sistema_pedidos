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
							p.setDni(rs.getInt("dni"));
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
			pstmt.setInt(1, per.getDni());
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				p= new Persona();
				p.setId_persona(rs.getInt("id_persona"));
				p.setRazonSocial(rs.getString("razon_social"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getInt("dni"));
				p.setUsuario(rs.getString("usuario"));		
				p.setContrasenia(rs.getString("contrasenia"));								
				p.setEmail(rs.getString("email"));
				p.setCelular(rs.getString("celular"));
				p.setTelefono(rs.getString("telefono"));
				p.setCiudad(rs.getString("ciudad"));
				p.setDireccion(rs.getString("direccion"));
				p.setLatitud(rs.getString("latitud"));
				p.setLongitud(rs.getString("longitud"));
				
				//		p.setHabilitado(rs.getBoolean("habilitado"));
			//	int idCat= rs.getInt("id_categoria");
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
	
	

}
