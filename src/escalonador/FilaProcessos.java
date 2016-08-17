package escalonador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FilaProcessos {
	protected LinkedList<Processo> fila;

	public FilaProcessos() {
		this.fila = new LinkedList<>();
	}
	
	public FilaProcessos(FilaProcessos f) {
		this.fila = new LinkedList<>();
		for (Processo processo : f.fila) {
			this.fila.add(processo);
		}
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
		this.ordenarPorTempoInicial();
	}

	public void insere(Processo p) {
		this.fila.addLast(p);
	}

	public Processo remove() {
		return (!this.fila.isEmpty()) ? this.fila.removeFirst() : null;
	}

	public Processo getCabeca() {
		return (!this.fila.isEmpty()) ? this.fila.getFirst() : null;
	}

	public void remove(Processo p) {
		this.fila.remove(p);
	}

	public boolean vazia() {
		return this.fila.isEmpty();
	}

	public List<Processo> getFila() {
		return fila;
	}
	
	public final void ordenarPorTempoInicial(){
		Comparator<Processo> comparador = (p1, p2) -> {
			return Integer.compare(p1.getTempoInicial(), p2.getTempoInicial());
		};
		this.fila.sort(comparador);//Isso aqui é um mergesort
	}

	public void imprimirTempos(String algoritmo) {
		/*
		 * Tempo de espera: tempo gasto aguardando ser processado.(Obs: Da
		 * entrada na fila até o final da execução). Tempo de espera médio:
		 * média aritmética dos tempos de espera de todos os processos na fila
		 */
		/*
		 * Tempo de resposta: tempo gasto desde a entrada na fila até a primeira
		 * execução. Tempo de resposta médio: média aritmética dos tempos de
		 * resposta de todos os processos na fila
		 */
		/*
		 * Tempo de retorno: tempo gasto desde início do processo até sua
		 * finalização. Tempo de retorno médio: média aritmética dos tempos de
		 * retorno de todos os processos na fila
		 */

		float esperaTotal = 0;
		float retornoTotal = 0;
		float respostaTotal = 0;

		for (Processo p : this.fila) {
			esperaTotal += p.getTempoEspera();
			retornoTotal += p.getTempoRetorno();
			respostaTotal += p.getTempoResposta();
		}

		int qtd = this.fila.size();

		System.out.printf("%s %.1f %.1f %.1f\n", algoritmo, retornoTotal / qtd, respostaTotal / qtd, esperaTotal / qtd);
	}

}
