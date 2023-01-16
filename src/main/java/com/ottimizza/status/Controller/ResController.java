package com.ottimizza.status.Controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.ottimizza.status.Model.Body;
import com.ottimizza.status.StatusApplication;
import com.ottimizza.status.Services.ReqServices;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/status")
public class ResController {
  
  @Autowired
  ReqServices services;
  
  @RequestMapping(method = RequestMethod.POST)
  public String saveInfo(@RequestBody Body rotaAtiva) {
    return services.addToList(rotaAtiva);

  }

  @CrossOrigin
  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public String listInfo() {
    HashMap<String, JSONArray> retornoMap = services.serverParser(StatusApplication.rotaInfoLog);
    
    return new JSONObject(retornoMap).toString();
  }
}
