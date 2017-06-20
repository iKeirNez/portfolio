package com.keirnellyer.portfolio.listener;

import com.keirnellyer.portfolio.Profile;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;

@WebListener
public class ApplicationInitializer implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		Profile profile = new Profile("Keir", "Nellyer", LocalDate.of(1999, 1, 12),
				"Dunfermline, Scotland", "keir@nellyer.co.uk");
		context.setAttribute("profile", profile);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
