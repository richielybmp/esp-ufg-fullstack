/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunoinf_2
 */
public class Cidade {

	private int codigo;
	private String nome;
	private String siglaEstado;
	private int numVeiculos;
	private int numAcidentes;

	public Cidade(int codigo, String nome, String sigla, int numVeiculos, int numAcidentes) {
		this.codigo = codigo;
		this.nome = nome;
		this.siglaEstado = sigla;
		this.numVeiculos = numVeiculos;
		this.numAcidentes = numAcidentes;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSigla() {
		return this.siglaEstado;
	}

	public int getNumVeiculos() {
		return this.numVeiculos;
	}

	public int getNumAcidentes() {
		return this.numAcidentes;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.siglaEstado = sigla;
	}

	public void setNumVeiculos(int numVeiculos) {
		this.numVeiculos = numVeiculos;
	}

	public void setNumAcidenetes(int numAcidentes) {
		this.numAcidentes = numAcidentes;
	}

}
