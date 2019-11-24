package grammar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fragment.noun.NounFragment;
import fragment.verb.TransitiveVerbFragment;
import word.boundWord.Adjective;
import word.boundWord.Adverb;
import word.boundWord.Article;
import word.freeWord.noun.Noun;
import word.freeWord.verb.TransitiveVerb;
import word.freeWord.verb.Verb;

public class testTransitiveVerbFragment {

    @Test
    public void testConstructor_eat_theCat() {
        Verb eating = new TransitiveVerb("eat");
        Noun noun2 = new Noun("cats");
        Article the = new Article("the");
        NounFragment object = new NounFragment(noun2);
        object.addBoundWord(the);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                object);
        assertEquals(object, frag.getObject());
        assertEquals(object.getBaseWord(), frag.getObject().getBaseWord());
        assertEquals(object.getBaseWord().getWord(),
                frag.getObject().getBaseWord().getWord());
        assertEquals(eating, frag.getBaseWord());
        assertEquals(eating.getType(), frag.getBaseWord().getType());
    }

    @Test
    public void testAddModifier_eat_cats_happily() {
        Verb eating = new TransitiveVerb("eat");
        Noun noun2 = new Noun("cats");
        NounFragment object = new NounFragment(noun2);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                object);
        Adverb happily = new Adverb("happily");
        frag.addBoundWord(happily);

        assertTrue(frag.getModifiers().contains(happily));
    }

    @Test
    public void testAddModifier_shoot_apples_blue_FAIL() {
        Verb eating = new TransitiveVerb("shoot");
        Noun noun2 = new Noun("apples");
        NounFragment object = new NounFragment(noun2);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                object);
        Adjective blue = new Adjective("blue");
        try {
            fail("added invalid word to fragment");
            frag.addBoundWord(blue);
        } catch (Error e) {
            //pass
        }
    }

    @Test
    public void testToString_eat_food_happily() {
        Verb eating = new TransitiveVerb("eat");
        Noun noun2 = new Noun("food");
        NounFragment object = new NounFragment(noun2);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                object);
        Adverb happily = new Adverb("happily");
        frag.addBoundWord(happily);
        assertEquals("eat food happily", frag.toString());

    }

}
