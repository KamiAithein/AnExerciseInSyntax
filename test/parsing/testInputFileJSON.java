package parsing;

import org.junit.Test;

public class testInputFileJSON {

    @Test
    public void test() {
        InputFileJSON ifjs = new InputFileJSON("data/test1.json");
        ifjs.dumpToFile("data/test1output.txt");
    }

}
