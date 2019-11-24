package fragment.verb;

import java.util.List;

import fragment.noun.NounFragment;
import word.boundWord.BoundWord;
import word.freeWord.FreeWord;
import word.freeWord.verb.TransitiveVerb;

/**
 * Constructs transitive verb fragment.
 *
 * @author Koepcke.1
 *
 */
public class TransitiveVerbFragment extends VerbFragment {

    /**
     * NounFragment representing object.
     */
    private NounFragment object;

    /**
     * Constructs transitive verb.
     *
     * @param verb
     *            verb
     * @param object
     *            object of sentence
     */
    public TransitiveVerbFragment(FreeWord verb, NounFragment object) {
        super(verb);
        assert verb instanceof TransitiveVerb : ""
                + "Tried to construct fragment of invalid type.";
        this.object = object;
    }

    /**
     * Returns the object of this verb fragment.
     *
     * @return the object of this verb fragment
     */
    public NounFragment getObject() {
        return this.object;
    }

    /**
     * Returns a string representation of this verb fragment.
     */
    @Override
    public String toString() {
        StringBuilder transBuilder = new StringBuilder();
        transBuilder.append(this.getBaseWord().toString());
        transBuilder.append(" ");
        transBuilder.append(this.getObject().toString());
        List<BoundWord> mods = this.getModifiers();
        if (mods.size() > 0) {
            transBuilder.append(" ");
            transBuilder.append(mods.get(0));
        }
        return transBuilder.toString();
    }

}
