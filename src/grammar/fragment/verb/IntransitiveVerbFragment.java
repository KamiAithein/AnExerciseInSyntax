package grammar.fragment.verb;

import java.util.List;

import grammar.word.boundWord.BoundWord;
import grammar.word.freeWord.FreeWord;
import grammar.word.freeWord.verb.IntransitiveVerb;

/**
 * Representation of an intransitive verb fragment.
 *
 * @author Koepcke.1
 *
 */
public class IntransitiveVerbFragment extends VerbFragment {

    /**
     * Constructs an intransitive verb fragment.
     *
     * @param verb
     *            the verb.
     *
     */
    public IntransitiveVerbFragment(FreeWord verb) {
        super(verb);
        assert verb instanceof IntransitiveVerb : ""
                + "Tried to construct fragment of invalid type.";
    }

    /**
     * Adds subject to verb phrase.
     */
    @Override
    public String toString() {
        List<BoundWord> mods = this.getModifiers();
        StringBuilder b = new StringBuilder(this.getBaseWord().toString());
        String adverb = "";
        if (mods.size() > 0) {
            adverb = mods.get(0).getWord();
            b.append(" ");
            b.append(adverb);
        }

        return b.toString();
    }

}
