package cdb.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import cdb.config.ConfigWeb;
import cdb.model.Computer;
import cdb.persistance.DTO.ComputerDTO;
import cdb.persistance.DTO.ComputerDTO.ComputerDTOBuilder;
import cdb.service.ComputerService;

/**
 * Servlet implementation class AddComputerServlet
 */
@WebServlet("/addComputer")
public class AddComputerServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private ComputerService computerService;
	private ComputerDTO computerDTO;
	// private WebApplicationContext springContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
	public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }
    
    */
	
    public AddComputerServlet() {
        super();
    }
    
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
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     	/* String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String email=request.getParameter("email");  
	        String country=request.getParameter("country"); */
			
		
		String computerName = request.getParameter("name");
		String computerIntroduced = request.getParameter("introduced");
		String computerDiscontinued = request.getParameter("discontinued");
		String computerCompanyID = request.getParameter("companyID");
		
		Computer computer = new Computer();
		/*
		computer.setName(computerName);
		computer.setIntroduced(computerIntroduced);
		computer.setDiscontinued(computerDiscontinued);
		
		*/
		
		
		
		
		
		
		doGet(request, response);
	}

}
