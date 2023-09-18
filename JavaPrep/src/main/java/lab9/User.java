package lab9;

import javax.swing.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Validator{
    private String nickname;
    private String password;

    private final Pattern Email_patern = Pattern.compile("^[a-zA-Z]$");
    private final String filePath = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab9\\nameAndPass.txt";

    public User(String nickname, String password) throws WrongEmailException {
        this.setNickname(nickname);
        this.password = password;
    }

    @Override
    public boolean checkEmail(String email) {
        Matcher matcher = Email_patern.matcher(email);
        return matcher.matches();
    }

    public void addUser(String name, String password) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {
            printWriter.println(name + " " + password);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean checkNameAndPass(File file, String name, String password){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null){
                String[] index = currentLine.split(" ");
                if(index[0].equals(name) && index[1].equals(password)){
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) throws WrongEmailException{
        if(checkEmail(nickname)){
            this.nickname = nickname;
        }
        else {
            throw new WrongEmailException();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
