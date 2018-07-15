/*
    URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)
*/

package task3;

import java.util.Scanner;

interface TaskSolution {
    void URLify(char[] s, int length);
}

class TaskSolutionImpl implements TaskSolution {
    public void URLify(char[] s, int length) {
        int numberOfSpaces = 0;
        for(int i = 0; i < length; i++) {
            if(s[i] == ' ') {
                ++numberOfSpaces;
            }
        }
        int trueLength = length + numberOfSpaces * 2;
        --length; s[trueLength] = '\0';
        for(int i = trueLength - 1; i >= 0; i--) {
            if(s[length] == ' ') {
                s[i] = '0'; s[i - 1] = '2'; s[i - 2] = '%';
                i = i - 2;
            }
            else {
                s[i] = s[length];
            }
            --length;
        }
        System.out.println(s);
    }
}

public class Task3 {
    private TaskSolution taskSolution;
    private void URLify(char[] s, int length) {
        taskSolution.URLify(s, length);
    }
    private void setTaskSolution(TaskSolution taskSolution) {
        this.taskSolution = taskSolution;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = "Take my place               ".toCharArray();
        Task3 task = new Task3();
        task.setTaskSolution(new TaskSolutionImpl());
        task.URLify(s, 13);
    }
}
