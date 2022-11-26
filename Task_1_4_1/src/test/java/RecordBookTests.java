import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing module for my Record Book realisation.
 */
public class RecordBookTests {

    @Test
    public void myRealRecordBookTest() throws Exception {
        RecordBook recordBook = new RecordBook("Mikhail");
        Assertions.assertEquals("Mikhail", recordBook.getName());
        recordBook.addMark("Algebra", 3);
        recordBook.addMark("DiscreteMath", 3);
        recordBook.addMark("Declarative", 3);
        recordBook.addMark("Imperative", 4);
        recordBook.addMark("English", 5);
        recordBook.deleteMark("English");
        recordBook.addMark("History", 2);
        recordBook.changeMark("History", 5);
        recordBook.addMark("Russian", 5);
        Assertions.assertEquals(1, recordBook.getSemesterNumber());
        Assertions.assertEquals(3.8, recordBook.gradePointAverage());
        Assertions.assertFalse(recordBook.scholarshipCheck());
        recordBook.setSemesterNumber(2);
        recordBook.addMark("Algebra", 3);
        recordBook.addMark("DiscreteMath", 3);
        recordBook.addMark("Declarative", 3);
        recordBook.addMark("Imperative", 3);
        recordBook.addMark("English", 5);
        recordBook.addMark("DigitalPlatforms", 4);
        Assertions.assertEquals(3.7, recordBook.gradePointAverage());
        Assertions.assertEquals(5, recordBook.getMark("English"));
    }

    @Test
    public void goodDiplomaMarkTest() throws Exception {
        RecordBook recordBook = new RecordBook("Evan");
        recordBook.setName("Ivan");
        Assertions.assertEquals("Ivan", recordBook.getName());
        recordBook.addMark("Algebra", 5);
        recordBook.addMark("DiscreteMath", 5);
        recordBook.addMark("Declarative", 5);
        recordBook.addMark("Imperative", 5);
        recordBook.addMark("History", 5);
        recordBook.addMark("Russian", 5);
        Assertions.assertTrue(recordBook.scholarshipCheck());
        recordBook.setSemesterNumber(2);
        recordBook.addMark("English", 5);
        recordBook.addMark("DigitalPlatforms", 4);
        for (int i = 3; i < 9; i++) {
            recordBook.setSemesterNumber(i);
            recordBook.addMark("English", 5);
        }
        recordBook.setDiplomaWorkMark(5);
        Assertions.assertEquals(5, recordBook.getDiplomaWorkMark());
        Assertions.assertTrue(recordBook.redDiplomaCheck());
    }

    @Test
    public void badDiplomaMarkTest1() throws Exception {
        RecordBook recordBook = new RecordBook("Ivan");
        for (int i = 1; i < 9; i++) {
            recordBook.setSemesterNumber(i);
            recordBook.addMark("Algebra", 3);
        }
        recordBook.setDiplomaWorkMark(5);
        Assertions.assertFalse(recordBook.redDiplomaCheck());
    }

    @Test
    public void badDiplomaMarkTest2() throws Exception {
        RecordBook recordBook = new RecordBook("Ivan");
        for (int i = 1; i < 9; i++) {
            recordBook.setSemesterNumber(i);
            recordBook.addMark("Algebra", 5);
        }
        recordBook.setDiplomaWorkMark(4);
        Assertions.assertFalse(recordBook.redDiplomaCheck());
    }
}
