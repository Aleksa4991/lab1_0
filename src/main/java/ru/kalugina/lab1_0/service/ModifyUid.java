package ru.kalugina.lab1_0.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kalugina.lab1_0.model.Response;
@Service
@Qualifier("ModifyUid")
public class ModifyUid implements MyService{
    @Override
    public Response execute(Response response) {
        response.setUid("New Uid");
        return response;
    }
}
