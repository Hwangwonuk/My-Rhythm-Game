package Rhythm_Game_15;

public class Main {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 3; // 노트 속도
	public static final int SLEEP_TIME = 10; // 얼마간의 주기로 떨어지냐
	public static final int REACH_TIME = 2; // 판정라인에 도달하는 시간
	// 상수는 모두 대문자를 이용하여 만든다.
	public static void main(String[] args) {
		// 자바에서 제공하는 이미지를 화면에 띄우는 방식을 이용하면 버퍼링이 상당히 심하다.
		// 따라서 더블 버퍼링이라는 프로그래밍 기법을 이용할 필요가 있다.
		// 더블 버퍼링이란 현재프로그램의 전체 화면의 크기에 맞는 이미지를 매순간 생성해서
		// 원하는 컴포넌트만 화면에 출력하는 방식이다.
		new MyRhythmGame(); 

	}

}
