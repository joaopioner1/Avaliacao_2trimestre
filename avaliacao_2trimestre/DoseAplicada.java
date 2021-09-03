package avaliacao_2trimestre;

import java.time.LocalDate;

public class DoseAplicada {
	//Autores: JOAO VITOR PIONER $ VITOR HUGO SEHN | 02/09/2021
	
	//Atributos
	private final String fabricante;
	private final LocalDate dataAplicacao;
	
	//Construtor
	public DoseAplicada(String fabricante, LocalDate dataAplicacao) {
		this.fabricante = fabricante;
		this.dataAplicacao = dataAplicacao;
	}
	
	//Getters
	public String getFabricante() {
		return fabricante;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	//equals
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!o.getClass().isInstance(this)) {
			return false;
		}
		if (o == this) {
			return true;
		}
		DoseAplicada doseAp = (DoseAplicada) o;
		if (this.dataAplicacao == null && doseAp.dataAplicacao != null) {
			return false;
		}
		else if (!dataAplicacao.equals(doseAp.dataAplicacao))
			return false;
		if (this.fabricante == null && doseAp.fabricante != null) {
			return false;
		}
		else if (!fabricante.equals(doseAp.fabricante))
			return false;
		return true;
	}
}
