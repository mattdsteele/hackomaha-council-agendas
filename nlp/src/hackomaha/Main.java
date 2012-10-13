package hackomaha;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStream modelIn = null;
		POSModel model = null;

		try {
		  modelIn = new FileInputStream("en-pos-maxent.bin");
		  model = new POSModel(modelIn);
		}
		catch (IOException e) {
		  // Model loading failed, handle the error
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
		    }
		  }
		}
		
		POSTaggerME tagger = new POSTaggerME(model);
		
		String item = "6. Ord. to approve a PUD-Planned Unit Development Overlay District in a R7-Medium-Density Multiple-Family Residential District located East of 99th Street and South of Redick Avenue, to approve the Development Plan, and to provide for an effective date - see attached.  ((PUBLIC HEARING TODAY – CAN BE PASSED TODAY))";
		String words[] = item.split(" ");		  
		String tags[] = tagger.tag(words);
		
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i] + " -> " + tags[i]);
		}
	}
}
