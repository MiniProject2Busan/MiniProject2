package model;

// 메인 서비스 작업 로직 - MainController에서 호출됨
public class MainService {
	private static MainService instance = new MainService();

	private MainService() {

	}

	public static MainService getInstance() {
		return instance;
	}

}
