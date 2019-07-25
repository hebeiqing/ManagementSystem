package com.hwua.ManagementSystem.service;

import java.util.List;

import com.hwua.ManagementSystem.entity.Score;

public interface ScoreService {
	int create(Score score);
	int update(Score score);
	int delete(String id);
	 Score findById(String id);
	List<Score> findAll();
	Score findByScorename(String scorename);
	List<Score> findByidscore(String id);
}
