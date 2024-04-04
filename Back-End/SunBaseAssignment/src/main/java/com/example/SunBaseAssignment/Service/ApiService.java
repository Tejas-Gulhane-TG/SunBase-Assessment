package com.example.SunBaseAssignment.Service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {

    public String callApi(String apiUrl, String requestBody) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        String responseBody = responseEntity.getBody();

        return responseBody;
    }

    public List<Object> getCustomers(String token, String apiUrl){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);


        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,  // Change this based on your API's HTTP method
                requestEntity,
                Object[].class
        );

        Object[] responseBody = responseEntity.getBody();

        return List.of(responseBody);

    }
}
