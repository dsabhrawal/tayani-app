package com.tayani.app.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

@SpringBootApplication
@ImportResource("classpath:WEB-INF/spring/root-context.xml")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		// assume SLF4J is bound to logback in the current environment
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		StatusPrinter.print(lc);

		logger.debug("------------------------Starting Tayani App------------------------");
		SpringApplication.run(Application.class);

	}
}
