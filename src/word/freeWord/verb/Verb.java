package word.freeWord.verb;

import word.Type;
import word.Word;
import word.freeWord.FreeWord;

/***
 * Representation of a Verb.
 *
 * @author Koepcke.1
 *
 */
public abstract class Verb extends FreeWord {

    /**
     * Construction of a Verb.
     *
     * @param word
     *            the word
     */
    Verb(String word) {
        super(Type.VERB, word);
    }

    /**
     * Checks if input is valid for this type of word.
     */
    @Override
    public <T extends Word> boolean isValidInput(T input) {
        return input.getType() == Type.ADVERB;
    }

}
