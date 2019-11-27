package grammar.sentence;

import grammar.fragment.noun.NounFragment;
import grammar.fragment.preposition.PrepositionalFragment;
import grammar.fragment.verb.VerbFragment;

/**
 * Representation of a sentence.
 *
 * @author Koepcke.1
 *
 */
public class Clause {
    /**
     * the verbPhrase of the sentence.
     */
    private VerbFragment verbPhrase;

    /**
     * the subjectPhrase of the sentence.
     */
    private NounFragment subjectPhrase;
    /**
     * the prepPhrase of the sentence.
     *
     * @null
     */
    private PrepositionalFragment prepPhrase;

    /**
     * the conjunction of the sentence.
     */

    /**
     * Constructs a default clause, having both a prepPhrase and a verbPhrase.
     *
     * @param subjectPhrase
     *            the subjectPhrase
     * @param verbPhrase
     *            the verbPhrase, which contains a subject at minimum.
     * @param prepPhrase
     *            the prepPhrase
     */
    public Clause(NounFragment subjectPhrase, VerbFragment verbPhrase,
            PrepositionalFragment prepPhrase) {
        this.verbPhrase = verbPhrase;
        this.prepPhrase = prepPhrase;
        this.subjectPhrase = subjectPhrase;
    }

    /**
     * returns the verbFragment.
     *
     * @return the verbFragment
     */
    public VerbFragment getVerbPhrase() {
        return this.verbPhrase;
    }

    /**
     * returns the prepPhrase.
     *
     * @return the prepPhrase.
     */
    public PrepositionalFragment getPrepPhrase() {
        return this.prepPhrase;
    }

    /**
     * Returns the subjectPhrase.
     *
     * @return the subjectPhrase
     */
    public NounFragment getSubjectPhrase() {
        return this.subjectPhrase;
    }

    /**
     * Constructs a minimum sentence, having only a verbPhrase.
     *
     * @param subjectPhrase
     *            a subjectPhrase
     * @param verbPhrase
     *            a verbPhrase
     */
    public Clause(NounFragment subjectPhrase, VerbFragment verbPhrase) {
        this(subjectPhrase, verbPhrase, null);
    }

    /**
     * returns a string representation of this Clause.
     *
     * @return the string representation of this Clause.
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(this.subjectPhrase.toString());
        b.append(" ");
        b.append(this.verbPhrase.toString());
        if (this.prepPhrase != null) {
            b.append(" ");
            b.append(this.prepPhrase.toString());
        }
        return b.toString();
    }
}
