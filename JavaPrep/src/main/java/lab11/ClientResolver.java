package lab11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientResolver implements Runnable {

    private final Socket client;

    public ClientResolver(Socket client){
        this.client = client;
    }

    public List<Tickets> notResolved = Collections.synchronizedList(new ArrayList<>());
    public List<Tickets> resolved = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter printWriter = new PrintWriter(client.getOutputStream())){

            String userType;
            userType = bufferedReader.readLine();
            switch (userType){
                case "Customer" -> {
                    Customers customer = new Customers(Integer.parseInt(bufferedReader.readLine()));
                    openCustomerCommunication(customer, bufferedReader);
                }
                case "Support" -> {
                    Supports supports = new Supports(bufferedReader.readLine());
                    openSupportCommunication(supports, bufferedReader);
                }

            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void openCustomerCommunication(Customers customer, BufferedReader bufferedReader){
        try{
            String message = bufferedReader.readLine();
            Tickets tickets = new Tickets(message, false);
            notResolved.add(tickets);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void openSupportCommunication(Supports support, BufferedReader bufferedReader){
        for(Tickets ticket : notResolved){
            ticket.changeStatus();
            if(ticket.isResolved()){
                resolved.add(ticket);
            }
        }
    }
}
