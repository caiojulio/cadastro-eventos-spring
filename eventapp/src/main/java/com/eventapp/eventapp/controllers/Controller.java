package com.eventapp.eventapp.controllers;

import com.eventapp.eventapp.EventappApplication;
import com.eventapp.eventapp.models.EventModel;
import com.eventapp.eventapp.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class Controller {
    @Autowired
    EventsRepository eventsRepository;

    @GetMapping("")
    public ResponseEntity<String> opening(){
        return ResponseEntity.status(HttpStatus.OK).body("API DE CADASTRO DE EVENTOS, SEJA BEM VINDO(A)!");
    }

    @GetMapping("/list-events") //ACESSAR TODOS OS EVENTOS
    public List<EventModel> getEvents(){
        return eventsRepository.findAll();
    }

    @PostMapping("/register-event") //REGISTRAR EVENTO
    public String registerEvent(@RequestBody EventModel infoEvent){
        eventsRepository.save(infoEvent);
        return "Evento Registrado";
    }

    @GetMapping("/get-event/{idEvent}") //ENCONTRA EVENTO ESPECIFICO
    public ResponseEntity<Object> getEvent(@PathVariable int idEvent){
        if(eventsRepository.findById(idEvent).isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");
        return ResponseEntity.status(HttpStatus.OK).body(eventsRepository.findById(idEvent));
    }

    @PutMapping("/update-event/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable Integer idEvent, @RequestBody EventModel newEvent){
        newEvent.setIdEvent(idEvent); //COPIA O ID DO EVENTO QUE SERÁ ATUALIZADO, NESSE CASO SOBRESCREVERÁ O EVENTO QUE TEM O MESMO ID

        if(eventsRepository.findById(idEvent).isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");
        return ResponseEntity.status(HttpStatus.OK).body(eventsRepository.save(newEvent));
    }

    @DeleteMapping("/delete-event/{idEvent}")
    public ResponseEntity<String> updateEvent(@PathVariable Integer idEvent){

        if(eventsRepository.findById(idEvent).isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");

        eventsRepository.deleteById(idEvent);
        return ResponseEntity.status(HttpStatus.OK).body("Evento de ID: " + idEvent +  " deletado");
    }
}
