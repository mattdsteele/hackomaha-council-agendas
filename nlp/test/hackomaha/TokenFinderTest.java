package hackomaha;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TokenFinderTest {

    private String text;

    @Before
    public void setUp() throws Exception {
        text = getText();
    }

    @Test
    public void canFindSomeNames() throws Exception {
        TokenFinder tokenFinder = TokenFinder.nameFinder();
        Set<String> names = tokenFinder.findNames(text);
        assertThat(names.contains("Jim Suttle"), is(true));
    }

    @Test
    public void canFindOrgs() throws Exception {
        Set<String> orgs = TokenFinder.orgFinder().findNames(text);
        assertThat(orgs.contains("Union Pacific Railroad"), is(true));
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
