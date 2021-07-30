package com.allstate.crimsoncherry.control;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.service.ActorService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
/*
*  Rest APis
*
* */
    @Autowired
    private ActorService actorService;

    @GetMapping("/all")
    public List<Actor> getAllActors( @RequestParam(required = false) Long maxHeight, @RequestParam(required = false) Long minHeight){
        System.out.println("maxHeight" + maxHeight + " " + minHeight);
        return actorService.getAllActors(maxHeight, minHeight);
    }

    @GetMapping("/{id}")
    public List<Actor> getActorsById(@PathVariable long id){
        return actorService.findActorsById(id);
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

    @PutMapping("/update")
    public Actor updateActorByChildren(@RequestParam long id, long children){
        return actorService.updateActorByChildren(id, children);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
         actorService.deleteById(id);
    }

}
