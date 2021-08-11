package cdb.config;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration

@ComponentScan(basePackages = {
		"cdb.persistance",
		"cdb.service",
		"cdb.controller",
		"cdb.servlet",
		"cdb.persistance.CdbConnection"
})

@PropertySource("classpath:database.properties")

public class ConfigWeb {
// class spring à étendre..

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
