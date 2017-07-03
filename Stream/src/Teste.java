import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream entrada = new FileInputStream("entrada.txt");
		Scanner scanner = new Scanner(entrada);

		FileOutputStream saida = new FileOutputStream("saida.txt");
		PrintStream printStream = new PrintStream(saida);

		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			printStream.println(linha);
		}

		scanner.close();
		printStream.close();

	}
}
