import static org.junit.Assert.assertEquals;

import org.junit.Test;

import word.Type;
import word.freeWord.verb.IntransitiveVerb;
import word.freeWord.verb.Verb;

public class testVerb {

    @Test
    public void testConstructor_hello() {
        String word = "eats";
        Verb hello = new IntransitiveVerb(word);

        assertEquals(word, hello.getWord());
        assertEquals(Type.VERB, hello.getType());

    }

}
