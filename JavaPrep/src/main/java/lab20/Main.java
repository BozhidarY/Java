package lab20;

import lab19.Users.Client;
import lab5.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoadJson loading = new LoadJson();
        DataB dataB = new DataB();
        Scanner scanner = new Scanner(System.in);

        loading.loadUsers("D:\\Java Prep\\Java\\JavaPrep\\src\\lab20\\data.json");

        Clients client = new Clients("Hello", "Buy");
        Clients client2 = new Clients("Helloooooooo", "Buy");
        Authors admin = new Authors("Hello", "Buy");
        Authors admin2 = new Authors("Hello", "Buyyyyy");
        Users user = new Users("User");
        String username = scanner.nextLine();
        Users user2 = new Users(username);

        dataB.getListUsers().add(client);
        dataB.getListUsers().add(client2);
        dataB.getListUsers().add(admin);
        dataB.getListUsers().add(user);
        dataB.getListUsers().add(user2);
        dataB.getListUsers().add(admin2);

        int countClients = 0;
        int countAuthors = 0;
        int countUsers = 0;

        for (Users users: dataB.getListUsers()){
            if(users instanceof Authors newAuthor){
                ACom(newAuthor);
            }
        }



        System.out.println("c" + countClients);
        System.out.println("A" + countAuthors);
        System.out.println("U" + countUsers);


        loading.saveUsers(System.getProperty("user.dir")+"\\src\\lab20\\data.json", dataB);
    }

    public static void ACom(Authors authors){
        System.out.println("Hello");
    }


}
