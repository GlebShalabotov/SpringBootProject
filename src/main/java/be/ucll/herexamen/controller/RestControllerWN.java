package be.ucll.herexamen.controller;

import be.ucll.herexamen.model.MyService;
import be.ucll.herexamen.model.Werkgever;
import be.ucll.herexamen.model.Werknemer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
public class RestControllerWN {

    @Autowired
    public MyService wnService;

    @GetMapping("/werknemer")
    public List<Werknemer> getAllWerknemers(){
        return wnService.findAllWerknemers();
    }

    @PostMapping("/werknemer/add")
    public List<Werknemer> addNewWerknemer(@RequestBody @Valid Werknemer werknemer){
        wnService.addWerknemer(werknemer);
        return wnService.findAllWerknemers();
    }

    @PatchMapping("/werknemer/change/{id}")
    public List<Werknemer> changeWerkgever(@RequestBody @Valid Werknemer werknemer, @PathVariable int id) throws ParseException {
        wnService.updateWerknemer(werknemer);
        return wnService.findAllWerknemers();
    }

    @DeleteMapping ("/werknemer/delete/{id}")
    public void deleteWerknemer(@PathVariable int id){
        wnService.deleteWerknemerById(id);
    }
}
