package com.stackroute.MuzixApp.config;

import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.error.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.service.MuzixSrevice;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class WebConfiguration
{
    MuzixSrevice muzixSrevice;

    public WebConfiguration(MuzixSrevice muzixSrevice)
    {
        this.muzixSrevice=muzixSrevice;
    }

    //Using ContextRefreshedEvent
    /*
    @EventListener
    public void seedData(ContextRefreshedEvent contextRefreshedEvent)
    {
        try
        {
            muzixSrevice.saveTrack(new Muzix(1,"One call away","local"));
            muzixSrevice.saveTrack(new Muzix(3,"One direction","central"));
        }
        catch (TrackAlreadyExistsException ex)
        {
            ex.printStackTrace();
        }
    }

     */


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
