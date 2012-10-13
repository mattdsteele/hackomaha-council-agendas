package hackomaha;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import org.junit.Test;

public class TestFoo {

	@Test
	public void testMaxent() {
		POSModel model = PosModelBuilder.build("resources/en-pos-maxent.bin");

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

}
