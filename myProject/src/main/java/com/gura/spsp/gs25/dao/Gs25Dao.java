package com.gura.spsp.gs25.dao;

import java.util.List;

import com.gura.spsp.gs25.dto.Gs25Dto;

public interface Gs25Dao {

	public void save(Gs25Dto dto);

	public List<Gs25Dto> getList(Gs25Dto dto);

	public int getCount(Gs25Dto dto);

}
