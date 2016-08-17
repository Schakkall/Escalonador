package escalonador;

public class RR extends Processador {

	private int quantum = 1;

	public RR(int quantum) {
		super();
		this.quantum = quantum;
	}

	public void executar(Processo p) {
		int tempQuantum = (this.quantum > (p.getTempoDuracao() - p.getTempoExecutado()))
				? (p.getTempoDuracao() - p.getTempoExecutado()) : this.quantum;

		p.setTempoEspera(this.tempoExecucao - p.getTempoInicial() - p.getTempoExecutado());
		p.setTempoExecutado(p.getTempoExecutado() + tempQuantum);
		p.setTempoRetorno(p.getTempoExecutado() + p.getTempoEspera());
		p.setTempoResposta(this.tempoExecucao - p.getTempoInicial());

		this.imprimirExecucao(p, tempQuantum);

		this.tempoExecucao += tempQuantum;
	}

	public Processo escalonar(FilaProcessos f) {
		return f.getCabeca();
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
}
