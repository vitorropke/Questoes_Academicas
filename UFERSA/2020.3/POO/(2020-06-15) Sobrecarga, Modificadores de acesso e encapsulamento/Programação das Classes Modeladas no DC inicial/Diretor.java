//import java.util.Calendar;

public class Diretor {
	// Atributos*****************************************************************
	private String login;
	private String senha;
	private String email;
	
	// Getters and Setters*******************************************************
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login != null && login != "") {
			this.login = login;
			System.out.println("Login cadastrado!");
		}else {
			System.out.println("Login não pode ser vazio!");
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
			System.out.println("Senha não pode ser vazia!");
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email != null && email != "") {
			if(Validadores.isEmail(email)) {// Se o email for válido
				this.email = email;
				System.out.println("Email cadastrado!");
			}else {// Se o email não for válido
				System.out.println("Email é inválido!");
			}
		}else {
			System.out.println("Email não pode ser vazio!");
		}
	}
	
	// Métodos*******************************************************************
	public void definirLoginSenha(String login, String senha) {
		if(login != null && login != "") {
			setLogin(login);
		}else {
			System.out.println("Login não pode ser vazio!");
		}
		
		if(senha != null && senha != "") {
			setSenha(senha);
		}else {
			System.out.println("Senha não pode ser vazia!");
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
			System.out.println("Login atual não pode ser vazio!");
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
			System.out.println("Senha atual não pode ser vazia!");
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
			System.out.println("Email atual não pode ser vazio!");
		}
	}/*
	// Aluno
	public void cadastrarAluno(Aluno aluno, String nome, String cpf, String matricula, String endereco, String historico, Turma[] turma) {
		if(aluno != null) {
			aluno.setNome(nome);
			aluno.setCpf(cpf);
			aluno.setMatricula();
			aluno.setEndereco(endereco);
			aluno.setHistorico(historico);
			aluno.setTurma(turma);
		}else {
			System.out.println("Aluno não pode ser vazio!");
		}
	}
	public void alterarNomeAluno(Aluno aluno, String nome) {
		if(aluno != null) {
			aluno.setNome(nome);
		}else {
			System.out.println("Aluno não pode ser vazio!");
		}
	}
	public void alterarCpfAluno(Aluno aluno, String cpf) {
		if(aluno != null) {
			aluno.setCpf(cpf);
		}else {
			System.out.println("Aluno não pode ser vazio!");
		}
	}
	public void alterarEnderecoAluno(Aluno aluno, String endereco) {
		if(aluno != null) {
			aluno.setEndereco(endereco);
		}else {
			System.out.println("Aluno não pode ser vazio!");
		}
	}
	public void alterarHistoricoAluno(Aluno aluno, String historico) {
		if(aluno != null) {
			aluno.setHistorico(historico);
		}else {
			System.out.println("Aluno não pode ser vazio!");
		}
	}
	public void alterarTurmaAluno(Aluno aluno, Turma turmaAntiga, Turma novaTurma) {
		if(aluno != null) {
			if(turmaAntiga != null) {
				if(novaTurma != null) {
					boolean temVaga = false
					int indiceVaga = 0;
					
					for(int i = 0; i < novaTurma.getAluno().length; i++) {// Verifica se tem vaga na nova turma
						if(novaTurma.getAluno()[i] == null) {
							indiceVaga = i;
							temVaga = true;
							break;
						}
					}
					
					if(temVaga) {
						boolean turmaAntigaExiste = false;
						int indiceTurma = 0;
						
						for(int i = 0; i < aluno.getTurma().length; i++) {// Identifica o índice da 'turmaAntiga' e também verifica se o aluno está cursando ela
							if(aluno.getTurma()[i] == turmaAntiga) {
								turmaAntigaExiste = true;
								indiceTurma = i;
								break;
						}
						
						if(turmaAntigaExiste) {
							aluno.turma[indiceTurma] = novaTurma;
							novaTurma.aluno[indiceVaga] = aluno;
							turmaAntiga.aluno = null;
						}else {
							System.out.println("Aluno não está cursando nessa turma antiga!");
						}
					}
					}else {
						System.out.println("Turma nova está cheia!");
					}
				}else {
					System.out.println("Turma nova não pode ser vazia!");
				}
			}else {
				System.out.println("Turma antiga não pode ser vazia!");
			}
		}else {
			System.out.println("Aluno não pode ser vazio!");
		}
	}
	public void removerTurmaAluno(Aluno aluno, Turma turma) {
		if(aluno != null) {
			if(turma != null) {
				turma.aluno = null;
				
				if(turma.getAluno() == null) {
					deletarTurma(turma);
				}
				
				aluno.turma = null;
			}else {
				System.out.println("Turma não pode ser vazia!");
			}
		}else {
			System.out.println("Aluno não pode ser vazio!");
		}
	}
	public Aluno[] buscarAluno(Turma turma[]) {
		if(turma != null) {
			return turma.aluno;
		}else {
			System.out.println("Turma não pode ser vazia!");
		}
	}*/
	/*
	// Professsor
	public void cadastrarProfessor(Professor professor, String nome, String cpf, String endereco, Turma[] turma) {
		if(professor != null) {
			professor.setNome(nome);
			professor.setCpf(cpf);
			professor.setEndereco(endereco);
			
			for(int i = 0; i < turma.length; i++) {
				professor.setTurma(turma[i]);
			}
		}else {
			System.out.println("Aluno não pode ser vazio!");
		}
	}*/
	public void alterarNomeProfessor(Professor professor, String nome) {
		if(professor != null) {
			professor.setNome(nome);
		}else {
			System.out.println("Professor não pode ser vazio!");
		}
	}
	public void alterarCpfProfessor(Professor professor, String cpf) {
		if(professor != null) {
			professor.setCpf(cpf);
		}else {
			System.out.println("Professor não pode ser vazio!");
		}
	}
	public void alterarEnderecoProfessor(Professor professor, String endereco) {
		if(professor != null) {
			professor.setEndereco(endereco);
		}else {
			System.out.println("Professor não pode ser vazio!");
		}
	}/*
	public void alterarTurmaProfessor(Professor professor, Turma turmaAntiga, Turma novaTurma) {
		Professor professorAntigo = novaTurma.professor; // Salva 'professorAntigo' que ensinava em 'novaTurma'
		professsorAntigo.setTurma(turmaAntiga); // Coloca o 'professorAntigo' na turma que 'professor' saiu
		turmaAntiga.setProfessor(professorAntigo); // Define o professor da turma antiga
		
		professor.setTurma(novaTurma); // Define a nova turma do professor
		novaTurma.setProfessor(professor); // Define o professor na nova turma
	}
	public void deletarProfessor(Professor[] professor) {
		if(professor != null) {
			for(int i = 0;  i < professor.length; i++){
				Turma[] turma = professor[i].turma;// Pega as turmas que o professor ensina
				Aluno[] aluno = turma.aluno;// Pega os alunos que estudam nessas turmas
				
				professor[i] = null;// Apaga o professor
				aluno.turma = null;// Apaga as turmas dos alunos que esse professor ensinava
				turma = null;// Apaga as turmas que o professor ensinava
			}
		}else {
			System.out.println("Professor não pode ser vazio!");
		}
	}
	public Professor[] buscarProfessor() {
		
	}
	
	// Turma
	public void cadastrarTurma(Turma turma, String nomeDisciplina, Calendar horario, Aluno[] aluno, Professor professor, String local) {
		if(turma != null) {
			turma.setNomeDisciplina(nomeDisciplina);
			turma.setHorario(horario);
			
			for(int i = 0; i < aluno.length; i++) {
				turma.setAluno(aluno[i]);
			}
			
			turma.setProfessor(professor);
			turma.setLocal(local);
		}else {
			System.out.println("Turma não pode ser vazia!");
		}
	}
	public void alterarNomeDisciplinaTurma(Turma turma, String nomeDisciplina) {
		if(turma != null) {
			turma.setNomeDisciplina(nomeDisciplina);
		}else {
			System.out.println("Turma não pode ser vazia!");
		}
	}
	public void alterarHorarioTurma(Turma turma, Calendar horario) {
		if(turma != null) {
			turma.setHorario(horario);
		}else {
			System.out.println("Turma não pode ser vazia!");
		}
	}
	public void deletarAlunoTurma(Turma turma, Aluno[] aluno) {
		if(turma != null) {
			for(int i = 0;  i < aluno.length; i++){
				turma.aluno[i] = null;
				aluno[i].turma = null;
			}
		}else {
			System.out.println("Turma não pode ser vazia!");
		}
	}
	public void alterarLocalTurma(Turma turma, String local) {
		if(turma != null) {
			turma.setLocal(local);
		}else {
			System.out.println("Turma não pode ser vazia!");
		}
	}
	public void deletarTurma(Turma[] turma) {
		if(turma != null) {
			for(int i = 0; i < turma.length; i++) {
				Professor professor = turma[i].professor;
				
				if(turma[i].aluno != null) {
					Aluno[] aluno = turma[i].aluno;
				}
				
				professor.turma[i] = null;
				aluno.turma[i] = null;
				
				turma[i] = null;
			}
		}else {
			System.out.println("Turma não pode ser vazia!");
		}
	}
	public Turma[] buscarTurma(Professor[] professor) {
		return professor.turma;
	}*/
}
