package edu.qu.helpers;

import java.util.ArrayList;
import java.util.Random;

//import gpl.pierrick.brihaye.aramorph.AraMorph;
//import gpl.pierrick.brihaye.aramorph.lucene.ArabicGlossAnalyzer;
import edu.qu.entities.Comment;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class POSTagger {

	public static final String arabicTaggerPath = "libraries//models//arabic-train.tagger";

	
	public static ArrayList<Comment> tagPOS(ArrayList<Comment> array)
	{

		
		MaxentTagger tagger = new MaxentTagger(arabicTaggerPath);
		
		for(Comment cmnt : array)
		{
			//1.get the cmnt text
			//2.get POS tags
			//3.set the text
			cmnt.setText(tagger.tagString(cmnt.getText()));
		}
		
		

	
		return array;
		
	}

}
