import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWriteFiles {
	public static String readFile(String classlist) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		String line = null;
		try {
			br = new BufferedReader(new FileReader(new File(classlist)));
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (IOException io) {
			throw new RuntimeException(io);
		} finally {
			try {
				br.close();
			} catch (IOException io) {

			}
		}
	}

	public static void writeToFile(String name, String classlist) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(new File(classlist), true));
			pw.println(name);
		} catch (IOException io) {
			throw new RuntimeException(io);
		} finally {
			pw.close();
		}
	}
}
