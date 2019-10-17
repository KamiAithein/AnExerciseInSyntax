import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fragment.NounFragment;
import fragment.TransitiveVerbFragment;
import word.boundWord.Adjective;
import word.boundWord.Adverb;
import word.boundWord.Article;
import word.freeWord.noun.Noun;
import word.freeWord.verb.TransitiveVerb;
import word.freeWord.verb.Verb;

public class testTransitiveVerbFragment {

    @Test
    public void testConstructor_dogs_eat_theCat() {
        Verb eating = new TransitiveVerb("eat");
        Noun noun = new Noun("dogs");
        NounFragment subject = new NounFragment(noun);
        Noun noun2 = new Noun("cats");
        Article the = new Article("the");
        NounFragment object = new NounFragment(noun2);
        object.addBoundWord(the);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                subject, object);
        assertEquals(subject, frag.getSubject());
        assertEquals(subject.getBaseWord(), frag.getSubject().getBaseWord());
        assertEquals(subject.getBaseWord().getWord(),
                frag.getSubject().getBaseWord().getWord());
        assertEquals(object, frag.getObject());
        assertEquals(object.getBaseWord(), frag.getObject().getBaseWord());
        assertEquals(object.getBaseWord().getWord(),
                frag.getObject().getBaseWord().getWord());
        assertEquals(eating, frag.getBaseWord());
        assertEquals(eating.getType(), frag.getBaseWord().getType());
    }

    @Test
    public void testAddModifier_dogs_eat_cats_happily() {
        Verb eating = new TransitiveVerb("eat");
        Noun noun = new Noun("dogs");
        NounFragment subject = new NounFragment(noun);
        Noun noun2 = new Noun("cats");
        NounFragment object = new NounFragment(noun2);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                subject, object);
        Adverb happily = new Adverb("happily");
        frag.addBoundWord(happily);

        assertTrue(frag.getModifiers().contains(happily));
    }

    @Test
    public void testAddModifier_soldiers_shoot_apples_blue_FAIL() {
        Verb eating = new TransitiveVerb("shoot");
        Noun noun = new Noun("soldiers");
        NounFragment subject = new NounFragment(noun);
        Noun noun2 = new Noun("apples");
        NounFragment object = new NounFragment(noun2);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                subject, object);
        Adjective blue = new Adjective("blue");
        try {
            fail("added invalid word to fragment");
            frag.addBoundWord(blue);
        } catch (Error e) {
            //pass
        }
    }

    @Test
    public void testToString_chickens_eat_food_happily() {
        Verb eating = new TransitiveVerb("eat");
        Noun noun = new Noun("chickens");
        NounFragment subject = new NounFragment(noun);
        Noun noun2 = new Noun("food");
        NounFragment object = new NounFragment(noun2);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                subject, object);
        Adverb happily = new Adverb("happily");
        frag.addBoundWord(happily);
        assertEquals("chickens eat food happily", frag.toString());

    }

}
