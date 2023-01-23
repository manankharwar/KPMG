public class Q2 {

    public static String rearrangeWord(String word){
        // what I was thinking is finding all the permutations of a string and then just having a loop to find out the next big permutation
        // turns out I'm running into TLE -> time limit exceeded

        // 2 -> 2 xy [xy, yx]
        // 3 -> 6 xyz [xyz, xzy, yxz, yzx, zyx, zyx]
        // 4 -> 24 wxyz



        return "";
    }

    public static void main(String[] args){
        // Rearranging the word
        // We have to find the next permutation of the string. If there are no next permutation simply return "no answer"
        String word = "baca";
        String result = rearrangeWord(word);
    }
}
