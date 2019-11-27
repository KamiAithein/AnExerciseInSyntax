package grammar.word.boundWord;

import grammar.word.Type;

/**
 * Representation of an adjective.
 *
 * @author Koepcke.1
 *
 */
public class Adverb extends BoundWord {

    /**
     * Constructs adjective MUST HAVE TYPE adjective.
     *
     * @param word
     *            the word representation as a string
     */
    public Adverb(String word) {
        super(Type.ADVERB, word);
    }

}
