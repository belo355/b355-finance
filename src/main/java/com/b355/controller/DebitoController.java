package com.b355.controller;

import com.b355.model.Debito;
import com.b355.repository.DebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/debitos")
public class DebitoController {

    private DebitoRepository repository;

    @Autowired
    public DebitoController(DebitoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public List<Debito> getAll(){
        try{
            //TODO: add dto como model-transfer
            List<Debito> debitos = (List<Debito>) repository.findAll(); //todo: entender necessidade do cast
            return debitos;
        }catch (IllegalArgumentException e ){
            //TODO: add logger
        }
    }

    @GetMapping
    @ResponseBody
    public Optional<Debito> getOne(@PathVariable("id") Long id){
        //TODO:add try catch
        return (Optional<Debito>) repository.findById(id);
    }
}
