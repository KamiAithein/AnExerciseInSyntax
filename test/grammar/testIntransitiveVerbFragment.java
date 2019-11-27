package grammar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import grammar.fragment.verb.IntransitiveVerbFragment;
import grammar.word.boundWord.Adjective;
import grammar.word.boundWord.Adverb;
import grammar.word.freeWord.verb.IntransitiveVerb;
import grammar.word.freeWord.verb.Verb;

public class testIntransitiveVerbFragment {

    @Test
    public void testConstructor_eat() {
        Verb eating = new IntransitiveVerb("eat");
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating);
        assertEquals(eating, frag.getBaseWord());
        assertEquals(eating.getType(), frag.getBaseWord().getType());
    }

    @Test
    public void testAddModifier_eat_happily() {
        Verb eating = new IntransitiveVerb("eat");
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating);
        Adverb happily = new Adverb("happily");
        frag.addBoundWord(happily);

        assertTrue(frag.getModifiers().contains(happily));
    }

    @Test
    public void testAddModifier_shoot_blue_FAIL() {
        Verb eating = new IntransitiveVerb("shoot");
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating);
        Adjective blue = new Adjective("blue");
        try {
            fail("added invalid word to fragment");
            frag.addBoundWord(blue);
        } catch (Error e) {
            //pass
        }
    }

    @Test
    public void testAddModifier_sleeping_happily_funnily_FAIL() {
        Verb eating = new IntransitiveVerb("sleeping");
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating);
        Adverb happily = new Adverb("happily");
        Adverb funnily = new Adverb("funnily");
        frag.addBoundWord(happily);
        try {
            frag.addBoundWord(funnily);
            fail("added adverb when one was already present");
        } catch (Error e) {
            //pass
        }
    }

    @Test
    public void testToString_chickens_sleeping_happily() {
        Verb eating = new IntransitiveVerb("sleeping");
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating);
        Adverb happily = new Adverb("happily");
        frag.addBoundWord(happily);
        assertEquals("sleeping happily", frag.toString());

    }

}
