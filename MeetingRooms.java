import java.util.*;



public class MeetingRooms {
    public static Boolean canAttendMeeting(List<List<Integer>> meetings){
        meetings.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0).compareTo(b.get(0));
            } else {
                return a.get(1).compareTo(b.get(1));
            }
        }); //sort meetings in increasing order of meetStart and meetEnd
        int lastMeetingEnd = -1;
        boolean ans = true;
        for(List<Integer> meet:meetings){
            if(lastMeetingEnd >meet.get(0)){ // if the lastMeetingEnd is greater than current meeting start time then we cant attend all meetings
                System.out.println(lastMeetingEnd+ " "+meet.get(0));
                ans = false;
                break;
            }
            lastMeetingEnd = meet.get(1); //update lastMeetingEnd
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalMeets = sc.nextInt();
        List<List<Integer>> meetings = new ArrayList<List<Integer>>();
        for(int i=0;i<totalMeets;i++){
            int meetStart = sc.nextInt();
            int meetEnd = sc.nextInt();
            meetings.add(Arrays.asList(meetStart,meetEnd));
        }
        System.out.println(canAttendMeeting(meetings));

    }
}
