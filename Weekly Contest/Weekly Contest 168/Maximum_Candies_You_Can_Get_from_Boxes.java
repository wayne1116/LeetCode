class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        //status[i]: an integer which is 1 if box[i] is open and 0 if box[i] is closed.
        //candies[i]: an integer representing the number of candies in box[i].
        //keys[i]: an array contains the indices of the boxes you can open with the key in box[i].
        //containedBoxes[i]: an array contains the indices of the boxes found in box[i].
        
        Queue<Integer> currboxkey = new LinkedList<Integer>();
        boolean[] hasbox = new boolean[status.length];
        Arrays.fill(hasbox, false);
        for(int i=0; i<initialBoxes.length; i++){
            // currboxkey: here only put the box you get
            currboxkey.offer(initialBoxes[i]);
            // record the box you have
            hasbox[initialBoxes[i]]=true;
        }
        
        int result=0;
        // record the box you had opened 
        boolean[] taken = new boolean[status.length];
        // record the key you have
        boolean[] hasKey = new boolean[status.length];
        Arrays.fill(taken, false);
        Arrays.fill(hasKey, false);
        
        while(currboxkey.size()>0){
            // you may get the box or key from currboxkey
            Integer box=currboxkey.poll();
            // if you get the box from the currboxKey, check whether you had opened this box (taken[box])
            // if you get the key from the currboxKey, check whether you have the box (hasbox[box])
            if(!taken[box] && hasbox[box]){
                // if this box is opened or you have the key
                if(status[box]==1 || hasKey[box]){
                    taken[box]=true;
                    result+=candies[box];
                    for(int i=0; i<containedBoxes[box].length; i++){
                        if(!taken[containedBoxes[box][i]]){
                            currboxkey.offer(containedBoxes[box][i]);
                            hasbox[containedBoxes[box][i]]=true;
                        }
                    }
                    for(int i=0; i<keys[box].length; i++){
                        hasKey[keys[box][i]]=true;
                        if(!taken[keys[box][i]]) currboxkey.offer(keys[box][i]);
                    }
                }
            }
        }
        
        return result;
    }
}
