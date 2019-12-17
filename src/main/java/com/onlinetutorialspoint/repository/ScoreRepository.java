package com.onlinetutorialspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
