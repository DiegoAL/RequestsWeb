import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Translate {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String texto = "Ola, gostaria de fazer um pedido!";

		texto = URLEncoder.encode(texto, "UTF-8");
		texto = texto.replaceAll("\\+", "%20");

		URL url = new URL(
				"https://translate.google.com.br/translate_tts?ie=UTF-8&q=ola"
						+ "&tl=en&total=1&idx=0&textlen=3&tk=725596.870513&client=t&prev=input&ttsspeed=0.24");
		// Devido a necessidade do token (tk) nao é mais possivel fzr
		// requisicoes sem ele, a nao ser com o usao de api
		// "http://translate.google.com.br/translate_tts?ie=UTF-8&q="
		// + texto
		// + "&tl=pt&total=1&idx=0&textlen=10&client=t&prev=input");

		URLConnection urlConnection = url.openConnection();
		urlConnection
				.addRequestProperty(
						"User-Agent",
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.69 Safari/537.36");
		InputStream inputStream = urlConnection.getInputStream();

		FileOutputStream audio = new FileOutputStream("audio.mp3");

		byte[] buffer = new byte[1024];

		int byteLido;

		while ((byteLido = inputStream.read(buffer)) != -1) {
			System.out.println(byteLido);
			audio.write(buffer, 0, byteLido);
			System.out.println("laço");
		}

		audio.close();
		inputStream.close();
	}
}
