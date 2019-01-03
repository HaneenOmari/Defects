package com.example.Defects;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cmserver.ar.Defects;
import com.cmserver.ar.Reader;
import com.cmserver.ar.Writer;
import com.example.Defects.domain.App;
import com.example.Defects.domain.AppRepository;

@SpringBootApplication
public class DefectsApplication {
	@Autowired
	private AppRepository repository;

	private static ArrayList<Defects> defectsList;

	public static void main(String[] args) {
		SpringApplication.run(DefectsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		Writer writer = Reader.extracted("CMServer.20170924_1557.log");
		defectsList = writer.getDefectsList();
		return args -> {
			int id = 0;int i;
			for(Defects defect : defectsList ) {
			//	App app = new App(defect.getApp() + i,defect.getCode(),defect.getSeverity());
				i=defect.getApp().indexOf(" ");
				App app = new App(id+" ",defect.getApp().substring(0, i),defect.getApp().substring(i+1,(defect.getApp().length()) ));
				repository.save(app);
				id++;
			}
		};
	}
}
