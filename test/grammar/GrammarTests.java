package grammar;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testClause.class, testIntransitiveVerbFragment.class,
        testNoun.class, testTransitiveVerbFragment.class, testVerb.class,
        testSententialVerbFragment.class, testSentence.class })
public class GrammarTests {

}
