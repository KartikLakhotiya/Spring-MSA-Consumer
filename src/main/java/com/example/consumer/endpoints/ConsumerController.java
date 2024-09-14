package com.example.consumer.endpoints;

import com.example.consumer.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ConsumerController {
    private RestTemplate restTemplate;

    @Autowired
    ConsumerController(RestTemplate template){
        restTemplate = template;
    }

    @GetMapping(path = "/demo/consumer")
    EmployeeDTO getData(@RequestParam String name, @RequestParam int ID){
        String apiUrl = "http://DEMO/demo/data";
        String urlWithParams = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("name",name)
                .queryParam("ID",ID)
                .toUriString();

        return restTemplate.getForObject(urlWithParams, EmployeeDTO.class);
    }

    @PostMapping(path = "/demo/data",produces = MediaType.APPLICATION_JSON_VALUE)
    String postData(@RequestBody EmployeeDTO employee){
        String apiUrl = "http://DEMO/demo/data";
        HttpEntity<EmployeeDTO> requestEntity = new HttpEntity<>(employee);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }

}
