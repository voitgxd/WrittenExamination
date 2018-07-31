package nowcoder.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _11_WordBreak2 {

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        return null;
    }

    public static void main(String[] args) {
        //s ="catsanddog",
        //dict =["cat", "cats", "and", "sand", "dog"].
        //A solution is["cats and dog", "cat sand dog"].
        String s = "catsanddog";
        String[] dict = {"cat", "cats", "and", "sand", "dog"};
        String[] result;
        HashSet<Integer> test = new HashSet<Integer>();
        HashMap<Integer, Integer> test2 = new HashMap<>();
        test2.put(4, 1);
        System.out.print(test2.containsKey(4));
    }
}
