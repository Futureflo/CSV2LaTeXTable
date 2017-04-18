package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Translator {

	public void readFile(String filename, String separator) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				this.translate(currentLine, separator);
			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void translate(String line, String separator) {

		List<String> result = Arrays.asList(line.split("\\s*" + separator + "\\s*"));

		this.writeFile(result, "C:\\Users\\Florian\\workspace\\CSV2LaTeXTable\\result.csv");

		// for(String string : result) {
		// System.out.print(string + " &");
		// }
		// System.out.println();
	}

	public void writeFile(List<String> results, String filename) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
			boolean odd = true;

			for (String result : results) {
				bw.write(result);
				if (odd) {
					bw.write(" & ");
				}
				odd = !odd;
			}
			/*
			 * TODO delte the \\ when the last string is read
			 */
			bw.write("\\\\ \n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Translator translator = new Translator();
		translator.readFile("C:\\Users\\Florian\\workspace\\CSV2LaTeXTable\\test.csv", ",");
	}
}
