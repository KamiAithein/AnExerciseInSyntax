package grammar.sentence;

import grammar.fragment.conjunction.ConjunctiveFragment;

/**
 * Represents a sentence.
 *
 * @author Koepcke.1
 */
public class Sentence {
    /**
     * The root sentence.
     */
    private Clause clause;

    /**
     * The conjunctive fragment of this sentence.
     */
    private ConjunctiveFragment conjFrag;

    /**
     * Constructs a full sentence.
     *
     * @param c
     *            the clause
     * @param cf
     *            the conjunctive fragment
     */
    public Sentence(Clause c, ConjunctiveFragment cf) {
        this.clause = c;
        this.conjFrag = cf;
        assert c != null : "Clause is null";
    }

    /**
     * Constructs a sentence without a conjunctive fragment.
     *
     * @param c
     *            the clause
     */
    public Sentence(Clause c) {
        this(c, null);

    }

    /**
     * Returns the string representation of this sentence.
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(this.clause.toString());
        if (this.conjFrag != null) {
            b.append(" ");
            b.append(this.conjFrag);
        }
        return b.toString();
    }
}
