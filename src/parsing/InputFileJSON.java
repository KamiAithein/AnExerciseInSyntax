package parsing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import grammar.fragment.noun.NounFragment;
import grammar.fragment.verb.IntransitiveVerbFragment;
import grammar.fragment.verb.TransitiveVerbFragment;
import grammar.sentence.Clause;
import grammar.sentence.Sentence;
import grammar.word.boundWord.Adjective;
import grammar.word.boundWord.Adverb;
import grammar.word.boundWord.Article;
import grammar.word.boundWord.BoundWord;
import grammar.word.freeWord.noun.Noun;
import grammar.word.freeWord.verb.IntransitiveVerb;
import grammar.word.freeWord.verb.TransitiveVerb;

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
        List<Adverb> adverbs = this.js.getAdverbs();
        NounFragment themself = new NounFragment(new Noun("themself"));
        assert nouns.size() > 0 : "There must be nouns";

        List<NounFragment> nounFrags = new LinkedList<>();
        for (Noun n : nouns) {
            for (Article art : articles) {
                NounFragment nounFragNoAdj = new NounFragment(n);
                nounFrags.add(nounFragNoAdj);
                for (Adjective adj : adjectives) {
                    NounFragment nounFrag = new NounFragment(n);
                    nounFrag.addBoundWord(art);
                    nounFrag.addBoundWord(adj);
                    nounFrags.add(nounFrag);
                    /**
                     * Create recursive n List bike lock function for adj number
                     */
                    for (Adjective adj2 : adjectives) {
                        if (adj2 != adj) {
                            NounFragment nounFrag2 = new NounFragment(n);
                            nounFrag2.addBoundWord(art);
                            nounFrag2.addBoundWord(adj);
                            nounFrag2.addBoundWord(adj2);
                            nounFrags.add(nounFrag2);
                        }
                    }
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
                for (Adverb adv : adverbs) {
                    TransitiveVerbFragment tvf = new TransitiveVerbFragment(tv,
                            nfObject);
                    tvf.addBoundWord(adv);
                    for (NounFragment nfSubject : nounFrags) {
                        boolean containsSubj = false;
                        for (BoundWord bw : nfSubject.getModifiers()) {
                            if (nfObject.getModifiers().contains(bw)) {
                                containsSubj = true;
                            }
                        }

                        if (!containsSubj && !nfSubject.getBaseWord()
                                .equals(nfObject.getBaseWord())) {
                            clauses.add(new Clause(nfSubject, tvf));
                        }

                    }
                }

            }
        }

        /*
         * Intransitive Verbs
         */
        List<IntransitiveVerb> intransVerbs = this.js.getIntransitiveVerbs();
        for (IntransitiveVerb iv : intransVerbs) {
            for (NounFragment nfSubject : nounFrags) {
                for (Adverb adv : adverbs) {
                    IntransitiveVerbFragment ivf = new IntransitiveVerbFragment(
                            iv);
                    ivf.addBoundWord(adv);
                    clauses.add(new Clause(nfSubject, ivf));
                }

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
