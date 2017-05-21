package search.matchstrategy.impl;

import java.util.List;

import search.matchstrategy.MatchStrategy;
import search.model.ProgrammingLanguage;

/**
 * Implementation of {@link MatchStrategy}
 * 
 * @author Raman Skaskevich
 * */
public class ExactMatchStrategy implements MatchStrategy
{

	@Override
	public boolean match(ProgrammingLanguage pl, List<String> searchTokens)
	{
		boolean nameMatches = containsAllTokens(pl.getName(), searchTokens);
		boolean typeMatches = containsAllTokens(pl.getType(), searchTokens);
		boolean authorsMatches = containsAllTokens(pl.getDesignedBy(), searchTokens);
		
		return nameMatches || typeMatches || authorsMatches;
	}
	
	private boolean containsAllTokens(String fieldValue, List<String> searchTokens)
	{
		boolean contains = true;
		for(String token: searchTokens)
		{
			if(!fieldValue.contains(token))
			{
				contains = false;
			}
		}
		
		return contains;
	}

}
