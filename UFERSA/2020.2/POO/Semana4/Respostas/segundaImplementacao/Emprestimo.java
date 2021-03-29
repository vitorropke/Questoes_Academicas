import java.util.Calendar;

class Emprestimo {
	// Variáveis
	private static float	faturamento = 0;
	private Calendar		dataEmprestimo;
	private Calendar		dataDevolucao;

	// Getters e Setters
	public static float getFaturamento() {
		return Emprestimo.faturamento;
	}
	public static void setFaturamento(float faturamento) {
		Emprestimo.faturamento = faturamento;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		Calendar dataAtual = Calendar.getInstance();
		// Obtem a data atual

		if (dataEmprestimo.after(dataAtual)) {
			System.out.println("Data de empréstimo não pode ser no futuro!");
		} else {
			this.dataEmprestimo = dataEmprestimo;
		}
	}
	
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Calendar dataDevolucao) {
		Calendar dataAtual = Calendar.getInstance();
		// Obtem a data atual

		if (dataDevolucao.after(dataAtual)) {
			this.dataDevolucao = dataDevolucao;
		} else {
			System.out.println("Data de devolucao so pode ser no futuro!");
		}
	}
	
	// Métodos
	public void alugarLivro(Livro livro, int quantidade, Cliente cliente, Calendar dataDevolucao) {
		Calendar dataAtual = Calendar.getInstance();
		// Obtem a data atual

		if (quantidade <= livro.getNumeroExemplares()) {
			// Verifica se existe quantidade suficiente de livros

			// Adiciona o livro no cliente
			if (cliente.getLivro() != null) {
				// Se o clientes tiver livros

				Livro[] livros = new Livro[(cliente.getLivro().length) + 1];
				// Cria o vetor de livros com espaço para o novo livro

				for (int x = 0; x < livros.length - 1; x++) {
					livros[x] = cliente.getLivro()[x];
					// Coloca os livros existentes no vetor de livros
				}

				livros[(livros.length) - 1] = livro;
				// Coloca o novo livro no final do vetor de livros

				cliente.setLivro(livros);
				// Coloca o vetor no atributo 'livro' do cliente
			} else {
				// Se o clientes não tiver livros

				Livro[] livros = new Livro[1];
				// Cria o vetor de livros

				livros[0] = livro;
				// Coloca o livro no vetor

				cliente.setLivro(livros);
				// Coloca o vetor no atributo 'livro' do cliente
			}
			
			livro.setNumeroExemplares((livro.getNumeroExemplares()) - quantidade);
			// Diminui a quantidade de livros disponíveis
			
			livro.setNumeroEmprestimos((livro.getNumeroEmprestimos()) + 1);
			// Adiciona ao número de empréstimos desse livro

			Emprestimo.setFaturamento(getFaturamento() + ((livro.getValorAluguel()) * quantidade));
			// Adiciona ao faturamento geral

			setDataEmprestimo(dataAtual);
			setDataDevolucao(dataDevolucao);
			// Define a data de empréstimo e de devolução
		} else {
			System.out.println("Sem livros suficientes!");
		}
	}
	/*
	public void devolverLivro(Livro[] livro, int[] quantidade, Cliente cliente) {
		for (int x = 0; x < livro.length(); x++) {
			livro[x].numeroExemplares = livro[x].numeroExemplares + quantidade[x];
		}
		cliente.livro = livro;
	}

	public void alugarDisco(Disco[] disco, int[] quantidade, Cliente cliente) {
		for (int x = 0; x < disco.length(); x++) {
			disco[x].numeroExemplares = disco[x].numeroExemplares - quantidade[x];
		}
		cliente.disco = disco;
	}

	public void devolverDisco(Disco[] disco, int[] quantidade, Cliente cliente) {
		for (int x = 0; x < disco.length(); x++) {
			disco[x].numeroExemplares = disco[x].numeroExemplares + quantidade[x];
		}
		cliente.disco = disco;
	}
*/
	/*
	public void gerarRelatorio(Calendar dataInicio, Calendar dataFim) {
		
	}

	public void gerarRelatorioCliente(Cliente cliente, Calendar dataInicio, Calendar dataFim) {
		
	}
	*/
}
