package escalonador;

public abstract class Processador {
	protected int tempoExecucao = 0;
	
	protected abstract void executar(Processo p);
	
	public void executar(FilaProcessos prontos, FilaProcessos finalizados) {
		Processo p;
		//this.tempoExecucao = 0;
		while (!prontos.vazia()) {
			p = prontos.remove();
			
			if (this.tempoExecucao < p.getTempoInicial())
				this.tempoExecucao = p.getTempoInicial();
				
			this.executar(p);		
			
			if (p.finalizado())
				finalizados.insere(p);
			else
				prontos.insere(p);
		}
	}
	
}
