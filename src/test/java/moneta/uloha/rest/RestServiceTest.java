package moneta.uloha.rest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class RestServiceTest {

    RestService service = new RestService();

    @Test
    public void testTransform(){

        String text = "Ahoj, jak se   máš?";
        String reverseText = service.transform(text);

        assertTrue(reverseText.equals("?šÁm es kaj ,jOha"));
    }

    @Test
    public void testReverseLetters(){
        char[] text = new char[] {'a', 'b', 'c', 'd'};
        char[] reverseText = service.reverseLetters(text);

        char[] check = new char[] {'d', 'c', 'b', 'a'};

        assertArrayEquals(reverseText, check);
    }

    @Test
    public void testCreatePattern(){
        char[] text = new char[] {'a', 'b', 'c', 'D', 'E'};
        int[] pattern = service.createPattern(text);

        int[] check = new int[] {1,0,0,0,1};

        assertArrayEquals(pattern, check);
    }

    @Test
    public void testApplyPattern(){
        char[] text = new char[] {'a', 'b', 'c', 'D', 'E'};
        int[] pattern = new int[]{1,0,1,1,0};
        char[] patternText = service.applyPattern(text, pattern);

        char[] check = new char[]{'A','b','C','D','e'};

        assertArrayEquals(patternText, check);
    }
}
