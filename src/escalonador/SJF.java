package escalonador;

public class SJF extends Processador {

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
	

	private FilaProcessos organizarProcessos(){
		return null;
	}
}
