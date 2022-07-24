package com.iec.cbfapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import com.iec.cbfapp.entities.Evento;


@Repository
public class EventoRepository {
	
	public static final String HASH_KEY = "Evento";
    @Autowired
    private RedisTemplate template;

    public Evento save(@RequestBody Evento evento){    	
        template.opsForHash().put(HASH_KEY,evento.getId(),evento);
        return evento;
    }

    public List<Evento> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Evento findEventoById(int id){
        return (Evento) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteEvento(int id){
         template.opsForHash().delete(HASH_KEY,id);
        return "Evento removed !!";
    }

}
