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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import cdb.config.ConfigWeb;
import cdb.model.Computer;
import cdb.model.Page;
import cdb.persistance.DTO.ComputerDTODb;
import cdb.persistance.mapper.ComputerMapper;
import cdb.service.ComputerService;

@Controller
public class DashboardServlet extends HttpServlet {
	
	
	private ComputerService computerService; 
	private ComputerMapper computerMapper;
	
	
	public DashboardServlet(ComputerService computerService, ComputerMapper computerMapper) {
		super();
		this.computerService = computerService;
		this.computerMapper = computerMapper;
	}
	
	@GetMapping(value = "/dashboard")
	protected ModelAndView getModelAndView(String viewName, Exception ex) {
		  ModelAndView mv = new ModelAndView(viewName);
		
			mv.addObject("listComputer", this.getAllComputer());
		  
		  return mv;
		}
	
	private List<ComputerDTODb> getAllComputer() {
		
		return computerService.getAllComputer();
	}
	
}




/*
 * 
 * 
 * List<Computer> listComputer = computerService.getAllComputer();
request.setAttribute("listComputer", listComputer);

int nbComputer = computerService.countAllComputer();
request.setAttribute("nbComputer", nbComputer);


request.setAttribute("page", page);
 * 
 
// @WebServlet("/dashboard")
@WebServlet(name = "Dashboard", urlPatterns = { "/dashboard" })



	
	private Page page = new Page();
	
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

	*/