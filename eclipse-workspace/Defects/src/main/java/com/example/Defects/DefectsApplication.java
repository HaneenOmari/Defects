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
import com.example.Defects.domain.DefectRepository;

@SpringBootApplication
public class DefectsApplication {
	@Autowired
	private DefectRepository repository;

	private static ArrayList<Defects> defectsList;

	public static void main(String[] args) {
		SpringApplication.run(DefectsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		Writer writer = Reader.extracted("CMServer.20170924_1557.log");
		defectsList = writer.getDefectsList();
		return args -> {
			int i = 0;
			for(Defects defect : defectsList ) {
				App app = new App(defect.getApp() + i,defect.getCode(),defect.getSeverity());
				repository.save(app);
				i++;
			}
		};
	}
}
