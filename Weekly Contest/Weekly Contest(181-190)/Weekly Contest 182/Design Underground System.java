class UndergroundSystem {   
    Map<Integer, Integer> times;
    Map<Integer, String> st;
    Map<String, Map<String, double[]>> average;
    public UndergroundSystem() {
        times=new HashMap<Integer, Integer>();
        st=new HashMap<Integer, String>();
        average=new HashMap<String, Map<String, double[]>>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        st.put(id, stationName);
        times.put(id, t);
        if(!average.containsKey(stationName))
            average.put(stationName, new HashMap<String, double[]>());
    }
    
    public void checkOut(int id, String stationName, int t) {
        String startstation=st.get(id);
        int starttime=times.get(id);
        Map<String, double[]> temp=average.get(startstation);
        
        if(!temp.containsKey(stationName)){
            temp.put(stationName, new double[]{t-starttime, 1.0});
        } else{
            double[] temp1=temp.get(stationName);
            temp1[0]+=t-starttime;
            ++temp1[1];
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Map<String, double[]> temp=average.get(startStation);
        double[] temp1=temp.get(endStation);
        return temp1[0]/temp1[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
