public class CifraDeVernam {
	public static String encriptar(String mensagem, String chave) {
		if (mensagem.length() != chave.length()) {
			// a mensagem não pode ter tamanho diferente da chave
			System.out.println("Falha na encriptacao. Chave possui comprimento diferente da mensagem.");
			return "";
		}

		String mensagemEncriptada = "";

		for (int i = 0; i < mensagem.length(); i++) {
			// XOR de cada caractere
			mensagemEncriptada += (char)(mensagem.charAt(i) ^ chave.charAt(i));
		}

		return mensagemEncriptada;
	}

	public static String decriptar(String mensagem, String chave) {
		if (mensagem.length() != chave.length()) {
			// a mensagem não pode ter tamanho diferente da chave
			System.out.println("Falha na decriptacao. Chave possui comprimento diferente da mensagem.");
			return "";
		}

		String mensagemDecriptada = "";

		for (int i = 0; i < mensagem.length(); i++) {
			// XOR de cada caractere
			mensagemDecriptada += (char)(mensagem.charAt(i) ^ chave.charAt(i));
		}

		return mensagemDecriptada;
	}
}
