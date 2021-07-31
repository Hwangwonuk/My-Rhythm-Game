package Rhythm_Game_11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread{	// Thread는 하나의 프로그램 안에서 실행되는 작은 프로그램이라고 할수있다 하나의 게임이 하나의 단위로서 동작해야 하기때문
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("..//images//noteBasic.png")).getImage();
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
		g.drawImage(noteBasicImage, 228, 120, null); // 노트 이미지
		g.drawImage(noteBasicImage, 332, 580, null);
		g.drawImage(noteBasicImage, 436, 500, null);
		g.drawImage(noteBasicImage, 540, 340, null);
		g.drawImage(noteBasicImage, 640, 340, null);
		g.drawImage(noteBasicImage, 744, 325, null);
		g.drawImage(noteBasicImage, 848, 305, null);
		g.drawImage(noteBasicImage, 952, 305, null);
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // 글자가 깨짐없이 매끄럽게 출력됨
		g.setFont(new Font("Arial", Font.BOLD, 30)); // Arial폰트 굵은 글씨체로 크기가 30인 글씨를 그릴수 있도록 세팅
		g.drawString("Affection_Touching_Across_Time", 20, 702); // 제목이 출력된다
		g.drawString("Easy", 1190, 702);
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
		
	}
	
}
