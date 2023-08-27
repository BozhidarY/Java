package lab13;

import lab13.Constructors.Question;
import lab13.Constructors.Quiz;
import lab13.Constructors.Student;
import lab13.Exceptions.StudentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientResolver implements Runnable{

    private final Socket client;

    public ClientResolver(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter printWriter = new PrintWriter(client.getOutputStream())){
            String username = bufferedReader.readLine();
            int password = Integer.parseInt(bufferedReader.readLine());
            Student student = new Student(username,password);
            List<Question> questions = Quiz.loadQuestions("users.bin");
            Quiz quiz = new Quiz(student, questions);
            printWriter.println("Enter question index and your answer");
            Map<Integer, Question.Answer> checkQuestions = new HashMap<>();

            while(quiz.hasNext()){
                checkQuestions.put(quiz.getCurrentQuestionIndex(), Question.Answer.valueOf(bufferedReader.readLine()));
                quiz.setCurrentQuestionIndex(quiz.getCurrentQuestionIndex() + 1);
            }
            quiz.setAnswer(Question.Answer.A);

            quiz.isPassed(checkQuestions);
            quiz.saveToFile("results.bin", checkQuestions);
        }catch (IOException e){
            e.printStackTrace();
        } catch (StudentException e) {
            throw new RuntimeException(e);
        }
    }
}
