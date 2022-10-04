package ru.kalugina.lab1_0.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kalugina.lab1_0.model.Response;

@Service
@RequiredArgsConstructor
@Qualifier("ModifyErrorMessage")
public class ModifyErrorMessage implements MyService {

    @Override
   public Response execute(Response response) {
        response.setErrorMessage("Все плохо");
       return response;
   }
}
