
		
 //Não consegui fazer 3.6 e 3.8
		 


package testePratico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Principal {
	public static void main(String[] args) {
		List<Funcionario> listaFunc = criarListaFuncionarios();

		System.out.println("---------Remoção do Funcionário João----------\n");
		removerFuncionario(listaFunc, "João");

		System.out.println("---------Lista de Funcionários da Empresa----------\n");
		imprimirFuncionarios(listaFunc);

		aplicarAumentoSalario(listaFunc, new BigDecimal("0.10"));

		System.out
				.println("\n---------Os funcionários que fazem aniversário no mês de outubro ou dezembro:----------\n");
		imprimirAniversariantes(listaFunc);


		System.out.println("\n---------O funcionário de maior idade----------\n");
		imprimirMaiorIdade(listaFunc);

		System.out.println("\n---------Funcionários em Ordem alfabética----------\n");
		ordenarFuncionariosPorNome(listaFunc);

		System.out.println("\n---------Total do salário de todos os Funcionários----------\n");
		imprimirTotalSalarios(listaFunc);

		System.out.println("\n----------Salário mínimo de cada Funcionário---------------------\n");

		imprimirSalariosMinimos(listaFunc);
	}

	private static List<Funcionario> criarListaFuncionarios() {
		List<Funcionario> listaFunc = new ArrayList<>();

		Funcionario func1 = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador");
		Funcionario func2 = new Funcionario("João", LocalDate.of(1990, 05, 12), new BigDecimal("2284.38"), "Operador");
		Funcionario func3 = new Funcionario("Caio", LocalDate.of(1961, 05, 02), new BigDecimal("9836.14"),
				"Coordenador");
		Funcionario func4 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"),
				"Diretor");
		Funcionario func5 = new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal("2234.68"),
				"Recepcionista");
		Funcionario func6 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"),
				"Operador");
		Funcionario func7 = new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal("4071.84"),
				"Contador");
		Funcionario func8 = new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal("3017.45"), "Gerente");
		Funcionario func9 = new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), new BigDecimal("1606.85"),
				"Eletricista");
		Funcionario func10 = new Funcionario("Helena", LocalDate.of(1996, 9, 02), new BigDecimal("2799.93"), "Gerente");

		// adiciono os objetos numa lista
		listaFunc.add(func1);
		listaFunc.add(func2);
		listaFunc.add(func3);
		listaFunc.add(func4);
		listaFunc.add(func5);
		listaFunc.add(func6);
		listaFunc.add(func7);
		listaFunc.add(func8);
		listaFunc.add(func9);
		listaFunc.add(func10);

		return listaFunc;
	}

	private static void removerFuncionario(List<Funcionario> listaFunc, String nome) {
		if (listaFunc.removeIf(funcionario -> funcionario.getNome().equals(nome))) {
			System.out.println("Funcionário removido com sucesso!!\n\n");
		} else {
			System.out.println("Funcionário não removido. Certifique-se de que o nome está correto.\n\n");
		}
	}

	private static void imprimirFuncionarios(List<Funcionario> listaFunc) {
		int i = 0;

		for (Funcionario funcionario : listaFunc) {

			System.out.printf("FUNCIONÁRIO %d\n\n", (i + 1));

			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Data de nascimento: " + formatarData(funcionario.getDataNascimento()));
			System.out.println("Salário: " + formatarNumero(funcionario.getSalario()));
			System.out.println("Função: " + funcionario.getFuncao());

			System.out.println("-----------------------------------");
			i++;

		}
	}

	private static void aplicarAumentoSalario(List<Funcionario> listaFunc, BigDecimal multiplicador) {

		for (Funcionario funcionario : listaFunc) {

			funcionario.setSalario(((funcionario.getSalario()).multiply(multiplicador)).add(funcionario.getSalario()));
		}
	}

	private static void imprimirAniversariantes(List<Funcionario> listaFunc) {
		for (Funcionario funcionario : listaFunc) {

			if (funcionario.getDataNascimento().getMonthValue() == 10
					| funcionario.getDataNascimento().getMonthValue() == 12) {

				System.out.println(funcionario.getNome() + ", Mês " + funcionario.getDataNascimento().getMonthValue());
			}

		}
	}

	private static void imprimirMaiorIdade(List<Funcionario> listaFunc) {
		int maiorIdade = 0;
		int i1 = 0;

		for (; i1 < listaFunc.size() - 1; i1++) {

			LocalDate atual = LocalDate.now(); // pego data atual
			int idadeAtual = Period.between(listaFunc.get(i1).getDataNascimento(), atual).getYears();

			if (idadeAtual > maiorIdade) {
				maiorIdade = idadeAtual;
			}

		}

		System.out.println(listaFunc.get(i1).getNome() + " Com " + maiorIdade + " Anos de idade");
	}

	private static void ordenarFuncionariosPorNome(List<Funcionario> listaFunc) {
		listaFunc.sort(Comparator.comparing(Funcionario::getNome));

		for (Funcionario funcionario : listaFunc) {

			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Data de nascimento: " + formatarData(funcionario.getDataNascimento()));
			System.out.println("Salário: " + formatarNumero(funcionario.getSalario()));
			System.out.println("Função: " + funcionario.getFuncao());

			System.out.println("-----------------------------------");

		}
	}

	private static void imprimirTotalSalarios(List<Funcionario> listaFunc) {
		BigDecimal totalSalario = new BigDecimal("0");

		for (Funcionario funcionario : listaFunc) {

			totalSalario = totalSalario.add(funcionario.getSalario());

		}

		System.out.println(formatarNumero(totalSalario));
	}

	private static void imprimirSalariosMinimos(List<Funcionario> listaFunc) {
		for (Funcionario funcionario : listaFunc) {
			BigDecimal quantSalaMin = funcionario.getSalario().divide(new BigDecimal("1212.00"), 0, RoundingMode.FLOOR);
			System.out.println(
					"O funcionário " + funcionario.getNome() + " ganha " + quantSalaMin + " Salário(s) Mínimo");
		}

	}

	private static String formatarData(LocalDate data) { // Não sabia usar essa função, pesquisei na internet
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatter);
	}

	private static String formatarNumero(BigDecimal numero) { // Não sabia usar essa função tbm
		NumberFormat formatoNumero = new DecimalFormat("#,##0.00");
		return formatoNumero.format(numero);
	}

}