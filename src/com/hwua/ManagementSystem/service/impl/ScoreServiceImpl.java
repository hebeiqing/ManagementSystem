package com.hwua.ManagementSystem.service.impl;

import java.util.List;

import com.hwua.ManagementSystem.dao.Scoredao;
import com.hwua.ManagementSystem.dao.impl.ScoreDaoImpl;
import com.hwua.ManagementSystem.entity.Score;
import com.hwua.ManagementSystem.service.ScoreService;

public class ScoreServiceImpl implements ScoreService {

	 private Scoredao scoredao;
	 
	 public ScoreServiceImpl() {
		 scoredao=new ScoreDaoImpl();
	}
	
	@Override
	public int create(Score score) {
		
		return scoredao.create(score);
	}

	@Override
	public int update(Score score) {
		// TODO Auto-generated method stub
		return scoredao.update(score);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return scoredao.delete(id);
	}

	@Override
	public  Score findById(String id) {
		// TODO Auto-generated method stub
		return scoredao.findById(id);
	}

	@Override
	public List<Score> findAll() {
		// TODO Auto-generated method stub
		return scoredao.findAll();
	}

	@Override
	public Score findByScorename(String scorename) {
		// TODO Auto-generated method stub
		return scoredao.findByScorename(scorename);
	}

	@Override
	public List<Score> findByidscore(String id) {
		// TODO Auto-generated method stub
		return scoredao.findByidscore(id);
	}

}
