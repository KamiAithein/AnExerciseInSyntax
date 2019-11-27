package grammar.fragment.verb;

import grammar.fragment.Fragment;
import grammar.word.Type;
import grammar.word.freeWord.FreeWord;

/**
 * Creates a verb fragment.
 *
 * @author Koepcke.1
 *
 */
public abstract class VerbFragment extends Fragment {

    /**
     * Constructs a Verb Fragment.
     *
     * @param verb
     *            the verb to construct the fragment with.
     */
    VerbFragment(FreeWord verb) {
        super(verb);
        assert verb.getType() == Type.VERB : "Invalid verb argument";
    }

}
