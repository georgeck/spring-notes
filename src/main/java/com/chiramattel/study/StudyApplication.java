package com.chiramattel.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {

		// An easy (default) way of initializing the `ApplicationContext`.
		ApplicationContext ctx = SpringApplication.run(StudyApplication.class, args);

		// Alternate way of initializing the ApplicationContext
		//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(/*ApplicationConfig.class, Component1.class, Component2.class*/);
		//		ctx.scan("com.chiramattel.study");
		//		ctx.refresh();

		// Get all Beans currently registered in context
		Arrays.asList(ctx.getBeanDefinitionNames()).forEach(System.out::println);

		// Get a specified bean from the context
		Component1 component1 = ctx.getBean(Component1.class);
		System.out.println(component1.getDataFromResource());

		// Get the active 'environment' from the context
		final Environment environment = ctx.getEnvironment();
		final String[] activeProfiles = environment.getActiveProfiles();
		Arrays.asList(activeProfiles).forEach(s -> System.out.println("profiles = " + s));
	}
}
