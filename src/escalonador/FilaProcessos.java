package escalonador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FilaProcessos {
	protected List<Processo> fila;

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
	
	public void remove(Processo p) {
		int cont = 0;
		for (Processo processo : fila) {
			if (p.getId() == processo.getId()){
				this.fila.remove(cont);
				break;
			}
			cont++;
		}
	}

	public boolean vazia() {
		return this.fila.isEmpty();
	}

	
	public List<Processo> getFila() {
		return fila;
	}


	public void setFila(List<Processo> fila) {
		this.fila = fila;
	}


	public void imprimrTempos(String algoritmo) {
		/*
		 * Tempo de espera: somatório dos tempos de espera (Obs: Da entrada na
		 * fila até início da execução) Tempo de espera médio: média aritmética
		 * dos tempos de espera de todos os processos
		 */
		/*
		 * Tempo de resposta: tempo gasto desde a entrada na fila até a primeira
		 * execução Tempo de resposta médio: média aritmética dos tempos de
		 * resposta de todos os processos
		 */
		/*
		 * Tempo de retorno: tempo gasto desde início do processo até sua
		 * finalização Tempo de retorno médio: média aritmética dos tempos de
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
