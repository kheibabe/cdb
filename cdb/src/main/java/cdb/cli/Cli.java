package cdb.cli;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cdb.config.ConfigJPA;
import cdb.config.ConfigWeb;
import cdb.model.Company;
import cdb.model.Computer;
import cdb.model.Computer.ComputerBuilder;
import cdb.persistance.ComputerDAO;
import cdb.persistance.DTO.ComputerDTODb;
import cdb.persistance.DTO.DTOCompanyDB;
import cdb.service.CompanyService;
import cdb.service.ComputerService;



public class Cli {

	private static ApplicationContext context;

	public static void main(final String[] args) {
		
		
		String name = "javaleSangouaisouaisouais";
		LocalDate introduced = LocalDate.parse("1993-02-23");
		LocalDate discontinued = LocalDate.parse("2000-10-08");
		int id = 578;
		int company = 13;
		
		ComputerDTODb computertest = new ComputerDTODb().setName(name).setIntroduced(introduced).setDiscontinued(discontinued).setCompany(new DTOCompanyDB(company, "newcompany"));
		
		context = new AnnotationConfigApplicationContext(ConfigWeb.class);
		context.getBean(ComputerService.class).editCPR(id, computertest);
		List<ComputerDTODb> listcomputer = context.getBean(ComputerService.class).getAllComputer();
		for (ComputerDTODb computer : listcomputer) {
			System.out.println(computer);
		}
		
		System.out.println(listcomputer.size());
		//System.out.println(Dtocompanydb);
		/* List<DTOCompanyDB> listcompany = context.getBean(CompanyService.class).getAllCompany();
		for (DTOCompanyDB company : listcompany) {
			System.out.println(company);
		}
		
		*/
		

		/*
		 * TEST EDIT COMPUTER
		 * 
		 * String name = "mashallaaaaaa";
		LocalDate introduced = LocalDate.parse("1993-02-21");
		LocalDate discontinued = LocalDate.parse("2000-10-12");
		int company = 3;
		int cprid = 578;
		
		Computer computertest = new ComputerBuilder().setName(name).setIntroduced(introduced).setDiscontinued(discontinued).setCompany(new Company(company, "newcompany")).build();
		
		context = new AnnotationConfigApplicationContext(ConfigWeb.class);
		context.getBean(ComputerService.class).editCPR(cprid, computertest);
		List<Computer> listcomputer = context.getBean(ComputerService.class).getAllComputer();
		for (Computer computer : listcomputer) {
			System.out.println(computer);
		}
		
		 * 
		 * TEST DELETE COMPANY 
		 * 
		 * context = new AnnotationConfigApplicationContext(ConfigWeb.class);
		int id = 42;
		context.getBean(CompanyService.class).deleteCompany(id);
		List<Company> listcompany = context.getBean(CompanyService.class).getAllCompany();
		for (Company company : listcompany) {
			System.out.println(company);
		}
		
		
		 * TEST DELETE COMPUTER WITH COMPANY ID
		 * context = new AnnotationConfigApplicationContext(ConfigWeb.class);
		int id = 42;
		context.getBean(ComputerService.class).deleteComputerWithCnyId(id);
		List<Computer> listcomputer = context.getBean(ComputerService.class).getAllComputer();
		for (Computer computer : listcomputer) {
			System.out.println(computer);
		 * 
		 * 
		 * TEST ADD COMPUTER
		 * 	String name = "javalesaaaang";
		LocalDate introduced = LocalDate.parse("1993-02-23");
		LocalDate discontinued = LocalDate.parse("2000-10-08");
		int company = 3;
		
		Computer computertest = new ComputerBuilder().setName(name).setIntroduced(introduced).setDiscontinued(discontinued).setCompany(new Company(company, "newcompany")).build();
		
		context = new AnnotationConfigApplicationContext(ConfigWeb.class);
		context.getBean(ComputerService.class).addComputer(computertest);
		List<Computer> listcomputer = context.getBean(ComputerService.class).getAllComputer();
		for (Computer computer : listcomputer) {
			System.out.println(computer);
		}
		 * 
		 * TEST DELETE COMPUTER
		 * 	context = new AnnotationConfigApplicationContext(ConfigWeb.class);
		int id = 5;
		context.getBean(ComputerService.class).deleteComputer(id);
		List<Computer> listcomputer = context.getBean(ComputerService.class).getAllComputer();
		for (Computer computer : listcomputer) {
			System.out.println(computer);
		}
		*
		*
		*TEST GET COMPANYID
		*context = new AnnotationConfigApplicationContext(ConfigWeb.class);
		int id = 42;
		Optional<DTOCompanyDB> Dtocompanydb = context.getBean(CompanyService.class).getCompany(id);
		System.out.println(Dtocompanydb);
		
		
		
		
	*/
		
		
		
		//computerController.addComputer(computerAdd);
		//computerAdd = computerController.getComputerById(590);
		//System.out.println(computerAdd);
				
		// int id = 5;
		// int computer = context.getBean(ComputerService.class).countAllComputer();
		// System.out.println(computer);
		
		
		
		}
		
		
		/*
		 * 
		 *  List<Company> listcompany = context.getBean(CompanyService.class).getAllCompany();
		for (Company company : listcompany) {
			System.out.println(company);
		 *  
		 *  List<Computer> listcomputer = context.getBean(ComputerService.class).getAllComputer();
		for (Computer computer : listcomputer) {
			System.out.println(computer);
		} */

	}



/*

public class Cli {

	  
	  public static void main(final String[] args) {
	    appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

	    try {
	      ComputerService computerService = appContext.getBean(ComputerService.class);
	      computerService.getAllComputer();
	      List <Computer> listcomputer = computerService.getAllComputer();
	      for (Computer computer : listcomputer) {
				System.out.println(computer);
			}
	    } catch (final Exception e) {
	      e.printStackTrace();
	      System.exit(1);
	    }
	  }
	}


/*
 * 
 * 
 * 
 *  public static void main(final String[] args) {
	  
		//  ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ConfigCli.class);	
	 
	  private static ClassPathXmlApplicationContext appContext;
public class Cli {

	public static void main(String[] args) {
		ComputerService cs = ComputerService.getInstance();
		List <Computer> listcomputer = cs.getAllComputer();
		
		for (Computer computer : listcomputer) {
			System.out.println(computer);
		}
		
		int id = 5;
		Computer computer = cs.getComputer(id);
		System.out.println(computer);
	}

}

*/
