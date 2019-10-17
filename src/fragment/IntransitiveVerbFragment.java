package fragment;

import java.util.List;

import word.boundWord.BoundWord;
import word.freeWord.FreeWord;
import word.freeWord.verb.IntransitiveVerb;

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
     * @param subject
     *            the subject of the verb fragment
     */
    public IntransitiveVerbFragment(FreeWord verb, NounFragment subject) {
        super(verb, subject);
        assert verb instanceof IntransitiveVerb : ""
                + "Tried to construct fragment of invalid type.";
    }

    /**
     * Adds subject to verb phrase.
     */
    @Override
    public String toString() {
        List<BoundWord> mods = this.getModifiers();
        String adverb = "";
        if (mods.size() > 0) {
            adverb = mods.get(0).getWord();
        }
        return this.getSubject().toString().concat(" ")
                .concat(this.getBaseWord().toString()).concat(" ")
                .concat(adverb);
    }

}
