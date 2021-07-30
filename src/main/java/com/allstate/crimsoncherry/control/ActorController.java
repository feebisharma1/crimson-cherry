package com.allstate.crimsoncherry.control;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
/*
* GET/api/actor
* GET/api/actor/id
* GET/api/actor?movies={""}
*
* */
    @Autowired
    private ActorService actorService;

    @GetMapping("/all")
    public List<Actor> getAllActors(){
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public List<Actor> getAllActorsById(@PathVariable long id){
        return actorService.findAllActorsById(id);
    }

    @GetMapping()
    public List<Actor> getActorsBySex(@RequestParam String sex){
        return actorService.findAllMaleActors(sex);
    }

    @PostMapping("/save")
    public void saveActor(@RequestBody Actor actor){
        actorService.saveActor(actor);
    }

    @PostMapping("/saveAll")
    public void saveAllActor(@RequestBody List<Actor> actors ){
        actorService.saveAllActors(actors);
    }



}
