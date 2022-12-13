import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Class FileSearcher for searching the substring into txt file.
 */
public class FileSearcher {

    /**
     * Method for searching the substring into txt file.
     *
     * @param filename - name of file for searching.
     * @param string - substring to search.
     * @return arr - array list with indexes of found substrings.
     */
    public static List<Long> search(InputStream filename, String string) {
        List<Long> ansArray = new ArrayList<>();
        List<Character> buffer = new ArrayList<>();
        long i = 0;
        int findCnt = 0;
        try (Reader badReader = new InputStreamReader(filename, StandardCharsets.UTF_8)) {
            try (Reader reader = new BufferedReader(badReader)) {
                int c;
                while ((c = reader.read()) != -1) {
                    i++;
                    if (c == string.charAt(findCnt)) {
                        buffer.add((char) c);
                        findCnt++;
                        if (findCnt == string.length()) {
                            ansArray.add(i - findCnt);
                            findCnt = 0;
                            buffer.clear();
                        }
                    } else {
                        if (findCnt != 0) {
                            buffer.add((char) c);
                            buffer.remove(0);
                            findCnt = bufferSearch(buffer, string);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ansArray;
    }

    private static int bufferSearch(List<Character> buffer, String string) {
        int findCnt = 0;
        for (Character character : buffer) {
            if (character == string.charAt(findCnt)) {
                findCnt++;
            } else {
                findCnt = 0;
            }
        }
        return findCnt;
    }
}