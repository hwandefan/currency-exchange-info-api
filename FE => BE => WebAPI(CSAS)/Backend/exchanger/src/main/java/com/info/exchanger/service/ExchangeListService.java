package com.info.exchanger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.info.exchanger.model.ExchangeList;
import com.info.exchanger.repository.ExchangeListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Component
public class ExchangeListService {

    @Autowired
    private ExchangeListRepository exchangeListRepository; //Connects Repository for CRUD manipulations

    //This function get All INFO from DB
    public List<ExchangeList> getAllExchangesInfo(boolean userdb){
        if(userdb){
            //Gets all data from DB
            List<ExchangeList> db = this.exchangeListRepository.findAll();
            //Checking if DB is empty or not and calls updateDB() if empty
            if(db.size()>0){
                return db;
            } else {
                return updateDB();
            }
        } else {
            return updateDB();
        }
    }

    //This function Updates DB INFO with DATA from Ceska Sporitelna Server and returns it
    private List<ExchangeList> updateDB() {
        //Get Data from Ceska Sporitelna Server
        List<ExchangeList> exchangeLists = getDataFromServer();
        if(exchangeLists != null){
            this.exchangeListRepository.deleteAll();
            this.exchangeListRepository.saveAll(exchangeLists);
            return this.exchangeListRepository.findAll();
        } else {
            return null;
        }
    }

    //This function Get Data from Server
    private List<ExchangeList> getDataFromServer(){
        List<ExchangeList> exchangeList = null;
        //Tries to GET data from Server
        try{
            URL url = new URL("https://www.csast.csas.cz/webapi/api/v2/rates/exchangerates?web-api-key=86d63706-3a9c-4762-bd7a-415651cc26f8");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            //Close connections
            in.close();
            con.disconnect();

            //Parse Data
            ObjectMapper mapper = new ObjectMapper();
            exchangeList = Arrays.asList(mapper.readValue(content.toString(), ExchangeList[].class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exchangeList;
    }
}

