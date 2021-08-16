package cdb.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import cdb.config.ConfigWeb;
import cdb.model.Computer;
import cdb.model.Page;
import cdb.service.ComputerService;

// @WebServlet("/dashboard")
@WebServlet(name = "Dashboard", urlPatterns = { "/dashboard" })

public class DashboardServlet extends HttpServlet {

	private ComputerService computerService; 
	private Page page = new Page();
	// private WebApplicationContext springContext;
			
	
	/*
	public DashboardServlet() {
		this.computerService = ComputerService.getInstance();
		
	}
	
	@Autowired
	public DashboardServlet(ComputerService computerService) {
		this.computerService = computerService;
	}
	*/
	
	
	
	
	/* 
	 * ApplicationContext context = new AnnotationConfigApplicationContext(AccountConfig.class);
AccountService accountService = context.getBean(AccountService.class);
	 * 
	 */
	public void init() {
		try {
			super.init();
			ApplicationContext context = new AnnotationConfigApplicationContext(ConfigWeb.class);
			computerService = context.getBean(ComputerService.class);
			
		} catch(ServletException e) {
			e.printStackTrace();
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Computer> listComputer = computerService.getAllComputer();
		request.setAttribute("listComputer", listComputer);
		
		int nbComputer = computerService.countAllComputer();
		request.setAttribute("nbComputer", nbComputer);
		
		
		request.setAttribute("page", page);
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
		
	}

	
	
	
	
}