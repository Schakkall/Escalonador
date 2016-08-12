package escalonador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FilaProcessos {
	protected List<Processo> fila;

	public static final int TEMPO_ESPERA = 1;

	public FilaProcessos() {
		this.fila = new LinkedList<>();
	}

	public FilaProcessos(String arquivo) {
		this.fila = new LinkedList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			for (int i = 0; br.ready(); i++) {
				String linha = br.readLine();
				this.fila.add(new Processo(linha, i));
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao carregar o arquivo de processos");
		}

	}

	public void insere(Processo p) {
		this.fila.add(p);
	}

	public Processo remove() {
		return this.fila.remove(0);
	}

	public boolean vazia() {
		return this.fila.isEmpty();
	}

	public void imprimrTempos(String algoritmo) {
		/*
		 * Tempo de espera: somat�rio dos tempos de espera (Obs: Da entrada na
		 * fila at� in�cio da execu��o) Tempo de espera m�dio: m�dia aritm�tica
		 * dos tempos de espera de todos os processos
		 */
		/*
		 * Tempo de resposta: tempo gasto desde a entrada na fila at� a primeira
		 * execu��o Tempo de resposta m�dio: m�dia aritm�tica dos tempos de
		 * resposta de todos os processos
		 */
		/*
		 * Tempo de retorno: tempo gasto desde in�cio do processo at� sua
		 * finaliza��o Tempo de retorno m�dio: m�dia aritm�tica dos tempos de
		 * retorno de todos os processos
		 */
		
		float esperaTotal = 0;
		float retornoTotal = 0;
		float respostaTotal = 0;

		for (Processo p : this.fila) {
			esperaTotal += p.getTempoEspera();
			retornoTotal += p.getTempoRetorno();
			respostaTotal += p.getTempoResposta();
		}
		System.out.println(algoritmo + " " + retornoTotal / this.fila.size() + " " + respostaTotal / this.fila.size()
				+ " " + esperaTotal / this.fila.size());

	}
}
