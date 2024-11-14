package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> getAllLists(){
		List<GameList> listEntities = gameListRepository.findAll();
		return listEntities.stream().map((list) -> new GameListDTO(list)).toList();
	
	}

	
	@Transactional
	public List<GameMinDTO> updatePosition(Long listId, int sourceIndex, int destinationIndex){
		List<GameMinProjection> listProjection = gameRepository.searchByList(listId);
		
		GameMinProjection gameMoved = listProjection.remove(sourceIndex);
		listProjection.add(destinationIndex, gameMoved);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int newIndex = min; newIndex <= max; newIndex++) {
			gameListRepository.updateBelongingPosition(listId, listProjection.get(newIndex).getId(), newIndex);
		}
		
		return gameRepository.searchByList(listId).stream().map((game) -> new GameMinDTO(game)).toList();
	}
	
	
}
