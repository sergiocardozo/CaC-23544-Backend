package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.entity.Hora_Turno;
import ar.com.codoacodo.entity.Turno;
import ar.com.codoacodo.utils.DateUtils;

public class MysqlTurnoRepository implements ITurnoRepository {

	// alt+shift+R refactor
	@Override
	public void save(Turno turno) {

		String sql = "INSERT INTO turnos (nombre,apellido,mail,fecha_turno,id_hora,tipo_corte) VALUES(?,?,?,?,?,?)";

		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, turno.getNombre());
			statement.setString(2, turno.getApellido());
			statement.setString(3, turno.getMail());
			statement.setDate(4, new java.sql.Date(DateUtils.asDate(turno.getFecha_turno()).getTime()));
			statement.setInt(5, turno.getId_hora());
			statement.setString(6, turno.getTipo_corte());

			statement.executeUpdate();// INSERT-UPDATE-DELETE

			ResultSet res = statement.getGeneratedKeys();
			if (res.next()) {
				Long id = res.getLong(1);
				turno.setId(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el turno", e);
		}
	}

	@Override
	public Turno getById(Long id) {

		String sql = "SELECT * FROM turnos WHERE id = ?";

		Turno turno = null;
		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, id);

			ResultSet res = statement.executeQuery();
			if (res.next()) {
				Long dbId = res.getLong(1);
				String nombre = res.getString(2);
				String apellido = res.getString(3);
				String email = res.getString(4);
				Date fecha_turno = res.getDate(5);
				Integer id_hora = res.getInt(6);
								String tipo_corte = res.getString(8);
				Date fecha_alta = res.getDate(8);
				
				turno = new Turno(dbId, nombre, apellido, email, DateUtils.asLocalDate(fecha_turno), id_hora, tipo_corte, fecha_alta);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el turno", e);
		}
		return turno;
	}

	@Override
	public void update(Turno turnos) {
		String sql = "UPDATE turnos SET nombre=?, apellido=?, mail=?, fecha_turno=?, id_hora=?, tipo_corte=? WHERE id = ?";

		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, turnos.getNombre());
			statement.setString(2, turnos.getApellido());
			statement.setString(3, turnos.getMail());
			statement.setDate(4, new java.sql.Date(DateUtils.asDate(turnos.getFecha_turno()).getTime()));
			statement.setInt(5, turnos.getId_hora());
			statement.setString(6, turnos.getTipo_corte());
			statement.setLong(7, turnos.getId());
			statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo actualizar el turno", e);
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM turnos WHERE id = ?";

		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setLong(1, id);
			statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el turno", e);
		}
	}

	@Override
	public List<Turno> findAll() {

		String sql = "SELECT"
				+ "    turnos.id, "
				+ "    turnos.nombre, "
				+ "    turnos.apellido, "
				+ "    turnos.mail, "
				+ "    turnos.fecha_turno, "
				+ "    hora_turno.id_hora, "
				+ "    hora_turno.nombre_hora, "
				+ "    turnos.tipo_corte, "
				+ "    turnos.fecha_alta "
				+ "FROM turnos "
				+ "JOIN hora_turno ON turnos.id_hora = hora_turno.id_hora "
				+ "WHERE turnos.fecha_turno >= CURRENT_DATE() "
				+ "ORDER BY turnos.fecha_turno ASC;";
		
		List<Turno> turnos = new ArrayList<>();
		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Long dbId = res.getLong(1);
				String nombre = res.getString(2);
				String apellido = res.getString(3);
				String email = res.getString(4);
				LocalDate fecha_turno = DateUtils.asLocalDate(res.getDate(5));
				Integer id_hora = res.getInt(6);
				String nombre_hora = res.getString(7);
				String tipo_corte = res.getString(8);
				Date fecha_alta = res.getDate(9);
				

				turnos.add(new Turno(dbId, nombre, apellido, email, fecha_turno, id_hora, nombre_hora, tipo_corte, fecha_alta));

			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el orador", e);
		}
		return turnos;
	}

	public List<Hora_Turno> findAllHoras() {

		String sql = "SELECT * FROM hora_turno"
				;
		
		List<Hora_Turno> horas = new ArrayList<>();
		try (Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Long dbId = res.getLong(1);
				String nombre_hora = res.getString(2);
				
				horas.add(new Hora_Turno(dbId, nombre_hora));

			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("No se pudo crear el orador", e);
		}
		return horas;
	}
}
