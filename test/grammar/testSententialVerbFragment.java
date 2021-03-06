package grammar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grammar.fragment.noun.NounFragment;
import grammar.fragment.verb.SententialVerbFragment;
import grammar.fragment.verb.TransitiveVerbFragment;
import grammar.fragment.verb.VerbFragment;
import grammar.sentence.Clause;
import grammar.word.boundWord.Adverb;
import grammar.word.boundWord.Article;
import grammar.word.freeWord.noun.Noun;
import grammar.word.freeWord.verb.SententialVerb;
import grammar.word.freeWord.verb.TransitiveVerb;
import grammar.word.freeWord.verb.Verb;

public class testSententialVerbFragment {

    @Test
    public void testConstructor_think_the_cat_eats_food() {
        Verb eating = new SententialVerb("think");

        Noun noun2 = new Noun("cat");
        Article the = new Article("the");
        NounFragment subject = new NounFragment(noun2);
        subject.addBoundWord(the);

        Verb trans = new TransitiveVerb("eats");
        NounFragment object = new NounFragment(new Noun("food"));
        VerbFragment transPhrase = new TransitiveVerbFragment(trans, object);

        Clause c = new Clause(subject, transPhrase);

        SententialVerbFragment frag = new SententialVerbFragment(eating, c);
        assertEquals(object, ((TransitiveVerbFragment) frag
                .getSententialObject().getVerbPhrase()).getObject());
        assertEquals(object.getBaseWord(),
                ((TransitiveVerbFragment) frag.getSententialObject()
                        .getVerbPhrase()).getObject().getBaseWord());
        assertEquals(eating, frag.getBaseWord());
        assertEquals(eating.getType(), frag.getBaseWord().getType());
    }

    @Test
    public void testAddModifier_thinks_eat_cats_happily() {
        Verb eating = new TransitiveVerb("eat");
        Noun noun2 = new Noun("cats");
        NounFragment object = new NounFragment(noun2);
        TransitiveVerbFragment frag = new TransitiveVerbFragment(eating,
                object);
        Clause c = new Clause(object, frag);

        Verb thinks = new SententialVerb("thinks");
        SententialVerbFragment sentVFrag = new SententialVerbFragment(thinks,
                c);
        Adverb happily = new Adverb("happily");
        sentVFrag.addBoundWord(happily);

        assertTrue(sentVFrag.getModifiers().contains(happily));
        assertEquals("thinks cats eat cats happily", sentVFrag.toString());
    }


}
