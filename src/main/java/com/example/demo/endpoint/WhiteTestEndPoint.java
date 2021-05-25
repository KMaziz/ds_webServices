package com.example.demo.endpoint;

import de.tekup.soap.models.whitetest.ExamRequest;
import de.tekup.soap.models.whitetest.ExamResponse;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.demo.service.*;

@Endpoint
public class WhiteTestEndPoint {

    public static final String nameSpace="http://www.tekup.de/soap/models/whitetest";

    @Autowired
    private WhiteTestService WhiteTestservice;

    @Autowired
    private ExamService Examservice;


    @PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
    @ResponsePayload
    public WhiteTestResponse getTestStatus(@RequestPayload StudentRequest customerRequest) {

        WhiteTestResponse whiteTestResponse =WhiteTestservice.checkWhiteTest(customerRequest);
        return whiteTestResponse;
    }

    @PayloadRoot(namespace = nameSpace, localPart = "ExamRequest")
    @ResponsePayload
    public ExamResponse getListDisponible(@RequestPayload ExamRequest examRequest){
        return Examservice.TestExam();
    }
}
