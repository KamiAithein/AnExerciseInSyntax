package grammar.fragment.verb;

import java.util.List;

import grammar.sentence.Clause;
import grammar.word.boundWord.BoundWord;
import grammar.word.freeWord.FreeWord;
import grammar.word.freeWord.verb.SententialVerb;

/**
 * Constructs transitive verb fragment.
 *
 * @author Koepcke.1
 *
 */
public class SententialVerbFragment extends VerbFragment {

    /**
     * Clause representing SententialObject.
     */
    private Clause sententialObject;

    /**
     * Constructs transitive verb.
     *
     * @param verb
     *            verb
     * @param sententialObject
     *            sententialObject of sentence
     */
    public SententialVerbFragment(FreeWord verb, Clause sententialObject) {
        super(verb);
        assert verb instanceof SententialVerb : ""
                + "Tried to construct fragment of invalid type.";
        this.sententialObject = sententialObject;
    }

    /**
     * Returns the sententialObject of this verb fragment.
     *
     * @return the sententialObject of this verb fragment
     */
    public Clause getSententialObject() {
        return this.sententialObject;
    }

    /**
     * Returns a string representation of this verb fragment.
     */
    @Override
    public String toString() {
        StringBuilder transBuilder = new StringBuilder();
        transBuilder.append(this.getBaseWord().toString());
        transBuilder.append(" ");
        transBuilder.append(this.getSententialObject().toString());
        List<BoundWord> mods = this.getModifiers();
        if (mods.size() > 0) {
            transBuilder.append(" ");
            transBuilder.append(mods.get(0));
        }

        return transBuilder.toString();
    }

}
