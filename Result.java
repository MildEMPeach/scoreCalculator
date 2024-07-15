package scoreCalculator;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import static scoreCalculator.Utils.*;
import java.io.File;

/**
 * Result contains a HashMap, which contains all the information about 
 * the course and corresponding score.
 * @author mildEmPeach
 */

public class Result implements Serializable{
    private Map<Course, Score> courseToScoreMap;

    public class Score implements Serializable{
        /** score and gradepoint */
        private double score;
        private double gradePoint;
        public Score(double score, double gradePoint) {
            this.score = score;
            this.gradePoint = gradePoint;
        }

        public double getScore() {
            return this.score;
        }

        public double getgradePoint() {
            return this.gradePoint;
        }

    }

    public class Course implements Serializable{
        String name;
        int point;
    
        public Course (String name, int point) {
            this.name = name;
            this.point = point;
        }

        public int getpoint() {
            return this.point;
        }
    }

    public Result() {
        courseToScoreMap = new HashMap<>();
    }

    public Map<Course, Score> getCourseToScoreMap() {
        return this.courseToScoreMap;
    }

    public void SaveResult() {
        File desFile = Repository.SCOR_FILE;
        writeObject(desFile, this);
    }

    public static Result getCurrResult() {
        File desFile = join(Repository.RESULT ,"myscore");
        return readObject(desFile, Result.class);
    }

    public void addResult(String courseName, int coursePoint, double score, double gradePoint) {
        // TODO:repetive add
        Course newCourse = new Course(courseName, coursePoint);
        Score newScore = new Score(score, gradePoint);
        courseToScoreMap.put(newCourse, newScore);
    }

    public void calAverageScore() {
        int sumpoint = 0;
        double sumPointMulScore = 0.0;
        for (Course curriculumn : this.getCourseToScoreMap().keySet()) {
            int p = curriculumn.getpoint(); 
            sumpoint += p;
            double s = this.getCourseToScoreMap().get(curriculumn).getScore();
            sumPointMulScore += s * p;
        }
        double averagescore = sumPointMulScore / sumpoint;
        System.out.println("Your average score is " + String.valueOf(averagescore));
    }

    public void calAveragePoint() {
        int sumpoint = 0;
        double sumPointMulGrade = 0.0;
        for (Course curriculumn: this.getCourseToScoreMap().keySet()) {
            int p = curriculumn.getpoint();
            sumpoint += p;
            double s = this.getCourseToScoreMap().get(curriculumn).getgradePoint();
            sumPointMulGrade += s * p;
        }
        double averagepoint = sumPointMulGrade / sumpoint;
        System.out.println("Your average gradepoint is " + String.valueOf(averagepoint));
    }
        
}

