package com.gura.spring02.guest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.guest.dao.GuestDao;
import com.gura.spring02.guest.dto.GuestDto;

@Service
public class GuestServiceImpl implements GuestService {
	// Service 는 비즈니스 로직을 처리하기위해 Dao에 의존한다

	// 지금은 GuestDao 하나만 쓰지만 혹시 dao 여러개 쓸경우 변수 dao의 이름을 각각 다르게 해서 사용
	@Autowired
	private GuestDao dao;

	@Override
	public void addGuest(GuestDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateGuest(GuestDto dto) {
		dao.update(dto);
	}

	@Override
	public void deleteGuest(GuestDto dto) {
		dao.delete(dto);
	}

	@Override
	public void getGuestInfo(ModelAndView mView, int num) {
		GuestDto dto = dao.getData(num);

		mView.addObject("dto", dto);

	}

	@Override
	public void getGuestList(ModelAndView mView) {
		List<GuestDto> list = dao.getList();
		mView.addObject("list", list);

	}

}
