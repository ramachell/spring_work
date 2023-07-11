package com.example.hello2.util;

public class TvRemocon implements Remocon {

	@Override
	public void up() {
		System.out.println("TV 올림");
	}

	@Override
	public void down() {
		System.out.println("TV 내림");
	}

}
