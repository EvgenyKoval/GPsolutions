package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task670 {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int index = Integer.parseInt(reader.readLine());
			List<String> list = new ArrayList<>();

			for (int i = 1; list.size() < index; i++) {
				boolean check = true;
				String s = String.valueOf(i);
				for (int k = 0; k < s.length() - 1; k++) {
					String tmp = s.substring(k + 1);
					if (tmp.contains(String.valueOf(s.charAt(k)))) {
						check = false;
						break;
					}
				}
				if (check) {
					list.add(s);
				}
			}
			System.out.println(list.get(index - 1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
