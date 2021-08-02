package Rhythm_Game_13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread { // 노트또한 하나의 부분적인 기능이기 때문에 스레드

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("..//images//noteBasic.png")).getImage();
	private int x, y = 580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED; // 노트가 생성되고 1초뒤에 판정라인에 닿임
	private String noteType; 
	
	public Note(int x, String noteType) { // 생성자 
		this.x = x;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("short")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else if(noteType.equals("long")) { // 스페이스바
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
