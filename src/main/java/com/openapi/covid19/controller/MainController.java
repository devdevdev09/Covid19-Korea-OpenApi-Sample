package com.openapi.covid19.controller;

import com.openapi.covid19.service.MainService;
import com.openapi.covid19.vo.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    MainService mainService;

    public MainController(MainService mainService){
        this.mainService = mainService;
    }
    
    @GetMapping("/covid19")
    public void getCovid19(){
        ResponseEntity<String> responseEntity = mainService.getAPi();
        Response response = mainService.parser(responseEntity.getBody());

        System.out.println(response);
    }
}
