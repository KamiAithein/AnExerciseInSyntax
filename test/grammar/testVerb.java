package grammar;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import grammar.word.Type;
import grammar.word.freeWord.verb.IntransitiveVerb;
import grammar.word.freeWord.verb.Verb;

public class testVerb {

    @Test
    public void testConstructor_hello() {
        String word = "eats";
        Verb hello = new IntransitiveVerb(word);

        assertEquals(word, hello.getWord());
        assertEquals(Type.VERB, hello.getType());

    }

}
