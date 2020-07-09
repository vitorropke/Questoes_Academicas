import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validadores {
	// Tirado de 
	// https://stackoverflow.com/questions/8204680/java-regex-email
	// https://pt.stackoverflow.com/questions/68209/verificacao-de-email-em-java
	// https://receitasdecodigo.com.br/java/validar-email-em-java
	public static boolean isEmail(String email) {
		String expressao = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\\\[[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\])|(([a-zA-Z\\\\-0-9]+\\\\.)+[a-zA-Z]{2,}))$";
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(expressao, Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		
		return matcher.matches();
	}
	
	// C�digo de https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097
	public static boolean isCpf(String cpf) {
		/* Cada um dos nove primeiros n�meros do CPF � multiplicado por um peso
		 * que come�a em 10 e vai at� 1 decrementando um em um
		 * somando-se as parcelas calculadas:
		*/
		// Considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (
				cpf.equals("00000000000") || cpf.equals("11111111111") ||
				cpf.equals("22222222222") || cpf.equals("33333333333") ||
				cpf.equals("44444444444") || cpf.equals("55555555555") ||
				cpf.equals("66666666666") || cpf.equals("77777777777") ||
				cpf.equals("88888888888") || cpf.equals("99999999999")
			)
			return(false);
		
		char digito10, digito11;
		int soma = 0, indice, resto, numeroAtual, peso = 10;
		
		// "try" - protege o c�digo para eventuais erros de convers�o de tipo (int)
		try {
			// C�lculo do 1� d�gito verificador(10� d�gito do cpf)
			for (indice = 0; indice < 9; indice++) {              
				// Converte o i-�simo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 � a posicao de '0' na tabela ASCII)
				numeroAtual = (int)(cpf.charAt(indice) - 48);
				soma += numeroAtual * peso;
				peso--;
			}
			
			/* Calcula-se o d�gito atrav�s da seguinte express�o:
			 * 11 - (soma % 11) = d�gito
			 * obs. Se o resto da divis�o (operador %) calculado for 10 ou 11, 
			 * o d�gito verificador ser� 0; nos outros casos, o d�gito verificador
			 * � o pr�prio resto.
			*/
			resto = 11 - (soma % 11);
			
			// Se o resto for 10 ou 11 o d�gito verificador ser� 0. Sen�o, ser� o pr�prio n�mero
			if ((resto == 10) || (resto == 11))
				digito10 = '0';
			else
				digito10 = (char)(resto + 48); // Convers�o de int para char
			
			// C�lculo do 2� d�gito verificador (11� d�gito do cpf)
			soma = 0;
			peso = 11;
			
			for(indice = 0; indice<10; indice++) {
				numeroAtual = (int)(cpf.charAt(indice) - 48); //convers�o char para int
				soma += numeroAtual * peso;
				peso--;
			}
			
			resto = 11 - (soma % 11);
			
			// Se o resto for 10 ou 11 o d�gito verificador ser� 0. Sen�o, ser� o pr�prio n�mero
			if ((resto == 10) || (resto == 11))
				digito11 = '0';
			else
				digito11 = (char)(resto + 48); // Convers�o de int para char
			
			// Verifica se os d�gitos calculados conferem com os d�gitos informados.
			if ((digito10 == cpf.charAt(9)) && (digito11 == cpf.charAt(10)))
				return true;
			else
				return false;
		} catch (InputMismatchException erro) {
			return false;
		}
	}
	
	public static boolean isTelefone(String numeroTelefone) {
		String expressao = ".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}";
		return numeroTelefone.matches(expressao);
    }
}
