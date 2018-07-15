/*
    Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    other.
*/


package task2;

import java.util.Arrays;
import java.util.Scanner;

interface TaskSolution {
    boolean checkPermutation(String s, String s2);
}

class SolutionUsingSorting implements TaskSolution {

    String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public boolean checkPermutation(String s1, String s2) {

        System.out.println("Solution using sorting. Time complexity: O(n * log n). Space complexity: O(n).");

        if(s1.length() != s2.length()) {
            return false;
        }

        return sort(s1).equals(sort(s2));
    }
}


class SolutionUsingCharacterCount implements TaskSolution {

    int[] getCharactersCount(String s) {

        int[] characterCount = new int[128];

        for(int i = 0; i < s.length(); i++) {
            int charIndex = (int) s.charAt(i);
            ++characterCount[charIndex];
        }

        return characterCount;
    }

    public boolean checkPermutation(String s1, String s2) {

        System.out.println("Solution using characterCount. Time complexity: O(n + m). Space complexity: O(n + m). n = size of first string, m = size of second string");

        if(s1.length() != s2.length()) {
            return false;
        }

        return Arrays.equals(getCharactersCount(s1), getCharactersCount(s2));
    }
}


class SolutionUsingCharacterCountOneArray implements TaskSolution {

    public boolean checkPermutation(String s1, String s2) {

        System.out.println("Solution using characterCount, but with only one array. Time complexity: O(n + m). Space complexity: O(n). n = size of first string, m = size of second string");

        int[] characterCount = new int[128];

        if(s1.length() != s2.length()) {
            return false;
        }

        for(int i = 0; i < s1.length(); i++) {
            int charIndex = (int) s1.charAt(i);
            ++characterCount[charIndex];
        }

        for(int i = 0; i < s2.length(); i++) {

            int charIndex = (int) s2.charAt(i);

            --characterCount[charIndex];

            if(characterCount[charIndex] < 0) {
                return false;
            }
        }

        return true;
    }
}

public class Task2 {

    private TaskSolution taskSolution;

    private boolean checkPermutation(String s1, String s2) {
        return taskSolution.checkPermutation(s1, s2);
    }

    private void setTaskSolution(TaskSolution taskSolution) {
        this.taskSolution = taskSolution;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = "fabecdef"; //String s = scanner.next();
        String s2 = "abcdeffe"; //String s = scanner.next();

        Task2 task = new Task2();

        task.setTaskSolution(new SolutionUsingSorting());
        System.out.println(task.checkPermutation(s1, s2));

        task.setTaskSolution(new SolutionUsingCharacterCount());
        System.out.println(task.checkPermutation(s1, s2));

        task.setTaskSolution(new SolutionUsingCharacterCountOneArray());
        System.out.println(task.checkPermutation(s1, s2));
    }

}
