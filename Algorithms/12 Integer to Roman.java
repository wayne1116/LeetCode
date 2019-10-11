class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        
        while(num>0){
            if(num>=1000){
                result.append("M");
                num-=1000;
            }
            else if(num>=500){
                if(num>=900){
                    result.append("CM");
                    num-=900;
                }
                else{
                    result.append("D");
                    num-=500;
                }
            }
            else if(num>=100){
                if(num>=400){
                    result.append("CD");
                    num-=400;
                }
                else{
                    result.append("C");
                    num-=100;
                }
            }
            else if(num>=50){
                if(num>=90){
                    result.append("XC");
                    num-=90;
                }
                else{
                    result.append("L");
                    num-=50;
                }
            }
            else if(num>=10){
                if(num>=40){
                    result.append("XL");
                    num-=40;
                }
                else{
                    result.append("X");
                    num-=10;
                }
            }
            else if(num>=5){
                if(num==9){
                    result.append("IX");
                    num-=9;
                }
                else{
                    result.append("V");
                    num-=5;
                }
            }
            else{
                if(num==4){
                    result.append("IV");
                    num-=4;
                }
                else{
                    result.append("I");
                    num-=1;
                }
            }
        }
        return result.toString();
    }
}