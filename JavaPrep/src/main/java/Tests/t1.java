package Tests;


import java.util.*;

public class t1 {

    static class Student{
        public int N;
        public String pass;

        public Student(int n, String pass) {
            N = n;
            this.pass = pass;
        }

        public int isPassed(Map<Integer, String > questionsMap){
            int count = 0;
            if(questionsMap.containsKey(N)){
                if(pass.equals(questionsMap.get(N))){
                    count++;
                }
            }
            return count;
        }
    }
    public static void main(String[] args){
//        String f = new String("f");
//        changeReference(f); // It won't change the reference!
//        modifyReference(f); // It will modify the object that the reference variable "f" refers to!
//    }
//    public static void changeReference(String a){
//        String b = new String("b");
//        a = b;
//    }
//    public static void modifyReference(String c){
//        c);

//----------------------------------Linked List--------------------------------------------------
        // create a linked list
//        LinkedList ll = new LinkedList();
//        LinkedList<String> ll= new LinkedList<String>();
//        // add elements to the linked list
//        ll.add("I");
//        ll.add("am");
//        ll.add("example");
//        ll.add("!");
//        System.out.println("Original contents of ll: " + ll);
//        // remove elements from the linked list
//        ll.remove("!");
//        ll.remove(2);
//        System.out.println("Contents of ll after deletion: " + ll);
//        // remove first and last elements
//        ll.removeFirst();
//        ll.removeLast();

        //---------------------------------------Stack-------------------------------------------------
        // create a linked list
//        Stack cars=new Stack();
//        cars.push("Honda");
//        cars.push("Opel");
//        cars.push("Mazda");
//        cars.push("Audi");
//
//        System.out.println(cars.peek());

        //    -------------------------------------Queue--------------------------------------
//        Queue cars=new LinkedList();
//        cars.offer("Honda");
//        cars.offer("Opel");
//        cars.offer("Mazda");
//        cars.offer("Audi");
//
//        System.out.println(cars.peek());


        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1,"Hello");
        hm.put(2,"Bye");

        Student student = new Student(1, "Hello12");
        int result = student.isPassed(hm);
        System.out.println(result);

    }
}

