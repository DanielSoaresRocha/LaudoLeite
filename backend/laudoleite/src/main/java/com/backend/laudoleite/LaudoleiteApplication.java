package com.backend.laudoleite;

import com.backend.laudoleite.domain.FisicoQuimico;
import com.backend.laudoleite.domain.Laudo;
import com.backend.laudoleite.domain.Microbiologica;
import com.backend.laudoleite.repositories.LaudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class LaudoleiteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LaudoleiteApplication.class, args);
	}

	@Autowired
	private LaudoRepository laudoRepository;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Override
	public void run(String... args) throws Exception {


		Laudo l2= new FisicoQuimico(null,"Daniel","FISICOQUIMICO","OK","01001","PEDRO",
				sdf.parse("10/03/2020 10:32"),"12:30","A","SIM",
				"LUCAS","23","Em análise","Leite ninho","Natal","produtos",2,0,"amostragem",sdf.parse("10/03/2020 10:32"));


		Laudo l1 = new Microbiologica(null,"Wesley","MICROBIOLOGICO","OK","01001","PEDRO",
				sdf.parse("10/03/2020 10:32"),"12:30","A","SIM",
				"LUCAS","23","Em análise","Leite","32323",  sdf.parse("10/03/2020 10:32"),  sdf.parse("10/03/2020 10:32"),true,
				12,"Lucas",  sdf.parse("10/03/2020 10:32"),"13:23","OK","25");

		laudoRepository.saveAll(Arrays.asList(l1, l2));
	}

}
