package com.allstate.crimsoncherry.control;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.service.ActorService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/actor")
@CrossOrigin
public class ActorController {
/*
*  Rest APis
*
* */

    @Autowired
    private ActorService actorService;

    //Retrieve ALl Actors and heights are optional
    @GetMapping("/all")
    public List<Actor> getAllActors( @RequestParam(required = false) Long maxHeight, @RequestParam(required = false) Long minHeight){
        System.out.println("maxHeight" + maxHeight + " " + minHeight);
        return actorService.getAllActors(maxHeight, minHeight);
    }

    //Retrieve Actors by ID provided
    @GetMapping("/{id}")
    public List<Actor> getActorsById(@PathVariable long id){
        return actorService.findActorsById(id);
    }

    //Retrieve all Actors according to their sex
    @GetMapping()
    public List<Actor> getActorsBySex(@RequestParam String sex){
        return actorService.findAllMaleActors(sex);
    }

    //Add a new Actor
    @PostMapping("/save")
    public void saveActor(@RequestBody Actor actor){
        actorService.saveActor(actor);
    }

    //Add Actors
    @PostMapping("/saveAll")
    public void saveAllActor(@RequestBody List<Actor> actors ){
        actorService.saveAllActors(actors);
    }

    //Update the children by providing id on Actor
    @PutMapping("/update")
    public Actor updateActorByChildren(@RequestParam long id, long children){
        return actorService.updateActorByChildren(id, children);
    }

    //Delete specific Actor
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
         actorService.deleteById(id);
    }

}
