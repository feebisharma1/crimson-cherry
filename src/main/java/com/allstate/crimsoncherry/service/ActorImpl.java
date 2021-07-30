package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = {NullPointerException.class})
public class ActorImpl implements ActorService{

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public List<Actor> findAllActorsById(long id) {
        return actorRepository.findAllById(id);
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


}
