package fragment.noun;

import java.util.ArrayList;
import java.util.List;

import fragment.Fragment;
import word.Type;
import word.boundWord.Adjective;
import word.boundWord.Article;
import word.boundWord.BoundWord;
import word.freeWord.FreeWord;

/**
 * Representation of a Noun Fragment.
 *
 * @author Koepcke.1
 *
 */
public class NounFragment extends Fragment {

    /**
     * Constructs a fragment from a free word.
     *
     * @param word
     *            the word.
     */
    public NounFragment(FreeWord word) {
        super(word);
        assert word
                .getType() == Type.NOUN : "Tried to construct Fragment of invalid type";
    }

    /**
     * Constructs a fragment from a free word with an article.
     *
     * @param word
     *            the word.
     * @param art
     *            the article.
     */
    public NounFragment(FreeWord word, Article art) {
        this(word);
        assert art.getType() == Type.ARTICLE;
        this.addBoundWord(art);
    }

    /**
     * Returns string representation of Noun Fragment.
     */
    @Override
    public String toString() {
        StringBuilder outputBuilder = new StringBuilder("");
        Article article = null;
        List<Adjective> adjectives = new ArrayList<>();
        for (BoundWord modifier : this.getModifiers()) {
            if (modifier.getType() == Type.ARTICLE) {
                article = (Article) (modifier);
            } else {
                adjectives.add((Adjective) (modifier));
            }

        }
        if (article != null) {
            outputBuilder.append(article);
            outputBuilder.append(" ");
        }

        for (Adjective a : adjectives) {
            outputBuilder.append(a);
            outputBuilder.append(" ");
        }
        outputBuilder.append(this.getBaseWord());
        return outputBuilder.toString();
    }
}
