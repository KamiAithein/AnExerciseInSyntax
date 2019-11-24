package grammar;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import word.Type;
import word.freeWord.noun.Noun;

public class testNoun {

    @Test
    public void testConstructor_hello() {
        String word = "hello";
        Noun hello = new Noun(word);

        assertEquals(word, hello.getWord());
        assertEquals(Type.NOUN, hello.getType());

    }

}