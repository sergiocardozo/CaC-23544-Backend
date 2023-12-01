package ar.com.codoacodo.controllers;

import java.io.IOException;

import ar.com.codoacodo.entity.Orador;
import ar.com.codoacodo.repository.IOradorRepository;
import ar.com.codoacodo.repository.MysqlOradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/orador/nuevo")
public class NuevoOradorController extends HttpServlet{

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("mail");
		String tema = request.getParameter("tema");
		
		Orador nuevo = new Orador(nombre, apellido, email, tema);
		IOradorRepository repository = new MysqlOradorRepository();
		
		repository.save(nuevo);
		
		response.getWriter().print("OK");
	}
}
