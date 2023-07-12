package com.example.boot07.users.dao;

import com.example.boot07.users.dto.UsersDto;

public interface UsersDao {
	// 인자로 전달된 아이디가 존재하는지 여부
	public boolean isExist(String inputId);

	public void insert(UsersDto dto);

	public UsersDto getData(String id);

	public void updatePwd(UsersDto dto);

	public void update(UsersDto dto);

	public void delete(String id);

}
