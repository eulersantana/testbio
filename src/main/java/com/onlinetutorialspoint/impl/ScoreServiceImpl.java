package com.onlinetutorialspoint.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.model.Score;
import com.onlinetutorialspoint.repository.ScoreRepository;
import com.onlinetutorialspoint.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	private ScoreRepository scoreRepository;

	@Override
	public void save(Score score) {
		scoreRepository.saveAndFlush(score);
	}

	@Override
	public Optional<Score> get(int id) {
		return scoreRepository.findById(id);
	}
}
