package lab7;

public class Main {

    public static void main(String[] args) {

        String fileName = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab7\\deviceLists.txt";
        Service service = new Service();


        Device device = new Device("Samsung", "Galaxy S20", 799.99);
        BrokenDevice brokenDevice = new BrokenDevice("Apple", "iPhone X", 699.99, "Screen cracked", "2");

        service.addDevices(device);
        service.addBrokenDevices(brokenDevice);

//        service.displayDevices();

        service.saveToFile(fileName);

        service = new Service();

        // Load the lists from the file
        service.loadFromFile(fileName);

        // Display the loaded lists
        service.displayDevices();

    }

}
