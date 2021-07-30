package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> getAllActors(Long maxHeight, Long minHeight);

    List<Actor> findActorsById(long id);

    void saveActor(Actor actor);

    void saveAllActors(List<Actor> actors);

    List<Actor> findAllMaleActors(String male);

    Actor updateActorByChildren(long id, long children);

    void deleteById(long id);
}
