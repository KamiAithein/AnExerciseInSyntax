import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fragment.IntransitiveVerbFragment;
import fragment.NounFragment;
import word.boundWord.Adjective;
import word.boundWord.Adverb;
import word.freeWord.noun.Noun;
import word.freeWord.verb.IntransitiveVerb;
import word.freeWord.verb.Verb;

public class testIntransitiveVerbFragment {

    @Test
    public void testConstructor_dogs_eat() {
        Verb eating = new IntransitiveVerb("eat");
        Noun noun = new Noun("dogs");
        NounFragment subject = new NounFragment(noun);
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating,
                subject);
        assertEquals(subject, frag.getSubject());
        assertEquals(subject.getBaseWord(), frag.getSubject().getBaseWord());
        assertEquals(subject.getBaseWord().getWord(),
                frag.getSubject().getBaseWord().getWord());
        assertEquals(eating, frag.getBaseWord());
        assertEquals(eating.getType(), frag.getBaseWord().getType());
    }

    @Test
    public void testAddModifier_dogs_eat_happily() {
        Verb eating = new IntransitiveVerb("eat");
        Noun noun = new Noun("dogs");
        NounFragment subject = new NounFragment(noun);
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating,
                subject);
        Adverb happily = new Adverb("happily");
        frag.addBoundWord(happily);

        assertTrue(frag.getModifiers().contains(happily));
    }

    @Test
    public void testAddModifier_soldiers_shoot_blue_FAIL() {
        Verb eating = new IntransitiveVerb("shoot");
        Noun noun = new Noun("soldiers");
        NounFragment subject = new NounFragment(noun);
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating,
                subject);
        Adjective blue = new Adjective("blue");
        try {
            fail("added invalid word to fragment");
            frag.addBoundWord(blue);
        } catch (Error e) {
            //pass
        }
    }

    @Test
    public void testAddModifier_chickens_sleeping_happily_funnily_FAIL() {
        Verb eating = new IntransitiveVerb("sleeping");
        Noun noun = new Noun("chickens");
        NounFragment subject = new NounFragment(noun);
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating,
                subject);
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
        Noun noun = new Noun("chickens");
        NounFragment subject = new NounFragment(noun);
        IntransitiveVerbFragment frag = new IntransitiveVerbFragment(eating,
                subject);
        Adverb happily = new Adverb("happily");
        frag.addBoundWord(happily);
        assertEquals("chickens sleeping happily", frag.toString());

    }

}
