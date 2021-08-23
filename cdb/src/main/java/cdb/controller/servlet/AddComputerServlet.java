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
import cdb.model.Company;
import cdb.model.Computer;
import cdb.persistance.DTO.ComputerDTO;
import cdb.persistance.DTO.ComputerDTO.ComputerDTOBuilder;
import cdb.persistance.DTO.DTOCompanyDB;
import cdb.service.CompanyService;
import cdb.service.ComputerService;

/**
 * Servlet implementation class AddComputerServlet
 */
@WebServlet("/AddComputerServlet")
public class AddComputerServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;;
	private ComputerService computerService;
	private ComputerDTO computerDTO;
	private CompanyService companyService;
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
			companyService = context.getBean(CompanyService.class);
			computerDTO = context.getBean(ComputerDTO.class);
			
		} catch(ServletException e) {
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DTOCompanyDB> listCompany = companyService.getAllCompany();
		request.setAttribute("listCompany", listCompany);
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComputerDTO computerDTO = new ComputerDTO();
		ComputerDTOBuilder addComputer = new ComputerDTOBuilder();
		
		String computerName = request.getParameter("name");
		String computerIntroduced = request.getParameter("introduced");
		String computerDiscontinued = request.getParameter("discontinued");
		String computerCompanyID = request.getParameter("companyID");
		
		Computer computer = new Computer();
		
		addComputer.setName(computerName);
		addComputer.setIntroduced(computerIntroduced);
		addComputer.setDiscontinued(computerDiscontinued);
		addComputer.setCompanyID(computerCompanyID);
		
		computerDTO = addComputer.build();
		
		//computerService.addComputer(computer);
		
		
		response.sendRedirect("http://localhost:8080/cdb/AddComputerServlet");
		
		
		
	}

}
