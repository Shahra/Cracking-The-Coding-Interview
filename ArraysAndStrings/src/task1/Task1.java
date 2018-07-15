/*
    Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    cannot use additional data structures?
*/

package task1;

import java.util.Arrays;
import java.util.Scanner;

interface TaskSolution {
    boolean hasAllUniqueCharacters(String s);
}

class SolutionUsingArray implements TaskSolution {

    public boolean hasAllUniqueCharacters(String s) {

        System.out.println("Solution using array. Time complexity: O(n). Space complexity: O(1).");

        if(s.length() > 128) {
            return false;
        }

        boolean[] usedCharacter = new boolean[128];

        for(int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i);

            if(usedCharacter[charIndex]) {
                return false;
            }
            else {
                usedCharacter[charIndex] = true;
            }
        }

        return true;
    }
}

class SolutionUsingBitVector implements TaskSolution {

    public boolean hasAllUniqueCharacters(String s) {

        System.out.println("Solution using BitVector. Time complexity: O(n). Space complexity: O(1).");
        System.out.println("We assume that the string uses only lowercase letters a to z.");

        int usedCharacters = 0;

        for(int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';

            if((usedCharacters & (1 << charIndex)) > 0) {
                return false;
            }

            usedCharacters |= 1 << charIndex;
        }

        return true;
    }
}

class SolutionUsingComparisonOfEveryTwoCharacters implements TaskSolution {

    public boolean hasAllUniqueCharacters(String s) {

        System.out.println("Solution using comparison of every two characters. Time complexity: O(n^2). Space complexity: O(1).");

        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}

class SolutionUsingSorting implements TaskSolution {

    public boolean hasAllUniqueCharacters(String s) {

        System.out.println("Solution using sorting. Time complexity: O(n * log n). Space complexity: O(1).");
        System.out.println("This is not working properly because we are not sorting INPLACE.");

        char[] chars = s.toCharArray(); Arrays.sort(chars);

        for(int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;
    }
}

public class Task1 {

    private TaskSolution taskSolution;

    private boolean hasAllUniqueCharacters(String s) {
        return taskSolution.hasAllUniqueCharacters(s);
    }

    private void setTaskSolution(TaskSolution taskSolution) {
        this.taskSolution = taskSolution;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = "abecd"; //String s = scanner.next();

        Task1 task = new Task1();

        task.setTaskSolution(new SolutionUsingArray());
        System.out.println(task.hasAllUniqueCharacters(s));

        task.setTaskSolution(new SolutionUsingBitVector());
        System.out.println(task.hasAllUniqueCharacters(s));

        task.setTaskSolution(new SolutionUsingComparisonOfEveryTwoCharacters());
        System.out.println(task.hasAllUniqueCharacters(s));

        task.setTaskSolution(new SolutionUsingSorting());
        System.out.println(task.hasAllUniqueCharacters(s));
    }

}
