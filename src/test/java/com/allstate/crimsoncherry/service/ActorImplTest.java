package com.allstate.crimsoncherry.service;

import com.allstate.crimsoncherry.entity.Actor;
import com.allstate.crimsoncherry.repository.ActorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActorImplTest {

    @Mock
    ActorRepository actorRepository;

    @InjectMocks
    ActorImpl actorImpl;

    @Test
    void getAllActors_test() {
        Mockito.when(actorRepository.findAll()).thenReturn(getActors());

        List<Actor> result = actorImpl.getAllActors(null, null);

        assertEquals(2, result.size());
        assertEquals("test1", result.get(0).getName());
        assertEquals("test2", result.get(1).getName());
    }

    @Test
    void getAllActorsMaxHeight_test() {
        Mockito.when(actorRepository.findAll()).thenReturn(getActors());

        List<Actor> result = actorImpl.getAllActors(6L, null);

        assertEquals(5L, result.get(0).getHeight());
    }

    @Test
    void getAllActorsMinHeight_test() {
        Mockito.when(actorRepository.findAll()).thenReturn(getActors());

        List<Actor> result = actorImpl.getAllActors(null, 6L);

        assertEquals(7L, result.get(0).getHeight());
    }

    @Test
    void findActorsById_test() {
        Mockito.when(actorRepository.findAllById(Mockito.anyLong())).thenReturn(getActors());

        List<Actor> result = actorImpl.findActorsById(1);

        assertEquals(2, result.size());
        assertEquals("test1", result.get(0).getName());
        assertEquals("test2", result.get(1).getName());
    }

    @Test
    void saveActor() {
    }

    @Test
    void saveAllActors() {
    }

    @Test
    void findAllMaleActors() {
    }

    @Test
    void updateActorByChildren() {
    }

    @Test
    void deleteById() {
    }

    List<Actor> getActors(){
        List<Actor> actors = new ArrayList<>();
        Actor actor1 = new Actor();
        actor1.setName("test1");
        actor1.setHeight(5L);
        Actor actor2 = new Actor();
        actor2.setName("test2");
        actor2.setHeight(7L);
        actors.add(actor1);
        actors.add(actor2);
        return actors;
    }
}