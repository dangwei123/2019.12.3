给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。

(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

注意：
你可以假设两个字符串均只含有小写字母
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ransom-note
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[26];
        for(int i=0;i<magazine.length();i++){
            arr[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            arr[ransomNote.charAt(i)-'a']--;
        }
        for(int i:arr){
            if(i<0){
                return false;
            }
        }
        return true;
    }
}

输入两个字符串a和b，字符串内容为二进制数字，求两个字符串相加的结果，
加法计算方法以二进制方式计算，并返回对应的字符串结果。要求程序尽可能的高效。
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        System.out.println(func(str1,str2));
    }
    
    private static String func(String str1,String str2){
        StringBuilder sb=new StringBuilder();
        int carry=0;
        int i=str1.length()-1;
        int j=str2.length()-1;
        while(i>=0||j>=0||carry!=0){
            carry+=i>=0?(str1.charAt(i--)-'0'):0;
            carry+=j>=0?(str2.charAt(j--)-'0'):0;
            sb.append(carry%2);
            carry/=2;
        }
        return sb.reverse().toString();
    }
}

将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if(str.equals("")){
            System.out.println("");
        }else{
            String s=reverse(str,0,str.length()-1);
        System.out.println(reverse(s));
        }
    }
    
    private static String reverse(String str){
        char[] arr=str.toCharArray();
        int l=0;
        for(int i=0;i<=str.length();i++){
            if(i==str.length()||arr[i]==' '){
                int r=i-1;
                while(l<r){
                    char tmp=arr[l];
                    arr[l++]=arr[r];
                    arr[r--]=tmp;
                }
                l=i+1;
            }
        }
        return new String(arr);
    }
    
    private static String reverse(String str,int l,int r){
        char[] arr=str.toCharArray();
                while(l<r){
                    char tmp=arr[l];
                    arr[l++]=arr[r];
                    arr[r--]=tmp;
                }
        return new String(arr);
    }
}