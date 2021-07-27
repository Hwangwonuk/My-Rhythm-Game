package Rhythm_Game_8;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyRhythmGame extends JFrame {

	private Image screenImage; // 더블 버퍼링 전체화면에 대한 이미지를 담는다.
	private Graphics screenGraphic; // 더블 버퍼링 전체화면에 대한 이미지를 담는다.

	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			Main.class.getResource("..//images//exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("..//images//exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			Main.class.getResource("..//images//startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("..//images//startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(
			Main.class.getResource("..//images//quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("..//images//quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(
			Main.class.getResource("..//images//leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("..//images//leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			Main.class.getResource("..//images//rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("..//images//rightButtonBasic.png"));

	private ImageIcon easyButtonEnteredImage = new ImageIcon(
			Main.class.getResource("..//images//easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("..//images//easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(
			Main.class.getResource("..//images//hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("..//images//hardButtonBasic.png"));
	
	private Image background = new ImageIcon(Main.class.getResource("..//images//introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("..//images//menuBar.png")));
	// menuBar라는 객체안에 해당 이미지(menuBar)가 자리잡게 된다.

	private JButton exitButton = new JButton(exitButtonBasicImage);
	// 기본적으로 JButton이 제공하는 템플릿이 존재한다 -> 사용자가 커스텀 해야한다
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
		
	private int mouseX, mouseY; // 현재 프로그램 안에서 마우스의 x와 y좌표를 말한다

	private boolean isMainScreen = false; // 처음에는 메인화면이 아닌 시작화면이기 때문에 false

	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic; // 선언해준 변수를 사용할수 있도록 함수를 만들어야 한다 즉 코드의 함수활르 통해서 훨씬 간결하게 코드가 만들어진다.
	private int nowSelected = 0; // 그곡의 번호를 의미한다 index니까 0부터

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

		Music introMusic = new Music("introMusic.mp3", true); // 시작화면에서 음악이 직접 종료시키기 전까지 무한정 반복해서 재생이 이루어지도록 해준다.
		introMusic.start(); // 시작하면서 뮤직이 실행된다.

		trackList.add(new Track("Inuyasha Title Image.png", "inuyasha Start Image.png", "Inuyasha Game Image.png",
				"Affection Touching Selected.mp3", "Affection_Touching_Across_Time.mp3"));
		// 총 5개의 매개변수가 들어가는데 배열에 차례대로 들어간다. track 생성자를 확인. 0번째 인덱스가 된다.
		trackList.add(new Track("Inu Title Image.png", "Inu Start Image.png", "Inu Game Image.png",
				"Always with me Selected.mp3", "always_with_me_ocarina_ver.mp3"));
		trackList.add(new Track("Howls Title Image.png", "Howls Start Image.png", "Howls Game Image.png",
				"Howls Moving Selected.mp3", "Howls_Moving_Castle.mp3"));
		//add의 순서를 바꾸면 곡의 순서가 바뀐다.

		exitButton.setBounds(1250, 0, 30, 30); // 메뉴바의 가장 오른쪽 부분에 위치하게된다.
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
				System.exit(0); // 1초 딜레이 후 프로그램 종료
			}
		});
		add(exitButton);

		startButton.setBounds(40, 200, 400, 100); // 메뉴바의 가장 오른쪽 부분에 위치하게된다.
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage); // 마우스가 올라갔을 때 entered로 바꿔준다
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 손가락 모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage); // 마우스가 빠져나왔을 때 이미지
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 원래 상태로 돌아온다
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 클리하면 종료
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
				introMusic.close(); // start버튼을 누르면 intromusic이 멈춤
				// 게임 시작 이벤트
				selectTrack(0);
				startButton.setVisible(false); // start버튼 안보이게
				quitButton.setVisible(false); // quit버튼 안보이게
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				easyButton.setVisible(true);
				hardButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("..//images//mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);

		quitButton.setBounds(40, 330, 400, 100); // 메뉴바의 가장 오른쪽 부분에 위치하게된다.
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage); // 마우스가 올라갔을 때 entered로 바꿔준다
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 손가락 모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage); // 마우스가 빠져나왔을 때 이미지
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 원래 상태로 돌아온다
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
				System.exit(0); // 1초 딜레이 후 프로그램 종료
			}
		});
		add(quitButton);

		leftButton.setVisible(false); // 맨 처음엔 보이지 않다가 시작하기 버튼을 누르고 메인화면가면 메인 스크린에 나온다.
		leftButton.setBounds(140, 310, 60, 60); // 메뉴바의 가장 오른쪽 부분에 위치하게된다.
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage); // 마우스가 올라갔을 때 entered로 바꿔준다
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 손가락 모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage); // 마우스가 빠져나왔을 때 이미지
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 원래 상태로 돌아온다
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 클리하면 종료
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
				// 왼쪽 버튼 이벤트
				selectLeft();
			}
		});
		add(leftButton);

		rightButton.setVisible(false); // 맨 처음엔 보이지 않다가 시작하기 버튼을 누르고 메인화면가면 메인 스크린에 나온다.
		rightButton.setBounds(1080, 310, 60, 60); // 메뉴바의 가장 오른쪽 부분에 위치하게된다.
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage); // 마우스가 올라갔을 때 entered로 바꿔준다
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 손가락 모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage); // 마우스가 빠져나왔을 때 이미지
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 원래 상태로 돌아온다
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 클리하면 종료
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
				// 오른쪽 버튼 이벤트
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false); // 맨 처음엔 보이지 않다가 시작하기 버튼을 누르고 메인화면가면 메인 스크린에 나온다.
		easyButton.setBounds(375, 580, 250, 67); // 메뉴바의 가장 오른쪽 부분에 위치하게된다.
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage); // 마우스가 올라갔을 때 entered로 바꿔준다
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 손가락 모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage); // 마우스가 빠져나왔을 때 이미지
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 원래 상태로 돌아온다
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 클리하면 종료
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
				// 난이도 쉬움 이벤트
				gameStart(nowSelected, "easy"); // 쉬움난이도를 알려줌
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false); // 맨 처음엔 보이지 않다가 시작하기 버튼을 누르고 메인화면가면 메인 스크린에 나온다.
		hardButton.setBounds(655, 580, 250, 67); // 메뉴바의 가장 오른쪽 부분에 위치하게된다.
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage); // 마우스가 올라갔을 때 entered로 바꿔준다
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 손가락 모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage); // 마우스가 빠져나왔을 때 이미지
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 원래 상태로 돌아온다
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 클리하면 종료
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); // 한번만 음악실행
				buttonEnteredMusic.start();
				// 난이도 어려움 이벤트
				gameStart(nowSelected, "hard"); // 어려움 난이도를 알려준다
			}
		});
		add(hardButton);

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
	}

	public void paint(Graphics g) { // paint는 하나의 약속된 메소드 JFrame을 상속받은 GUI 게임에서 가장 첫번째로 화면을 그리는 함수
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1280 * 720만큼의 이미지를 만든뒤에 그것을 screenImage에
																			// 넣는다.
		screenGraphic = screenImage.getGraphics(); // screenImage를 이용해서 Graphics 객체를 얻어온다.
		screenDraw(screenGraphic); // screenDraw를 이용해서 screenGraphic에 그림을 그려준다. 아직 만들지 않음
		g.drawImage(screenImage, 0, 0, null); // screenImage를 0, 0의 위치에 그린다.

	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // background를 스크린 이미지에 그려준다 0, 0 위치에
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null); // g.drawImage 단순히 이미지를 그려주는것
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g); // 이미지를 단순하게 해당 스크린 이미지라는 변수안에 그려주는것 이외에 따로 menuBar를 JFrame안에 그려준다
							// 항상 존재하는 이미지이고 역동적으로 움직이는게 아니고 고정적인 버튼이나, 메뉴바는 paintComponents를 사용한다
							// 메인프레임에 추가된 부분을 보여준다, 위의 add가 된 부분
		this.repaint(); // 다시 paint 메소드를 불러온다. 즉, 매 순간마다 반복하며 그려줌
	}

	public void selectTrack(int nowSelected) {
		if(selectedMusic != null) 
			selectedMusic.close();  // 어떤 곡이 실행되고 있다면 바로 종료시킨다.
		titleImage = new ImageIcon(Main.class.getResource("..//images//" + trackList.get(nowSelected).getTitleImage())).getImage(); // 현재 선택된 곡의 타이틀 이미지 값을 가져와서 넣는다
		selectedImage = new ImageIcon(Main.class.getResource("..//images//" + trackList.get(nowSelected).getStartImage())).getImage(); // 현재 선택된 이미지를 곡 이미지로 바꿔주고 제목 이미지또한 선택된 것으로 변경
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true); // track list에서 nowselected를 가져와서 음악도 가져온다 true값으로 무한재생
		selectedMusic.start(); // 실행
	}
	
	public void selectLeft() {
		if (nowSelected == 0) // 0번째 곡일때
			nowSelected = trackList.size() - 1; // 왼쪽으로 누르면 가장 오른쪽의 곡이 선택되어야 하기 때문에
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1) // 마지막 곡일때 첫번째 곡으로 이동
			nowSelected = 0;
		else
			nowSelected++; // 오른쪽으로 한칸 이동
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("..//images//" + trackList.get(nowSelected).getGameImage())).getImage();
	}
}
