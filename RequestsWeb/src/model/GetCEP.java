package model;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Realize pesquisa com base no cep e retorne todos os dados de endere�o
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
			JOptionPane.showMessageDialog(null,
					"Favor inserir um valor para o CEP", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		url = new URL(
				"http://www.buscacep.correios.com.br/sistemas/buscacep/resultadoBuscaCepEndereco.cfm");
		urlConnection = url.openConnection();
		urlConnection
				.setRequestProperty("User-Agent",
						"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:54.0) Gecko/20100101 Firefox/54.0");
		urlConnection
				.setRequestProperty(
						"Cookie",
						"CFID=Z16c97xp1nfat85vel35thx6qc0x7tyryg54wwfrh1nlek21mq-52614282; CFTOKEN=Z16c97xp1nfat85vel35thx6qc0x7tyryg54wwfrh1nlek21mq-975aff30ec9ce297-63F634C2-5056-8847-BAF7A23034A2EECC; CFGLOBALS=urltoken%3DCFID%23%3D52614282%26CFTOKEN%23%3D975aff30ec9ce297%2D63F634C2%2D5056%2D8847%2DBAF7A23034A2EECC%26jsessionid%23%3DBD9E469C2B053B5AC2A238B5E527F994%2Ecfusion02%23lastvisit%3D%7Bts%20%272017%2D07%2D10%2018%3A18%3A11%27%7D%23hitcount%3D4%23timecreated%3D%7Bts%20%272017%2D05%2D29%2021%3A40%3A13%27%7D%23cftoken%3D975aff30ec9ce297%2D63F634C2%2D5056%2D8847%2DBAF7A23034A2EECC%23cfid%3D52614282%23; CFGLOBALS=urltoken%3DCFID%23%3D52614282%26CFTOKEN%23%3D975aff30ec9ce297%2D63F634C2%2D5056%2D8847%2DBAF7A23034A2EECC%26jsessionid%23%3DBD9E469C2B053B5AC2A238B5E527F994%2Ecfusion02%23lastvisit%3D%7Bts%20%272017%2D07%2D10%2018%3A18%3A11%27%7D%23hitcount%3D4%23timecreated%3D%7Bts%20%272017%2D05%2D29%2021%3A40%3A13%27%7D%23cftoken%3D975aff30ec9ce297%2D63F634C2%2D5056%2D8847%2DBAF7A23034A2EECC%23cfid%3D52614282%23; _ga=GA1.3.606651095.1498689508; opEueMonUID=u_4df6asigy4pj4hl1pcr; ssvbr0327_www2=ssvbr0278; _gid=GA1.3.28554588.1499721490; _gat=1; ssvbr0327_buscacep=sac2093_2cep; JSESSIONID=BD9E469C2B053B5AC2A238B5E527F994.cfusion02");
		urlConnection.setRequestProperty("relaxation", cep);
		urlConnection.setRequestProperty("tipoCEP", "ALL");
		urlConnection.setRequestProperty("semelhante", "N");

		Scanner scanner = new Scanner(urlConnection.getInputStream());
		PrintStream ps = new PrintStream("saidaCorreios.txt");
		// StringBuilder stringBuilder = new StringBuilder();

		while (scanner.hasNext()) {
			ps.println(scanner.nextLine());
		}
	}

}
