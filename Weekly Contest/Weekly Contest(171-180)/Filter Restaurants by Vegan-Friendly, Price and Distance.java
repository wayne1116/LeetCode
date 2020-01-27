class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Node> temp=new ArrayList<Node>();
        for(int i=0; i<restaurants.length; i++){
            if(maxPrice>=restaurants[i][3] && maxDistance>=restaurants[i][4]){
                if(veganFriendly==1 && veganFriendly==restaurants[i][2] || veganFriendly==0){
                    Node tmp=new Node(restaurants[i][0], restaurants[i][1]);
                    temp.add(tmp);
                }
            }
        }
        Collections.sort(temp, new Comparator<Node>(){
            public int compare(Node x, Node y){
                if(x.rating==y.rating) 
                    return y.id-x.id;
                return y.rating-x.rating;
            }    
        });
        List<Integer> result=new ArrayList<Integer>();
        for(int i=0; i<temp.size(); i++){
            result.add(temp.get(i).id);
        }
        return result;
    }
}

class Node{
    public int id;
    public int rating;
    public Node(int i, int r){
        id=i;
        rating=r;
    }
}
