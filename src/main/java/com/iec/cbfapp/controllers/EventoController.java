package com.iec.cbfapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iec.cbfapp.entities.Evento;
import com.iec.cbfapp.repository.EventoRepository;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
    private EventoRepository eventoRepository;

    @PostMapping
    public Evento save(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @GetMapping
    public List<Evento> getAllEvento() {
        return eventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Evento findProduct(@PathVariable int id) {
        return eventoRepository.findEventoById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
    	return eventoRepository.deleteEvento(id);
	}

}
