package com.b355.controller;

import com.b355.model.Debito;
import com.b355.repository.DebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class DebitoController {

    private DebitoRepository debitoRepository;

    @Autowired
    public DebitoController(DebitoRepository debitoRepository){
        this.debitoRepository = debitoRepository;
    }

    @RequestMapping(value="/debitos", method = RequestMethod.GET)
    @ResponseBody
    public List<Debito> getAllDebitos(){
        return (List<Debito>) debitoRepository.findAll();
    }

    @RequestMapping(value="/debito/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Optional<Debito> getOneDebito(@PathVariable("id") Long id){
        return (Optional<Debito>) debitoRepository.findById(id);
    }
}
