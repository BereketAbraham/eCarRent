package mum.edu.cs.cs425.project.ecarrent.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import mum.edu.cs.cs425.project.ecarrent.ECarRentApplication;


public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ECarRentApplication.class);
	}

}