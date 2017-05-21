
package search.matchstrategy;

import search.matchstrategy.impl.ExactMatchStrategy;
import search.matchstrategy.impl.GeneralMatchStrategy;

/**
 * Enum with {@link MatchStrategy}
 * 
 * @author Raman Skaskevich
 * */
public enum MatchStrategyEnum
{
	EXACT_MATCH_STRATEGY(new ExactMatchStrategy(), "exactMatchStrategy"), GENERAL_MATCH_STRATEGY(
			new GeneralMatchStrategy(), "generalMatchStrategy");
	private MatchStrategy strategy;
	private String name;

	MatchStrategyEnum(MatchStrategy strategy, String name)
	{
		this.strategy = strategy;
		this.name = name;
	}

	public MatchStrategy getStrategy()
	{
		return strategy;
	}
	
	public static MatchStrategyEnum fromValue(String arg)
	{
		for(MatchStrategyEnum value : MatchStrategyEnum.values())
		{
			if(value.getName().equals(arg))
			{
				return value;
			}
		}
		
		return null;
	}

	public String getName()
	{
		return name;
	}
}
