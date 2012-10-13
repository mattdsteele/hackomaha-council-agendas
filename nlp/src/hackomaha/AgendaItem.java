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
		List<String> namesList = new ArrayList<String>();
		List<String> orgsList = new ArrayList<String>();

		SentenceDetectorME detector = Builder.sentenceDetector();
		TokenizerME tokenizer = Builder.tokenizer();
		NameFinderME nameFinder = Builder.nameFinder();
		NameFinderME orgFinder = Builder.orgFinder();

		this.sentences = detector.sentDetect(text);

		for (String sentence : this.sentences) {
			String[] words = tokenizer.tokenize(sentence);

			for (Span span : nameFinder.find(words)) {
				namesList.add(rebuildSpan(words, span));
			}
			for (Span span : orgFinder.find(words)) {
				orgsList.add(rebuildSpan(words, span));
			}

		}

		this.map.put("names", namesList);
		this.map.put("companies", orgsList);
	}

	private String rebuildSpan(String[] words, Span span) {
		String[] spanWords = Arrays.copyOfRange(words, span.getStart(),
				span.getEnd());
		return join(spanWords);
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
