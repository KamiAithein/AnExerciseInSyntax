package grammar.fragment;

import java.util.ArrayList;
import java.util.List;

import grammar.word.boundWord.BoundWord;
import grammar.word.freeWord.FreeWord;

/**
 * A fragment of a sentence.
 *
 * @author Koepcke.1
 *
 */
public abstract class Fragment {
    /**
     * The root of the fragment.
     */
    private FreeWord baseWord;

    /**
     * The list of modifiers for the base word.
     */
    private List<BoundWord> modifiers;

    /**
     * Constructor.
     *
     * @param word
     *            the word
     */
    protected Fragment(FreeWord word) {
        this.baseWord = word;
        this.modifiers = new ArrayList<>();
    }

    /**
     * Gets the base word of the fragment.
     *
     * @return the base word of the fragment
     */
    public FreeWord getBaseWord() {
        return this.baseWord;
    }

    /**
     * Gets the modifiers of the fragment.
     *
     * @return the modifiers of the fragment.
     */
    public List<BoundWord> getModifiers() {
        return this.modifiers;
    }

    /**
     * Adds a bound word to the fragment.
     *
     * @param b
     *            the bound word
     */
    public void addBoundWord(BoundWord b) {
        assert this.baseWord.isValidInput(b);
        this.modifiers.add(b);
    }

}
