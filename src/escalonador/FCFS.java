package escalonador;

public class FCFS extends Processador {

	public void executar(Processo p){
		p.setTempoEspera(this.tempoExecucao - p.getTempoInicial());
		p.setTempoExecutado(p.getTempoDuracao());
		p.setTempoRetorno(this.tempoExecucao + p.getTempoDuracao() - p.getTempoInicial());
		p.setTempoResposta(this.tempoExecucao - p.getTempoInicial());
		/*
		System.out.println("Rodar processo ["+ p.getId() +"] de ["+ this.tempoExecucao +"] ate ["+ 
				(this.tempoExecucao + p.getTempoDuracao()) +"]");
		*/
		
		this.tempoExecucao += p.getTempoDuracao();
	}	
	
	public  Processo getProximoProcesso(FilaProcessos f){
		return f.getFila().get(0);
	}
}
