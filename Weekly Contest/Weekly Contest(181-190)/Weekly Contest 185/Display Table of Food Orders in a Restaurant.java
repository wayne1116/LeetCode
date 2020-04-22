class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, List<String>> tmap=new TreeMap<Integer, List<String>>();
        TreeMap<String, Integer> t1=new TreeMap<String, Integer>();
        List<String> f;
        
        for(int i=0; i<orders.size(); i++){
            List<String> temp=orders.get(i);
            int table=Integer.parseInt(temp.get(1));
            String food=temp.get(2);
            if(!tmap.containsKey(table)){
                f=new ArrayList<String>();
                f.add(food);
                tmap.put(table, f);
            } else{
                f=tmap.get(table);
                f.add(food);
            }
            
            if(!t1.containsKey(food))
                t1.put(food, 0);
        }
        
        Set set=t1.entrySet();
        Iterator iterator=set.iterator();
        int count=0;
        List<List<String>> result=new ArrayList<List<String>>();
        List<String> temp=new ArrayList<String>();
        temp.add("Table");
        while(iterator.hasNext()) {
            Map.Entry mentry=(Map.Entry)iterator.next();
            t1.put((String)mentry.getKey(), count++);
            temp.add((String)mentry.getKey());
        }
        result.add(temp);
        
        set=tmap.entrySet();
        iterator=set.iterator();
        int[] fcount=new int[count];
        while(iterator.hasNext()){
            Map.Entry mentry=(Map.Entry)iterator.next();
            String table=Integer.toString((Integer)mentry.getKey());
            f=(List<String>)mentry.getValue();
            Arrays.fill(fcount, 0);
            for(int i=0; i<f.size(); i++)
                ++fcount[t1.get(f.get(i))];
            temp=new ArrayList<String>();
            temp.add(table);
            for(int i=0; i<count; i++)
                temp.add(Integer.toString(fcount[i]));
            result.add(temp);
        }
        
        return result;
    }
}
