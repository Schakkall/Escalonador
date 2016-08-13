package escalonador;

public abstract class Processador {
	protected boolean impressaoHabilitada = false;
	protected int tempoExecucao = 0;

	protected abstract void executar(Processo p);

	protected abstract Processo escalonar(FilaProcessos f);

	protected final void imprimirExecucao(Processo p, int quantum) {
		if (impressaoHabilitada)
			System.out.println("Rodar processo [" + p.getId() + "] de [" + this.tempoExecucao + "] ate ["
					+ (this.tempoExecucao + quantum) + "]");
	}

	private void prepararNovos(FilaProcessos novos, FilaProcessos prontos) {
		while ((novos.cabeca() != null) && (novos.cabeca().getTempoInicial() <= this.tempoExecucao)) {
			prontos.insere(novos.remove());
		}
	}

	private void descartarTempoOcioso(FilaProcessos novos) {
		Processo p = novos.cabeca();
		this.tempoExecucao = (this.tempoExecucao < p.getTempoInicial() ? p.getTempoInicial() : 0);
	}

	public void executar(FilaProcessos novos, FilaProcessos prontos, FilaProcessos finalizados) {
		this.descartarTempoOcioso(novos);
		this.prepararNovos(novos, prontos);

		Processo p;
		while (!(prontos.vazia() && novos.vazia())) {
			p = this.escalonar(prontos);

			if (p != null) {
				prontos.remove(p);
				this.executar(p);
				this.prepararNovos(novos, prontos);
				if (p.finalizado())
					finalizados.insere(p);
				else
					prontos.insere(p);
			} else {
				this.descartarTempoOcioso(novos);
				this.prepararNovos(novos, prontos);
			}
		}
	}

}
