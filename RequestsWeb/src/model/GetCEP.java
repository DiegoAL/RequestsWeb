package model;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

/**
 * Realize pesquisa com base no cep e retorne todos os dados de endereço
 * disponiveis
 * 
 * @author M206255
 *
 */
public class GetCEP {

	public static void main(String[] args) throws IOException {
		// Variaveis
		String cep;
		URL url;
		URLConnection urlConnection;

		cep = JOptionPane.showInputDialog("Insira o CEP");
		if (cep.equals("")) {
			JOptionPane.showMessageDialog(null, "Favor inserir um valor para o CEP", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		url = new URL("Referer:http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		urlConnection = url.openConnection();
		urlConnection.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
		urlConnection.addRequestProperty("relaxation", cep);
	}

}
