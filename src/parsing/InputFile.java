package parsing;

import java.util.List;

import grammar.sentence.Sentence;

/**
 * Interface describing the functions of a basic inputFile.
 *
 * @author Koepcke.1
 *
 */
public interface InputFile {
    /**
     * Gets all terms from the input file.
     *
     * @return all terms from the input file in a set
     */
    List<Sentence> getSentences();
}
