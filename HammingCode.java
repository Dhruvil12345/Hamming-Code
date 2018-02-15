package temporary;
import java.util.Random;
import java.util.Scanner;
public class HammingCode{
    Scanner s = new Scanner(System.in);
    private int one;
    private String samplebit="";
    private int[] randomNumber = new int[]{0,1};
    private int extra1,extra2,extra3;
    private String[] ofSampleBit;
    private String[] ofFirst,ofSecond,ofThird;
    private int x,minValue;
    public HammingCode()
    {
        System.out.println("Enter first string:");
        String first = s.nextLine();
        System.out.println("Enter second string:");
        String second = s.nextLine();
        System.out.println("Enter third string");
        String third = s.nextLine();
        one = first.length();
         if((third.length() & second.length())!=first.length()){
            System.out.println("Please enter equal length strings");
         }
        else{
           this.RandomGenerator(one,randomNumber);
           System.out.println("Sample bit:"+samplebit);
           ofSampleBit = samplebit.split("");
           ofFirst = first.split("");
           ofSecond = second.split("");
           ofThird = third.split("");
           for(x=0;x<ofFirst.length;x++)
           {
              if(!ofFirst[x].equals(ofSampleBit[x])){
                  extra1++;
              }
              if(!ofSecond[x].equals(ofSampleBit[x])){
                  extra2++;
              }
              if(!ofThird[x].equals(ofSampleBit[x])){
                  extra3++;
              }
           }
           minValue = this.minValueGiver(extra1, extra2, extra3);
           if(minValue==extra1){
               System.out.println("Bit1 is the minimum error string with hamming distance : "+extra1);
           }
           else if(minValue==extra2){
               System.out.println("Bit2 is the minimum error string with hamming distance : "+extra2);
           }
           else{
               System.out.println("Bit3 is the minimum error string with hamming distance : "+extra3);
           }
        }
    }
    private void RandomGenerator(int random,int[] rn)
    {
        Random r = new Random();
        for(int i=0;i<random;i++)
        {
            int x = rn[r.nextInt(rn.length)];
            samplebit = samplebit+Integer.toString(x);
        }  
    }
    private int minValueGiver(int a,int b,int c){
        int temp=0;
        if(a<b && a<c){
            temp = a;
        }
        else if(b<a && b<c){
            temp = b;
        }
        else if(c<a && c<b) {
            temp = c;
        }
      return temp;
    }
    public static void main(String[] args)
    {
        new HammingCode();
    }
}