package parsing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import fragment.noun.NounFragment;
import fragment.verb.IntransitiveVerbFragment;
import fragment.verb.TransitiveVerbFragment;
import sentence.Clause;
import sentence.Sentence;
import word.boundWord.Adjective;
import word.boundWord.Article;
import word.freeWord.noun.Noun;
import word.freeWord.verb.IntransitiveVerb;
import word.freeWord.verb.TransitiveVerb;

/**
 * Parses a JSON file.
 *
 * @author Koepcke.1
 *
 */
public class InputFileJSON implements InputFile {

    /**
     * The JSON file representing this file.
     */
    private JSON js;

    /**
     * Constructs an inputFile from a given JSON.
     *
     * @param fileName
     *            the filename
     */
    public InputFileJSON(String fileName) {
        this.js = new JSON(fileName);
    }

    /**
     * Gets the sentences from the input file.
     */
    @Override
    public List<Sentence> getSentences() {
        List<Noun> nouns = this.js.getNouns();
        List<Article> articles = this.js.getArticles();
        List<Adjective> adjectives = this.js.getAdjectives();
        assert nouns.size() > 0 : "There must be nouns";

        List<NounFragment> nounFrags = new LinkedList<>();
        for (Noun n : nouns) {
            for (Article art : articles) {
                for (Adjective adj : adjectives) {
                    NounFragment nounFrag = new NounFragment(n);
                    nounFrag.addBoundWord(art);
                    nounFrag.addBoundWord(adj);
                    nounFrags.add(nounFrag);
                }
            }
        }
        /*
         * Clauses ======================
         */
        List<Clause> clauses = new LinkedList<>();
        /*
         * Transitive Verbs
         */
        List<TransitiveVerb> transVerbs = this.js.getTransitiveVerbs();
        for (TransitiveVerb tv : transVerbs) {
            for (NounFragment nfObject : nounFrags) {
                TransitiveVerbFragment tvf = new TransitiveVerbFragment(tv,
                        nfObject);
                for (NounFragment nfSubject : nounFrags) {
                    clauses.add(new Clause(nfSubject, tvf));
                }
            }
        }

        /*
         * Intransitive Verbs
         */
        List<IntransitiveVerb> intransVerbs = this.js.getIntransitiveVerbs();
        for (IntransitiveVerb iv : intransVerbs) {
            for (NounFragment nfSubject : nounFrags) {
                IntransitiveVerbFragment ivf = new IntransitiveVerbFragment(iv);
                clauses.add(new Clause(nfSubject, ivf));
            }
        }
        /*
         * ==============================
         */
        List<Sentence> sentences = new LinkedList<>();
        for (Clause c : clauses) {
            sentences.add(new Sentence(c));

        }
        return sentences;
    }

    /**
     * Dumps the sentences to the given file.
     *
     * @param fileName
     *            the fileName
     */
    public void dumpToFile(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (Sentence s : this.getSentences()) {
                bw.write(s.toString());
                bw.write("\n");
            }
            bw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
