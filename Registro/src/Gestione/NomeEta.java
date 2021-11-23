package Gestione;

import java.io.Serializable;

public class NomeEta implements Serializable {
	
	private String nome;
	private int età;
	
	public NomeEta(String nome , int eta) 
	{
	  this.nome = nome;
	  this.età = età;
	}
	
	
	public String getNome() { return this.nome; }
	public int getEta() { return this.età; }
	
	
	public void setEta(int età) { this.età = età; }
	
	public String toString() { return "NOME: " + this.getNome() + "   ETA': " + this.getEta(); }

}
