package Rhythm_Game_6;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread { // Thread는 프로그램 안의 작은 프로그램
	
	private Player player; // Player는 라이브러리중 하나
	private boolean isLoop; // isLoop라는 변수는 무한반복인지, 한번 재생하고 끝나는지 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { // 생성자를 만들어 곡의 이름과 무한반복인지 여부를 입력받는다.
		try {	// try-catch 구문은 예외처리를 위하여 사용함
			this.isLoop = isLoop; // isLoop라는 변수를 초기화
			file = new File(Main.class.getResource("..//music//" + name).toURI()); // 뮤직 폴더안의 해당이름의 파일을 실행시키고 toURI로 해당파일의 위치를 가져온다.
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); // 해당 파일을 버퍼에 담아서 읽어올 수 있도록 한다.
			player = new Player(bis); // player는 해당 파일을 담을 수 있도록 해준다
		} catch(Exception e) {
			System.out.println(e.getMessage()); // 오류를 출력
		}
	}
	
	public int getTime() { // getTime은 현재 어느 시간대를 실행중인지 나타낸다. 0.001초 단위까지 알려준다.음악에 맞춰서 노트를 떨어뜨릴때 시간을 분석한다.
		if (player == null)
			return 0; // 
		return player.getPosition();
	}
	
	public void close() { // 음악이 언제 실행되고 있던간에 항상 종료할 수 있도록 해주는 함수
		isLoop = false;
		player.close();
		this.interrupt(); // 해당 스레드(곡을 실행하는 프로그램)를 중지상태로 만든다. 곡을 재생해주는 프로그램이 따로 있다고 생각하면 된다.
	}
	
	@Override
	public void run() { // run 메소드는 쓰레드를 상속받으면 무조건 생성해야 하는 함수이다.
		try {
			do {
				player.play(); // 곡을 실행시킨다.
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis); // 해당 파일을 버퍼에 담아서 읽어올 수 있도록 한다.
				player = new Player(bis); // player는 해당 파일을 담을 수 있도록 해준다
			} while (isLoop); // isLoop라는 변수가 true값이라면 해당곡은 무한반복이 된다.
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 오류가 발생할 경우 오류를 출력
		}
	}
}
