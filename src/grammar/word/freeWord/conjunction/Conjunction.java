package grammar.word.freeWord.conjunction;

import grammar.word.Type;
import grammar.word.Word;
import grammar.word.freeWord.FreeWord;

/**
 * Represents a conjunction.
 *
 * @author Koepcke.1
 *
 */
public class Conjunction extends FreeWord {

    /**
     * Constructs a Conjunction.
     *
     * @param word
     *            the conjunction
     */
    public Conjunction(String word) {
        super(Type.CONJUNCTION, word);
    }

    /**
     * Returns true iff input is the same type as Conjunction.
     */
    @Override
    public <T extends Word> boolean isValidInput(T input) {
        return input.getType() == Type.CONJUNCTION;
    }

}
