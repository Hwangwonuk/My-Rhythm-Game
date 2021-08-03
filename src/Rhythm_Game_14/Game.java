package Rhythm_Game_14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{	// Thread는 하나의 프로그램 안에서 실행되는 작은 프로그램이라고 할수있다 하나의 게임이 하나의 단위로서 동작해야 하기때문
	
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("..//images//noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("..//images//judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("..//images//gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	
	private String titleName;	// 실행중인 곡 이름
	private String difficulty;	// 난이도
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false); // 한번만 실행되고 말도록 해준다 false값으로
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null); // 노트 루트 이미지
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null); // 노트 루트 구분하는 라인 이미지
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null); // gameInfoIamge
		g.drawImage(judgementLineImage, 0, 580, null); // 판정라인 이미지
		for(int i = 0; i < noteList.size(); i ++) {
			Note note = noteList.get(i); // 리스트에 추가된 각각의 노트를 불러온다
			note.screenDraw(g); // 그려준다
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // 글자가 깨짐없이 매끄럽게 출력됨
		g.setFont(new Font("Arial", Font.BOLD, 30)); // Arial폰트 굵은 글씨체로 크기가 30인 글씨를 그릴수 있도록 세팅
		g.drawString(titleName, 20, 702); // 현재 실행중인 곡이름
		g.drawString(difficulty, 1190, 702); // 현재 실행중인 난이도
		g.setFont(new Font("Arial", Font.BOLD, 26)); // 크기를 26
		g.setColor(Color.DARK_GRAY); // 다크 그레이색상
		g.drawString("S", 270, 609); // 키 이름을 화면에 출력
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30)); // Elephant폰트 사용
		g.drawString("000000", 565, 702); // 점수출력
		
	}
	
	public void pressS() { // S라는 버튼을 눌렀을 때 Pressed이미지
		noteRouteSImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseS() { // S라는 버튼을 누르다가 떼어낼 때 기본 이미지
		noteRouteSImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressD() { 
		noteRouteDImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseD() { 
		noteRouteDImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressF() { 
		noteRouteFImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseF() { 
		noteRouteFImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressSpace() { 
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseSpace() { 
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressJ() { 
		noteRouteJImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseJ() { 
		noteRouteJImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseK() { 
		noteRouteKImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressL() { 
		noteRouteLImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseL() { 
		noteRouteLImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes();
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes() {
		Beat[] beats = null; 
		if(titleName.equals("Affection_Touching_Across_Time")) {
			int startTime = 4460 - Main.REACH_TIME * 1000; // 곡마다 재설정
			int gap = 125;
			beats = new Beat[] { // new 하여 새로운 노트를 만들 수 있다. 구현은 알아서하자
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "S"),
					new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 18, "J"),
					new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "J"),
					new Beat(startTime + gap * 24, "K"),
					new Beat(startTime + gap * 26, "J"),
					new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 38, "D"),
					new Beat(startTime + gap * 40, "S"),
					new Beat(startTime + gap * 42, "D"),
					new Beat(startTime + gap * 44, "S"),
					new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 48, "S"),
					new Beat(startTime + gap * 49, "D"),
					new Beat(startTime + gap * 50, "K"),
					new Beat(startTime + gap * 52, "J"),
					new Beat(startTime + gap * 52, "L"),
					new Beat(startTime + gap * 52, "Space"),
			};
		}
		else if(titleName.equals("always_with_me_ocarina_ver")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Howls_Moving_Castle")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i = 0;
		gameMusic.start(); // 초기화가 이루어지고 음악이 실행되어야 딜레이를 맞출수 있다.
		while(i < beats.length && !isInterrupted()) { // 현재 곡의 재생되는 시점을 실시간으로 파악해서 해당위치에 걸맞는 노트를 떨어뜨린다
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) { // beats에서 떨어지는 Time이 gameMusic의 Time보다 더 작거나 같다면
				Note note = new Note(beats[i].getNoteName()); // 현재의 비트에서 Note네임을 얻어온다
				note.start(); // 노트가 떨어지도록
				noteList.add(note);
				i++;
				dropped = true; // 무한정 반복하면서 떨어뜨리는게 아니라 텀을 두고 떨어뜨릴수 있게 해준다
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
