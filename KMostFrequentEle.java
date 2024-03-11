import java.util.*;
import java.util.stream.*;

public class KMostFrequentEle {

    public static List<Integer> kMostFrequentFunctional2(List<Integer> nums, int k){
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        nums.forEach(ele ->{
            freqMap.put(ele,freqMap.getOrDefault(ele,0)+1);
        });
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        freqMap.entrySet().forEach(entry ->{
            pq.add(entry);
        });
        List<Integer> kMostFrequentElements = new ArrayList<>();
        while(kMostFrequentElements.size()<k){
            kMostFrequentElements.add(pq.poll().getKey());
        }
        return kMostFrequentElements;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        while(sc.hasNextInt()){
            nums.add(sc.nextInt());
        }
        List<Integer> kMostFrequentElements = new ArrayList<>();
        kMostFrequentElements = kMostFrequentFunctional2(nums,k);
        System.out.println(kMostFrequentElements);
    }
}
