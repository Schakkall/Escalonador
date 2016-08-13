package escalonador;

public class Main {

	public static void main(String[] args) {
		String lote = "F:\\WorkSpace\\Escalonamento\\lote.txt";
		
		Processador CPU = new FCFS();
		FilaProcessos prontos = new FilaProcessos(lote);
		FilaProcessos finalizados = new FilaProcessos();
		CPU.executar(prontos, finalizados);
		finalizados.imprimrTempos("FCFS");


		CPU = new SJF();
		prontos = new FilaProcessos(lote);
		finalizados = new FilaProcessos();
		CPU.executar(prontos, finalizados);
		finalizados.imprimrTempos("SJF");

	}

}
