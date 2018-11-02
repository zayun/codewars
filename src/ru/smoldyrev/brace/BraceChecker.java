package ru.smoldyrev.brace;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class BraceChecker {

    private final java.util.Map<Character, Character> BRACES = new java.util.HashMap<Character, Character>() {
        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    public boolean isValid(String braces) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        return braces.chars().allMatch(c -> isValid(stack, (char) c)) && stack.empty();
    }

    public boolean isValid(java.util.Stack<Character> stack, Character character) {
        if (BRACES.values().contains(character)) {
            stack.push(character);
            return true;
        } else {
            if (stack.empty()) {
                return false;
            } else if (stack.peek().equals(BRACES.get(character))) {
                stack.pop();
                return true;
            } else {
                return false;
            }
        }
    }
}
