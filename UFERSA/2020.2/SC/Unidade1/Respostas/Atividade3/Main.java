import java.util.Random;

class Main {
	public static void main(String[] args) {
		String mensagemEncriptada;
		String mensagemDecriptada;
		String mensagem = "farofa";

		// Cria uma chave aleatória, alfanumérica
		// https://www.baeldung.com/java-random-string
		int limiteInferior = 48; // numeral '0'
		int limiteSuperior = 122; // letra 'z'
		int tamanhoChave = 16;
		Random random = new Random();

		// string aleatória 'chave'
		String chave = random.ints(limiteInferior, limiteSuperior + 1)
		.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		.limit(tamanhoChave)
		.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		.toString();

		System.out.print("Mensagem:            ");
		System.out.println(mensagem);

		System.out.print("Chave:               ");
		System.out.println(chave);
		System.out.println();

		/*
		mensagemEncriptada = CifraDeVernam.encriptar(mensagem, chave);

		System.out.print("Mensagem encriptada: ");
		System.out.println(mensagemEncriptada);

		mensagemDecriptada = CifraDeVernam.decriptar(mensagemEncriptada, chave);

		System.out.print("Mensagem decriptada: ");
		System.out.println(mensagemDecriptada);
		*/
		
		String[] chaves = Aes.expandirChave(chave);

		for (int i = 0; i < 44; i++) {
			System.out.print(i + ": ");
			System.out.println(chaves[i]);
		}
		
		//System.out.print("Mensagem expandida: ");
		//System.out.println(mensagemEncriptada);
		
	}
}
