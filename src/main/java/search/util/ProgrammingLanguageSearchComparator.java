
package search.util;

import java.util.Comparator;
import java.util.List;

import search.model.ProgrammingLanguage;

/**
 * Performs comparison of two programming language objects. 
 *  Language which contains more matches with search terms is greater.
 * 
 * @author Raman Skaskevich
 * */
public class ProgrammingLanguageSearchComparator implements Comparator<ProgrammingLanguage>
{
	List<String> tokens;

	ProgrammingLanguageSearchComparator(List<String> tokens)
	{
		this.tokens = tokens;
	}

	@Override
	public int compare(ProgrammingLanguage o1, ProgrammingLanguage o2)
	{
		int numO1 = numberOfConsidedWords(o1);
		int numO2 = numberOfConsidedWords(o2);
		if(numO1 == numO2)
		{
			return 0;
		}
		else
		{
			return numberOfConsidedWords(o1) > numberOfConsidedWords(o2) ? -1 : 1;
		}		
	}
	
	private int numberOfConsidedWords(ProgrammingLanguage pl)
	{
		int count = 0;
		for(String token : tokens)
		{
			if (pl.getDesignedBy().contains(token)
					|| pl.getName().contains(token) || pl.getType().contains(token))
			{
				count++;
			}
		}
		
		return count;
	}

}
