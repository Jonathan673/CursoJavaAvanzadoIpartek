package com.accesodatos;

import com.interfaces.GeneroInterface;
import com.pojos.Genero;

public class GeneroDaoImplementacion implements GeneroInterface {

	@Override
	public Iterable<Genero> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genero buscarGenero(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genero insertarGenero(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genero modificarGenero(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarGenero(Long id) {
		// TODO Auto-generated method stub
		
	}

//	private final static String SQL = "SELECT * FROM generos";
//
//	@Override
//	public Iterable<Genero> obtenerTodos() {
//		// TODO Auto-generated method stub
//
//		try (Connection con = ConexionBBDD.getConnection();
//				PreparedStatement pst = con.prepareStatement(SQL);
//				ResultSet rs = pst.executeQuery()) {
//			ArrayList<Genero> generos = new ArrayList<>();
//			while (rs.next()) {
//				generos.add(new Genero(rs.getLong("id"), rs.getString("nombre")));
//
//			}
//			return generos;
//		} catch (SQLException e) {
//			throw new AccesoDatosException("Error al obtener los generos", e);
//
//		}
//
//	}

}
