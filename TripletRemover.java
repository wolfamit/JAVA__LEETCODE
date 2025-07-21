// 1957. Delete Characters to Make Fancy String
// You are given a string s consisting of lowercase English letters.
// A string is fancy if it does not contain three consecutive characters that are equal.
// A fancy string is a string where no three consecutive characters are equal.
// Given a string s, delete the minimum possible number of characters from s to make it fancy.
// Return the final string after the deletion. It can be shown that the answer will always be unique.
public class TripletRemover {
    public static String removeTriplets(String s) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && i < s.length() - 1 &&
                s.charAt(i) == s.charAt(i - 1) &&
                s.charAt(i) == s.charAt(i + 1)) {
                continue;
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    // Example usage
    public static void main(String[] args) {
        String input = "aaabbbc";
        String result = removeTriplets(input);
        System.out.println(result); // Output: "c"
    }
}
