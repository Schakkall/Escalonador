package escalonador;

public class Main {

	public static void main(String[] args) {
		String lote = "F:\\WorkSpace\\Escalonamento\\lote.txt";

		Processador CPU;
		FilaProcessos novos;
		FilaProcessos processos;
		FilaProcessos finalizados;
		
		processos = new FilaProcessos(lote);
		
		CPU = new FCFS();
		novos = new FilaProcessos(processos);
		finalizados = new FilaProcessos();
		CPU.executar(novos, finalizados);
		finalizados.imprimirTempos("FCFS");

		CPU = new SJF();
		novos = new FilaProcessos(processos);
		finalizados = new FilaProcessos();
		CPU.executar(novos, finalizados);
		finalizados.imprimirTempos("SJF");

		CPU = new RR(2);
		finalizados = new FilaProcessos();
		novos = new FilaProcessos(processos);
		CPU.executar(novos, finalizados);
		finalizados.imprimirTempos("RR");
	}

}
