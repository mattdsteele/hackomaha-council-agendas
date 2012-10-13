package hackomaha;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;

public class Builder {

	private static InputStream modelIn = null;

	public static POSModel posModel(String filepath) {
		try {
			modelIn = new FileInputStream("resources/en-pos-maxent.bin");
			return new POSModel(modelIn);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Checked exceptions blow", e);
		} finally {
			closeIfNeeded();
		}
	}

	public static TokenNameFinderModel tokenNameFinderModel(String filepath) {
		try {
			modelIn = new FileInputStream(filepath);
			return new TokenNameFinderModel(modelIn);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Checked exceptions blow", e);
		} finally {
			closeIfNeeded();
		}
	}

	private static void closeIfNeeded() {
		if (modelIn != null) {
			try {
				modelIn.close();
			} catch (IOException e) {
			}
		}
	}

}
