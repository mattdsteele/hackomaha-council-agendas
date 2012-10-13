package hackomaha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.util.Span;

public class AgendaItem {

	public Map<String, List<String>> map = new HashMap<String, List<String>>();
	public String[] sentences;

	public AgendaItem(String text) {
		map.put("addresses", new ArrayList<String>());
		map.put("names", new ArrayList<String>());
		map.put("companies", new ArrayList<String>());

		SentenceDetector detector = new SentenceDetector();
		TokenizerME tokenizer = new TokenizerME(
				Builder.tokenizerModel("resources/en-token.bin"));
		NameFinderME nameFinder = new NameFinderME(
				Builder.tokenNameFinderModel("resources/en-ner-person.bin"));

		// NameFinderME locationFinder = new NameFinderME(
		// Builder.tokenNameFinderModel("resources/en-ner-location.bin"));

		sentences = detector.getSentences(text);

		for (String sentence : sentences) {

			String[] words = tokenizer.tokenize(sentence);

			Span[] nameSpans = nameFinder.find(words);
			// Span[] locationSpans = locationFinder.find(words);

			List<String> namesList = map.get("names");
			for (Span span : nameSpans) {
				String[] spanWords = Arrays.copyOfRange(words, span.getStart(),
						span.getEnd());
				namesList.add(join(spanWords));
			}
		}

	}

	private String join(String[] spanWords) {
		StringBuilder result = new StringBuilder();
		for (String word : spanWords) {
			if (result.length() > 0) {
				result.append(" ");
			}
			result.append(word);
		}
		return result.toString();
	}
}
