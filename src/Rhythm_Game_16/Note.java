package Rhythm_Game_16;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread { // 노트또한 하나의 부분적인 기능이기 때문에 스레드

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("..//images//noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; // 노트가 생성되고 ~초후에 판정라인에 닿임
	private String noteType; 
	private boolean proceeded = true; // 현재 노트의 진행여부
	
	public String getNotetype() { // 현재 노트의 타입을 반환
		return noteType;
	}
	
	public boolean isProceeded() { // 현재 진행이 되고있는지 여부를 getter함수
		return proceeded;
	}
	
	public void close() { // 현재 노트가 움직이지 않도록 해주는 close()메소드 성공적으로 입력했을 때 처리해주기 위한 함수
		proceeded = false;
	}
	
	public Note(String noteType) { // 생성자 
		if(noteType.equals("S")) {
			x = 228;
		}
		else if(noteType.equals("D")) {
			x = 332;
		}
		else if(noteType.equals("F")) {
			x = 436;
		}
		else if(noteType.equals("Space")) {
			x = 540;
		}
		else if(noteType.equals("J")) {
			x = 744;
		}
		else if(noteType.equals("K")) {
			x = 848;
		}
		else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType; // 노트 타입에 따라서 서로 다른 그림을 그린다
	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > 620) { // 판정 라인보다 아래로 내려갔다면 miss판정
			System.out.println("Miss"); // Miss출력
			close();
		}
	}
	@Override
	public void run() {
		try {
			while (true) {
				drop(); // 한번 노트를 떨어뜨리고
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME); // 노트가 움직이는 동안이라면 반복적으로 sleep
				}
				else {
					interrupt(); // 해당노트가 더이상 움직이지 않도록
					break;
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String judge() {
		if(y >= 613) {
			System.out.println("Late"); // 노트가 많이 지나가면 Late판정
			close();
			return "Late";
		}
		else if(y >= 600) {
			System.out.println("Good"); 
			close();
			return "Good";
		}
		else if(y >= 587) {
			System.out.println("Great"); 
			close();
			return "Great";
		}
		else if(y >= 573) {
			System.out.println("Perfect"); 
			close();
			return "Perfect";
		}
		else if(y >= 565) {
			System.out.println("Great"); 
			close();
			return "Great";
		}
		else if(y >= 550) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y >= 535) {
			System.out.println("Early");
			close();
			return "Early";
		}
		return "None";
	}
	
	public int getY() {
		return y;
	}
}
