package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.service.PlayerService;
import com.spring.playerapi.model.Player;

// http://localhost:8082/spring-crm-rest
@RestController
@RequestMapping("/api")
// http://localhost:8082/spring-crm-rest/api
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/data")
	// http://localhost:8082/spring-crm-rest/api/data
	public String getData() {
		return "my data";
	}

	// http://localhost:8082/spring-crm-rest/api/players
	@GetMapping("/players")
	public List<Player> getPlayers() {
		return playerService.allPlayers();
	}

	// http://localhost:8082/spring-crm-rest/api/player?id=1
	@GetMapping("/player")
	public Player getPlayer(@RequestParam int id) {
		Player player = playerService.showPlayer(id);
		return player;
	}

	// http://localhost:8082/spring-crm-rest/api/player/1
	@GetMapping("/player/{id}")
	public Player getPlayerWithPathVar(@PathVariable("id") int id) {
		Player player = playerService.showPlayer(id);
		return player;
	}

}
