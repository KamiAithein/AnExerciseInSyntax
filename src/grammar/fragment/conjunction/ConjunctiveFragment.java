package grammar.fragment.conjunction;

import grammar.fragment.Fragment;
import grammar.sentence.Sentence;
import grammar.word.Type;
import grammar.word.freeWord.FreeWord;

/**
 * A conjunctive fragment that contains a conjunction and a sentence.
 *
 * @author Koepcke.1
 *
 */
public class ConjunctiveFragment extends Fragment {

    /**
     * The sentential object.
     */
    private Sentence sententialObject;

    /**
     * Constructs the fragment.
     *
     * @param conj
     *            the conjunction
     * @param sent
     *            the sentential object
     */
    public ConjunctiveFragment(FreeWord conj, Sentence sent) {
        super(conj);
        assert conj.getType() == Type.CONJUNCTION;
        this.sententialObject = sent;
    }

    /**
     * Returns the sentential object.
     *
     * @return the sentential object
     */
    public Sentence getSententialObject() {
        return this.sententialObject;
    }

    /**
     * Constructs the string.
     */
    @Override
    public String toString() {
        return this.getBaseWord().toString().concat(" ")
                .concat(this.sententialObject.toString());
    }

}
