public class Solution {
    public boolean rotateString(String s, String goal) {
        // If the lengths of the strings are different, they can't be rotations
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Check if goal is a substring of s + s
        String doubled = s + s;
        return doubled.contains(goal);
    }
}
