package word.freeWord.preposition;

import word.Type;
import word.Word;
import word.freeWord.FreeWord;

/**
 * Represents a preposition.
 *
 * @author Koepcke.1
 *
 */
public class Preposition extends FreeWord {

    /**
     * Constructs a preposition.
     *
     * @param word
     *            the preposition
     */
    public Preposition(String word) {
        super(Type.PREPOSITION, word);
    }

    /**
     * Only valid input for prepositions is noun.
     */
    @Override
    public <T extends Word> boolean isValidInput(T input) {
        return input.getType() == Type.NOUN;
    }

}
