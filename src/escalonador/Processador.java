package escalonador;

public abstract class Processador {
	protected int tempoExecucao = 0;
	
	protected abstract void executar(Processo p);
	protected abstract Processo getProximoProcesso(FilaProcessos f);
	
	public void executar(FilaProcessos prontos, FilaProcessos finalizados) {
		Processo p = prontos.getFila().get(0);

		if (this.tempoExecucao < p.getTempoInicial())
			this.tempoExecucao = p.getTempoInicial();
		
		while (!prontos.vazia()) {
			
			p = this.getProximoProcesso(prontos);
			
			prontos.remove(p);

			this.executar(p);		
			
			if (p.finalizado())
				finalizados.insere(p);
			else
				prontos.insere(p);
		}
	}
	
}
