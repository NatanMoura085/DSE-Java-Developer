package org.example.util;

import java.util.ArrayList;
import java.util.List;
public class AnagramGenerator {
        public static List<String> generateAnagrams(String input) {
            if (input == null || input.isEmpty() || !input.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Input must be non-empty and contain only letters.");
            }
            List<String> result = new ArrayList<>();
            permute("", input, result);
            return result;
        }

        private static void permute(String prefix, String remaining, List<String> result) {
            if (remaining.isEmpty()) {
                result.add(prefix);
            } else {
                for (int i = 0; i < remaining.length(); i++) {
                    permute(prefix + remaining.charAt(i),
                            remaining.substring(0, i) + remaining.substring(i + 1),
                            result);
                }
            }
        }

        public static void main(String[] args) {
            List<String> anagrams = generateAnagrams("abc");
            System.out.println(anagrams);
        }


}
