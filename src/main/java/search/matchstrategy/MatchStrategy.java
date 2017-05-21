package search.matchstrategy;

import java.util.List;

import search.model.ProgrammingLanguage;

/**
 * Strategy of finding fields that satisfies search criteria.
 * 
 * @author Raman Skaskevich
 * */
public interface MatchStrategy
{
	public boolean match(ProgrammingLanguage pl, List<String> searchTokens);
}
