package com.example.demo.cpfgenerator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class CpfController {

    private CpfTest test;

    @Autowired
    public CpfController(CpfTest test){
        this.test = test;
    }

    @RequestMapping(value = "/cpf/generator", method = RequestMethod.GET)
    public ResponseEntity<String> registerUserProfile(
            HttpServletRequest request) throws Throwable {
        String cpf = test.cpf();
        return  ResponseEntity.ok().body(cpf);
    }
}


