package edu.qu.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import edu.qu.entities.Comment;

public class ExcelHandler {

	public static void main(String args[])
	{
		try {
			ReadFromExcel("C:\\Users\\Khalid\\Google Drive\\Qatar University\\Thesis\\8. Data\\1. Arabic\\1. AJA (ISIS)\\CrowdFlower V2.0\\AJA_5000_Annotated_310815.xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Comment> ReadFromExcel(String path) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(path));
		
		HSSFWorkbook wb = new HSSFWorkbook(file);
		HSSFSheet sheet = wb.getSheetAt(1);
		
		ArrayList<Comment> cmntArray = new ArrayList<Comment>();
		
		Iterator<Row> ri = sheet.iterator();
		Row rw;
		
		//skip the first entry (i.e. table headers)
		ri.next();
		
		while(ri.hasNext())
		{
			
			rw = ri.next();
			
			Comment cmnt = new Comment();
			cmnt.setID(rw.getCell(1).toString());
			
			//System.out.println(cmnt.getID());
			if(rw.getCell(2).toString().equalsIgnoreCase("false"))
			{
				cmnt.setIsItTestQuestion(false);
			}else if(rw.getCell(2).toString().equalsIgnoreCase("true"))
			{
				cmnt.setIsItTestQuestion(true);
			}
			
			try{
				
				// setting cmnt object to the numeric value of cell 4, casted to int from double.
				cmnt.setNoOfAnnotators((int)rw.getCell(4).getNumericCellValue());
				
			}catch(NumberFormatException e)
			{
				
			}
			
							
		
				//setting the sentiment to the string value of cell 7 (skipping cell no 3)
				cmnt.setSentiment(rw.getCell(7).getStringCellValue());
				
				
				//setting the confidence score from cell 8
				cmnt.setConfidenceScore(rw.getCell(8).getNumericCellValue());
					

			
			//setting the comment text from cell 9
			cmnt.setText(rw.getCell(10).getStringCellValue());
			

			try
			{
			
				//setting dislikes from cell 10
				cmnt.setDislikes((int)rw.getCell(10).getNumericCellValue());
				//setting likes from cell 11
				cmnt.setLikes((int)rw.getCell(11).getNumericCellValue());
				
			}catch(Exception e)
			{
				//do nothing
			}
			
			//setting the page URL 
			cmnt.setPageURL(rw.getCell(14).toString());
			
			//setting page title string from cell 15 
			cmnt.setPageTitle(rw.getCell(15).toString());
			
			
			
			//finally adding cmnt object to array 
			cmntArray.add(cmnt);

			
		}
		
		
		
		System.out.println(cmntArray.size());
		
		return cmntArray; 
	}
	
	public void WriteToExcel(ArrayList<Comment> commentsList)
	{
		
	}
	
	
	
}
