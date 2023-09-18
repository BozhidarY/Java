package lab12.Constructors;

import java.util.ArrayList;
import java.util.Comparator;

public class Grade {
    private int semester;
    private String discipline;
    private double newGrades;

    public static ArrayList<Grade> grades = new ArrayList<>();

    public Grade(int semester, String discipline, double newGrades) {
        this.semester = semester;
        this.discipline = discipline;
        this.newGrades = newGrades;
    }

    public static void addGrades(Double grade){
        for(Grade grade1: grades){
            grade1.setNewGrades(grade);
        }
    }

    public static String sortGrades(){
        grades.sort(Comparator.comparing(Grade::getSemester).thenComparing(Grade::getDiscipline));
        return grades.toString();
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public double getNewGrades() {
        return newGrades;
    }

    public void setNewGrades(double newGrades) {
        this.newGrades = newGrades;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "semester=" + semester +
                ", discipline='" + discipline + '\'' +
                ", newGrades=" + newGrades +
                '}';
    }
}
