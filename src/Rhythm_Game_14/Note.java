package Rhythm_Game_14;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread { // 노트또한 하나의 부분적인 기능이기 때문에 스레드

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("..//images//noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; // 노트가 생성되고 ~초후에 판정라인에 닿임
	private String noteType; 
	
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
	}
	@Override
	public void run() {
		try {
			while (true) {
				drop(); // 한번 노트를 떨어뜨리고
				Thread.sleep(Main.SLEEP_TIME); // 슬립
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
