package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task579 {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int count = Integer.parseInt(reader.readLine());
			String s2 = reader.readLine();
			s2 = s2.trim();
			String[] strings = s2.split(" ");
			List<Integer> numbers = new ArrayList<>();
			for (int i = 0; i < strings.length; i++) {
				numbers.add(Integer.valueOf(strings[i]));
			}
			int pos = 0;
			int posCount = 0;
			int neg = 0;
			int negCount = 0;
			for (Integer i : numbers) {
				if (i >= 0) {
					pos += i;
					posCount++;
				} else {
					neg -= i;
					negCount++;
				}
			}
			if (pos > neg) {
				System.out.println(posCount);
				for (int i = 0; i < numbers.size(); i++) {
					if (numbers.get(i) >= 0) {
						System.out.print((i + 1) + " ");
					}
				}
			} else {
				System.out.println(negCount);
				for (int i = 0; i < numbers.size(); i++) {
					if (numbers.get(i) < 0) {
						System.out.print((i + 1) + " ");
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
