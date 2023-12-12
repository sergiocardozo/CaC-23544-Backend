package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.codoacodo.entity.Hora_Turno;
import ar.com.codoacodo.entity.Turno;
import ar.com.codoacodo.repository.MysqlTurnoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/horas")
public class NuevoHoraController extends HttpServlet {

	private MysqlTurnoRepository repository = new MysqlTurnoRepository();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Hora_Turno> listaTurno = repository.findAllHoras();

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);

		String jsonParaFront = mapper.writeValueAsString(listaTurno);

		resp.getWriter().print(jsonParaFront);
	}
}
