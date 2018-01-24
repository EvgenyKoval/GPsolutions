package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task278 {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String s1 = reader.readLine();
			String s2 = reader.readLine();
			int j = 0;
			if (s1.length() > s2.length()) {
				System.out.println("NO");

			} else if (s1.length() == 0) {
				System.out.println("YES");
			} else {
				for (int i = 0; i < s2.length(); i++) {
					if (s2.charAt(i) == s1.charAt(j)) {
						j++;
						if (j == s1.length()) {
							System.out.println("YES");
							return;
						}
					}
				}
				System.out.println("NO");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}