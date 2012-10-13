package hackomaha;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;

public class PosModelBuilder {

	public static POSModel build(String modelFileName) {
		InputStream modelIn = null;

		try {
		  modelIn = new FileInputStream("resources/en-pos-maxent.bin");
		  return new POSModel(modelIn);
		}
		catch (IOException e) {
		  e.printStackTrace();
		  throw new RuntimeException("Checked exceptions blow");
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
	}
	
}
