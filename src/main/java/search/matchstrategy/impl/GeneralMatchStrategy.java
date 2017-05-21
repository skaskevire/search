package search.matchstrategy.impl;

import java.util.List;

import search.matchstrategy.MatchStrategy;
import search.model.ProgrammingLanguage;

/**
 * Implementation of {@link MatchStrategy}
 * 
 * @author Raman Skaskevich
 * */
public class GeneralMatchStrategy  implements MatchStrategy
{

	@Override
	public boolean match(ProgrammingLanguage pl, List<String> searchTokens)
	{
		if (pl != null)
		{
			for (String token : searchTokens)
			{
				if (!token.isEmpty() && (pl.getDesignedBy().contains(token)
						|| pl.getName().contains(token) || pl.getType().contains(token)))
				{
					return true;
				}
			}
		}
		return false;
	}



}
