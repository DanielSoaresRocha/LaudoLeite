package com.backend.laudoleite.services;

import com.backend.laudoleite.domain.Laudo;
import com.backend.laudoleite.repositories.LaudoRepository;
import com.backend.laudoleite.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import java.util.List;


import java.util.Optional;


@Service
public class LaudoService {
    @Autowired
    private LaudoRepository repo;

    public Laudo insert(Laudo obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Laudo find(Integer id) {
        Optional<Laudo> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Laudo.class.getName()));
    }

    public List<Laudo> findAll() {
        return repo.findAll();
    }

    public void delete() {
        repo.deleteAll();
    }
    public Laudo update(Laudo obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public Page<Laudo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

}
