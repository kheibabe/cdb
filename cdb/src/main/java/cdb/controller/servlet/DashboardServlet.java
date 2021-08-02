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
	private Page page = new Page();
			
	public DashboardServlet() {
		this.computerService = ComputerService.getInstance();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//afficher la jsp depuis sont path
		// request.setAttribute("heure", "jour");
		
		List<Computer> listComputer = computerService.getAllComputer();
		request.setAttribute("listComputer", listComputer);
		
		int nbComputer = computerService.countAllComputer();
		request.setAttribute("nbComputer", nbComputer);
		
		
		request.setAttribute("page", page);
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
	}

	
	
	
	
}
