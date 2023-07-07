package com.gura.spsp.gs25.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spsp.gs25.dto.Gs25Dto;

@Repository
public class Gs25DaoImpl implements Gs25Dao {

	@Autowired
	private SqlSession session;

	@Override
	public void save(Gs25Dto dto) {
		session.insert("gs25.insert", dto);
	}

	@Override
	public List<Gs25Dto> getList(Gs25Dto dto) {

		return session.selectList("gs25.getList", dto);
	}

	@Override
	public int getCount(Gs25Dto dto) {
		return session.selectOne("gs25.getCount", dto);
	}

}
