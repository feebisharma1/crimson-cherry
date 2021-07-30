package com.allstate.crimsoncherry.repository;

import com.allstate.crimsoncherry.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    public List<Actor> findAllById(long id);
    public List<Actor> findAllBySex(String sex);
}
