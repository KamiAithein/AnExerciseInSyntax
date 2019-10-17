package word;
/**
 * An abstract representation of a word.
 *
 * @author Koepcke.1
 *
 */
public abstract class Word {

    /**
     * The type of the word.
     */
    private final Type type;

    /**
     * The actual word in string form.
     */
    private final String word;

    /**
     * Constructor, requires type.
     *
     * @param word
     *            the string representation of the word.
     *
     * @param t
     *            the type of word
     */
    public Word(Type t, String word) {
        this.type = t;
        this.word = word;
    }

    /**
     * Gets the type of the word.
     *
     * @return the type
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Gets the word.
     *
     * @return the word
     */
    public String getWord() {
        return this.word;
    }

    /**
     * Returns the type of the word as a string.
     */
    @Override
    public String toString() {
        return "" + this.word;
    }
}
