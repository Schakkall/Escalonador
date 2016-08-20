package escalonador;
/**
 * Implementação de algoritmos de escalonamento 
 * 
 * @author  J. Eurique C. Ribeiro Jr
 * @author  Guilherme Boroni Pereira
 */

public class Main {

	public static void main(String[] args) {
		// Arquivo do lote se encontra junto aos arquivos do projeto
		String lote = "lote.txt";

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
		novos = new FilaProcessos(processos);		
		finalizados = new FilaProcessos();
		CPU.executar(novos, finalizados);
		finalizados.imprimirTempos("RR");
	}
}
