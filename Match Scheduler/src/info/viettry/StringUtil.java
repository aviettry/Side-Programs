package info.viettry;

public class StringUtil {

	/**
	 * 
	 * @param string
	 * @return True if string only contains alpha characters. False otherwise.
	 */
	public static boolean isAlpha(String string) {
		return string.matches("[a-zA-Z]*");
	}
}
