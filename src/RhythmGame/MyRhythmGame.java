package RhythmGame;

import javax.swing.JFrame;

public class MyRhythmGame extends JFrame {

	public MyRhythmGame() {
		setTitle("Dynamic Beat"); // 제목을 Dynamic Beat로
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 창의 크기를 Main의 상수로 설정, static한 변수 or 상수는 
		setResizable(false); // 한번 만들어진 창은 사이즈 조절이 불가능하다.
		setLocationRelativeTo(null); // 만든 창이 화면의 정중앙에 위치하게 됨.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 종료시 프로그램 종료
		setVisible(true); // 만든 창이 정상적으로 화면에 출력되게 한다. 기본값은 false
		
	}
}
