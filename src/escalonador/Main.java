package escalonador;

public class Main {

	public static void main(String[] args) {
		String lote = "F:\\WorkSpace\\Escalonamento\\lote.txt";

		Processador CPU;
		FilaProcessos novos;
		FilaProcessos prontos;
		FilaProcessos finalizados;

		CPU = new FCFS();
		novos = new FilaProcessos(lote);
		prontos = new FilaProcessos();
		finalizados = new FilaProcessos();
		CPU.executar(novos, prontos, finalizados);
		finalizados.imprimirTempos("FCFS");

		CPU = new SJF();
		novos = new FilaProcessos(lote);
		prontos = new FilaProcessos();
		finalizados = new FilaProcessos();
		CPU.executar(novos, prontos, finalizados);
		finalizados.imprimirTempos("SJF");

		CPU = new RR(2);
		novos = new FilaProcessos(lote);
		prontos = new FilaProcessos();
		finalizados = new FilaProcessos();
		CPU.executar(novos, prontos, finalizados);
		finalizados.imprimirTempos("RR");
	}

}
