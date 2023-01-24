import java.util.*;

public class Q2 {
    public static Set<String> set = new HashSet<>();
    public static String swap(String word, int start, int end){
        char[] back = word.toCharArray();
        char ch;

        ch = back[start];
        back[start] = back[end];
        back[end] = ch;

        return  String.valueOf(back);
    }

    public static Set<String> rearrangeWord(String word, int start, int end){
        // what I was thinking is finding all the permutations of a string and then just having a loop to find out the next big permutation
        // turns out I'm running into TLE -> time limit exceeded

        // 2 -> 2 xy [xy, yx]
        // 3 -> 6 xyz [xyz, xzy, yxz, yzx, zyx, zyx]
        // 4 -> 24 wxyz

        if(word.length() == 0){
            return set;
        }
        // first find how to calculate all the permutations of the string
        for(int i = start; i < end; i++){
            // using substring

            word = swap(word, start, i);
            set.add(word);
            rearrangeWord(word, start + 1, end);
            word = swap(word, start, i);
            set.add(word);

        }

        //System.out.println(set);
        return set;
    }

    public static void main(String[] args){
        // Rearranging the word
        // We have to find the next permutation of the string. If there are no next permutation simply return "no answer"
        String word = "baca";
        set = rearrangeWord(word, 0, word.length());
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        System.out.println(result);
    }
}
