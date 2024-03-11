import java.util.*;
import java.util.stream.*;

public class KMostFrequentEle {

    public static List<Integer> kMostFrequentFunctional2(List<Integer> nums, int k){
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        nums.forEach(ele ->{
            freqMap.put(ele,freqMap.getOrDefault(ele,0)+1); //streaming through the nums array and mapping the elements with their frequency
        });
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->(a.getValue()-b.getValue())); //PriorityQueue to store a mapEntry to store elements with min frequency at the top
        freqMap.entrySet().forEach(entry ->{
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();//Remove the head of the pq whenever the size goes above k to only store the k Maximum frequencies
            }
        });
        List<Integer> kMostFrequentElements = new ArrayList<>();

        while(!pq.isEmpty()){
            kMostFrequentElements.add(pq.poll().getKey());
        }
        return kMostFrequentElements;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); //Enter K value
        List<Integer> nums = new ArrayList<>();
        
        while(sc.hasNextInt()){
            nums.add(sc.nextInt());//Enter integer values to the array, enter any other character to finish input
        }
        List<Integer> kMostFrequentElements = new ArrayList<>();
        kMostFrequentElements = kMostFrequentFunctional2(nums,k);
        System.out.println(kMostFrequentElements);
    }
}
