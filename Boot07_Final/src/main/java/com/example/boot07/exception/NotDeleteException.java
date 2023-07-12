package com.example.boot07.exception;

/*
 * 예외 클래스를 만드는법
 * 1. RuntimeException 클래스 상속
 * 2. String type 을 전달받는 생성자 정의후 그 문자열을 부모 생성자에 전달하는 코드작성
 * 이 클래스로 생성된 객체는 getMessage() 메소드 가지고있는데
 * 해당 메소드는 생성자에 전달받았던 예외 메시지를 리턴해줌
 * 
 * ex)
 * NotDeleteException nde = new NotDeleteException("oh! no");
 * String msg = nde.getMessage();
 * 
 * 어딛선가 이 예외를 발생시키고 싶으면 throw 예약어 활용
 * 
 * throw new DeleteException("남의 파일 지우는거 안댐");
 * 
 */
public class NotDeleteException extends RuntimeException {

	public NotDeleteException(String message) {
		super(message);
	}
}
