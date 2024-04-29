package com.crud.crud.service;

import com.crud.crud.model.Persona;
import com.crud.crud.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    private IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> getAll() {
        return iPersonaRepository.findAll();
    }

    @Override
    public void save(Persona p) {
        iPersonaRepository.save(p);

    }

    @Override
    public Optional<Persona> findById(Long id) {
        return iPersonaRepository.findById(id);
    }
}
