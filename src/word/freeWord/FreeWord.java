package word.freeWord;

import word.Type;
import word.Word;

/**
 * A morpheme that can stand alone.
 *
 * @author School
 *
 */
public abstract class FreeWord extends Word {

    /**
     * Constructs a free morpheme.
     *
     * @param word
     *            the word.
     * @param t
     *            the type
     */
    public FreeWord(Type t, String word) {
        super(t, word);
        assert (t == Type.NOUN || t == Type.VERB || t == Type.PREPOSITION
                || t == Type.CONJUNCTION) : ""
                        + "Tried to construct Free Word of invalid type.";
    }

    /**
     * checks if the input is valid.
     *
     * @param <T>
     *            the type of the input
     * @param input
     *            the actual input
     * @return true if the input is valid for this type of word.
     */
    public abstract <T extends Word> boolean isValidInput(T input);

}
