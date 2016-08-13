package escalonador;

public class SJF extends Processador {

	public void executar(Processo p){
		p.setTempoEspera(this.tempoExecucao - p.getTempoInicial());
		p.setTempoExecutado(p.getTempoDuracao());
		p.setTempoRetorno(this.tempoExecucao + p.getTempoDuracao() - p.getTempoInicial());
		p.setTempoResposta(this.tempoExecucao - p.getTempoInicial());
	
		this.imprimirExecucao(p, p.getTempoDuracao());
		
		this.tempoExecucao += p.getTempoDuracao();
	}
	
	public  Processo escalonar(FilaProcessos f){
		int menor = Integer.MAX_VALUE;
		Processo result = null;
		for (Processo p : f.getFila()) {
			if (p.getTempoDuracao() < menor){
				result = p;
				menor = p.getTempoDuracao();
			}
		}
		return result;
	}	
}
