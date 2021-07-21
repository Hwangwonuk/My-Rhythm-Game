package Rhythm_Game_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyRhythmGame extends JFrame {
	
	private Image screenImage; // 더블 버퍼링 전체화면에 대한 이미지를 담는다.
	private Graphics screenGraphic; // 더블 버퍼링 전체화면에 대한 이미지를 담는다.
	
	private Image introBackground; // introBackground라는 이미지를 담을 하나의 객체

	public MyRhythmGame() {
		setTitle("Dynamic Beat"); // 제목을 Dynamic Beat로
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 창의 크기를 Main의 상수로 설정, static한 변수 or 상수는 
		setResizable(false); // 한번 만들어진 창은 사이즈 조절이 불가능하다.
		setLocationRelativeTo(null); // 만든 창이 화면의 정중앙에 위치하게 됨.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 종료시 프로그램 종료
		setVisible(true); // 만든 창이 정상적으로 화면에 출력되게 한다. 기본값은 false
		
		introBackground = new ImageIcon(Main.class.getResource("..//images//introBackground.jpg")).getImage();
		//Main class의 위치를 기반으로 해서 resource 이미지파일을 얻어온 뒤에 이미지 인스턴스를 introBackground라는 이미지 변수에 초기화해준다.
		Music introMusic = new Music("introMusic.mp3", true); // 시작화면에서 음악이 직접 종료시키기 전까지 무한정 반복해서 재생이 이루어지도록 해준다.
		introMusic.start(); // 시작하면서 뮤직이 실행된다.
		
	}
	
	public void paint(Graphics g) { // paint는 하나의 약속된 메소드 JFrame을 상속받은 GUI 게임에서 가장 첫번째로 화면을 그리는 함수
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1280 * 720만큼의 이미지를 만든뒤에 그것을 screenImage에 넣는다. 
		screenGraphic = screenImage.getGraphics(); // screenImage를 이용해서 Graphics 객체를 얻어온다.
		screenDraw(screenGraphic); // screenDraw를 이용해서 screenGraphic에 그림을 그려준다. 아직 만들지 않음
		g.drawImage(screenImage, 0, 0, null); // screenImage를 0, 0의 위치에 그린다.
		
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // introBackground를 스크린 이미지에 그려준다 0, 0 위치에
		this.repaint(); // 다시 paint 메소드를 불러온다. 즉, 매 순간마다 반복하며 그려줌
	}
}
