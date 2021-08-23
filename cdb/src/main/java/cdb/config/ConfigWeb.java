package cdb.config;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// @EnableWebMvc
@Configuration
@Import(ConfigJPA.class)
@ComponentScan(basePackages = { "cdb.persistance", "cdb.service", "cdb.controller", "cdb.servlet",
		"cdb.persistance.CdbConnection" })

@PropertySource("classpath:database.properties")

public class ConfigWeb {


	@Bean
	public HikariDataSource mysqlDataSource() {

		HikariConfig config = new HikariConfig("/database.properties");
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return new HikariDataSource(config);
	}

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(mysqlDataSource());
	}

	@Bean
	public JdbcTemplate JdbcTemplate() {
		return new JdbcTemplate(mysqlDataSource());
	}

}
