package application;

import java.util.Arrays;
import java.util.List;

public class Translator {
	
	public void readFile() {
		
	}

	public void translate(String line, String separator) {
		
		List<String> result = Arrays.asList(line.split("\\s*"+separator+"\\s*"));
		
		for(String string : result) {
			System.out.println(string + " &");
		}
	}
	
	public void writeFile(List<String> strings, String file) {
		
	}
	
	public static void main(String[] args) {
		Translator translator = new Translator();
		translator.translate("a, b, c;d;e, f", "," );
	}
}
