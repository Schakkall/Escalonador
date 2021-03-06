package escalonador;

public class Processo {
	private int id;
	private int tempoInicial = -1;
	private int tempoDuracao = -1;
	private int tempoExecutado = 0;
	private int tempoEspera = 0;
	private int tempoRetorno = 0;
	private int tempoResposta = 0;	
	private boolean jaRespondido = false;

	public Processo(String strProcesso, int id) {
		String[] strProParts = strProcesso.split(" ");
		this.tempoInicial = Integer.parseInt(strProParts[0]);
		this.tempoDuracao = Integer.parseInt(strProParts[1]);
		this.id = id;
		this.tempoExecutado = 0;
		this.tempoEspera = 0;
		this.tempoRetorno = 0;
		this.tempoResposta = 0;			
		this.jaRespondido = false;
	}

	public Processo() {
	}

	public static Processo copiar(Processo p) {
		Processo result = new Processo();
		result.setId(p.getId());
		result.setTempoDuracao(p.getTempoDuracao());
		result.setTempoInicial(p.getTempoInicial());
		result.setTempoEspera(p.getTempoEspera());
		result.setTempoExecutado(p.getTempoExecutado());
		result.setTempoResposta(p.getTempoResposta());
		result.setTempoRetorno(p.getTempoRetorno());
		result.setJaRespondido(p.isJaRespondido());
		return result;
	}

	public Processo(int tempoInicial, int tempoDuracao, int id) {
		this.id = id;
		this.tempoInicial = tempoInicial;
		this.tempoDuracao = tempoDuracao;
		this.tempoExecutado = 0;
		this.tempoEspera = 0;
		this.tempoRetorno = 0;
		this.tempoResposta = 0;			
		this.jaRespondido = false;		
	}

	public boolean equals(Processo p) {
		return this.id == p.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(int tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public int getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(int tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	public int getTempoExecutado() {
		return tempoExecutado;
	}

	public void setTempoExecutado(int tempoExecutado) {
		this.tempoExecutado = tempoExecutado;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	public boolean finalizado() {
		return this.tempoExecutado >= this.tempoDuracao;
	}

	public int getTempoRetorno() {
		return tempoRetorno;
	}

	public void setTempoRetorno(int tempoRetorno) {
		this.tempoRetorno = tempoRetorno;
	}

	public int getTempoResposta() {
		return (jaRespondido) ? tempoResposta : -1;
	}

	public void setTempoResposta(int tempoResposta) {
		if (!jaRespondido) {
			this.jaRespondido = true;
			this.tempoResposta = tempoResposta;
		}
	}

	public boolean isJaRespondido() {
		return jaRespondido;
	}

	private void setJaRespondido(boolean jaRespondido) {
		this.jaRespondido = jaRespondido;
	}	
}
