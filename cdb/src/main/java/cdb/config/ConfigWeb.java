package cdb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan(basePackages = {
		"cdb.persistance",
		"cdb.service",
		"cdb.controller",
		"cdb.servlet",
		"cdb.persistance.CdbConnection"
})

public class ConfigWeb {

}
