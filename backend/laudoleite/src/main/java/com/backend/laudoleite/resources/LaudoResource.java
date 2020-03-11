package com.backend.laudoleite.resources;

import com.backend.laudoleite.domain.FisicoQuimico;
import com.backend.laudoleite.domain.Laudo;
import com.backend.laudoleite.domain.Microbiologica;
import com.backend.laudoleite.services.LaudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/laudos")
public class LaudoResource {

    @Autowired
    private LaudoService service;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Laudo obj) {
        Laudo laudo = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(laudo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Laudo obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
