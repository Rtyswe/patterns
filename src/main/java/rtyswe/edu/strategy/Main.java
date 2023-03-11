package rtyswe.edu.strategy;

import java.io.*;

public class Main {

    private static int[] getArrayFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (int[]) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        int[] array = new int[]{1, 1, 2, 2, 3, 5, 5, 5};
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[0]))) {
//            out.writeObject(array);
//        } catch (IOException ignored) {}

        int[] arrayFromFile = getArrayFromFile(args[0]);
        System.out.println(new OptimalStrategy().countNumberOfOccurrences(arrayFromFile));
        System.out.println(new BadStrategy().countNumberOfOccurrences(arrayFromFile));
    }

}
