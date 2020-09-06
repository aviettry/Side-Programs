package learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
	public static final int FIRST_NAME = 1;
	public static final int LAST_NAME = 0;

	private static String capitalize(String name) {
		name = name.toLowerCase();
		String[] names = name.split(" ");
		for( int i = 0; i < names.length; i++ ) {
			String each = names[i];
			char[] chars = each.toCharArray();
			chars[0] = (char)((int)chars[0]-32);
			each = String.valueOf(chars);
			names[i] = each;
		}
		name = "";
		for(int i = 0; i < names.length-1; i++) {
			name += names[i] + " ";
		}
		name += names[names.length-1];

		return name;
	}
	
	public static void main(String[] args) {
		File file = new File("./../Database/Client Arrivals Report 2-25-2019 - 4-25-2019.txt");
		if (file.exists()) {
			try {
				Scanner scan = new Scanner(file);
				String str = scan.nextLine();
				while (scan.hasNextLine()) {
					str = scan.nextLine();
					String[] client = str.split("\t");
					String clientName = client[1].substring(1, client[1].length() - 1);
					String[] clientNames = clientName.split(",");
					clientNames[1] = clientNames[1].substring(1, clientNames[1].length());
					clientName = (clientNames[FIRST_NAME] + " " + clientNames[LAST_NAME]);
					clientName = capitalize(clientName);
					System.out.println("ID: " + client[0] + " - Name: " + clientName);
				}
				scan.close();
			} catch (FileNotFoundException a) {
				a.printStackTrace();
			}
		} else {
			System.out.println("File not found.");
		}
	}

}
