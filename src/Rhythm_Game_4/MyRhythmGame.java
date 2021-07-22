package Rhythm_Game_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyRhythmGame extends JFrame {

	private Image screenImage; // 더블 버퍼링 전체화면에 대한 이미지를 담는다.
	private Graphics screenGraphic; // 더블 버퍼링 전체화면에 대한 이미지를 담는다.
		
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("..//images//exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("..//images//exitButtonBasic.png"));
	
	private Image introBackground = new ImageIcon(Main.class.getResource("..//images//introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("..//images//menuBar.png")));
	// menuBar라는 객체안에 해당 이미지(menuBar)가 자리잡게 된다.
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	// 기본적으로 JButton이 제공하는 템플릿이 존재한다 -> 사용자가 커스텀 해야한다
	private int mouseX, mouseY; // 현재 프로그램 안에서 마우스의 x와 y좌표를 말한다
	
	public MyRhythmGame() {
		setUndecorated(true); // 기본적으로 존재하는 메뉴바가 보이지않게 된다.
		setTitle("Dynamic Beat"); // 제목을 Dynamic Beat로
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 창의 크기를 Main의 상수로 설정, static한 변수 or 상수는
		setResizable(false); // 한번 만들어진 창은 사이즈 조절이 불가능하다.
		setLocationRelativeTo(null); // 만든 창이 화면의 정중앙에 위치하게 됨.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 종료시 프로그램 종료
		setVisible(true); // 만든 창이 정상적으로 화면에 출력되게 한다. 기본값은 false
		setBackground(new Color(0, 0, 0, 0)); // paintComponents를 했을때 배경이 흰색으로 바뀐다.
		setLayout(null); // 버튼이나 JLabel을 넣으면 그 위치에 출력된다.
		
		exitButton.setBounds(1245, 0, 30, 30); // 메뉴바의 가장 오른쪽 부분에 위치하게된다.
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage); // 마우스가 올라갔을 때 entered로 바꿔준다
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 손가락 모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage); // 마우스가 빠져나왔을 때 이미지
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 원래 상태로 돌아온다
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 클리하면 종료
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //1초 딜레이 후 프로그램 종료				
			}
		});
		add(exitButton);
		
		menuBar.setBounds(0, 0, 1280, 30); // 위치와 크기를 정해준다
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { // 마우스로 해당 버튼을 눌렀을때 이벤트처리
				mouseX = e.getX();
				mouseY = e.getY(); // 이벤트가 발생했을 때 그 X,Y좌표를 얻어온다
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) { // 드래그 이벤트가 발생했을 때
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // 누가 드래그 했을 때 자동으로 이벤트를 처리해줌
													 // 메뉴바를 드래그하여 창을 이동시킬 수 있다.
			}
		});
		add(menuBar); // Jframe에 menubar가 추가된다

		Music introMusic = new Music("introMusic.mp3", true); // 시작화면에서 음악이 직접 종료시키기 전까지 무한정 반복해서 재생이 이루어지도록 해준다.
		introMusic.start(); // 시작하면서 뮤직이 실행된다.

	}

	public void paint(Graphics g) { // paint는 하나의 약속된 메소드 JFrame을 상속받은 GUI 게임에서 가장 첫번째로 화면을 그리는 함수
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1280 * 720만큼의 이미지를 만든뒤에 그것을 screenImage에
																			// 넣는다.
		screenGraphic = screenImage.getGraphics(); // screenImage를 이용해서 Graphics 객체를 얻어온다.
		screenDraw(screenGraphic); // screenDraw를 이용해서 screenGraphic에 그림을 그려준다. 아직 만들지 않음
		g.drawImage(screenImage, 0, 0, null); // screenImage를 0, 0의 위치에 그린다.

	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // introBackground를 스크린 이미지에 그려준다 0, 0 위치에
		paintComponents(g); // 이미지를 단순하게 해당 스크린 이미지라는 변수안에 그려주는것 이외에 따로 menuBar를 JFrame안에 그려준다
							// 항상 존재하는 이미지이고 역동적으로 움직이는게 아니고 고정적인 버튼이나, 메뉴바는 paintComponents를 사용한다
		this.repaint(); // 다시 paint 메소드를 불러온다. 즉, 매 순간마다 반복하며 그려줌
	}
}
