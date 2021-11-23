package InputOutput;

import java.io.*;
import java.util.*;

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
		ArrayList<NomeEta> nomeEta= new ArrayList();
	    NomeEta end = new NomeEta("test",10);
		//TODO: Risolvere possibili problemi in fase di output !
		try 
		  {
			/*
			ObjectInputStream in =
					new ObjectInputStream ( new BufferedInputStream (
					new FileInputStream (this.nomeFile )));
			
			nomeEta = (ArrayList<NomeEta>)in.readObject();
			*/
			
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.nomeFile)));
			int i=0;
			while( ! (end == null)) {
				 nomeEta.add((NomeEta)ois.readObject());
				 end = new NomeEta(nomeEta.get(i).getNome() , nomeEta.get(i).getEta());
				 i++;
			}
		  }
		
		catch(EOFException eof) 
		 {
			return nomeEta;
		 }
		
		catch(FileNotFoundException ee) 
		{
			System.out.println("FILE NON TROVATO O FILE VUOTO");
			System.out.println(ee);
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
	  daConfrontare = registro.getRegistro();
//    Legge le vecchie modifiche del file	  
	  ArrayList<NomeEta> originale = this.leggiDaFile();  

	  int check = 0;
	  

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
	

	// TODO LUCA: RIVEDERE QUESTO METODO
//  Ritorna true se il file è vuoto , ovvero se non contiene alcun oggetto di tipo NomeEta;
//  ritorna false in ogni altro caso
	public boolean isEmpty() 
	{
		if(this.leggiDaFile().isEmpty()) return true;
		return false;
	}

}
