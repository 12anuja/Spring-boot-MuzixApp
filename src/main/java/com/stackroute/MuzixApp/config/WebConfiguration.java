package com.stackroute.MuzixApp.config;

import org.apache.catalina.servlets.WebdavServlet;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration
{
    @Bean
    public ServletRegistrationBean h2servletRegistration()
    {
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new WebServlet());

        //to use h2 console : http:localhost:8080/console
        //enter db username nad password and CRUD operations will execute using RUN command
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }

}
