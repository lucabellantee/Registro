package Gestione;

import java.io.Serializable;

public class NomeEta implements Serializable {
	
	private String nome;
	private int et�;
	
	public NomeEta(String nome , int eta) 
	{
	  this.nome = nome;
	  this.et� = et�;
	}
	
	
	public String getNome() { return this.nome; }
	public int getEta() { return this.et�; }
	
	
	public void setEta(int et�) { this.et� = et�; }
	
	public String toString() { return "NOME: " + this.getNome() + "   ETA': " + this.getEta(); }

}
