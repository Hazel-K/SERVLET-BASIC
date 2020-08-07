package blog.naver.hyojin4588.common;

public class Utils {
	
	public static int parseStringToInt(String arg0, int arg1) {
		try {
			return Integer.parseInt(arg0);
		} catch (Exception e) {
			return arg1;
		}
	}

}