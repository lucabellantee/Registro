package Principale;

import java.util.*;
import java.io.*;
import Gestione.*;
import InputOutput.*;
import InputOutput.File;

// TODO : Controllare vari input

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<NomeEta> nomeEta = new ArrayList();
		RegistroEtaCompleto registro = new RegistroEtaCompleto(nomeEta);
		
// C:\\Users\\lucab\\Desktop\\EclipseProgetti\\Registro\\prova.txt	
		System.out.println("Inserire nome file in un formato corretto: ");
		String nomeFile = input.nextLine();
		File file = new File(nomeFile);
		
		
		
// ************************ CARICO DATI PRE-ESISTENTI DA FILE**********************************
        if(!file.isEmpty()) 
        {
      	  for(NomeEta s : file.leggiDaFile()) 
      	  {
      		  registro.addElemento(s);
      	  }
      	  System.out.println("Carico dei dati da file effettuato con successo !");
			  System.out.println("");
			  System.out.println("");
        }
        
        else
        	System.out.println("Il file è vuoto !");
//*********************** FINE CARICO DATI PRE-ESISTENTI DA FILE**********************************
		

        
		int scelta = -1;
		boolean exit = true; 
		
		
		do 
		{
			System.out.println("               MENU: ");
			System.out.println("1) Per aggiungere uno studente");
			System.out.println("2) Per rimuovere uno studente");
			System.out.println("3) Per visualizzare il registro");
			System.out.println("4) Per incrementare l'età di uno studente");
			System.out.println("5) Per salvare i dati");
			System.out.println("6) Per uscire dal programma");
			
			
			  boolean controllo;
			  do {   
				  controllo = true;
			      try {
			    	   scelta = input.nextInt();;
			          }
			     catch(InputMismatchException ie) 
			          {
			    	    input.nextLine();
				        System.out.println("Non puoi inserire caratteri !");
				        controllo = false;
			          }
			     }while(!controllo);
			  
			  
		              
              
			  switch(scelta) 
			  {
			    case 1: 	
			    	   input.nextLine();
			    	   System.out.println("Inserisci il nome: ");
			    	   String daInserire = input.nextLine();
			    	   if(registro.findElemento(daInserire)) 
			    	   {
			    		   System.out.println("Studente gia presente nel registro !");
			    		   break;
			    	   }
			    	   //input.nextLine();
			    	   System.out.println("Inserisci l'età: ");
			    	   int eta = input.nextInt();
			    	   NomeEta studente = new NomeEta(daInserire,eta);
			    	   if(registro.addElemento(studente)) 
			    		   System.out.println("Studente aggiunto con successo !");
			    	   else
			    		   System.out.println("Errore durante l'operazione di aggiunta !");
			    	   
			    	   break;
			    
			    case 2:
			    	   if(registro.isEmpty()) 
			    	   {
			    		   System.out.println("Non puoi rimuovere uno studente sè la lista è vuota !");
			    		   break;
			    	   }
			    	  
			    	   input.nextLine();
			    	   System.out.println("Chi vuoi rimuovere? ");
			    	   String daRimuovere = input.nextLine();
			    	   
			    	   if(registro.removeElemento(daRimuovere)) 
			    	   {
			    		   System.out.println("Studente rimosso con successo !");
			    		   break;
			    	   }
			    	   
			    	   System.out.println("Non puoi rimuovere " + daRimuovere + " perchè non è presente nel registro");
			
			    	   break;
			    
			    case 3:
			    	   if(registro.isEmpty()) 
			    	   {
			    		   System.out.println("Il registro è vuoto, non puoi visualizzare nulla !");
			    		   break;
			    	   }
			    	   
			    	   for(String s : registro.listaStudenti()) 
			    	   {
			    		   System.out.println(s);
			    	   }
			    	   
			    	   break;
			    
			    case 4:
			    	   if(registro.isEmpty()) 
			    	   {
			    		   System.out.println("Non ci sono studenti quindi non puoi incrementare l'età !");
			    		   break;
			    	   }
			    	   
			    	   input.nextLine();
			    	   System.out.println("Di chi vuoi incrementare l'età? ");
			    	   String daIncrementare = input.nextLine();
			    	   
			    	   if(registro.incrementaEta(daIncrementare))
			    		   System.out.println("Età incrementata con successo !");
			    	   else
			    		   System.out.println("Non puoi incrementare l'età se lo studente non è presente in lista");
			    	   
			    	   break;
			    
			    case 5:
			    	   file.scriviSuFile(registro);
			    	   System.out.println("Salvataggio effettuato con successo !");
			    	   break;
			    
			    case 6:
			    	   if(!file.checkNoModifiche(registro)) 
			    	   {
			    		   System.out.println("ATTENZIONE ! Salva il file prima di uscire !");
			    		   break;
			    	   }
			           exit = false; 
			    	   break;
			  }
			  
			  System.out.println("");
			  System.out.println("");
			  System.out.println("");
			  
		}while(exit);
		
		
		System.out.println("Arrivederci , a presto !");

	}

}
