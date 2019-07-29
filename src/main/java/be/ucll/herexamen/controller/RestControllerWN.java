package be.ucll.herexamen.controller;

import be.ucll.herexamen.model.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerWN {

    @Autowired
    public MyService wnService;
}
