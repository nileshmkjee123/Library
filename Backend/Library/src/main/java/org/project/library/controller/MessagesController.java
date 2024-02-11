package org.project.library.controller;

import org.project.library.entity.Message;
import org.project.library.requestmodel.AdminQuestionRequest;
import org.project.library.service.MessagesService;
import org.project.library.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessagesController {
    private MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService){
        this.messagesService=messagesService;
    }
    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value = "Authorization")String token,
                            @RequestBody Message messageRequest){
        String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        messagesService.postMessage(messageRequest,userEmail);
    }
    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value = "Authorization")String token,
                           @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception{
        String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        String admin = ExtractJWT.payLoadJWTExtraction(token,"\"userType\"");
        if(admin == null || !admin.equals("admin")){
            throw new Exception("Administration page only");
        }
        messagesService.putMessage(adminQuestionRequest,userEmail);
    }
}
