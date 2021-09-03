package avaliacao_2trimestre;

import java.time.LocalDate;
import java.util.ArrayList;

public class TesteVacinacao {
	static double nota =0;
	static void printaGrupoTeste(ArrayList<Boolean> testes, String titulo, double peso) {
		System.out.print("conjunto de testes - "+titulo+": ");
		int acertos =0;
		for(boolean teste: testes) {
			if(teste) {
				System.out.print("o");
				acertos++;
			}
			else System.out.print("x");
		}
		double notaGrupo = acertos*peso/testes.size();
		System.out.println(" - "+acertos+"/"+testes.size()+"("+notaGrupo+")");
		nota+=notaGrupo;
	}
	public static void main(String[] args) {
		ArrayList<Boolean> t1 = new ArrayList<>();	//cria conjunto de testes 1: testa Pessoa
		ArrayList<Boolean> t2 = new ArrayList<>();  //cria conjunto de testes 2: testa vacinas
		ArrayList<Boolean> t3 = new ArrayList<>();  //cria conjunto de testes 3: testa equals e toString
		
		Pessoa tony = new Pessoa("Tony Stark", 50);
		Pessoa cap = new Pessoa("Steve Rogers",100);			//cap é mto velho pq ele lutou na segunda guerra! hehe
		Pessoa professor = new Pessoa("Charles Xavier", 59);
		
		t1.add(tony.isGrupoPrioritario()==false);				//tony n é grupo prioritário
		t1.add(cap.isGrupoPrioritario()==true);					//cap é grupo prioritário pois tem 60 ou mais
		t1.add(professor.isGrupoPrioritario()==false);			//professor x ainda não grupo prioritário

		cap.setGrupoPrioritario(false);							//cap não pode ser tirado do grupo prioritário por causa da idade
		professor.setGrupoPrioritario(true);					//professores entrando no grupo de prioritário! hehe
		t1.add(professor.isGrupoPrioritario()==true);
		t1.add(cap.isGrupoPrioritario()==true);				
		t1.add(cap.getIdade()==100);							//teste getIdade
		t1.add(cap.getNome().equals("Steve Rogers"));			//teste getNome
		t1.add(cap.getPrimeiraDose()==cap.getSegundaDose()		//nao vacinado, primeira e segunda doses sao null
				&&cap.getPrimeiraDose()==null);
		
		String saida  = "Steve Rogers (100 anos) - vacina covid: ";
		t3.add(cap.toString().equals(saida+"nao vacinado"));					//teste toString sem vacina
		
		t2.add(cap.vacina("Coronavac", LocalDate.of(2021, 3, 10))==true); 		//consegue vacinar 
		
		t2.add(professor.vacina("Coronavac", LocalDate.of(2021, 3, 10))==true);	//consegue vacinar 	
		t2.add(cap.vacina("Janssen")==false); 									//nao consegue vacinar Janssen de segunda dose
		t2.add(cap.vacina("Coronavac")==true);									//consegue vacinar 
		t2.add(tony.vacina("Janssen")==true);									//consegue vacinar 
		t2.add(tony.vacina("Astrazeneca")==false);								//nao consegue vacinar 
		DoseAplicada janssen = tony.getPrimeiraDose();
		t2.add(janssen.getFabricante().equals("Janssen")==true);
		LocalDate dt = janssen.getDataAplicacao();
		t2.add(dt.equals(LocalDate.now()));
		
		t3.add(tony.toString().equals("Tony Stark (50 anos) - vacina covid: dose 1: Janssen"));	//teste toString com uma vacina
		t3.add(cap.toString().equals(saida+"dose 1: Coronavac, dose 2: Coronavac"));			//teste toString com duas vacinas
		t3.add(cap.getPrimeiraDose().equals(professor.getPrimeiraDose())==true); //mesmo fabricante e data
		t3.add(cap.getSegundaDose().equals(professor.getPrimeiraDose())==false); //mesmo fabricante e datas diferentes
		t3.add(cap.getSegundaDose().equals(tony.getPrimeiraDose())==false);   	 //mesma data e fabricantes diferentes
		
		
		printaGrupoTeste(t1, "Pessoa", 2 ); 					//o --> acerto, x --> erro
		printaGrupoTeste(t2, "DoseAplicada", 2 ); 				//o --> acerto, x --> erro
		printaGrupoTeste(t3, "toString e equals", 3 ); 			//o --> acerto, x --> erro
		System.out.println("Nota Parcial: "+nota+"/7");
	}
}
