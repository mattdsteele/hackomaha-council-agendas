package hackomaha;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NameFinderTest {
    @Test
    public void canFindSomeNames() throws Exception {
        NameFinder nameFinder = new NameFinder();
        String[] tokens = getTokens();
        Set<String> names = nameFinder.findNames(tokens);
        assertThat(names.contains("Jim Suttle"), is(true));
    }
    private String[] getTokens() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resources/a12-10-16.txt"));
        List<String> strings = new ArrayList<String>();
        while(scanner.hasNext()) {
            strings.add(scanner.next());
        }
        return strings.toArray(new String[]{});
    }
}
