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
        String text = getText();
        Set<String> names = nameFinder.findNames(text);
        assertThat(names.contains("Jim Suttle"), is(true));
    }

    private String getText() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resources/a12-10-16.txt"));
        StringBuffer buffer = new StringBuffer();
        while(scanner.hasNextLine()) {
            buffer.append(scanner.nextLine());
        }
        return buffer.toString();
    }
}
