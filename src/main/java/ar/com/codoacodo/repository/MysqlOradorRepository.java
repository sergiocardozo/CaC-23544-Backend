package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.entity.Orador;

public class MysqlOradorRepository implements IOradorRepository {

	// alt+shift+R refactor
	@Override
	public void save(Orador orador) {

		String sql = "INSERT INTO oradores (nombre,apellido,tema,mail) VALUES(?,?,?,?)";

		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getTema());
			statement.setString(4, orador.getMail());

			statement.executeUpdate();// INSERT-UPDATE-DELETE

			ResultSet res = statement.getGeneratedKeys();
			if (res.next()) {
				Long id = res.getLong(1);
				orador.setId(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el orador", e);
		}
	}

	@Override
	public Orador getById(Long id) {

		String sql = "SELECT * FROM oradores WHERE id_oradores = ?";

		Orador orador = null;
		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, id);

			ResultSet res = statement.executeQuery();
			if (res.next()) {
				Long dbId = res.getLong(1);
				String nombre = res.getString(2);
				String apellido = res.getString(3);
				String tema = res.getString(4);
				String email = res.getString(5);
				Date fechaAlta = res.getDate(6);

				orador = new Orador(dbId, nombre, apellido, email, tema, fechaAlta);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el orador", e);
		}
		return orador;
	}

	@Override
	public void update(Orador orador) {
		String sql = "UPDATE oradores SET nombre=?, apellido=?, mail=?, tema=? WHERE id_oradores = ?";

		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getTema());
			statement.setString(4, orador.getMail());
			statement.setLong(5, orador.getId());
			
			statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo actualizar el orador", e);
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM oradores WHERE id_oradores = ?";

		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setLong(1, id);
			statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el orador", e);
		}
	}

	@Override
	public List<Orador> findAll() {

		String sql = "SELECT * FROM oradores";

		List<Orador> oradores = new ArrayList<>();
		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Long dbId = res.getLong(1);
				String nombre = res.getString(2);
				String apellido = res.getString(3);
				String tema = res.getString(4);
				String email = res.getString(5);
				Date fechaAlta = res.getDate(6);

				oradores.add(new Orador(dbId, nombre, apellido, email, tema, fechaAlta));

			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el orador", e);
		}
		return oradores;
	}

}
