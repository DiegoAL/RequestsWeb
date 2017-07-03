public class Teste {
	public static void main(String[] args) {
		System.out.println("ola");
		conta c1 = new conta();
		c1.saldo = 1;
		System.out.println(c1.saldo);
		System.out.println("");
	}
}

class conta {
	public int saldo;

}