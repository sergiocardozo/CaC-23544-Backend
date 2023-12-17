package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.codoacodo.entity.Turno;
import ar.com.codoacodo.repository.MysqlTurnoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/turnos")
public class NuevoTurnoController extends HttpServlet {

	private MysqlTurnoRepository repository = new MysqlTurnoRepository();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Con esta linea obtengo los datos desde el front IMPORTANTE
		String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
		TurnoRequest turnoRequest = mapper.readValue(json, TurnoRequest.class);

		Turno nuevo = new Turno(turnoRequest.getNombre(), turnoRequest.getApellido(), turnoRequest.getMail(),
				turnoRequest.getFecha_turno(), turnoRequest.getId_hora(), turnoRequest.getTipo_corte());

		repository.save(nuevo);

		String jsonParaFront = mapper.writeValueAsString(nuevo);

		response.getWriter().print(jsonParaFront);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Turno> listaTurno = repository.findAll();

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);

		String jsonParaFront = mapper.writeValueAsString(listaTurno);

		resp.getWriter().print(jsonParaFront);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");

		repository.delete(Long.parseLong(id));

		resp.setStatus(HttpServletResponse.SC_OK);
		;

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");

		// ahora quiero los datos que viene en el body
		String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));// spring

		// convierto de json String a Objecto java usando libreria de jackson2
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		TurnoRequest turnoRequest = mapper.readValue(json, TurnoRequest.class);

		// busco el orador en la db
		Turno turno = this.repository.getById(Long.parseLong(id));

		// ahora actualizo los datos
		turno.setNombre(turnoRequest.getNombre());
		turno.setApellido(turnoRequest.getApellido());
		turno.setMail(turnoRequest.getMail());
		turno.setFecha_turno(turnoRequest.getFecha_turno());
		turno.setId_hora(turnoRequest.getId_hora());
		turno.setTipo_corte(turnoRequest.getTipo_corte());

		// ahora si, actualizo en la db!!
		this.repository.update(turno);

		// le informa al front ok
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
