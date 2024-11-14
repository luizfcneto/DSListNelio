package com.devsuperior.dslist.dto;

public class ReplacementDTO {
	
	private int sourceIndex;
	private int destinationIndex;
	
	public ReplacementDTO() {};
	
	public ReplacementDTO(int sourceIndex, int destinationIndex) {
		this.sourceIndex = sourceIndex;
		this.destinationIndex = destinationIndex;
	}

	public int getSourceIndex() {
		return sourceIndex;
	}

	public int getDestinationIndex() {
		return destinationIndex;
	}
		
}
