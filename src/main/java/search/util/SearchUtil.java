
package search.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import search.matchstrategy.MatchStrategyEnum;
import search.model.ProgrammingLanguage;

/**
 * Parses json file step by step, so if will be a HUGE json file,
 * program will not throw a OutOfMemoryError or StackOverflowError
 * 
 * @author Raman Skaskevich
 * */
public class SearchUtil
{
	public static List<ProgrammingLanguage> findObjectsThatContainsTokens(List<String> searchTokens,
			String matchStrategy, String jsonFilePath) throws IOException
	{
		List<ProgrammingLanguage> results = new ArrayList<>();
		FileInputStream fis = new FileInputStream(jsonFilePath);

		JsonFactory jf = new JsonFactory();
		JsonParser jp = jf.createParser(fis);
		jp.setCodec(new ObjectMapper());
		jp.nextToken();
		jp.nextToken();
		while (jp.hasCurrentToken())
		{
			ProgrammingLanguage pl = jp.readValueAs(ProgrammingLanguage.class);

			if (pl != null && MatchStrategyEnum.fromValue(matchStrategy).getStrategy().match(pl,
					searchTokens))
			{
				results.add(pl);
			}

			jp.nextToken();
		}
		Collections.sort(results, new ProgrammingLanguageSearchComparator(searchTokens));
		return results;
	}
}
