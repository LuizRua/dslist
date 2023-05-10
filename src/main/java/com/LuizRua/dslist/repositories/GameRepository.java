package com.LuizRua.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LuizRua.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
