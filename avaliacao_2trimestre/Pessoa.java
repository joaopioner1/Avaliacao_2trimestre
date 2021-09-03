package avaliacao_2trimestre;

import java.time.LocalDate;

public class Pessoa {
	// Autores: JOAO VITOR PIONER $ VITOR HUGO SEHN | 02/09/2021

	// Atributos
	private final String nome;
	private final int idade;
	private boolean grupoPrioritario;
	private DoseAplicada primeiraDose;
	private DoseAplicada segundaDose;

	// Construtor
	public Pessoa(String nome, int idade) {
		if (idade >= 60) grupoPrioritario = true;
		else grupoPrioritario = false;
		this.nome = nome;
		this.idade = idade;
		this.primeiraDose = null;
		this.segundaDose = null;
	}

	// Getters & Setters
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public DoseAplicada getPrimeiraDose() {
		return primeiraDose;
	}

	public DoseAplicada getSegundaDose() {
		return segundaDose;
	}

	public boolean isGrupoPrioritario() {
		return grupoPrioritario;
	}

	public void setGrupoPrioritario(boolean grupoPrioritario) {
		if (this.idade < 60)
			this.grupoPrioritario = grupoPrioritario;
	}

	// Metodos
	public boolean vacina(String fabricante, LocalDate data) {
		if (primeiraDose != null && primeiraDose.getFabricante().equals("Janssen")) {
			return false;
		}
		else if (primeiraDose != null && segundaDose != null) {
			return false;
		}
		else if (primeiraDose != null && fabricante.equals("Janssen")) {
			return false;
		}
		else {
			if (primeiraDose == null) {
				primeiraDose =  new DoseAplicada(fabricante, data);
			}
			else if (segundaDose == null) {
				segundaDose =  new DoseAplicada(fabricante, data);
			}
			return true;
		}
	}

	public boolean vacina(String fabricante) {
		LocalDate ld = LocalDate.now();
		if (vacina(fabricante, ld)) {
			return true;
		} else return false;
	}

	@Override
	public String toString() {
		String retorna = "";
		if (this.primeiraDose == null) {
			retorna = String.format("%s (%d anos) - vacina covid: nao vacinado", this.nome, this.idade);
		}
		else if (this.segundaDose == null) {
			retorna = String.format("%s (%d anos) - vacina covid: dose 1: %s", this.nome, this.idade,
					this.primeiraDose.getFabricante());
		}
		else {
			retorna = String.format("%s (%d anos) - vacina covid: dose 1: %s, dose 2: %s", this.nome, this.idade,
					this.primeiraDose.getFabricante(), this.segundaDose.getFabricante());
		}
		return retorna;
	}

}
