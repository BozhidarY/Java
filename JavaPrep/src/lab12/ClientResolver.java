package lab12;

import lab12.Constructors.*;
import lab12.Validators.WrongCredentialsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientResolver implements Runnable{

    private final Socket client;

    public ClientResolver(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter printWriter = new PrintWriter(client.getOutputStream())){
        printWriter.println("Enter usertype");
        UserType userType = UserType.valueOf(bufferedReader.readLine());
        String username;
        String password;

        switch(userType){
            case ADMIN ->{
                printWriter.println("Login or register");
                String choice = bufferedReader.readLine();

                if(choice.equals("Register")){
                    username = bufferedReader.readLine();
                    password = bufferedReader.readLine();
                    String result = Admin.registerAdmin(username,password);
                    System.out.println(result);
                    openAdminCommunication(bufferedReader, printWriter);

                }
                else if(choice.equals("Login")){
                    username = bufferedReader.readLine();
                    password = bufferedReader.readLine();
                    for(Admin admin : UsersDB.admins){
                        if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
                            openAdminCommunication(bufferedReader, printWriter);
                        }
                    }
                }
            }
            case STUDENT -> {
                username = bufferedReader.readLine();
                password = bufferedReader.readLine();
                for(Student student : UsersDB.students){
                    if(username.equals(student.getUsername()) && password.equals(student.getPassword())){
                        openStudentCommunication(printWriter);
                    }
                }
            }
            case TEACHER -> {
                username = bufferedReader.readLine();
                password = bufferedReader.readLine();
                for(Teacher teacher : UsersDB.teachers){
                    if(username.equals(teacher.getUsername()) && password.equals(teacher.getPassword())){
                        openTeacherCommunication(bufferedReader, printWriter);
                    }
                }

            }
        }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void openAdminCommunication(BufferedReader bufferedReader, PrintWriter printWriter){
        try{
            printWriter.println("What userType do you want to create");
            String userType = bufferedReader.readLine();
            if(userType.equals("Student")){
                Admin.createUser(UserType.STUDENT, bufferedReader.readLine(), bufferedReader.readLine());
            }
            else if(userType.equals("Teacher")){
                Admin.createUser(UserType.TEACHER, bufferedReader.readLine(), bufferedReader.readLine());
            }
        } catch (IOException | WrongCredentialsException e) {
            throw new RuntimeException(e);
        }
    }

    public void openStudentCommunication(PrintWriter printWriter){
        try{
            String sortedGrades = Grade.sortGrades();
            printWriter.println(sortedGrades);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void openTeacherCommunication(BufferedReader bufferedReader, PrintWriter printWriter){
        try{
            printWriter.println("Enter facN of a student and a new grade");
            String facN = bufferedReader.readLine();
            for(Student student: UsersDB.students){
                if(facN.equals(student.getUsername())){
                    Grade.addGrades(Double.parseDouble(bufferedReader.readLine()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
