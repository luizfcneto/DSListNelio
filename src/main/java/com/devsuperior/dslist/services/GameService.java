package com.devsuperior.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> listGames(){
		List<Game> games = gameRepository.findAll();
		return games.stream().map((game) -> new GameMinDTO(game)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDTO getGameById(Long id) {
		Optional<Game> game = gameRepository.findById(id);
		return new GameDTO(game.get());
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> listGamesByList(Long listId){
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map((game) -> new GameMinDTO(game)).toList();
	}
	
}
