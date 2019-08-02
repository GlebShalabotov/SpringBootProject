package be.ucll.herexamen.controller;

import be.ucll.herexamen.model.MyService;
import be.ucll.herexamen.model.Werkgever;
import be.ucll.herexamen.model.Werknemer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RestControllerWG {

    @Autowired
    public MyService wgService;

    @GetMapping("/werkgever")
    public List<Werkgever> getWerkgevers(){
        return wgService.findAllWerkgevers();
    }

    @PostMapping("/werkgever/add")
    public Werkgever addNewWerkgever(@RequestBody @Valid Werkgever werkgever){
        wgService.addWerkgever(werkgever);
        return wgService.findWerkgeverByEmail(werkgever.getEmail());
    }

    @PatchMapping("/werkgever/change/{id}")
    public List<Werkgever> changeWerkgever(@RequestBody @Valid Werkgever werkgever, @PathVariable int id){
        wgService.updateWerkgever(werkgever);
        return wgService.findAllWerkgevers();
    }

    @DeleteMapping("/werkgever/delete/{id}")
    public void deleteWerkgever(@PathVariable int id){
        wgService.deleteWerkgeverById(id);
    }

}
