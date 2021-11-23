package Gestione;

import java.io.Serializable;
import java.util.ArrayList;

public class RegistroEtaCompleto implements Serializable{
	
	ArrayList<NomeEta> nomeEta = new ArrayList();
	
	
	public RegistroEtaCompleto(ArrayList<NomeEta> nomeEta) 
	{
	  this.nomeEta = nomeEta;	
	}
	
//  Ritorna true se quella persona è presente nel registro, in ogni altro caso ritorna false	
	public boolean findElemento(String daCercare) 
	{
	   for(NomeEta n : nomeEta) 
	   {
		   if(n.getNome().equals(daCercare)) return true;
	   }
	   
	   return false; 
	}
	


// La funzione ritornerà -1 se la persona non è presente nel elenco !
	public int getIndice(String daCercare) 
	{
		if(this.findElemento(daCercare)) 
		{      
			   int i=0;
			   for(NomeEta n : nomeEta) 
			   {
				   if(n.getNome().equals(daCercare)) return i;
				   i++; 
			   }
			   
			   
		}
		
		return -1;
	}
	
	
	public ArrayList<NomeEta> getRegistro(){ return nomeEta; }
	
	
	
	
// Ritorna true e aggiunge quella persona se è solo la persona non è gia presente nel file 	
	public boolean addElemento(NomeEta persona) 
	{
		if(!this.findElemento(persona.getNome())) 
		{
			this.nomeEta.add(persona);
			return true;
		}
		
		return false;
	}
	

	
//  Se l'elemento da rimuovere è presente in lista, lo rimuove e torna TRUE , altrimenti torna FALSE
	public boolean removeElemento(String daRimuovere) 
	{
		if(this.findElemento(daRimuovere)) 
		{
			this.getRegistro().remove(this.getIndice(daRimuovere));
			return true;
		}
		
		return false; 
	}
	

	
//  Incrementa di 1 l'età e ritorna true se la persona è presente nella lista, 
//  ritorna false in ogni altro caso
	public boolean incrementaEta(String daModificare) 
	{
		if(this.findElemento(daModificare)) 
		{
			this.getRegistro().get(this.getIndice(daModificare)).setEta(this.getRegistro().get(this.getIndice(daModificare)).getEta() + 1);
			return true;
		}
		
		return false;
	}
	
	
//  Ritorna l'ArrayList String con tutte le informazioni 
	public ArrayList<String> listaStudenti()
	{
	    ArrayList<String> info = new ArrayList();
	    
	    for(NomeEta n : this.getRegistro()) 
	      {
	    	 info.add(n.toString());
	      }
	    
	    return info; 
	}
	

	
//  Ritorna true se il registro è vuoto , false in ogni altro caso
	public boolean isEmpty() 
	{
		if(this.getRegistro().isEmpty()) return true;
		return false; 
	}


}
