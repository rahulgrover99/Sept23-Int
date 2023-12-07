package exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;

public class FileReader {

    public static void main(String[] args) {
//        try {
//            readFile();
////            System.out.println(1/0);
//            System.out.println("File is found");
//        } catch(RuntimeException e) {
//            System.out.println("please dont divide by zero");
//        } catch (Exception e) {
//            System.out.println("Exception");
//        }
        readFile();

    }

    static void readFile()  {
        try {
            java.io.FileReader fileReader = new java.io.FileReader(
                    "/Users/rahulgrover/Scaler/LLD/May23/code/Concurrency/" +
                            "src/exceptionhandling/ReadFil.java");
            System.out.println(fileReader.read());
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND!!!");
        }
    }
}