package cdb.cli;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cdb.config.ConfigWeb;
import cdb.model.Computer;
import cdb.service.ComputerService;



public class Cli {

	private static ApplicationContext context;

	public static void main(final String[] args) {

		context = new AnnotationConfigApplicationContext(ConfigWeb.class);

		List<Computer> listcomputer = context.getBean(ComputerService.class).getAllComputer();
		for (Computer computer : listcomputer) {
			System.out.println(computer);
		}

	}
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
