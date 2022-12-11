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
     *
     * @param name - student's name.
     */
    public RecordBook(String name) {
        this.name = name;
        diplomaWorkMark = 0;
        semesters = new HashMap<>();
        semesterNumber = 1;
        semesters.put(semesterNumber, new Marks());
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
     */
    public void setDiplomaWorkMark(int newMark) {
        if (newMark >= 2 && newMark <= 5) {
            this.diplomaWorkMark = newMark;
        } else {
            throw new IllegalArgumentException("Wrong mark value!");
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
     */
    public void setSemesterNumber(int semesterNumber) {
        if (semesterNumber > 0 && semesterNumber <= 8) {
            semesters.computeIfAbsent(semesterNumber, k -> new Marks());
            this.semesterNumber = semesterNumber;
        } else {
            throw new IllegalArgumentException("Wrong semester number value!");
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
     */
    public void addMark(String subject, int mark) {
        if (mark >= 2 && mark <= 5) {
            if (semesters.get(semesterNumber).marks.get(subject) != null) {
                System.out.println("If you want to change a mark, use changeMark() method.");
                System.out.println("Hint: also check correctness of the semester number");
                throw new IllegalStateException("Student already has a mark in this subject.");
            } else {
                semesters.get(semesterNumber).marks.put(subject, mark);
            }
        } else {
            throw new IllegalArgumentException("Wrong mark value!");
        }
    }

    /**
     * Method to change existing mark.
     *
     * @param subject - subject to change a mark.
     * @param newMark - new mark value.
     */
    public void changeMark(String subject, int newMark) {
        if (semesters.get(semesterNumber) == null) {
            throw new IllegalStateException("Student hasn't got marks in this semester.");
        }
        if (newMark >= 2 && newMark <= 5) {
            if (semesters.get(semesterNumber).marks.get(subject) != null) {
                semesters.get(semesterNumber).marks.put(subject, newMark);
            } else {
                System.out.println("If you want to add a mark, use addMark() method.");
                System.out.println("Hint: also check correctness of the semester number");
                throw new IllegalStateException("Student hasn't got a mark in this subject.");
            }
        } else {
            throw new IllegalArgumentException("Wrong mark value!");
        }
    }

    /**
     * Getter for a mark in current semester.
     *
     * @param subject - subject to get a mark.
     * @return mark value in selected subject.
     */
    public int getMark(String subject) {
        if (semesters.get(semesterNumber) != null) {
            if (semesters.get(semesterNumber).marks.get(subject) != null) {
                return semesters.get(semesterNumber).marks.get(subject);
            } else {
                System.out.println("If you want to add a mark, use addMark() method.");
                System.out.println("Hint: also check correctness of the semester number");
                throw new IllegalStateException("Student hasn't got a mark in this subject.");
            }
        } else {
            throw new IllegalStateException("Student hasn't got marks in this semester.");
        }
    }

    /**
     * Removes the mark.
     *
     * @param subject - subject to remove the mark.
     */
    public void deleteMark(String subject) {
        if (semesters.get(semesterNumber) == null) {
            throw new IllegalStateException("Student hasn't got marks in this semester.");
        }
        if (semesters.get(semesterNumber).marks.get(subject) == null) {
            throw new IllegalStateException("Student hasn't got a mark in this subject.");
        }
        semesters.get(semesterNumber).marks.remove(subject);
    }

    /**
     * Calculate a semester grade point.
     *
     * @param semesterNumber - number of the semester.
     * @return semester grade point.
     */
    private double semesterGradePoint(int semesterNumber) {
        //noinspection OptionalGetWithoutIsPresent
        double gradePoint =
            semesters.get(semesterNumber).marks.values().stream().reduce(Integer::sum).get();
        int counter = semesters.get(semesterNumber).marks.values().size();
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
        return semesters.get(semesterNumber).marks.values().stream().noneMatch(s -> s < 5);
    }

    /**
     * Count the ability of getting red diploma.
     *
     * @return true if it's possible, else returns false.
     */
    public boolean redDiplomaCheck() {
        if (diplomaWorkMark == 0) {
            throw new IllegalStateException("No diploma work mark.");
        }
        for (Marks i : semesters.values()) {
            if (i.marks.isEmpty()) {
                throw new IllegalStateException("It is too early to calculate the grade "
                    + "diploma mark. Student hasn't finished the last semester.");
            }
        }
        if (diplomaWorkMark < 5) {
            return false;
        }
        for (int i = 2; i < 9; i += 2) {
            if (semesters.get(i).marks.values().stream().anyMatch(s -> s < 4)) {
                return false;
            }
        }
        return !(semesterGradePoint(8) < 4.75);
    }
}