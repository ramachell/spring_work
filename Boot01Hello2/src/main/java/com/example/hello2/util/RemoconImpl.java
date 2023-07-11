package com.example.hello2.util;

public class RemoconImpl implements Remocon {

	@Override
	public void up() {
		System.out.println("올림");
	}

	@Override
	public void down() {
		System.out.println("내림");
	}

}
