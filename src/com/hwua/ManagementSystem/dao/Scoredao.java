package com.hwua.ManagementSystem.dao;

import java.util.List;

import com.hwua.ManagementSystem.entity.Score;

public interface Scoredao {
	int create(Score score);
	int update(Score score);
	int delete(String id);
	Score findById(String id);
	List<Score> findAll();
	Score findByScorename(String scorename);
	
	List<Score> findByidscore(String id);
}
