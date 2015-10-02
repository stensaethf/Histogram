/**
 * ListTest.java
 * A Java program that tests the methods of a list implementation.
 * Created by Frederik Roenn Stensaeth and Javier Moran.
 * 05.07.14
 */
public class ListTest {
    /** Tests methods of list implementaitons. */
    public static void main (String[] args) {
        List<String> testList;
        testList = new ArrayListImplementation<String>();
        //Tests the add method (single argument) of the list implementation. 
        //Prints an error message if method does not work properly.
        testList.add("Hi");
        if(!testList.at(testList.length() - 1).equals("Hi")) {
            System.out.printf("*** add FAILED: Expected Hi; Got %s ***\n", 
                testList.at(testList.length() - 1));
        }
        testList.add("null");
        if(!testList.at(testList.length() - 1).equals("null")) {
            System.out.printf("*** add FAILED: Expected null; Got %s ***\n", 
                testList.at(testList.length() - 1));
        }
        testList.add("false");
        if(!testList.at(testList.length() - 1).equals("false")) {
            System.out.printf("*** add FAILED: Expected false; Got %s ***\n", 
                testList.at(testList.length() - 1));
        }
        testList.add("true");
        if(!testList.at(testList.length() - 1).equals("true")) {
            System.out.printf("*** add FAILED: Expected true; Got %s ***\n", 
                testList.at(testList.length() - 1));
        }
        testList.add(".");
        if(!testList.at(testList.length() - 1).equals(".")) {
            System.out.printf("*** add FAILED: Expected .; Got %s ***\n", 
                testList.at(testList.length() - 1));
        }
        testList.add("");
        if(!testList.at(testList.length() - 1).equals("")) {
            System.out.printf("*** add FAILED: Expected \"\"; Got %s ***\n", 
                testList.at(testList.length() - 1));
        }
        testList.add("Hello Freddie wanted me to do this");
        if(!testList.at(testList.length() - 1).equals(
                            "Hello Freddie wanted me to do this")) {
            System.out.print("*** add FAILED: Expected Hello Freddie wanted ");
            System.out.printf("me to do this; Got %s ***\n", 
                              testList.at(testList.length() - 1));
        }
        testList.add("1");
        if(!testList.at(testList.length() - 1).equals("1")) {
            System.out.printf("*** add FAILED: Expected 1; Got %s ***\n", 
                              testList.at(testList.length() - 1));
        }
        testList.add("-1");
        if(!testList.at(testList.length() - 1).equals("-1")) {
            System.out.printf("*** add FAILED: Expected -1; Got %s ***\n", 
                              testList.at(testList.length() - 1));
        }
        testList.add("Hi \n Hello");
        if(!testList.at(testList.length() - 1).equals("Hi \n Hello")) {
            System.out.print("*** add FAILED: Expected Hi \\n Hello; ");
            System.out.printf("Got %s ***\n", 
                              testList.at(testList.length() - 1));
        }
        //Tests the add method (two-argument) of the list implementation.
        //Prints an error message if method does not work properly.
        testList.add(0, "Hi");
        if(!testList.at(0).equals("Hi")) {
            System.out.printf("*** add at FAILED: Expected Hi; Got %s ***\n", 
                              testList.at(0));
        }
        if(testList.add(-1, "Hi") == true) {
            System.out.print("*** add at FAILED: Expected false; "); 
            System.out.println("Got true ***");
        }
        if(testList.add(testList.length(), "Hi") == false) {
            System.out.print("*** add at FAILED: Expected true; "); 
            System.out.println("Got false ***");
        }
        if(testList.add(testList.length() + 1, "Hi") == true) {
            System.out.print("*** add at FAILED: Expected false; ");
            System.out.println("Got true ***");
        }
        if(testList.add(testList.length() / 2, "Hi") == false) {
            System.out.print("*** add at FAILED: Expected true; ");
            System.out.println("Got false ***");
        }
        //Tests the at method of the list implementation. Prints an error
        //message if method does not work properly.
        if(!testList.at(8).equals("Hello Freddie wanted me to do this")) {
            System.out.print("*** at FAILED: Expected Hello Freddie wanted ");
            System.out.printf("me to do this; Got %s ***\n", testList.at(8));
        }
        if(testList.at(-1) != null) {
            System.out.print("*** at FAILED: Expected null; Got an item "); 
            System.out.println("***");
        }
        if(testList.at(50) != null) {
            System.out.print("*** at FAILED: Expected null; Got an item ");
            System.out.println("***");
        }
        if(testList.at(testList.length()) != null) {
            System.out.print("*** at FAILED: Expected null; Got an item ");
            System.out.println("***");
        }

        //Tests the remove method of the list implementation. Prints an error
        //message if method does not work properly.
        String x = testList.remove(0);
        if(!x.equals("Hi")) {
            System.out.printf("*** remove FAILED: Expected Hi; Got %s ***\n", 
                              x);
        }
        x = testList.remove(-1);
        if(x != null) {
            System.out.printf("*** remove FAILED: Expected null; Got %s ***\n", 
                              x);
        }
        x = testList.remove(testList.length());
        if(x != null) {
            System.out.printf("*** remove FAILED: Expected null; Got %s ***\n", 
                              x);
        }
        x = testList.at(4);
        testList.remove(3);
        if(!testList.at(3).equals(x)) {
            System.out.printf("*** remove FAILED: Expected %s; Got %s ***\n", 
                              x, testList.at(3));
        }
        //Tests the clear method of the list implementation. Prints an error
        //message if method does not work properly.
        testList.clear();
        if(testList.at(0) != null) {
            System.out.printf("*** remove FAILED: Expected null; Got %s ***\n", 
                              testList.at(0));
        }

        testList.add("Hi");
        testList.add("message1");
        testList.add("message2");
        testList.add("message3");
        testList.add("message4");
        testList.add("message5");

        //Tests the replace method of the list implementation. Prints an error
        //message if method does not work properly.
        if(testList.replace(-1, "message6") != false) {
            System.out.print("*** replace FAILED: Expected false; Got "); 
            System.out.println("true ***");
        }
        if(testList.replace(testList.length(), "message6") != false) {
            System.out.print("*** replace FAILED: Expected false; Got ");
            System.out.println("true ***");
        }
        testList.replace(0, testList.at(1));
        if(!testList.at(1).equals(testList.at(0))) {
            System.out.printf("*** replace FAILED: Expected %s; Got %s ***\n", 
                              testList.at(1), testList.at(0));
        }

        //Tests the contains method of the list implementation. Prints an error
        //message if method does not work properly.
        if(!testList.contains("message5")) {
            System.out.print("*** contains FAILED: Expected true; Got ");
            System.out.println("false ***");
        }
        if(testList.contains("message6")) {
            System.out.print("*** contains FAILED: Expected false; Got ");
            System.out.println("true ***");
        }

        //Tests the length method of the list implementation. Prints an error
        //message if method does not work properly.
        int length = testList.length();
        testList.add("message6");
        if((length + 1) != testList.length()) {
            System.out.printf("*** length FAILED: Expected %d; Got %d ***\n", 
                              length + 1, testList.length());
        }

        //Tests the isEmpty method of the list implementation. Prints an error
        //message if method does not work properly.
        if(testList.isEmpty()) {
            System.out.print("*** length FAILED: Expected false; Got true "); 
            System.out.println("***");
        }
        testList.clear();
        if(!testList.isEmpty()) {
            System.out.print("*** length FAILED: Expected true; Got false "); 
            System.out.println("***");
        }
    }
}