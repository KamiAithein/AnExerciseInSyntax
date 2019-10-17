package word.freeWord.noun;

import word.Type;
import word.Word;
import word.freeWord.FreeWord;

/**
 * Representation of a Noun.
 *
 * @author School
 *
 */
public class Noun extends FreeWord {

    /**
     * Constructs a noun.
     *
     * @param word
     *            the word
     */
    public Noun(String word) {
        super(Type.NOUN, word);
    }

    /**
     * Tells whether input is valid.
     */
    @Override
    public <T extends Word> boolean isValidInput(T input) {
        return input.getType() == Type.ADJECTIVE
                || input.getType() == Type.ARTICLE;
    }

}
