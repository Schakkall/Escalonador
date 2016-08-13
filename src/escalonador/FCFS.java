package escalonador;

public class FCFS extends Processador {

	public void executar(Processo p){
		p.setTempoEspera(this.tempoExecucao - p.getTempoInicial());
		p.setTempoExecutado(p.getTempoDuracao());
		p.setTempoRetorno(this.tempoExecucao + p.getTempoDuracao() - p.getTempoInicial());
		p.setTempoResposta(this.tempoExecucao - p.getTempoInicial());
		
		this.imprimirExecucao(p, p.getTempoDuracao());
		
		this.tempoExecucao += p.getTempoDuracao();
	}	
	
	public  Processo escalonar(FilaProcessos f){
		return f.getFila().get(0);
	}
}
