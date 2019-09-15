class Solution {
    public int dayOfYear(String date) {
        String[] temp = date.split("-");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);
        int[] monthday = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        int result = 0;
        for(int i=1; i<month; i++) result+=monthday[i];
        result+=day;
        if(year%4==0 && (year%100!=0 || year%400==0)){
            if(month>2) ++result;
        }
        return result;
        
    }
}
