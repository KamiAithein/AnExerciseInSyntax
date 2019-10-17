package word.boundWord;

import word.Type;

/**
 * Represents an article.
 *
 * @author Koepcke.1
 *
 */
public class Article extends BoundWord {

    /**
     * Constructs an article.
     *
     * @param word
     *            the word
     */
    public Article(String word) {
        super(Type.ARTICLE, word);
    }

}
