package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(bracketsValidator("{([][])}"));
    }


    public static boolean bracketsValidator(String chars) {
        List<Character> brackets = new ArrayList<>();
        List<Character> openings = new ArrayList<>(List.of('{', '[', '('));
        List<Character> closings = new ArrayList<>(List.of('}', ']', ')'));

        for (Character c : chars.toCharArray()) {
            if (openings.contains(c)) {
                brackets.add(c);
                continue;
            }
            if (closings.contains(c)) {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (c.equals(')')) {
                    if (brackets.get(brackets.size() - 1).equals('(')) {
                        brackets.remove(brackets.size() - 1);
                    } else {
                        return false;
                    }
                } else if (c.equals(']')) {
                    if (brackets.get(brackets.size() - 1).equals('[')) {
                        brackets.remove(brackets.size() - 1);
                    } else {
                        return false;
                    }
                } else if (c.equals('}')) {
                    if (brackets.get(brackets.size() - 1).equals('{')) {
                        brackets.remove(brackets.size() - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return brackets.size() == 0;
    }

    // In Main just for visibility
    @Test
    void testSingleBrackets() {
        Assertions.assertTrue(bracketsValidator("()"));
    }

    @Test
    void testMultipleBrackets() {
        Assertions.assertTrue(bracketsValidator("()[]{}"));
    }

    @Test
    void testWrongCombination() {
        Assertions.assertFalse(bracketsValidator("(]"));
    }

    @Test
    void testMultipleWrongCombination() {
        Assertions.assertFalse(bracketsValidator("([]"));
    }

    @Test
    void testMultipleRightCombination() {
        Assertions.assertTrue(bracketsValidator("{([][])}"));
    }

    @Test
    void testMultipleWrongCombination2() {
        Assertions.assertFalse(bracketsValidator("{[}]()"));
    }


}