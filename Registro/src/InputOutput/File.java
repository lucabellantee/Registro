package InputOutput;

import java.io.*;
import java.util.ArrayList;

import Gestione.*;

// throw IOException
public class File  {
	
	private String nomeFile;
	
	public File(String nomeFile) 
	{
		this.nomeFile = nomeFile;
	}
	
	public String getNome() { return this.nomeFile; }
	
	
	
	public ArrayList<NomeEta> leggiDaFile()
	{
		ArrayList<NomeEta> nomeEta = new ArrayList();
		//TODO: Risolvere possibili problemi in fase di output !
		try 
		  {
			ObjectInputStream in =
					new ObjectInputStream ( new BufferedInputStream (
					new FileInputStream (this.nomeFile )));
			
			nomeEta = (ArrayList<NomeEta>)in.readObject();
		  }
		
		catch(ClassNotFoundException c) 
		  {
			System.out.println("Mancano oggetti nel file, attenzione ! ");
		  }
		catch(IOException e) 
		  {
			System.out.println("ERRORE NELLA LETTURA DEL FILE !");
			System.out.println(e);
		  }
		
	  return nomeEta;
	}
	
	
	
	
	public void scriviSuFile( RegistroEtaCompleto registro) 
	{
	   try 
	    {
		  ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(this.nomeFile))); 
	      
		  for(NomeEta s : registro.getRegistro()) out.writeObject(s);
		  
		  out.close();
	    }
	   catch(IOException e) 
	    {
		   System.out.println("ERRORE NELLA SCRITTURA DEL FILE !");
		   System.out.println(e);
	    }
	}
	

	
	
//  Ritorna true , se e solo sè, non ho effettuato alcuna modifica su mio registro
	public boolean checkNoModifiche(RegistroEtaCompleto registro) 
	{
	  ArrayList<NomeEta> daConfrontare = new ArrayList();
//    Legge le vecchie modifiche del file	  
	  ArrayList<NomeEta> originale = this.leggiDaFile();  

	  int check = 1;
	  
	  
	  
//    Vuol dire che ci saranno state delle aggiunte o delle rimozioni
      if(daConfrontare.size() != originale.size()) return false; 
	  
      for(int i=0 ; i<daConfrontare.size() ; i++) 
      {
    	  if(daConfrontare.get(i).getNome().equals(originale.get(i).getNome()) && daConfrontare.get(i).getEta() == originale.get(i).getEta())
             check++;
      }
      
      if(originale.size() == check) return true;
      
      return false; 
	}
	

	
//  Ritorna true se il file è vuoto , ovvero se non contiene alcun oggetto di tipo NomeEta;
//  ritorna false in ogni altro caso
	public boolean isEmpty() 
	{
		if(this.leggiDaFile().isEmpty()) return true;
		return false;
	}

}
