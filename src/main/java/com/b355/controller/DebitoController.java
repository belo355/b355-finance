package com.b355.controller;

import com.b355.model.Debito;
import com.b355.repository.DebitoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/debitos")
public class DebitoController {

    @Autowired
    private DebitoRepository repository;

    Logger logger = LoggerFactory.getLogger(DebitoController.class);

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Debito>> getAll(){
        try{
            //TODO: add dto como model-transfer
            List<Debito> debitos = (List<Debito>) repository.findAll(); //todo: entender necessidade do cast
            return ResponseEntity.ok(debitos);
        }catch (IllegalArgumentException e ){
            logger.info(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Debito> getOne(@PathVariable("id") Long id){
        //TODO:add try catch
        return (Optional<Debito>) repository.findById(id);
    }

    @PostMapping
    public ResponseEntity register(@RequestBody Debito debito){
        try {
            repository.save(debito);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
