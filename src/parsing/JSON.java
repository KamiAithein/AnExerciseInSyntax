package parsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grammar.word.boundWord.Adjective;
import grammar.word.boundWord.Adverb;
import grammar.word.boundWord.Article;
import grammar.word.freeWord.conjunction.Conjunction;
import grammar.word.freeWord.noun.Noun;
import grammar.word.freeWord.preposition.Preposition;
import grammar.word.freeWord.verb.IntransitiveVerb;
import grammar.word.freeWord.verb.TransitiveVerb;
import grammar.word.freeWord.verb.Verb;

/**
 * An object representation of a JSON.
 *
 * @author Koepcke.1
 *
 */
public class JSON {
    /**
     * The nouns.
     */
    private LinkedList<Noun> nouns;
    /**
     * The verbs.
     */
    private LinkedList<Verb> verbs;
    /**
     * The intransitive verbs.
     */
    private LinkedList<IntransitiveVerb> intransitiveVerbs;
    /**
     * the transitive verbs.
     */
    private LinkedList<TransitiveVerb> transitiveVerbs;
    /**
     * the adjectives.
     */
    private LinkedList<Adjective> adjectives;
    /**
     * the prepositions.
     */
    private LinkedList<Preposition> prepositions;
    /**
     * the conjunctions.
     */
    private LinkedList<Conjunction> conjunctions;
    /**
     * the articles.
     */
    private LinkedList<Article> articles;

    private LinkedList<Adverb> adverbs;

    /**
     * Tries to construct a JSON representation from a file URL. If the file
     * does not exist then it tries to construct a JSON from the string
     * specified.
     *
     * @param fileName
     *            the fileName or JSON String.
     */
    public JSON(String fileName) {
        this.adjectives = new LinkedList<>();
        this.articles = new LinkedList<>();
        this.conjunctions = new LinkedList<>();
        this.intransitiveVerbs = new LinkedList<>();
        this.nouns = new LinkedList<>();
        this.prepositions = new LinkedList<>();
        this.transitiveVerbs = new LinkedList<>();
        this.verbs = new LinkedList<>();
        this.adverbs = new LinkedList<>();
        File f = new File(fileName);
        Scanner s;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            s = new Scanner(fileName);
        }
        StringBuilder b = new StringBuilder();
        while (s.hasNext()) {
            b.append(s.nextLine());
        }
        s.close();
        String jsonS = b.toString().strip();
        assert jsonS
                .matches("^\\{.*\\}$") : "JSON does not start and end with {/}"
                        .concat(jsonS);
        jsonS = jsonS.substring(jsonS.indexOf('{') + 1, jsonS.lastIndexOf("}"))
                .strip();

        /**
         * (group1):(group2) ([A-Za-z]):([])
         */
        String pattern = "(\"[a-zA-Z]*\")[ ]*:[ ]*((?:\\[(?:[^\\[\\]]*\\])|(?:\\{(?:[^\\{\\}]*\\}))))";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(jsonS);

        while (m.find()) {
            String category = m.group(1).replaceAll("\"", "");
            String list = m.group(2).replaceAll("[\\[\\]]", "").trim();
            String[] items = list.split(",");
            for (String str : items) {
                switch (category) {
                    case "noun":
                        this.nouns.add(new Noun(str));
                        break;
                    case "intransitive":
                        this.intransitiveVerbs.add(new IntransitiveVerb(str));
                        break;
                    case "transitive":
                        this.transitiveVerbs.add(new TransitiveVerb(str));
                        break;
                    case "adjective":
                        this.adjectives.add(new Adjective(str));
                        break;
                    case "preposition":
                        this.prepositions.add(new Preposition(str));
                        break;
                    case "conjunction":
                        this.conjunctions.add(new Conjunction(str));
                        break;
                    case "article":
                        this.articles.add(new Article(str));
                        break;
                    case "adverb":
                        this.adverbs.add(new Adverb(str));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }

        }
        for (Verb v : this.transitiveVerbs) {
            this.verbs.add(v);
        }
        for (Verb v : this.intransitiveVerbs) {
            this.verbs.add(v);
        }

    }

    /**
     * @return the verbs
     */
    public LinkedList<IntransitiveVerb> getIntransitiveVerbs() {
        return this.intransitiveVerbs;
    }

    /**
     * @return the nouns
     */
    public LinkedList<Noun> getNouns() {
        return this.nouns;
    }

    /**
     * @return the verbs
     */
    public LinkedList<Verb> getVerbs() {
        return this.verbs;
    }

    /**
     * @return the transitiveVerbs
     */
    public LinkedList<TransitiveVerb> getTransitiveVerbs() {
        return this.transitiveVerbs;
    }

    /**
     * @return the adjectives
     */
    public LinkedList<Adjective> getAdjectives() {
        return this.adjectives;
    }

    /**
     * @return the prepositions
     */
    public LinkedList<Preposition> getPrepositions() {
        return this.prepositions;
    }

    /**
     * @return the conjunctions
     */
    public LinkedList<Conjunction> getConjunctions() {
        return this.conjunctions;
    }

    /**
     * @return the articles
     */
    public LinkedList<Article> getArticles() {
        return this.articles;
    }

    /**
     * @return the adverbs
     */
    public List<Adverb> getAdverbs() {
        return this.adverbs;
    }

}
