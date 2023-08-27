package lab13.Constructors;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Quiz {
    private Student student;
    private int currentQuestionIndex;
    private static List<Question> questions;

    public Quiz(Student student, List<Question> questions) {
        this.student = student;
        this.questions = questions;
    }

    public void saveToFile(String fileName, Map<Integer, Question.Answer> hm){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(hm);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Question> loadQuestions(String fileName){
        List<Question> loadedQuestions;

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            loadedQuestions = (List<Question>) objectInputStream.readObject();
            questions.addAll(loadedQuestions);
        } catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Collections.shuffle(questions);
        return questions;

    }

    public boolean hasNext(){
        if(getCurrentQuestionIndex() < questions.size()){
            return true;
        }
        else{
            return false;
        }
    }

    public String getCurrentQuestion(){
        String result = null;
        for(Question question: questions){
            result =  question.getQuestionText();
        }
        return result;
    }

    public void setAnswer(Question.Answer answer){
        if(hasNext()){
            questions.get(currentQuestionIndex).setAnswer(answer);
            currentQuestionIndex++;
        }
    }

    public boolean isPassed(Map<Integer, Question.Answer> questionsMap){
        int correctAnswers = 0;
        for(Question question: questions){
            if(questionsMap.containsKey(question.getId())){
                if(question.getAnswer() == questionsMap.get(question.getId())){
                    correctAnswers++;
                }
            }

        }
        if(correctAnswers > questions.size()/2 + 1){
            return true;
        }
        else {
            return false;
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestion) {
        this.currentQuestionIndex = currentQuestion;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
