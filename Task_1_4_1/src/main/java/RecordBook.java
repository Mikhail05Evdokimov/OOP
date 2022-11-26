import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Class record book which stores information about student:
 * Student's name, diploma work mark and semester grades
 * as Map (semester number, Marks).
 */
public class RecordBook {
    private String name;
    private int diplomaWorkMark;
    private int semesterNumber;
    private final Map<Integer, Marks> semesters;

    /**
     * Constructor for RecordBook class.
     * @param name - student's name.
     */
    public RecordBook(String name) {
        this.name = name;
        this.diplomaWorkMark = 0;
        this.semesters = new HashMap<>();
        this.semesterNumber = 1;
        this.semesters.put(semesterNumber, new Marks());
    }

    /**
     * Name getter.
     *
     * @return student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter.
     *
     * @param newName - new student's name.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Setter for DiplomaWorkMark.
     *
     * @param newMark - new value of Diploma Work Mark.
     * @throws Exception in case of incorrect input value.
     */
    public void setDiplomaWorkMark(int newMark) throws Exception {
        if (newMark >= 2 && newMark <= 5) {
            this.diplomaWorkMark = newMark;
        } else {
            throw new Exception("Wrong mark value!");
        }
    }

    /**
     * Getter for DiplomaWorkMark.
     *
     * @return the value of Diploma Work Mark.
     */
    public int getDiplomaWorkMark() {
        return diplomaWorkMark;
    }

    /**
     * Semester number setter.
     *
     * @param semesterNumber - desired semester number.
     * @throws Exception in case of incorrect input value.
     */
    public void setSemesterNumber(int semesterNumber) throws Exception {
        if (semesterNumber > 0 && semesterNumber <= 8) {
            this.semesters.computeIfAbsent(semesterNumber, k -> new Marks());
            this.semesterNumber = semesterNumber;
        } else {
            throw new Exception("Wrong semester number value!");
        }
    }

    /**
     * Semester number getter.
     *
     * @return current semester number.
     */
    public int getSemesterNumber() {
        return this.semesterNumber;
    }

    /**
     * Method to add a new mark as subject name and subject mark.
     *
     * @param subject - subject name.
     * @param mark - mark for this subject.
     * @throws Exception in case of incorrect mark value or if the subject has already had a mark.
     */
    public void addMark(String subject, int mark) throws Exception {
        if (mark >= 2 && mark <= 5) {
            if (semesters.get(semesterNumber).marks.get(subject) != null) {
                System.out.println("If you want to change a mark, use changeMark() method.");
                System.out.println("Hint: also check correctness of the semester number");
                throw new Exception("Student already has a mark in this subject.");
            } else {
                semesters.get(semesterNumber).marks.put(subject, mark);
            }
        } else {
            throw new Exception("Wrong mark value!");
        }
    }

    /**
     * Method to change existing mark.
     *
     * @param subject - subject to change a mark.
     * @param newMark - new mark value.
     * @throws Exception in case of incorrect mark value or if the subject doesn't have a mark yet.
     */
    public void changeMark(String subject, int newMark) throws Exception {
        if (newMark >= 2 && newMark <= 5) {
            if (this.semesters.get(semesterNumber).marks.get(subject) != null) {
                this.semesters.get(semesterNumber).marks.put(subject, newMark);
            } else {
                System.out.println("If you want to add a mark, use addMark() method.");
                System.out.println("Hint: also check correctness of the semester number");
                throw new Exception("Student hasn't got a mark in this subject.");
            }
        } else {
            throw new Exception("Wrong mark value!");
        }
    }

    public int getMark(String subject) throws Exception {
        if (this.semesters.get(semesterNumber).marks.get(subject) != null) {
            return this.semesters.get(semesterNumber).marks.get(subject);
        } else {
            System.out.println("If you want to add a mark, use addMark() method.");
            System.out.println("Hint: also check correctness of the semester number");
            throw new Exception("Student hasn't got a mark in this subject.");
        }
    }

    /**
     * Removes the mark.
     *
     * @param subject - subject to remove the mark.
     * @throws Exception if student doesn't have a mark in this subject.
     */
    public void deleteMark(String subject) throws Exception {
        if (this.semesters.get(semesterNumber).marks.get(subject) == null) {
            throw new Exception("Student hasn't got a mark in this subject.");
        }
        this.semesters.get(semesterNumber).marks.remove(subject);
    }

    /**
     * Calculate a semester grade point.
     *
     * @param semesterNumber - number of the semester.
     * @return semester grade point.
     */
    private double semesterGradePoint(int semesterNumber) {
        double gradePoint = 0;
        int counter = 0;
        for (int i : semesters.get(semesterNumber).marks.values()) {
            if (i != 0) {
                gradePoint += i;
                counter++;
            }
        }
        gradePoint = gradePoint / counter;
        return gradePoint;
    }

    /**
     * Calculate average grade point for all filled semesters.
     *
     * @return average grade point.
     */
    public double gradePointAverage() {
        double finalGrade = 0;
        for (int i = 1; i <= semesters.size(); i++) {
            finalGrade += semesterGradePoint(i);
        }
        finalGrade /= semesters.size();
        BigDecimal result = new BigDecimal(finalGrade);
        result = result.setScale(1, RoundingMode.HALF_UP);
        return result.doubleValue();
    }

    /**
     * Count the ability of scholarship promotion.
     *
     * @return true if it's possible, else returns false.
     */
    public boolean scholarshipCheck() {
        for (int i : semesters.get(semesterNumber).marks.values()) {
            if (i < 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * Count the ability of getting red diploma.
     *
     * @return true if it's possible, else returns false.
     * @throws Exception if student doesn't have a diploma work mark
     * or hasn't finished a learning yet.
     */
    public boolean redDiplomaCheck() throws Exception {
        if (diplomaWorkMark == 0) {
            throw new Exception("No diploma work mark.");
        }
        for (Marks i : semesters.values()) {
            if (i.marks.isEmpty()) {
                throw new Exception("It is too early to calculate the grade "
                    + "diploma mark. Student hasn't finished the last semester.");
            }
        }
        if (diplomaWorkMark < 5) {
            return false;
        }
        for (int i = 2; i < 9; i += 2) {
            for (int j : semesters.get(i).marks.values()) {
                if (j < 4) {
                    return false;
                }
            }
        }
        return !(semesterGradePoint(8) < 4.75);
    }
}