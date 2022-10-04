package ru.kalugina.lab1_0.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.kalugina.lab1_0.model.Response;
@Service
public class MessageSender implements ForwardMessage{
    @Override
    public Response send(Response response) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/feedback/";
        restTemplate.postForLocation(url,response);
        return response;
    }
}
