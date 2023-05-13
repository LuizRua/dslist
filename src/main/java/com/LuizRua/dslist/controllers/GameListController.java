package com.LuizRua.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LuizRua.dslist.dto.GameListDTO;
import com.LuizRua.dslist.dto.GameMinDTO;
import com.LuizRua.dslist.dto.ReplacementDTO;
import com.LuizRua.dslist.services.GameListService;
import com.LuizRua.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameService gameService;

	@Autowired
	private GameListService gameListService;

	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;

	}

	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByGameList(listId);
		return result;

	}

	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}