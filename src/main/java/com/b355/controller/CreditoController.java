package com.b355.controller;

import com.b355.model.Credito;
import com.b355.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class CreditoController {

    private CreditoRepository creditoRepository;

    @Autowired
    public CreditoController(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    @RequestMapping(value="/creditos", method= RequestMethod.GET)
    @ResponseBody
    public List<Credito> getAllCreditos() {
        return (List<Credito>) creditoRepository.findAll();
    }

    @RequestMapping(value="/credito/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Optional<Credito> getOneCredito(@PathVariable("id") Long id) {
        return (Optional<Credito>) creditoRepository.findById(id);
    }

    //TODO: adicionar controllers para add de creditos

}
