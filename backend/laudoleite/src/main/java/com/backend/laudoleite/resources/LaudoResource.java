package com.backend.laudoleite.resources;

import com.backend.laudoleite.domain.FisicoQuimico;
import com.backend.laudoleite.domain.Laudo;
import com.backend.laudoleite.domain.Microbiologica;
import com.backend.laudoleite.services.LaudoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value="API REST Produtos")
public class LaudoResource {

    @Autowired
    private LaudoService service;


    @RequestMapping(path = {"/microbiologica"},method=RequestMethod.POST)
    @ApiOperation(value="Criar laudo (MicroBiologica)")
    public ResponseEntity<Void> insert(@RequestBody Microbiologica obj) {
        Laudo laudo = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(laudo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(path = {"/fisicoQuimico"},method=RequestMethod.POST)
    @ApiOperation(value="Criar laudo (FisicoQuimico)")
    public ResponseEntity<Void> insert(@RequestBody FisicoQuimico obj) {
        Laudo laudo = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(laudo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value="Buscar laudo por ID")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Laudo obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation("Listar todos laudos cadastrados")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Laudo>> findAll() {
        List<Laudo> list= service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @ApiOperation("Deletar todos os laudos (Serviço para testes")
    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete() {
        service.delete();
        return ResponseEntity.noContent().build();
    }


}
