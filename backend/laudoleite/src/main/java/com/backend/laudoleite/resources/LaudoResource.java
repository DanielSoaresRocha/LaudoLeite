package com.backend.laudoleite.resources;

import com.backend.laudoleite.domain.FisicoQuimico;
import com.backend.laudoleite.domain.Laudo;
import com.backend.laudoleite.domain.Microbiologica;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/laudos")
public class LaudoResource {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @RequestMapping(method = RequestMethod.GET)
    public List<Laudo> hello() throws ParseException {

        Laudo l2= new FisicoQuimico(2,"Daniel","FISICOQUIMICO","OK","01001","PEDRO",
                sdf.parse("10/03/2020 10:32"),"12:30","A","SIM",
        "LUCAS","23","Leite ninho","Natal","produtos",2,0,"amostragem",sdf.parse("10/03/2020 10:32"));


        Laudo l1 = new Microbiologica(1,"Wesley","MICROBIOLOGICO","OK","01001","PEDRO",
                sdf.parse("10/03/2020 10:32"),"12:30","A","SIM",
                "LUCAS","23","Leite","32323",  sdf.parse("10/03/2020 10:32"),  sdf.parse("10/03/2020 10:32"),true,
                12,"Lucas",  sdf.parse("10/03/2020 10:32"),"13:23","OK","25");
        List<Laudo> laudos= new ArrayList<>();
        laudos.add(l1);
        laudos.add(l2);
        return laudos;
    }
}
