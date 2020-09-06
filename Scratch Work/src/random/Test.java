package random;

import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmm");
		long time = System.currentTimeMillis();
		System.out.println(formatter.format(time));
	}
	
}
