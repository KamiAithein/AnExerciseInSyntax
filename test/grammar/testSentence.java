package grammar;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fragment.conjunction.ConjunctiveFragment;
import fragment.noun.NounFragment;
import fragment.preposition.PrepositionalFragment;
import fragment.verb.IntransitiveVerbFragment;
import fragment.verb.TransitiveVerbFragment;
import sentence.Clause;
import sentence.Sentence;
import word.boundWord.Article;
import word.freeWord.conjunction.Conjunction;
import word.freeWord.noun.Noun;
import word.freeWord.preposition.Preposition;
import word.freeWord.verb.IntransitiveVerb;
import word.freeWord.verb.TransitiveVerb;

public class testSentence {

    @Test
    public void test_you_eat_doodoo_and_you_suck() {
        Noun you = new Noun("you");
        NounFragment youP = new NounFragment(you);
        TransitiveVerb eat = new TransitiveVerb("eat");
        Noun doodoo = new Noun("doodoo");
        NounFragment doodooP = new NounFragment(doodoo);
        TransitiveVerbFragment eat_doodooF = new TransitiveVerbFragment(eat,
                doodooP);
        Clause you_eat_doodoo = new Clause(youP, eat_doodooF);
        Conjunction and = new Conjunction("and");
        IntransitiveVerb suck = new IntransitiveVerb("suck");
        IntransitiveVerbFragment suckF = new IntransitiveVerbFragment(suck);
        Clause you_suck = new Clause(youP, suckF);
        Sentence you_suckS = new Sentence(you_suck);
        ConjunctiveFragment andF = new ConjunctiveFragment(and, you_suckS);

        Sentence you_eat_doodoo_and_you_suck = new Sentence(you_eat_doodoo,
                andF);

        assertEquals("you eat doodoo and you suck",
                you_eat_doodoo_and_you_suck.toString());

    }

    @Test
    public void test_you_eat_doodoo_in_the_mall_while_you_snort_crack_cocaine() {
        Noun you = new Noun("you");
        NounFragment youP = new NounFragment(you);
        TransitiveVerb eat = new TransitiveVerb("eat");
        Noun doodoo = new Noun("doodoo");
        NounFragment doodooP = new NounFragment(doodoo);
        TransitiveVerbFragment eat_doodooF = new TransitiveVerbFragment(eat,
                doodooP);
        Preposition in = new Preposition("in");
        Noun mall = new Noun("mall");
        Article the = new Article("the");
        NounFragment the_mall = new NounFragment(mall, the);
        PrepositionalFragment in_the_mall = new PrepositionalFragment(in,
                the_mall);
        Clause you_eat_doodoo = new Clause(youP, eat_doodooF, in_the_mall);
        Conjunction and = new Conjunction("while");
        TransitiveVerb snort = new TransitiveVerb("snort");
        Noun crack_cocaine = new Noun("crack cocaine");
        NounFragment crack_cocaineP = new NounFragment(crack_cocaine);
        TransitiveVerbFragment snortF = new TransitiveVerbFragment(snort,
                crack_cocaineP);
        Clause you_suck = new Clause(youP, snortF);
        Sentence you_suckS = new Sentence(you_suck);
        ConjunctiveFragment andF = new ConjunctiveFragment(and, you_suckS);

        Sentence you_eat_doodoo_in_the_mall_while_you_snort_crack_cocaine = new Sentence(
                you_eat_doodoo, andF);

        assertEquals("you eat doodoo in the mall while you snort crack cocaine",
                you_eat_doodoo_in_the_mall_while_you_snort_crack_cocaine
                        .toString());
    }

}
