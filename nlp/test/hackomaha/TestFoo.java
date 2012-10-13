package hackomaha;

import junit.framework.TestCase;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
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
	public void testLocation() throws Exception {
		NameFinderME nameFinder = new NameFinderME(
				Builder.tokenNameFinderModel("resources/en-ner-location.bin"));
		String[] tokens = { "Pierre", "Morgan", "is", "61", "yesars", "old",
				".", "1500", "N", "49th", "St", ",", "Omaha", ",", "NE",
				"68104" };
		Span[] spans = nameFinder.find(tokens);
		for (Span span : spans) {
			System.out.println("Start: " + tokens[span.getStart()]);
			System.out.println("End: " + tokens[span.getEnd()]);
		}
	}
}
