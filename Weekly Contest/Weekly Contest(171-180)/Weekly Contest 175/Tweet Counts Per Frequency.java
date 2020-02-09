class TweetCounts {
    Map<String, Integer> map;
    List<List<Integer>> tweet;
    
    public TweetCounts() {
        map=new HashMap<String, Integer>();
        tweet=new ArrayList<List<Integer>>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if(!map.containsKey(tweetName)){
            int index=map.size();
            map.put(tweetName, index);
            List<Integer> temp=new ArrayList<Integer>();
            temp.add(time);
            tweet.add(temp);
        }
        else{
            List<Integer> temp=tweet.get(map.get(tweetName));
            temp.add(time);
        }
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval=60;
        if(freq.equals("hour"))
            interval=3600;
        else if(freq.equals("day"))
            interval=3600*24;
        
        List<Integer> temp=tweet.get(map.get(tweetName));
        int[] recordtime=new int[temp.size()];
        for(int i=0; i<recordtime.length; i++)
            recordtime[i]=temp.get(i);
        Arrays.sort(recordtime);
        
        List<Integer> time=new ArrayList<Integer>();
        while(startTime<(endTime+1)){
            time.add(startTime);
            startTime+=interval;
        }
        time.add(endTime+1);
        
        List<Integer> result=new ArrayList<Integer>();
        int start=time.get(0);
        int end;
        
        for(int i=1; i<time.size(); i++){
            end=time.get(i);
            int left1=0;
            int right1=recordtime.length-1;
            while(left1<=right1){
                int middle=(left1+right1)>>1;
                if(recordtime[middle]>=start)
                    right1=middle-1;
                else
                    left1=middle+1;
            }
            
            int left2=left1;
            int right2=recordtime.length-1;
            while(left2<=right2){
                int middle=(left2+right2)>>1;
                if(recordtime[middle]>=end)
                    right2=middle-1;
                else
                    left2=middle+1;
            }
            result.add(left2-left1);
            start=end;
        }
        return result;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
