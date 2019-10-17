package fragment;

import word.Type;
import word.freeWord.FreeWord;

/**
 * Creates a verb fragment.
 *
 * @author Koepcke.1
 *
 */
abstract class VerbFragment extends Fragment {

    /**
     * The subject of the verb fragment.
     */
    private NounFragment subject;

    /**
     * Constructs a Verb Fragment.
     *
     * @param verb
     *            the verb to construct the fragment with.
     * @param subject
     *            the subject of the verb fragment.
     */
    VerbFragment(FreeWord verb, NounFragment subject) {
        super(verb);
        assert verb.getType() == Type.VERB : "Invalid verb argument";
        this.subject = subject;
    }

    /**
     * Returns the subject of this verb fragment.
     *
     * @return the subject of this verb fragment.
     */
    public NounFragment getSubject() {
        return this.subject;
    }

}
