package fragment.preposition;

import fragment.Fragment;
import fragment.noun.NounFragment;
import word.Type;
import word.freeWord.FreeWord;

/**
 * Represents a prepositional fragment.
 *
 * @author Koepcke.1
 *
 */
public class PrepositionalFragment extends Fragment {

    /**
     * The prepositional object of the phrase.
     */
    private NounFragment prepositionalObject;

    /**
     * Constructs a prepositional phrase.
     *
     * @param preposition
     *            the root word of the preposition.
     * @param prepObject
     *            the prepositional object
     */
    public PrepositionalFragment(FreeWord preposition,
            NounFragment prepObject) {
        super(preposition);
        assert preposition.getType() == Type.PREPOSITION : ""
                + "Tried to construct Preposition with invalid type";
        this.prepositionalObject = prepObject;
    }

    /**
     * returns the prepositional object of the phrase.
     *
     * @return the prepositional object of the phrase
     *
     */
    public NounFragment getPrepositionalObject() {
        return this.prepositionalObject;
    }

    /**
     * Returns the string as prep noun.
     */
    @Override
    public String toString() {
        return this.getBaseWord().toString()
                .concat(String.format(" %s", this.prepositionalObject));
    }

}
