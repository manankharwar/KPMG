import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Q1 {

    public static List<Long> maxMin(List<String> operations, List<Integer> x){
        List<Long> product = new ArrayList<>();
        // can we use a better data structure?
        Set<Long> treeSet = new TreeSet<>();

        // what if operations.get(0) == "pop"?? -> skipping
        int count = 0;
        while(operations.get(count) == "pop") {
            count++;
        }

        treeSet.add((long) x.get(0));
        product.add(((TreeSet<Long>) treeSet).first() * ((TreeSet<Long>) treeSet).last());
        for(int i = 1; i < operations.size(); i++){
            if(operations.get(i) == "push"){
                treeSet.add((long) x.get(i));
            }
            else if(operations.get(i) == "pop"){
                // we have to re-evaluate our min and max.
                // this means we are removing an element from the List<Integer> x
                // what if that element is not there

                if(!treeSet.contains((long) x.get(i))){
                    return product;
                }
                treeSet.remove((long) x.get(i));
            }
            product.add(((TreeSet<Long>) treeSet).first() * ((TreeSet<Long>) treeSet).last());
        }

        System.out.println(product);

        return product;
    }

    public static void main(String[] args){
        //we are passing in a list of strings operations and a list of integers x.
        // Product of the Maximum and Minimum in a dataset
        List<String> operations = new ArrayList<>();
        operations.add("push");
        operations.add("push");
        operations.add("push");
        operations.add("pop");
        operations.add("push");
        operations.add("push");
        operations.add("push");
        operations.add("pop");
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(3);
        x.add(1);
        x.add(5);
        x.add(2);
        x.add(4);
        x.add(5);

        // the number of elements in operations and x remains the same

        List<Long> result = maxMin(operations, x);
        System.out.println(result);
    }
}
