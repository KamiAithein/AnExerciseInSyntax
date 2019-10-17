package word.boundWord;

import word.Type;

/**
 * Representation of an adjective.
 *
 * @author Koepcke.1
 *
 */
public class Adjective extends BoundWord {

    /**
     * Constructs adjective MUST HAVE TYPE adjective.
     *
     * @param word
     *            the word representation as a string
     */
    public Adjective(String word) {
        super(Type.ADJECTIVE, word);
    }

}
