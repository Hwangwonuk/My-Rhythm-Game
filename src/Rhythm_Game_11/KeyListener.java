package Rhythm_Game_11;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if(MyRhythmGame.game == null) {	// game이 실행중이지 않다면 return을 넣어서 아래의 코드를 실행되지 않도록 만들어 키보드 입력시 아무 반응이 없게 만든다
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) { // S라는 key를 눌렀다면
			MyRhythmGame.game.pressS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			MyRhythmGame.game.pressD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			MyRhythmGame.game.pressF();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			MyRhythmGame.game.pressSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			MyRhythmGame.game.pressJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			MyRhythmGame.game.pressK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			MyRhythmGame.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) { // 키보드를 눌렀다 떼어낼 때
		if(MyRhythmGame.game == null) {	// game이 실행중이지 않다면 return을 넣어서 아래의 코드를 실행되지 않도록 만들어 키보드 입력시 아무 반응이 없게 만든다
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) { // S라는 key를 눌렀다면
			MyRhythmGame.game.releaseS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			MyRhythmGame.game.releaseD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			MyRhythmGame.game.releaseF();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			MyRhythmGame.game.releaseSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			MyRhythmGame.game.releaseJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			MyRhythmGame.game.releaseK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			MyRhythmGame.game.releaseL();
		}
	}
	
}
