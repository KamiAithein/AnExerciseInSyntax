package grammar;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fragment.noun.NounFragment;
import fragment.preposition.PrepositionalFragment;
import fragment.verb.TransitiveVerbFragment;
import sentence.Clause;
import word.boundWord.Adjective;
import word.boundWord.Adverb;
import word.boundWord.Article;
import word.freeWord.noun.Noun;
import word.freeWord.preposition.Preposition;
import word.freeWord.verb.TransitiveVerb;
import word.freeWord.verb.Verb;

public class testClause {

    @Test
    public void testToString_noPrep() {
        Noun chickens = new Noun("Kenny");
        Article the = new Article("the");
        Adjective green = new Adjective("green");
        Adjective curly = new Adjective("curly");
        Adjective white = new Adjective("white");
        NounFragment subject = new NounFragment(chickens);
        subject.addBoundWord(green);
        subject.addBoundWord(curly);
        subject.addBoundWord(white);
        subject.addBoundWord(the);

        Noun husbands = new Noun("husbands");
        NounFragment object = new NounFragment(husbands);
        Adjective fatherly = new Adjective("fatherly");
        object.addBoundWord(fatherly);
        Verb verb = new TransitiveVerb("fucks");
        TransitiveVerbFragment verbPhrase = new TransitiveVerbFragment(verb,
                object);
        Clause c = new Clause(subject, verbPhrase);
        assertEquals("the green curly white Kenny fucks fatherly husbands",
                c.toString());
    }

    @Test
    public void testToString_prep() {
        Noun chickens = new Noun("Kenny");
        Article the = new Article("the");
        Adjective green = new Adjective("green");
        Adjective curly = new Adjective("curly");
        Adjective white = new Adjective("white");
        NounFragment subject = new NounFragment(chickens);
        subject.addBoundWord(green);
        subject.addBoundWord(curly);
        subject.addBoundWord(white);
        subject.addBoundWord(the);

        Noun husbands = new Noun("husbands");
        NounFragment object = new NounFragment(husbands);
        Adjective fatherly = new Adjective("fatherly");
        object.addBoundWord(fatherly);
        Verb verb = new TransitiveVerb("fucks");
        TransitiveVerbFragment verbPhrase = new TransitiveVerbFragment(verb,
                object);
        Adverb furiously = new Adverb("furiously");
        verbPhrase.addBoundWord(furiously);

        Preposition at = new Preposition("at");
        Noun mall = new Noun("mall");
        NounFragment theMall = new NounFragment(mall);
        theMall.addBoundWord(the);
        PrepositionalFragment prep = new PrepositionalFragment(at, theMall);
        Clause c = new Clause(subject, verbPhrase, prep);
        assertEquals(
                "the green curly white Kenny fucks fatherly husbands furiously at the mall",
                c.toString());
    }

}
