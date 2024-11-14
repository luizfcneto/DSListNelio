package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public class GameMinDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	private Integer position;
	
	public GameMinDTO() {};
	
	public GameMinDTO(Game gameEntity) {
		this.id = gameEntity.getId();
		this.title = gameEntity.getTitle();
		this.year = gameEntity.getYear();
		this.imgUrl = gameEntity.getImgUrl();
		this.shortDescription = gameEntity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection gameMinProjectionEntity) {
		this.id = gameMinProjectionEntity.getId();
		this.title = gameMinProjectionEntity.getTitle();
		this.year = gameMinProjectionEntity.getGameYear();
		this.imgUrl = gameMinProjectionEntity.getImgUrl();
		this.shortDescription = gameMinProjectionEntity.getShortDescription();
		this.position = gameMinProjectionEntity.getPosition();
	}
	
	public GameMinDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	public Integer getPosition() {
		return position;
	}

}
