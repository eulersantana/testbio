package com.onlinetutorialspoint.service;

import java.util.Optional;

import com.onlinetutorialspoint.model.Score;

public interface ScoreService {
	public void save(Score score);
	
	public Optional<Score> get(int id);
}
