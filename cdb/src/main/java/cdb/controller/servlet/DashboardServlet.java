package cdb.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdb.model.Computer;
import cdb.service.ComputerService;

@WebServlet("/dashboard")

public class DashboardServlet extends HttpServlet {

	private ComputerService computerService; 
			
	public DashboardServlet() {
		this.computerService = ComputerService.getInstance();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//afficher la jsp depuis sont path
		// request.setAttribute("heure", "jour");
		
		List<Computer> listComputer = computerService.getAllComputer();
		
		int nbComputer = computerService.countAllComputer();
		
		request.setAttribute("nbComputer", nbComputer);
		request.setAttribute("listComputer", listComputer);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
	}

	
	
	
	
}
