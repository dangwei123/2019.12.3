给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也
表示为字符串形式。

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("")||num2.equals("")){
            return null;
        }
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] res=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            int a=(num1.charAt(i)-'0');
            for(int j=num2.length()-1;j>=0;j--){
                int b=(num2.charAt(j)-'0');
                int sum=res[i+j+1]+a*b;
                res[i+j+1]=sum%10;
                res[i+j]+=sum/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(i==0&&res[i]==0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}

罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/integer-to-roman
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            if(num>=1000){
                sb.append("M");
                num-=1000;
            }else if(num>=900&&num<1000){
                sb.append("CM");
                num-=900;
            }else if(num>=500&&num<900){
                sb.append("D");
                num-=500;
            }else if(num>=400&&num<500){
                sb.append("CD");
                num-=400;
            }else if(num>=100&&num<400){
                sb.append("C");
                num-=100;
            }else if(num>=90&&num<100){
                sb.append("XC");
                num-=90;
            }else if(num>=50&&num<90){
                sb.append("L");
                num-=50;
            }else if(num>=40&&num<50){
                sb.append("XL");
                num-=40;
            }else if(num>=10&&num<40){
                sb.append("X");
                num-=10;
            }else if(num>=9&&num<10){
                sb.append("IX");
                num-=9;
            }else if(num>=5&&num<9){
                sb.append("V");
                num-=5;
            }else if(num>=4&&num<5){
                sb.append("IV");
                num-=4;
            }else if(num>=0&&num<4){
                sb.append("I");
                num-=1;
            }
        }
        return sb.toString();
    }
}

给定一个字符串，逐个翻转字符串中的每个单词。

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public String reverseWords(String s) {
        if(s.equals("")){
            return "";
        }
        char[] arr=s.toCharArray();
        String str=reverse(arr);
        str=reverse(str.toCharArray(),0,str.length()-1);
        return clear(str.toCharArray());
        
    }
    private String reverse(char[] res,int l,int r){
        while(l<r){
            char tmp=res[l];
            res[l++]=res[r];
            res[r--]=tmp;
        }
        return new String(res);
    }
    private String reverse(char[] res){
        int l=0;
        for(int i=0;i<=res.length;i++){
            if(i==res.length||res[i]==' '){
                int r=i-1;
                while(l<r){
                    char tmp=res[l];
                    res[l++]=res[r];
                    res[r--]=tmp;
                }
               l=i+1;
            }
        }
        return new String(res);
    }

    private String clear(char[] res){
        int i=0;
        for(int j=0;j<res.length;j++){
            while(j<res.length&&res[j]==' '){
                j++;
            }while(j<res.length&&res[j]!=' '){
                res[i++]=res[j++];
            } while(j<res.length&&res[j]==' '){
                j++;
            }if(j<res.length){
                res[i++]=' ';
                j--;
            }
        }
        return new String(res).substring(0,i);
    }
}