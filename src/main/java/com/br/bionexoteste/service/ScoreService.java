package com.br.bionexoteste.service;

import java.util.Optional;

import com.br.bionexoteste.model.Score;

public interface ScoreService {
	public void save(Score score);
	
	public Optional<Score> get(int id);
}
