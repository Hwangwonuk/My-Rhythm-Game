package Rhythm_Game_8;

public class Track {	// 해당 곡의 앨범표지, 제목 등을 담을수 있도록 클래스 파일 생성 
	
	private String titleImage; // 제목 부분 이미지
	private String startImage; // 게임 선택창 표지 이미지
	private String gameImage; // 해당 곡을 실행했을 때 표지 이미지
	private String startMusic; // 게임 선택 창 클릭
	private String gameMusic; // 해당 곡을 실행했을 때 음악
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic) { // 생성자 생성, 값을 초기화한다
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
	}
	
	
	
}