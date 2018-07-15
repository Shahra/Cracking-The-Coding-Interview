/*
    Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    cannot use additional data structures?
*/

package template;

import java.util.Arrays;
import java.util.Scanner;

interface TaskSolution {
    boolean functionName();
}

class Solution1 implements TaskSolution {
    public boolean functionName() { return true; }
}

class Solution2 implements TaskSolution {
    public boolean functionName() { return false; }
}

public class Template {

    private TaskSolution taskSolution;

    private boolean functionName() {
        return taskSolution.functionName();
    }

    private void setTaskSolution(TaskSolution taskSolution) {
        this.taskSolution = taskSolution;
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //String s = "abecd"; //String s = scanner.next();

        Template template = new Template();

        template.setTaskSolution(new Solution1());
        System.out.println(template.functionName());

        template.setTaskSolution(new Solution2());
        System.out.println(template.functionName());
    }
}
