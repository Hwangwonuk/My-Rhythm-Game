package Rhythm_Game_15;

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
			if(!note.isProceeded()) { // 현재 노트가 작동하고있는 상태가 아니라면
				noteList.remove(i); // 해당 노트를 지운다
				i--;
			}
			else {
				note.screenDraw(g);
			}
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
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseS() { // S라는 버튼을 누르다가 떼어낼 때 기본 이미지
		noteRouteSImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressD() { 
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseD() { 
		noteRouteDImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressF() { 
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseF() { 
		noteRouteFImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressSpace() { 
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseSpace() { 
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressJ() { 
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseJ() { 
		noteRouteJImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseK() { 
		noteRouteKImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	public void pressL() { 
		judge("K");
		noteRouteLImage = new ImageIcon(Main.class.getResource("..//images//noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseL() { 
		noteRouteLImage = new ImageIcon(Main.class.getResource("..//images//noteRoute.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null; 
		if(titleName.equals("Affection_Touching_Across_Time") && difficulty.equals("Easy")) {
			int startTime = 3000 - Main.REACH_TIME * 1000; // 곡마다 재설정
			int gap = 125;
			beats = new Beat[] { // new 하여 새로운 노트를 만들 수 있다. 구현은 알아서하자
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 1, "D"),
					new Beat(startTime + gap * 2, "S"),
					new Beat(startTime + gap * 3, "D"),
					new Beat(startTime + gap * 5, "S"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 21, "D"),
					
					new Beat(startTime + gap * 44, "J"),
					new Beat(startTime + gap * 45, "K"),
					new Beat(startTime + gap * 46, "J"),
					new Beat(startTime + gap * 47, "K"),
					new Beat(startTime + gap * 48, "J"),
					new Beat(startTime + gap * 62, "K"),
					new Beat(startTime + gap * 70, "J"),
					
					new Beat(startTime + gap * 84, "S"),
					new Beat(startTime + gap * 91, "D"),
					new Beat(startTime + gap * 98, "F"),
					new Beat(startTime + gap * 105, "Space"),
					new Beat(startTime + gap * 112, "J"),
					new Beat(startTime + gap * 119, "K"),
					new Beat(startTime + gap * 126, "L"),
					new Beat(startTime + gap * 133, "K"),
					new Beat(startTime + gap * 152, "J"),
					
					new Beat(startTime + gap * 174, "Space"),
					new Beat(startTime + gap * 177, "J"),
					new Beat(startTime + gap * 177, "F"),
					new Beat(startTime + gap * 181, "D"),
					new Beat(startTime + gap * 181, "K"),
					new Beat(startTime + gap * 190, "S"),
					new Beat(startTime + gap * 194, "D"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 204, "L"),
					new Beat(startTime + gap * 208, "K"),
					new Beat(startTime + gap * 212, "J"),
					
					new Beat(startTime + gap * 219, "F"),
					new Beat(startTime + gap * 223, "J"),
					new Beat(startTime + gap * 227, "D"),
					new Beat(startTime + gap * 234, "K"),
					new Beat(startTime + gap * 238, "S"),
					new Beat(startTime + gap * 242, "L"),
					new Beat(startTime + gap * 250, "Space"),
					new Beat(startTime + gap * 254, "Space"),
					new Beat(startTime + gap * 258, "Space"),
					
					new Beat(startTime + gap * 266, "J"),
					new Beat(startTime + gap * 266, "L"),
					new Beat(startTime + gap * 272, "S"),
					new Beat(startTime + gap * 272, "F"),
					new Beat(startTime + gap * 277, "Space"),
										
					new Beat(startTime + gap * 282, "F"),
					new Beat(startTime + gap * 282, "D"),
					new Beat(startTime + gap * 284, "J"),
					new Beat(startTime + gap * 284, "K"),
					new Beat(startTime + gap * 287, "Space"),
								
			};
		}
		if(titleName.equals("Affection_Touching_Across_Time") && difficulty.equals("Hard")) {
			int startTime = 3000 - Main.REACH_TIME * 1000; // 곡마다 재설정
			int gap = 125;
			beats = new Beat[] { // new 하여 새로운 노트를 만들 수 있다. 구현은 알아서하자
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 1, "D"),
					new Beat(startTime + gap * 2, "S"),
					new Beat(startTime + gap * 3, "D"),
					new Beat(startTime + gap * 5, "S"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 21, "D"),
					
					new Beat(startTime + gap * 44, "J"),
					new Beat(startTime + gap * 45, "K"),
					new Beat(startTime + gap * 46, "J"),
					new Beat(startTime + gap * 47, "K"),
					new Beat(startTime + gap * 48, "J"),
					new Beat(startTime + gap * 62, "K"),
					new Beat(startTime + gap * 70, "J"),
					
					new Beat(startTime + gap * 84, "S"),
					new Beat(startTime + gap * 91, "D"),
					new Beat(startTime + gap * 98, "F"),
					new Beat(startTime + gap * 105, "Space"),
					new Beat(startTime + gap * 112, "J"),
					new Beat(startTime + gap * 119, "K"),
					new Beat(startTime + gap * 126, "L"),
					new Beat(startTime + gap * 133, "K"),
					new Beat(startTime + gap * 152, "J"),
					
					new Beat(startTime + gap * 174, "Space"),
					new Beat(startTime + gap * 177, "J"),
					new Beat(startTime + gap * 177, "F"),
					new Beat(startTime + gap * 181, "D"),
					new Beat(startTime + gap * 181, "K"),
					new Beat(startTime + gap * 190, "S"),
					new Beat(startTime + gap * 194, "D"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 204, "L"),
					new Beat(startTime + gap * 208, "K"),
					new Beat(startTime + gap * 212, "J"),
					
					new Beat(startTime + gap * 219, "F"),
					new Beat(startTime + gap * 223, "J"),
					new Beat(startTime + gap * 227, "D"),
					new Beat(startTime + gap * 234, "K"),
					new Beat(startTime + gap * 238, "S"),
					new Beat(startTime + gap * 242, "L"),
					new Beat(startTime + gap * 250, "Space"),
					new Beat(startTime + gap * 254, "Space"),
					new Beat(startTime + gap * 258, "Space"),
					
					new Beat(startTime + gap * 266, "J"),
					new Beat(startTime + gap * 266, "L"),
					new Beat(startTime + gap * 272, "S"),
					new Beat(startTime + gap * 272, "F"),
					new Beat(startTime + gap * 277, "Space"),
										
					new Beat(startTime + gap * 282, "F"),
					new Beat(startTime + gap * 282, "D"),
					new Beat(startTime + gap * 284, "J"),
					new Beat(startTime + gap * 284, "K"),
					new Beat(startTime + gap * 287, "Space"),
								
			};
		}
		else if(titleName.equals("always_with_me_ocarina_ver") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("always_with_me_ocarina_ver") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Howls_Moving_Castle") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Howls_Moving_Castle") && difficulty.equals("Hard")) {
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
	
	public void judge(String input) { // 키를 입력했을 때
		for(int i = 0; i < noteList.size(); i++) {  // index 0 부터 시작하기 때문에 가장먼저 입력된것 부터 찾는다.
			Note note = noteList.get(i);
			if(input.equals(note.getNotetype())) {  // 현재 노트가 해당 키라면
				note.judge(); //판정을 수행한다
				break; // 노트를 찾자마자 break;
			} // 해당하는 노트가 없으면 그냥 무시
		}
	}
}
