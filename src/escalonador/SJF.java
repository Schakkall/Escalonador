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
	
	public  Processo getProximoProcesso(FilaProcessos f){
		int menor = 99999;
		Processo result = null;
		for (Processo p : f.getFila()) {
			if (p.getTempoInicial() <= this.tempoExecucao){
				if (p.getTempoDuracao() < menor){
					result = p;
					menor = p.getTempoDuracao();
				}
			}
		}
		return result;
	}
	
}
