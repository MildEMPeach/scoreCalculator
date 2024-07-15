package scoreCalculator;

import java.io.File;
import static scoreCalculator.Utils.*;

/**
 * 
 * Repository is the main place dealing with the file and disk, just like a console.
 * @author mildEmPeach
 */

public class Repository {
    public static final File CWD = new File(System.getProperty("user.dir"));
    public static final File RESULT = join(CWD, ".score");
    public static final File SCOR_FILE = join(RESULT, "myscore");
    public static Result scoreFile;


    public static void init() {
        if (RESULT.exists()) {
            System.out.println("Don't init your score repository more than one time!");
            System.exit(0);
        }
        RESULT.mkdir();
        scoreFile = new Result();
        scoreFile.SaveResult();
    }

    public static void add(String courseName, int coursePoint, double score, double gradePoint) {
        if (!RESULT.exists()) {
            System.out.println("Please init your repository first!");
            System.out.println("Suggest command: init");
            System.exit(0);
        }
        /**TODO:Deal with adding the same course more than once, maybe replace or
         * display the error.
        */
        scoreFile = Result.getCurrResult();
        scoreFile.addResult(courseName, coursePoint, score, gradePoint);
        scoreFile.SaveResult();
    }

    public static void calculate(String method) {
        /**TODO:Deal with using calculate command on an empty file, maybe pop some
         * error message.
         * 
        */
        if (method.equals("averagescore")) {
            calScore();
        } else if (method.equals("averagepoint")) {
            calPoint();
        } else {
            System.out.println("Invalid argument for command 'calculate'");
            System.exit(0);
        }
    }

    private static void calScore() {
        scoreFile = Result.getCurrResult();
        scoreFile.calAverageScore();
    }

    private static void calPoint() {
        scoreFile = Result.getCurrResult();
        scoreFile.calAveragePoint();
    }

    public static void clear() {
        scoreFile = Result.getCurrResult();
        scoreFile.getCourseToScoreMap().clear();
        scoreFile.SaveResult();
    }
}