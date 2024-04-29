package com.crud.crud.service;

import com.crud.crud.model.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    public List<Persona> getAll();

    void save(Persona p);

    Optional<Persona> findById(Long id);
}
