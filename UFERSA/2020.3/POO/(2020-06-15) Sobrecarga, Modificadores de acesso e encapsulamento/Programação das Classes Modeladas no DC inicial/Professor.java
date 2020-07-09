
public class Professor {
	// Atributos*****************************************************************
	private String login;
	private String senha;
	private String email;
	private String nome;
	private String cpf;
	private String endereco;
	private String[] telefone;
	//private Turma[] turma;
	
	// Getters e Setters*********************************************************
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login != null && login != "") {
			this.login = login;
			System.out.println("Login cadastrado!");
		}else {
			System.out.println("Login n�o pode ser vazio!");
		}	
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha != null && senha != "") {
			this.senha = senha;
			System.out.println("Senha cadastrada!");
		}else {
			System.out.println("Senha n�o pode ser vazia!");
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email != null && email != "") {
			if(Validadores.isEmail(email)) {// Se o email for v�lido
				this.email = email;
				System.out.println("Email cadastrado!");
			}else {// Se o email n�o for v�lido
				System.out.println("Email � inv�lido!");
			}
		}else {
			System.out.println("Email n�o pode ser vazio!");
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && nome != "") {
			this.nome = nome;
			System.out.println("Nome cadastrado!");
		}else {
			System.out.println("Nome n�o pode ser vazio!");
		}
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf.length() == 11 || cpf.length() == 14) {
			if(cpf.length() == 14) {// Se o CPF tiver 14 d�gitos, reduzi-lo-ei para 11 d�gitos
				String cpfReduzido = cpf.replaceAll("[-.]", "");// Apaga todos os '.' e '-'
				
				if(cpfReduzido.length() == 11) {// Garante que a remo��o dos '.' e '-', reduziu o cpf para 11 d�gitos
					if(Validadores.isCpf(cpfReduzido)) {// Se a verifica��o for v�lida
						this.cpf = cpfReduzido;
						System.out.println("CPF cadastrado!");
					}else {// Se a verifica��o for inv�lida
						System.out.println("CPF � inv�lido! Falsificado!");
					}
				}else {// Se ap�s a remo��o dos '.' e '-' n�o der 11 d�gitos ent�o
					System.out.println("CPF n�o possui 11 n�meros!");
				}
			}else {// Se o CPF tiver 11 d�gitos � feita a verifica��o direta
				if(Validadores.isCpf(cpf)) {// Se a verifica��o for v�lida
					this.cpf = cpf;
					System.out.println("CPF cadastrado!");
				}else {// Se a verifica��o for inv�lida
					System.out.println("CPF � inv�lido! Falsificado");
				}
			}
		}else {// Se o CPF n�o tiver 11 nem 14 d�gitos, ent�o
			System.out.println("CPF n�o possui 11 nem 14 d�gitos!");
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco != null && endereco != "") {
			this.endereco = endereco;
			System.out.println("Endere�o cadastrado!");
		}else {
			System.out.println("Endere�o n�o pode ser vazio!");
		}
	}
	public String[] getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(getTelefone() != null) {// Se o vetor de telefone n�o for vazio
			int indiceInsercao = 0;
			
			for(int i = 1; i < getTelefone().length; i++) {// Verifica at� onde o vetor est� ocupado
				if(getTelefone()[i] == null) {
					indiceInsercao = i;
					break;
				}
			}
			
			if(indiceInsercao == 0) {// Se a lista de telefones estiver cheia
				System.out.println("Lista de telefones cheia! Telefone n�o cadastrado!");
			}else if(telefone != null && telefone != "") {// Se a entrada 'telefone' n�o for vazia
				if(Validadores.isTelefone(telefone)) {// Se a entrada 'telefone' for v�lida
					this.telefone[indiceInsercao] = telefone;
					System.out.println("Telefone cadastrado!");
				}else {// Se a entrada 'telefone' for inv�lida
					System.out.println("Telefone � inv�lido!");
				}
			}else {// Se a entrada 'telefone' for vazia
				System.out.println("Telefone n�o pode ser vazio!");
			}
		}else {// Se o vetor de telefone for vazio, coloque o n�mero no �ndice 0
			if(telefone != null && telefone != "") {// Se a entrada 'telefone' n�o for vazia
				if(Validadores.isTelefone(telefone)) {// Se a entrada 'telefone' for v�lida
					this.telefone = new String[5];
					this.telefone[0] = telefone;
					System.out.println("Telefone cadastrado!");
				}else {// Se a entrada 'telefone' for inv�lida
					System.out.println("Telefone � inv�lido!");
				}
			}else {// Se a entrada 'telefone' for vazia
				System.out.println("Telefone n�o pode ser vazio!");
			}
		}
	}/*
	public Turma[] getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		if(getTurma() != null) {// Se o vetor de turma n�o for vazio
			int indiceInsercao = 0;
			
			for(int i = 1; i < getTurma().length; i++) {// Verifica at� onde o vetor est� ocupado
				if(getTurma()[i] == null) {
					indiceInsercao = i;
					break;
				}
			}
			
			if(indiceInsercao == 0) {// Se a lista de turmas estiver cheia
				System.out.println("Lista de turmas cheia! Turma n�o cadastrada!");
			}else if(turma != null) {// Se a entrada 'turma' n�o for vazia
				this.turma[indiceInsercao] = turma;
				System.out.println("Turma cadastrada!");
			}else {// Se a entrada 'turma' for vazia
				System.out.println("Turma n�o pode ser vazia!");
			}
		}else {// Se o vetor de turma for vazio, coloque o vetor de entrada 'turma[]' a partir do �ndice 0
			if(turma != null) {// Se a entrada 'turma' n�o for vazia
				this.turma = new Turma[5];
				this.turma[0] = turma;
				System.out.println("Turma cadastrada!");
			}else {// Se a entrada 'turma' for vazia
				System.out.println("Turma n�o pode ser vazia!");
			}
		}
	}
	*/
	// M�todos*******************************************************************
	public void definirLoginSenha(String cpf, String login, String senha) {
		if(cpf != null && cpf != "") {
			if(cpf == getCpf()) {
				setLogin(login);
				setSenha(senha);
			}else {
				System.out.println("CPF n�o encontrado!");
			}
		}else {
			System.out.println("CPF n�o pode ser vazio!");
		}
	}
	public void alterarLogin(String loginAtual, String novoLogin) {
		if(loginAtual != null && loginAtual != "") {
			if(loginAtual == getLogin()) {
				setLogin(novoLogin);
			}else {
				System.out.println("Login incorreto!");
			}
		}else {
			System.out.println("Login atual n�o pode ser vazio!");
		}
	}
	public void alterarSenha(String senhaAtual, String novaSenha) {
		if(senhaAtual != null && senhaAtual != "") {
			if(senhaAtual == getSenha()) {
				setSenha(novaSenha);
			}else {
				System.out.println("Senha incorreta!");
			}
		}else {
			System.out.println("Senha atual n�o pode ser vazia!");
		}
	}
	public void alterarEmail(String emailAtual, String novoEmail) {
		if(emailAtual != null && emailAtual != "") {
			if(emailAtual == getEmail()) {
				setEmail(novoEmail);
			}else {
				System.out.println("Email incorreto!");
			}
		}else {
			System.out.println("Email atual n�o pode ser vazio!");
		}
	}
	public void alterarTelefone(String telefoneAtual, String novoTelefone) {
		if(getTelefone() != null) {
			if(telefoneAtual != null) {
				boolean telefoneEncontrado = false;
				
				for(int indice = 0; indice < getTelefone().length; indice++) {
					if(telefoneAtual == getTelefone()[indice]) {
						setTelefone(novoTelefone);
						telefoneEncontrado = true;
						break;
					}
				}
				
				if(!telefoneEncontrado) {// Se o telefone n�o for encontrado
					System.out.println("Telefone n�o encontrado!");
				}
			}else {
				System.out.println("Telefone n�o pode ser vazio!");
			}
		}else {
			System.out.println("Lista de telefones vazia!");
		}
	}
	public void adicionarTelefone(String telefone) {
		setTelefone(telefone);
	}
	public void deletarTelefone(String[] telefone) {
		if(getTelefone() != null) {
			if(telefone != null) {
				for(int indiceEntrada = 0; indiceEntrada < telefone.length; indiceEntrada++) {// Percorre vetor de entrada 'telefone'
					boolean telefoneEncontrado = false;
					
					for(int indiceInterno = 0; indiceInterno < getTelefone().length; indiceInterno++) {// Procura pelo telefone
						if(telefone[indiceEntrada] == getTelefone()[indiceInterno]) {
							this.telefone[indiceInterno] = null;// Remo��o do telefone
							System.out.println("Telefone deletado!");
							telefoneEncontrado = true;
							break;
						}
					}
					
					if(!telefoneEncontrado) {// Se o telefone n�o for encontrado
						System.out.println("Telefone " + telefone[indiceEntrada] + " n�o encontrado!");
					}
				}
			}else {
				System.out.println("Telefone n�o pode ser vazio!");
			}
		}else {
			System.out.println("Lista de telefones vazia!");
		}
	}
	/*
	public Turma[] buscarTurma() {
		
	}
	public void finalizarTurma(Turma turma) {
		if(turma != null) {
			turma.setStatus(false);
		}else {
			System.out.println("Turma n�o pode ser vazia!");
		}
	}
	public Aluno[] buscarAluno(Turma turma) {
		if(turma != null) {
			return turma.aluno;
		}else {
			System.out.println("Turma n�o pode ser vazia!");
		}
	}
	public void lancarNota(turma Turma, Aluno aluno, float[] nota) {
		if(turma != null) {
			if(aluno != null) {
				aluno.setNota(nota);
			}else {
				System.out.println("Aluno n�o pode ser vazio!");
			}
		}else {
			System.out.println("Turma n�o pode ser vazia!");
		}
	}
	public void lancarFrequencia(turma Turma, Aluno aluno, boolean[] frequencia) {
		if(turma != null) {
			if(aluno != null) {
				aluno.setFrequencia(frequencia);
			}else {
				System.out.println("Aluno n�o pode ser vazio!");
			}
		}else {
			System.out.println("Turma n�o pode ser vazia!");
		}
	}*/
}
