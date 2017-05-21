
package search.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import search.model.ProgrammingLanguage;
import search.util.SearchUtil;

/**
 * 
 * @author Raman Skaskevich
 * */
@RestController
public class SearchApplicationController
{
	@Value("${filePath}")
	private String jsonFilePath;
	
	
	@GetMapping("/search")
	public ResponseEntity<?> search(
			@RequestParam(value = "searchString", required = true) String name,
			@RequestParam(value = "matchStrategy", required = true) String matchStrategy,
			Model model) throws IOException
	{
		List<ProgrammingLanguage> results = SearchUtil
				.findObjectsThatContainsTokens(Arrays.asList(name.split(" ")), matchStrategy, jsonFilePath);

		return ResponseEntity.ok(results);
	}

}
