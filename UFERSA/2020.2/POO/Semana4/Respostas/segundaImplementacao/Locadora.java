import java.util.Calendar;

class Locadora {
	public static void main(String[] args) {
		// atributos escritos entre aspas simples '' significa que são opcionais, segundo os construtores

		// titulo, genero, numeroPaginas, numeroExemplares, 'numeroEmprestimos', 'numeroDiasAlugado'
		// anoLancamento, valorAluguel
		Livro livro1 = new Livro("oi", "romance", 150, 4, 2010, 12);
		Livro livro2 = new Livro("em", "acao", 220, 1, 2018, 26);
		// titulo, nomeBanda, estilo, numeroExemplares, 'numeroEmprestimos', 'numeroDiasAlugado'
		// anoLancamento, valorAluguel
		Disco disco1 = new Disco("ola", "ssd", "pagode", 15, 2, 28, 2018, 8.80f);
		
		// nome, cpf, endereco, 'email', 'telefone'
		Cliente cliente1 = new Cliente("joao", "19315322061", "rua 1",
			"123abc@gmail.com", "(84) 3000-0000");
		
		// login, senha, nome, cpf, endereco, 'email', 'telefone'
		Usuario usuario1 = new Usuario("jose123", "abc123", "jose", "324.281.100-39",
			"rua 2", "abc@gmail.com", "(84) 1234-5678");
		// login, senha, nome, cpf, endereco, 'email', 'telefone'
		Funcionario funcionario1 = new Funcionario("a", "vcdf", "Menino",
			"072.325.480-01", "rua 3", "a@hotmail.com", "(84) 0000-0000");
		// login, senha, nome, cpf, endereco, 'email', 'telefone'
		Gerente gerente1 = new Gerente("gen", "asds", "aaaa", "327.886.720-39",
			"rua 4", "gen@gmail.com", "(84) 99999-9999");
		
		Emprestimo emprestimo1 = new Emprestimo();

		// https://www.tutorialspoint.com/java/util/calendar_setfield4
		// create a calendar
		Calendar cal = Calendar.getInstance();

		// print current time
		//System.out.println("Current year is :" + cal.getTime());

		// Livro
		System.out.println("Titulo: " + livro1.getTitulo());
		System.out.println("Genero: " + livro1.getGenero());
		System.out.println("Numero de paginas: " + livro1.getNumeroPaginas());
		System.out.println("Numero de exemplares: " + livro1.getNumeroExemplares());
		System.out.println("Numero de emprestimos: " + livro1.getNumeroEmprestimos());
		System.out.println("Numero de dias alugado: " + livro1.getNumeroDiasAlugado());
		System.out.println("Ano de lancamento: " + livro1.getAnoLancamento());
		System.out.println("Valor do aluguel: " + livro1.getValorAluguel());

		System.out.println();

		// Disco
		System.out.println("Titulo: " + disco1.getTitulo());
		System.out.println("Nome da banda: " + disco1.getNomeBanda());
		System.out.println("Estilo: " + disco1.getEstilo());
		System.out.println("Numero de exemplares: " + disco1.getNumeroExemplares());
		System.out.println("Numero de emprestimos: " + disco1.getNumeroEmprestimos());
		System.out.println("Numero de dias alugado: " + disco1.getNumeroDiasAlugado());
		System.out.println("Ano de lancamento: " + disco1.getAnoLancamento());
		System.out.println("Valor do aluguel: " + disco1.getValorAluguel());

		System.out.println();

		// Cliente
		System.out.println("Nome: " + cliente1.getNome());
		System.out.println("CPF: " + cliente1.getCpf());
		System.out.println("Endereco: " + cliente1.getEndereco());
		System.out.println("Email: " + cliente1.getEmail());
		System.out.println("Telefone: " + cliente1.getTelefone());
		if (cliente1.getLivro() != null) {
			System.out.println("Livros: ");

			for (int x = 0; x < cliente1.getLivro().length; x++) {
				System.out.println();
			}
		}
		
		System.out.println();

		// Usuário
		System.out.println("Login: " + usuario1.getLogin());
		System.out.println("Senha: " + usuario1.getSenha());
		System.out.println("Nome: " + usuario1.getNome());
		System.out.println("CPF: " + usuario1.getCpf());
		System.out.println("Endereco: " + usuario1.getEndereco());
		System.out.println("Email: " + usuario1.getEmail());
		System.out.println("Telefone: " + usuario1.getTelefone());

		System.out.println();

		// Funcionário
		System.out.println("Login: " + funcionario1.getLogin());
		System.out.println("Senha: " + funcionario1.getSenha());
		System.out.println("Nome: " + funcionario1.getNome());
		System.out.println("CPF: " + funcionario1.getCpf());
		System.out.println("Endereco: " + funcionario1.getEndereco());
		System.out.println("Email: " + funcionario1.getEmail());
		System.out.println("Telefone: " + funcionario1.getTelefone());

		System.out.println();

		// Gerente
		System.out.println("Login: " + gerente1.getLogin());
		System.out.println("Senha: " + gerente1.getSenha());
		System.out.println("Nome: " + gerente1.getNome());
		System.out.println("CPF: " + gerente1.getCpf());
		System.out.println("Endereco: " + gerente1.getEndereco());
		System.out.println("Email: " + gerente1.getEmail());
		System.out.println("Telefone: " + gerente1.getTelefone());

		System.out.println();

		// Empréstimo
		System.out.print("Faturamento: R$");
		System.out.printf("%.2f", Emprestimo.getFaturamento());
		System.out.println();

		// https://www.tutorialspoint.com/java/util/calendar_setfield4
		// set the year,month and day to something else
		cal.set(2050, 5, 25, 04, 15, 20);
		
		emprestimo1.setDataDevolucao(cal);
		System.out.println("Data de devolucao: " + emprestimo1.getDataDevolucao().getTime());
		
		// livro, quantidade, cliente, dataDevolucao
		emprestimo1.alugarLivro(livro1, 2, cliente1, cal);

		System.out.print("Faturamento: R$");
		System.out.printf("%.2f", Emprestimo.getFaturamento());
		System.out.println();

		System.out.println();

		// Livro
		System.out.println("Titulo: " + livro1.getTitulo());
		System.out.println("Genero: " + livro1.getGenero());
		System.out.println("Numero de paginas: " + livro1.getNumeroPaginas());
		System.out.println("Numero de exemplares: " + livro1.getNumeroExemplares());
		System.out.println("Numero de emprestimos: " + livro1.getNumeroEmprestimos());
		System.out.println("Numero de dias alugado: " + livro1.getNumeroDiasAlugado());
		System.out.println("Ano de lancamento: " + livro1.getAnoLancamento());
		System.out.println("Valor do aluguel: " + livro1.getValorAluguel());

		System.out.println();

		emprestimo1.alugarLivro(livro2, 1, cliente1, cal);

		System.out.println("Titulo: " + livro2.getTitulo());
		System.out.println("Genero: " + livro2.getGenero());
		System.out.println("Numero de paginas: " + livro2.getNumeroPaginas());
		System.out.println("Numero de exemplares: " + livro2.getNumeroExemplares());
		System.out.println("Numero de emprestimos: " + livro2.getNumeroEmprestimos());
		System.out.println("Numero de dias alugado: " + livro2.getNumeroDiasAlugado());
		System.out.println("Ano de lancamento: " + livro2.getAnoLancamento());
		System.out.println("Valor do aluguel: " + livro2.getValorAluguel());

		if (cliente1.getLivro() != null) {
			System.out.println("Livros: ");
			for (int x = 0; x < cliente1.getLivro().length; x++) {
				System.out.println(cliente1.getLivro()[x].getTitulo());
			}
		}
	}
}
