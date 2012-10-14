package hackomaha;

import java.util.Arrays;

import junit.framework.Assert;
import junit.framework.TestCase;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.util.Span;

import org.junit.Test;

public class TestFoo extends TestCase {

	@Test
	public void testMaxent() {
		POSModel model = Builder.posModel("resources/en-pos-maxent.bin");

		POSTaggerME tagger = new POSTaggerME(model);

		String words[] = ("6. Ord. to approve a PUD-Planned Unit Development Overlay District "
				+ "in a R7-Medium-Density Multiple-Family Residential District located "
				+ "East of 99th Street and South of Redick Avenue, to approve the Development Plan, "
				+ "and to provide for an effective date - see attached.  ((PUBLIC HEARING TODAY – CAN BE PASSED TODAY))")
				.split(" ");
		String tags[] = tagger.tag(words);

		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i] + " -> " + tags[i]);
		}
	}

	@Test
	public void testLocation() {
		NameFinderME nameFinder = new NameFinderME(
				Builder.tokenNameFinderModel("resources/en-ner-location.bin"));
		String[] tokens = { "Pierre", "Morgan", "is", "61", "yesars", "old",
				".", "1500", "N", "49th", "St", ",", "Omaha", ",", "NE",
				"68104" };
		Span[] spans = nameFinder.find(tokens);
		for (Span span : spans) {
			System.out.print(span + ": ");
			for (String word : Arrays.copyOfRange(tokens, span.getStart(),
					span.getEnd())) {
				System.out.print(word);
			}
			System.out.println();
		}
	}

	@Test
	public void testSentence() {
		SentenceDetectorME detector = new SentenceDetectorME(
				Builder.sentenceModel("resources/en-sent.bin"));
		String[] sentences = detector
				.sentDetect(" This is the first sentence. This, however, is the second sentence! And the third? ");
		Assert.assertEquals(3, sentences.length);
		Assert.assertEquals(sentences[0], "This is the first sentence.");
		Assert.assertEquals(sentences[1],
				"This, however, is the second sentence!");
		Assert.assertEquals(sentences[2], "And the third?");
	}

	@Test
	public void testNameFinder() {
		NameFinderME nameFinder = new NameFinderME(
				Builder.tokenNameFinderModel("resources/en-ner-person.bin"));
		String sentence[] = new String[] { "Pierre", "Vinken", "is", "61",
				"years", "old", "." };

		Span nameSpans[] = nameFinder.find(sentence);

		for (Span span : nameSpans) {
			System.out.println("NEW SPAN");
			for (int i = span.getStart(); i < span.getEnd(); i++) {
				System.out.println(sentence[i]);
			}
		}
	}

}
