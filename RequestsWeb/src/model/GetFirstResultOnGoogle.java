package model;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 * @author Diego Alves
 * @version 1.0
 * 
 *          Realiza uma consulta no Google e retorna o primeiro link encontrado
 */
public class GetFirstResultOnGoogle {
	public static void main(String[] args) {
		String parametroPesquisa, htmlLink = "<h3 class=\"r\"><a href=\"/url?q=";
		URL url;
		Scanner scanner; // Leitura do response
		StringBuilder stringBuilder; // amarzenamento do response
		int indexOfHtmlLink; // index do primeiro link
		String subStrBuilder; // Substring do response

		try {
			parametroPesquisa = JOptionPane
					.showInputDialog("Parametro de pesquisa");

			if (parametroPesquisa.equals(""))
				JOptionPane.showMessageDialog(null, "Parametro Invalido",
						"Erro", JOptionPane.ERROR_MESSAGE);
			else {
				// enconding para utf-8 e ajuste da string
				parametroPesquisa = URLEncoder.encode(parametroPesquisa,
						"UTF-8");
				parametroPesquisa = parametroPesquisa.replaceAll("\\+", "%20");

				url = new URL("https://www.google.com.br/search?q="
						+ parametroPesquisa);

				// abrindo conexao
				URLConnection urlConnection = url.openConnection();
				urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

				scanner = new Scanner(urlConnection.getInputStream());
				stringBuilder = new StringBuilder();

				// lendo o response e armazenando
				while (scanner.hasNext()) {
					stringBuilder.append(scanner.nextLine());
				}
				scanner.close();

				// Retonar o primeiro link encontrado pela pesquisa
				indexOfHtmlLink = stringBuilder.indexOf(htmlLink)
						+ htmlLink.length();
				subStrBuilder = stringBuilder.substring(indexOfHtmlLink);

				JOptionPane.showMessageDialog(null,
						subStrBuilder.substring(0, subStrBuilder.indexOf("&")),
						"Mensagem", JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"<html><u>Um Erro ocorreu</u></html>", "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
}
