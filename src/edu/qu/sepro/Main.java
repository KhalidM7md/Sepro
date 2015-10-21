package edu.qu.sepro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.qu.entities.Comment;
import edu.qu.entities.POS;
import edu.qu.helpers.ExcelHandler;
import edu.qu.helpers.POSTagger;

public class Main {

	private final static String path = "data//AJA_5000_Annotated_310815.xls";
	private final static String adjectiveTag = "JJ";
	
	public static void main(String[] args) {
	
		//read comments from excel 
	try {
		long starttime = Calendar.getInstance().getTimeInMillis();
		ArrayList<Comment> array = POSTagger.tagPOS(ExcelHandler.ReadFromExcel(path));
		ArrayList<POS>  posContainer = new ArrayList<POS>();
			
		posContainer = POSExtractor(array, adjectiveTag);
		for(POS pos : posContainer)
		{
			if(pos.getNegative()>1)
			{
				System.out.println(pos.getPosText()+" : "+pos.getNegative());
			}
			
			for(POS pos1 : posContainer)
			{
				if(pos.getPosText().equalsIgnoreCase(pos1.getPosText()))
				{
					System.out.println(pos.getPosText());
				}
				
			}
		}
		
			
		
		
	
		System.out.println((Calendar.getInstance().getTimeInMillis()-starttime)/1000);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	
	
	
		
		
	}

	
	public static boolean IfPOSExist(ArrayList<POS> array, String pos)
	{
		for(POS p : array)
		{
			if(p.getPosText().equalsIgnoreCase(pos))
			{
				return true;
			}
		}
		
		return false; 
	}
	
	public static ArrayList<POS> POSExtractor(ArrayList<Comment> array, String posCode)
	{
		ArrayList<POS> posArray = new ArrayList<POS>();
		
		for(Comment cmnt : array)
		{
			String word[] = cmnt.getText().split(" ");
			
			for(int i=0;i<word.length;i++)
			{

				
				if(word[i].contains(posCode) && !IfPOSExist(posArray, word[i]))
				{
					
					POS pos = new POS();
					pos.setPosType(posCode);
					
						if(cmnt.getSentiment().equalsIgnoreCase("positive"))
						{
							pos.setPositive(pos.getPositive()+1);
							
						}else if(cmnt.getSentiment().equalsIgnoreCase("negative"))
						{
							pos.setNegative(pos.getNegative()+1);
							
						}else if(cmnt.getSentiment().equalsIgnoreCase("neutral"))
						{
							pos.setNeurtral(pos.getNeurtral()+1);
						}
					
					pos.setPosText(word[i]);
					
					posArray.add(pos);
				}
				
			}
	
		}
		
		
		return posArray;
		
	}
}
