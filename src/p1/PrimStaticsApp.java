package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class PrimStaticsApp {
	
	static final Integer[] ind= {1,3,7,9};
	
	public static int getLastDigit(int number)
	{
		return number%10;
	}
	
	public static void afficheStats2D(Map<Integer, CoupleStats> statsArray)
	{
		float proba;
		CoupleStats valeur ; 
		System.out.println("|From/to\t| 1\t| 3\t| 7\t| 9\t|");
		System.out.println("-----------------------------------------------");
		for (int i = 0; i < ind.length; i++) {
			System.out.print("|"+ind[i]+"\t\t");
			for (int j = 0; j < ind.length; j++) {
				valeur = statsArray.get(Indice.getIdIndice(ind[i], ind[j]) );
				proba = valeur.getCptPrimes() /valeur.getCptNbr() *100;
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.HALF_UP);
				System.out.print("| "+df.format(proba)+"\t");
			}
			System.out.println("\n-----------------------------------------------");
		}
	}
	
	public static void afficheStats(Map<Integer, CoupleStats> statsArray) {
		
		for(Entry<Integer, CoupleStats> entry : statsArray.entrySet()) {
		    Indice cle = Indice.ValueOf(entry.getKey());
		    CoupleStats valeur = entry.getValue();
		    float proba = (valeur.getCptPrimes() /valeur.getCptNbr()) *100;
		    System.out.println(cle + " : " + proba);
		}
	}
	
	public static void incLigne(Integer idcLgn , Map<Integer, CoupleStats> statsArray)
	{
		for (int i = 0; i < ind.length; i++) {
			statsArray.get( Indice.getIdIndice(idcLgn, ind[i] ) ).incrCptGlobal();
		}
	}
	
	
	public static void initMap(Map<Integer, CoupleStats> statsArray)
	{
		for (int i = 0; i < ind.length; i++) {
			for (int j = 0; j < ind.length; j++) {
				statsArray.put( Indice.getIdIndice(ind[i], ind[j]), new CoupleStats(0,0)) ;
			}
		}
	}
	
	public static void getStats(String fileName) throws NumberFormatException, IOException
	{
		
		Integer number, prevNumber;
		String st; 
		File file = new File(fileName); 
		BufferedReader br = new BufferedReader(new FileReader(file));
		Map<Integer, CoupleStats> statsArray= new TreeMap<Integer, CoupleStats>();
		
		//init matrice		
		
		initMap(statsArray);
		
		//Traitement
		
		prevNumber = 1;
		while ((st = br.readLine()) != null)
		{
			number = Integer.valueOf(st);
			if(number>=7) {
				
				statsArray.get(Indice.getIdIndice( getLastDigit(prevNumber), getLastDigit(number) ) 
						).incrCptprimes();
				incLigne(getLastDigit(prevNumber), statsArray);
				prevNumber = number;
			}
			
		}
		br.close();
		
		afficheStats2D(statsArray);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getStats("primes.txt"); 
	}

}
