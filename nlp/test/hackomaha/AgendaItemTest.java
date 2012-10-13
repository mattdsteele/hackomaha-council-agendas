package hackomaha;

import org.junit.Assert;
import org.junit.Test;

public class AgendaItemTest {

	@Test
	public void testEmpty() {
		AgendaItem item = new AgendaItem("");
		Assert.assertEquals(0, item.sentences.length);
	}

	@Test
	public void testRealAgendaItem() {
		AgendaItem item = new AgendaItem(
				"Ord. to rezone the properties located at 1002, 1010 and "
						+ "1012 South 10th Street from HI - Heavy Industrial District "
						+ "to CBD - Central Business District.  "
						+ "((PUBLIC HEARING TODAY Ð CAN BE PASSED TODAY))");
		Assert.assertEquals(2, item.sentences.length);
		Assert.assertEquals(
				"Ord. to rezone the properties located at 1002, 1010 and "
						+ "1012 South 10th Street from HI - Heavy Industrial District "
						+ "to CBD - Central Business District.",
				item.sentences[0]);
		Assert.assertEquals("((PUBLIC HEARING TODAY Ð CAN BE PASSED TODAY))",
				item.sentences[1]);
	}
}
