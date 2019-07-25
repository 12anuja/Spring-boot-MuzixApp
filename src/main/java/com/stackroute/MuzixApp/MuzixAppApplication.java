package com.stackroute.MuzixApp;

import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.error.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.service.MuzixSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

//Implements CommandLineRunner and extends SpringBootServerInitializer
public class MuzixAppApplication //extends SpringBootServletInitializer implements CommandLineRunner
{



	public static void main(String[] args)
	{
		SpringApplication.run(MuzixAppApplication.class, args);
	}


		//Methods used for implementing commandlinerunner interface
	/* Command line runners are a useful functionality to execute
	the various types of code that only have to be run once, right after application startup
	 */

	/*

	MuzixSrevice muzixSrevice;

	@Autowired
	public void setMuzixSrevice(MuzixSrevice muzixSrevice)
	{
		this.muzixSrevice=muzixSrevice;
	}

		@Override
		protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
			return application.sources(MuzixAppApplication.class);
		}


		@Override
		public void run (String...args) throws Exception {
			try {
				muzixSrevice.saveTrack(new Muzix(1,"How long","Charli Puth"));

			}
			catch (TrackAlreadyExistsException ex)
			{
				ex.printStackTrace();
			}
		}

	 */
}
