package lab14;

import lab12.UsersDB;
import lab14.Consctructors.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientResolver implements Runnable{
    private Socket client;

    public ClientResolver(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter printWriter = new PrintWriter(client.getOutputStream())){
            printWriter.println("Create or search for regex");
            String choose = bufferedReader.readLine();
            switch(choose){
                case "Create" -> {
                    Regex regex = new Regex(bufferedReader.readLine(), bufferedReader.readLine());
                    String[] testStrings = bufferedReader.readLine().split(" ");
                    List<Boolean> tests = RegexTester.test(regex, testStrings);
                    printWriter.println(tests);
                    printWriter.println("Do you want to add this regex? Y/N");

                    for(Regex regex1: RegexDB.regexs){
                        if(!regex.equals(regex1)){
                            RegexDB.regexs.add(regex);
                            RegexDB.saveRegexs("regexs.bin");
                        }
                    }
                }
                case "Search" ->{
                    List<Regex> keywordRegexs = new ArrayList<>();
                    String keyword = bufferedReader.readLine();
                    for(Regex regex: RegexDB.regexs){
                        if(regex.getDescription().contains(keyword)){
                            keywordRegexs.add(regex);
                            keywordRegexs.sort(Comparator.comparing(Regex::getRating).reversed());
                            printWriter.println(keywordRegexs);
                        }
                    }
                    int idChoose = Integer.parseInt(bufferedReader.readLine());
                    for(Regex regex: keywordRegexs){
                        if(idChoose == regex.getId()){
                            printWriter.println("Do you wish to change rating +/- 1");
                            regex.setRating(regex.getRating() + 1);
                        }
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
