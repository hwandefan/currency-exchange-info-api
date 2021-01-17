package com.info.exchanger.controller;

import com.info.exchanger.model.ExchangeList;
import com.info.exchanger.service.ExchangeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExchangeListController {

    @Autowired
    private ExchangeListService exchangeListService; //Service for Exchange Controller

    @CrossOrigin //Enabling Cross Origins Access for localhsot connections (Not required for public server)
    @GetMapping("/getList")
    public List<ExchangeList> getAllExchangesInfo(@RequestParam(name = "userdb") boolean userdb){
        //Call Main logic function from Exchange List Serivce
        return this.exchangeListService.getAllExchangesInfo(userdb);
    }
}
