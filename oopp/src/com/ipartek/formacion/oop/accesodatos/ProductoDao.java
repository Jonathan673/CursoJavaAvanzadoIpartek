package com.ipartek.formacion.oop.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.oop.interfaces.ProductoInterface;
import com.ipartek.formacion.oop.pojos.Producto;


public class ProductoDao implements ProductoInterface {
	
	@Override
	public List<Producto> listarProductos() {
		List<Producto> productos = new ArrayList<>();
		String sql = "Select * from productos";
		
		try (Connection conexion = ConexionDB.getConnection();
				PreparedStatement st = conexion.prepareStatement(sql);
				ResultSet rs = st.executeQuery(sql);) {
			
			while (rs.next()) {
				
				Producto p = new Producto();
				
				p.setId(rs.getLong("id_productos"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getBigDecimal("precio"));
				
				productos.add(p);
			}
//			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al listar los productos: " + e.getMessage());
		}
		return productos;
	}
	
	@Override
	public Producto buscarProducto(Long id) {
		String sql = "SELECT * FROM productos WHERE id_productos = ?";
		Producto producto = null;
		try (Connection conexion = ConexionDB.getConnection();
				PreparedStatement sentencia = conexion.prepareStatement(sql)) {
			
			sentencia.setLong(1, id);
			
			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					producto = new Producto();
					
					producto.setId(resultado.getLong("id_productos"));
					producto.setNombre(resultado.getString("nombre"));
					producto.setPrecio(resultado.getBigDecimal("precio"));
				}
			}
//			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al listar alumnos: " + e.getMessage());
			
		}
		return producto;
	}
	
	@Override
	public void insertarProducto(Producto producto) {
		String sql = "INSERT INTO 2993_basico.productos (nombre, precio) VALUES (?, ?)";
		try (Connection conexion = ConexionDB.getConnection();
				PreparedStatement sentencia = conexion.prepareStatement(sql)) {
			
			sentencia.setString(1, producto.getNombre());
			sentencia.setBigDecimal(2, producto.getPrecio());
			
			sentencia.executeUpdate();
			
			IO.println("Se ha insertado el producto correctamente");
//			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar el producto: " + e.getMessage());
		}
		
	}
	
	@Override
	public void modificarProducto(Producto producto) {
		if (buscarProducto(producto.getId()) != null) {
			String sql = "UPDATE productos SET nombre=?,precio=? WHERE id_productos=?";
			try (Connection conexion = ConexionDB.getConnection();
					PreparedStatement sentencia = conexion.prepareStatement(sql)) {
				
				sentencia.setString(1, producto.getNombre());
				sentencia.setBigDecimal(2, producto.getPrecio());
				sentencia.setLong(3, producto.getId());
				
				sentencia.executeUpdate();
				
				IO.println("Se ha modificado el producto correctamente");
//				conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al modificado el producto: " + e.getMessage());
			}
		} else {
			System.out.println("Producto no encontrado");
		}
	}
	
	@Override
	public void eliminarProducto(Long id) {
		
//		buscarProducto(id);
		if (buscarProducto(id) != null) {
			String sql = "DELETE FROM productos WHERE id_productos= ? ";
			try (Connection conexion = ConexionDB.getConnection();
					PreparedStatement sentencia = conexion.prepareStatement(sql)) {
				
				sentencia.setLong(1, id);
				
				sentencia.executeUpdate();
				
				IO.println("Se ha eliminado el producto correctamente");
//				conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al eliminar el producto: " + e.getMessage());
			}
		} else {
			System.out.println("Producto no encontrado");
		}
	}
}
