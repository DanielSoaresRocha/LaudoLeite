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
import org.springframework.data.domain.Page;

import java.net.URI;
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
    @ApiOperation(value="Buscar laudo por situacao")
    @RequestMapping(path="/emAnalise/{situacao}", method=RequestMethod.GET)
    public ResponseEntity<?> findSituacao(@PathVariable Integer situacao) {
        List<Laudo>  obj = service.findSituacao(situacao);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation("Listar todos laudos cadastrados")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Laudo>> findAll() {
        List<Laudo> list= service.findAll();
        return ResponseEntity.ok().body(list);

    }
    @ApiOperation("Listando todos os laudos por paginação")
    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<Laudo>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="cliente") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Laudo> list = service.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @ApiOperation("Deletar todos os laudos (Serviço para testes")
    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete() {
        service.delete();
        return ResponseEntity.noContent().build();
    }
    @ApiOperation("Atualizar laudo do tipo FisicoQuimico")
    @RequestMapping(value="fisicoquimico/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody FisicoQuimico obj, @PathVariable Integer id) {
           obj.setId(id);
           service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Atualizar laudo do tipo Microbiologico ")
    @RequestMapping(value="microbiologica/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Microbiologica obj, @PathVariable Integer id) {
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
