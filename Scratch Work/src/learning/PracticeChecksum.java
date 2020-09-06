package learning;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class PracticeChecksum {

	public static void main(String[] args) throws IOException {
		File file = new File("./test.txt");
		InputStream is = new FileInputStream(file);
		File file2 = new File("./testCopy.txt");
		FileUtils.copyInputStreamToFile(is, file2);
		long csum1 = FileUtils.checksumCRC32(file);
		long csum2 = FileUtils.checksumCRC32(file2);
		System.out.println(csum1);
		System.out.println(csum2);
	}

}
