package com.enlightendev.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * WebApplicationInitializer is an interface that is automatically picked up by Spring to initialize your application.
 */
public class MyWebAppInitializer implements WebApplicationInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(MyWebAppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        /*
         * Create the 'root' Spring application context
         * This creates a AnnotationConfigWebApplicationContext and adds our main config class AppConfig. We have to
         * add this to get things started because this is the class that tells Spring to scan the rest of the classes
         * with the @ComponentScan which triggers Spring to read the rest of our @Configuration classes.
         */
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        // Register application config
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Register Encoding Filter
        addEncodingFilter(servletContext);

        // Register Logging Filter
        addLoggingFilter(servletContext);

        // Register and map the dispatcher servlet
        addServiceDispatcherServlet(servletContext, rootContext);

    }

    /**
     * We also add the DispatcherServlet which is the cornerstone of Spring MVC to the servlet container and adding the
     * mapping of “/” so that our servlet picks up all requests to our host. This servlet is responsible for mapping
     * requests to the correct handler. It uses the configuration set up by our @EnableWebMvc in the WebConfig class.
     * This will only work on application servers supporting version 3.0 or later of the servlet specification.
     * My server of choice is Tomcat 7 which this application has been tested on.
     * @param servletContext
     * @param rootContext
     */
    private void addServiceDispatcherServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext) {

        final String SERVICES_MAPPING = "/";

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("servicesDispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        Set<String> mappingConflicts = dispatcher.addMapping(SERVICES_MAPPING);

        if (!mappingConflicts.isEmpty()) {
            for (String s : mappingConflicts) {
                LOG.error("Mapping conflict: " + s);
            }
            throw new IllegalStateException("'ServicesDispatcher' could not be mapped to '" + SERVICES_MAPPING + "'");
        }
    }

    private void addEncodingFilter(ServletContext container) {
        FilterRegistration.Dynamic fr = container.addFilter("encodingFilter", new CharacterEncodingFilter());
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
    }

    private void addLoggingFilter(ServletContext container) {
        FilterRegistration.Dynamic fr = container.addFilter("loggingFilter", new CommonsRequestLoggingFilter());
        fr.addMappingForUrlPatterns(null, true, "/*");
    }
}
