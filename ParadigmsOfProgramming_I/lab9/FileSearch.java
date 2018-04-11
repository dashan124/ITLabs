import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

class FileSearch{
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String contents = "";
		try(BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }

		    contents = sb.toString();
		} catch(Exception e){
			e.printStackTrace();
		}

		String[] words = contents.split(" ");
		System.out.println("Word count: " + words.length);
		System.out.println("Enter a string to search: ");
		String s = ip.next();

		System.out.println(contents.contains(s));
	}
}