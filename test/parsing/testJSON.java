package parsing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testJSON {

    @Test
    public void test1_json() {
        JSON js = new JSON("data/test1.json");
        assertEquals(
                "[\"chaloopa\",  \"marshmellow\",  \"mimi\",  \"idea\",  \"mall\",  \"potato\"]",
                js.getNouns().toString());
        assertEquals(
                "[\"green\",  \"colorless\",  \"floofy\",  \"cute\",  \"white\",  \"weird\"]",
                js.getAdjectives().toString());
        assertEquals("[\"a\",  \"the\",  \"that\"]",
                js.getArticles().toString());
        assertEquals("[\"while\",  \"during\",  \"and\",  \"for\"]",
                js.getConjunctions().toString());
        assertEquals("[\"runs\",  \"eats\",  \"flies\",  \"cries\"]",
                js.getIntransitiveVerbs().toString());
        assertEquals(
                "[\"in\",  \"at\",  \"by\",  \"under\",  \"through\",  \"beside\"]",
                js.getPrepositions().toString());
        assertEquals(
                "[\"kills\",  \"snorts\",  \"smacks\",  \"slaps\",  \"loves\"]",
                js.getTransitiveVerbs().toString());
        assertEquals(
                "[\"kills\",  \"snorts\",  \"smacks\",  \"slaps\",  \"loves\", \"runs\",  \"eats\",  \"flies\",  \"cries\"]",
                js.getVerbs().toString());

    }
}
