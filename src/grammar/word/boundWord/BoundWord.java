package grammar.word.boundWord;

import grammar.word.Type;
import grammar.word.Word;

/**
 * A morpheme that requires a free morpheme.
 *
 * @author Koepcke.1
 *
 */
public abstract class BoundWord extends Word {

    /**
     * Constructs a bound word.
     *
     * @param word
     *            the word
     * @param t
     *            the type of word.
     */
    public BoundWord(Type t, String word) {
        super(t, word);
        assert (t == Type.ADJECTIVE || t == Type.ADVERB || t == Type.ARTICLE
                || t == Type.PREPOSITION) : "Tried to construct BoundWord with"
                        + " invalid type";
    }

}
