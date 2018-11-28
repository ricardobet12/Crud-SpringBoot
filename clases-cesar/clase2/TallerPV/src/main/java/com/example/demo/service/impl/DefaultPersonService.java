/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricardo
 */
@Service
public class DefaultPersonService implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonDTO> listarPersonas() {
        List<PersonDTO> respuesta = null;
        List<Person> personas = personRepository.findAll();
        if (personas != null && !personas.isEmpty()) {
            respuesta = new ArrayList<>();
            for (Person persona : personas) {
                respuesta.add(personToDto(persona));
            }
        }
        return respuesta;
    }

    @Override
    public PersonDTO consultarPersona(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            return personToDto(personOptional.get());
        }
        return null;
    }

    @Override
    public PersonDTO guardarPersona(PersonDTO p) {
        Person persona = personRepository.save(dtoToPerson(p));
        return personToDto(persona);
    }

    private PersonDTO personToDto(Person persona) {
        return new PersonDTO(persona.getIdentificacion(), persona.getNombre(), persona.getDireccion(), persona.getTelefono());
    }

    private Person dtoToPerson(PersonDTO persona) {
        Person resp = new Person();
        resp.setIdentificacion(persona.getId());
        resp.setNombre(persona.getName());
        resp.setDireccion(persona.getAddress());
        resp.setTelefono(persona.getPhone());
        return resp;
    }

    @Override
    public PersonDTO eliminarPersona(Long id) {
        PersonDTO persona = consultarPersona(id);
        if (persona != null) {
            personRepository.deleteById(id);
            return persona;
        }

        return null;
    }
}
