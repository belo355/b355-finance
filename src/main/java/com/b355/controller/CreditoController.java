package com.b355.controller;

import com.b355.model.Credito;
import com.b355.repository.CreditoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/creditos")
public class CreditoController {

    @Autowired
    private CreditoRepository repository;

    Logger logger = LoggerFactory.getLogger(CreditoController.class);

    @GetMapping
    public ResponseEntity<List<Credito>> getAll() {
        try{
            List<Credito> creditos = repository.findAll();
            return ResponseEntity.ok(creditos);
        }catch (IllegalArgumentException e ){
            logger.info(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public Optional<Credito> getOne(@PathVariable("id") Long id) {
        return (Optional<Credito>) repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody Credito credito){
        try{
            repository.save(credito);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
        }
        return  new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
