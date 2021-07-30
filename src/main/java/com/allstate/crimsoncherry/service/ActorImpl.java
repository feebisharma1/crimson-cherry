package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = {NullPointerException.class})
public class ActorImpl implements ActorService{

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActors(Long maxHeight, Long minHeight) {
        List<Actor> actors = actorRepository.findAll();
        List<Actor> filteredByHeight = new ArrayList<>();
        for(Actor actor: actors){
            if(isMaxAndMinHeightPresent(maxHeight, minHeight) && isHeightLessThanMaxHeight(actor, maxHeight) && isHeightGreaterThanMinHeight(actor, minHeight)){
                filteredByHeight.add(actor);
            } else if(maxHeight != null && minHeight == null && isHeightLessThanMaxHeight(actor, maxHeight)) {
                filteredByHeight.add(actor);
            } else if (minHeight != null && maxHeight == null && isHeightGreaterThanMinHeight(actor, minHeight)){
                filteredByHeight.add(actor);
            }
        }
        return filteredByHeight.size() != 0 ? filteredByHeight : actors;
    }

    public boolean isMaxAndMinHeightPresent(Long maxHeight, Long minHeight){
        return maxHeight != null && minHeight != null;
    }

    public boolean isHeightLessThanMaxHeight(Actor actor, Long maxHeight){
        return  actor.getHeight() < maxHeight;
    }

    public boolean isHeightGreaterThanMinHeight(Actor actor, Long minHeight){
        return  actor.getHeight() > minHeight;
    }

    @Override
    public List<Actor> findActorsById(long id) {
        List<Actor> actors = actorRepository.findAllById(id);
        return actors;
    }

    @Override
    public void saveActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void saveAllActors(List<Actor> actors) {
         actorRepository.saveAll(actors);
    }

    @Override
    public List<Actor> findAllMaleActors(String male) {
        return actorRepository.findAllBySex(male);
    }

    @Override
    public Actor updateActorByChildren(long id, long children) {
        Actor actor = actorRepository.getById(id);
        actor.setChildren(children);
        actor = actorRepository.save(actor);
        return actor;
    }

    @Override
    public void deleteById(long id) {
        actorRepository.deleteById(id);
    }

}
