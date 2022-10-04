package ru.kalugina.lab1_0.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kalugina.lab1_0.model.Request;
import ru.kalugina.lab1_0.model.Response;
import ru.kalugina.lab1_0.service.ForwardMessage;
import ru.kalugina.lab1_0.service.MyLogger;
import ru.kalugina.lab1_0.service.MyService;

@RestController
public class MyController {
    private final MyService myService;
    private final ForwardMessage forwardMessage;

    private final Logger log = LoggerFactory.getLogger(MyController.class);

    private final MyLogger myLogger;



    @Autowired
    public MyController(@Qualifier("ModifyUid") MyService myService, ForwardMessage forwardMessage, MyLogger myLogger){

        this.myService=myService;

        this.forwardMessage = forwardMessage;
        this.myLogger = myLogger;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request){
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        Response aferModify = myService.execute(response);
        Response sender = forwardMessage.send(aferModify);
        myLogger.createLog(log);


         return new ResponseEntity<>(sender, HttpStatus.OK);
    }
}
