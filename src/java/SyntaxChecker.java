import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class SyntaxChecker {

    public static void main(String[] args) throws FileNotFoundException{
        System.out.print("Enter file path for input file >");
        Scanner sc = new Scanner(System.in);
        String fPath = sc.nextLine();
        System.out.println(isBalanced(fPath));

    }

    public static Boolean isBalanced(String fPath) throws FileNotFoundException {
        Scanner scFile = new Scanner(new File(fPath));
        Stack<Character> chStack = new Stack<>();
        while (scFile.hasNextLine()){
            String line  = scFile.nextLine();
            for (char ch : line.toCharArray()){
                if (ch == '{' || ch == '(' || ch == '<' || ch == '[') {
                    chStack.push(ch);
                } else if (ch == '}' || ch == ')' || ch == '>' || ch == ']') {
                    if (chStack.isEmpty()){
                        return false;
                    }

                    char opCh = chStack.pop();
                    if(ch == '}' && opCh != '{' || ch == ')' && opCh != '(' || ch == '>' && opCh != '<'
                            || ch == ']' && opCh != '[') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
