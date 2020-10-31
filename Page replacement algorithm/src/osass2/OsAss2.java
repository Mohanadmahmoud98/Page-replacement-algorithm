package osass2;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List.*;
import java.util.ArrayList.*;
import java.util.Arrays.*;
import java.util.List;
class Ass2
{
    int Ref[];
    int nof;
    int nop;
    int outputa[][];
    int outputb[][];
    int outputc[][];
    int outputd[][];
    int outpute[][];
    int tempaa[];
    int tempbb[];
    int tempcc[];
    int tempdd[];
    int tempee[];
    Random rand=new Random();
    int p=0;
    int p1=0;
    int nofaaa=0;
    int nofabb=0;
    int nofacc=0;
    int nofadd=0;
    int nofaee=0;
    int temp2[];
    int t=0;
    int t1=0;
    int t2=0;
    int m=0;
    int temp3[];
    int index[];
    int temp4[];
    int temp5[];
    int s=0;
    int Freq[];
    int h=0;
    int tempa;
   
    
  
   
  void input()
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("enter number of pages");
      nop=sc.nextInt();
      System.out.println("enter number of Frames ");
      nof=sc.nextInt();
      Ref=new int[nop];
      index=new int[nof];
      tempaa=new int[nof];
      tempbb=new int[nof];
      tempcc=new int[nof];
      tempdd=new int[nof];
      tempee=new int[nof];
      temp2=new int[nof];
      temp3=new int[nof];
      temp4=new int[nof];
      temp5=new int[nof];
      Freq=new int [99];
      
      outputa=new int[nof][nop];
      outputb=new int[nof][nop];
      outputc=new int[nof][nop];
      outputd=new int[nof][nop];
      outpute=new int[nof][nop];
      
      for(int i=0;i<nof;i++)
      {
          for (int j = 0; j < nop; j++) {
              outputa[i][j]=-1;
               outputb[i][j]=-1;
               outputc[i][j]=-1;
               outputd[i][j]=-1;
               outpute[i][j]=-1;
                    
              
          }
   
      }
     // System.out.println("enter pages:");
      for(int i=0;i<nop;i++)
      {
          Ref[i]=rand.nextInt(99);
          
      }
      for(int i=0;i<nop;i++)
      {
          System.out.print(Ref[i]+" ");
      }
       System.out.println();
           System.out.println("--------------------------------------");
      
      for(int i=0;i<nof;i++)
      {
         tempaa[i]=-1;
         tempbb[i]=-1;
         tempcc[i]=-1;
         tempdd[i]=-1;
         tempee[i]=-1;
      }
       for(int i=0;i<nof;i++)
      {
         index[i]=0;
      }
       for (int i = 0; i <99; i++) {
          Freq[i]=0;
      }
      
     
  }
   boolean checkaa(int k)
    {
     for(int i=0;i<nof;i++)
        {
     if(tempaa[i]==Ref[k])  
     {
         s=i;
         return true;
         
     }
        }
     return false;
    }
  void fifo()
  {
      int c1=0;
      while(c1<nop)
      {
            if(p==nof)
           {
               p=0;
           }
           if(!checkaa(c1))
           {
               tempaa[p]=Ref[c1];
             
              p++;
              nofaaa++;
           }
           
             for(int i=0;i<nof;i++)
               {
              outputa[i][c1]=tempaa[i];
               }  
         
           c1++;
  }
      
  }
   boolean checkbb(int k)
    {
     for(int i=0;i<nof;i++)
        {
     if(tempbb[i]==Ref[k])  
     {
         s=i;
         return true;
         
     }
        }
     return false;
    }
  int check2(int l)
  {
      int i=0;
      for( i=l;i>=0;i--)
      {
          if(Ref[i]==t)
          {
                
              return i;
  
          }
      }
      return i ;
  }
  int min()
  {
      int mine=100;
      int z=0;
      for(int i=0;i<nof;i++)
      {
          if(temp2[i]<mine)
          {
              mine=temp2[i];
              z=i;
          }
      }
      return z;
  }
  void LRU()
  {
      int c2=0;
      int d=0;
      while(c2<nop)
      {
          if(checkbb(c2))
          {
              for(int i=0;i<nof;i++)
               {
              outputb[i][c2]=tempbb[i];
               } 
               d=1;
          }
          if(c2<nof)
          {
              tempbb[c2]=Ref[c2];
               for(int i=0;i<nof;i++)
               {
              outputb[i][c2]=tempbb[i];
               } 
               d=1;
               nofabb++;
          }
          
          if(d==0)
          {
              for(int i=0;i<nof;i++)
              {
                  t=tempbb[i];
              
           int x=check2(c2);
           if(x>=0)
           {
               temp2[i]=x;
           }
              }
              int y=min();
               tempbb[y]=Ref[c2];
               
               for(int i=0;i<nof;i++)
               {
              outputb[i][c2]=tempbb[i];
               } 
             nofabb++; 
          }
          c2++;
          d=0;
      }
  }
   boolean checkcc(int k)
    {
     for(int i=0;i<nof;i++)
        {
     if(tempcc[i]==Ref[k])  
     {
         s=i;
         return true;
         
     }
        }
     return false;
    }
  int search(int l)
  {
      for(int i=l;i<nop;i++)
            if(Ref[i]==t)
              return i;
      return 200;
      
  }
  int max()
  {
      int maxe=0;
      int z1=0;
      for(int i=0;i<nof;i++)
      {
          if(temp3[i]>maxe)
          {
              maxe=temp3[i];
              
              z1=i;
          }
      }
      return z1;
      
  }
  void optimal()
  {
      int c3=0;
      int d1=0;
      int f=0;
      while(c3<nop)
      {
              if(checkcc(c3))
          {
              for(int i=0;i<nof;i++)
               {
              outputc[i][c3]=tempcc[i];
               } 
               d1=1;
               f=1;
          }
         if(c3<nof)
          {
              tempcc[c3]=Ref[c3];
               for(int i=0;i<nof;i++)
               {
              outputc[i][c3]=tempcc[i];
               } 
               d1=1;
               nofacc++;
          }

         if(c3==nop-1&&f==0)
         {
             tempcc[0]=Ref[c3];
             for(int i=0;i<nof;i++)
               {
              outputc[i][c3]=tempcc[i];
               } 
               d1=1;
               nofacc++;
             
         }
         if(d1==0)
         {
             for(int i=0;i<nof;i++)
              {
                  t=tempcc[i];
              
           int x=search(c3);
           if(x>=0)
           {
               temp3[i]=x;
           }
              }
             int y1=max();
             tempcc[y1]=Ref[c3];
             for(int i=0;i<nof;i++)
               {
              outputc[i][c3]=tempcc[i];
               } 
             nofacc++; 
             
         }
         c3++;
         d1=0;
         f=0;
      }
      
              
  }
   boolean checkdd(int k)
    {
     for(int i=0;i<nof;i++)
        {
     if(tempdd[i]==Ref[k])  
     {
         s=i;
         return true;
         
     }
        }
     return false;
    }
  void Secondchance()
  {
      int c4=0;
      int d3=0;
      
      while(c4<nop)
      {
         if(p1==nof)
           {
               p1=0;
           }
         if(checkdd(c4))
          {
              index[s]=1;
              for(int i=0;i<nof;i++)
               {
              outputd[i][c4]=tempdd[i];
               } 
               d3=1;
               
          }
         if(c4<nof)
          {
              tempdd[c4]=Ref[c4];
              index[c4]=1;
               for(int i=0;i<nof;i++)
               {
              outputd[i][c4]=tempdd[i];
               } 
               d3=1;
               nofadd++;
          } 
         
         if(d3==0)
         {
            int n=0;
            int b=0;
            while(n<nof)
            {
                if(index[p1]==1)
                {
                    index[p1]=0;
                    p1++;
                    b=1;
                    if(p1==nof)
                    {
                        p1=0;
                    }
                }
                if(b==0)
                {
                n=nof;
                }
                
                n++;
                b=0;
            }
                tempdd[p1]=Ref[c4];
                index[p1]=1;
                
                for(int i=0;i<nof;i++)
               {
              outputd[i][c4]=tempdd[i];
               } 
                 p1++;
                 nofadd++;
                
            }
          c4++;
          d3=0;
      }
  }
   
  
   int check3(int l)
  {
      int i=0;
      for( i=l;i>=0;i--)
      {
          if(Ref[i]==t1)
          {
                
              return i;
  
          }
      }
      return i ;
  }
  
  int min1()
  {
      int mine=100;
      int z=0;
      for(int i=0;i<nof;i++)
      {
          if(temp4[i]<mine)
          {
//              elrakmfetemp4=temp4[i];
             // FreqofLRU=Freq[temp[i]];
              mine=temp4[i];
              z=i;
          }
      }
      return z;
  }
  int Frqcheck()
  {
      int min1=100;
      int min2=100;
      int z=0;
      int d=0;
      for(int i=0;i<nof;i++)
      {
          if(temp5[i]<min1)
          {
           min1=temp5[i];   
           z=i;
           tempa=tempee[i];
           d=1;
          }
          if(temp5[i]==min1&&d==0)
              {
                    if(temp4[i]<temp4[z])  
                    {
                        z=i;
                        tempa=tempee[i];
                        min1=temp5[i];
                    }
              }
          d=0;
      }
     return z;  
  }
    boolean checkee(int k)
    {
     for(int i=0;i<nof;i++)
        {
     if(tempee[i]==Ref[k])  
     {
         s=i;
         return true;
         
     }
        }
     return false;
    }
  void LFU()
  {
      int c5=0;
      int d4=0;
      while(c5<nop)
      {
          if(checkee(c5))
          {
              Freq[Ref[c5]]++;
              for(int i=0;i<nof;i++)
               {
              outpute[i][c5]=tempee[i];
               } 
               d4=1;  
          }
          if(c5<nof)
          {
              tempee[c5]=Ref[c5];
              Freq[Ref[c5]]++;
               for(int i=0;i<nof;i++)
               {
              outpute[i][c5]=tempee[i];
               } 
               d4=1;
               nofaee++;
          } 
          
          if(d4==0)
          {
            for(int i=0;i<nof;i++)
              {
                  t1=tempee[i];
              
           int x=check3(c5);
           if(x>=0)
           {
               temp4[i]=x;
           }
              } 
             h=min1(); // el i bta3t LRU 
             for(int i=0;i<nof;i++)
              {
                
               temp5[i]=Freq[tempee[i]];
           
              } 
             int o=Frqcheck();
             Freq[tempa]--;
             tempee[o]=Ref[c5];
             Freq[Ref[c5]]++;
             for(int i=0;i<nof;i++)
               {
              outpute[i][c5]=tempee[i];
               } 
           nofaee++;
               } 
          
          c5++;
          d4=0;
      }
  }
public static int[] uniqueNumbers(int[]refStr,int nof)
    {
        List unique;
        unique = new ArrayList<>();
        int count=0;
        for (int i = 0; i < refStr.length; i++) {
            boolean b=false;
            for (int j = 0; j < 10; j++) {
                if((int)unique.get(j)==refStr[i])
                {
                    b=true;
                }
                if(!b)
                {
                    unique.add(refStr[i]);
                    count++;
                }
            }
        }
        int ret[]= new int[unique.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i]=(int)unique.get(i);
        }
    return ret;
    }






public static int EnhancedSecondChance(int[] refArr, int numberOfFrames) {
    int pageFaults = 0;
    int[] frames = new int[numberOfFrames];
    Map<Integer, String> dualBits = new HashMap();
    /*if (numberOfFrames >= refArr.length) {
        return uniqueNumbers(refArr, numberOfFrames);
    }*/
    for (int l = 0; l < refArr.length; l++) {
        if (!dualBits.containsKey(refArr[l])) {
            dualBits.put(refArr[l], "11");
        }
    }
    int i = 0;
    char c='0';
    for (int j = 0; j < frames.length; i++) {
        boolean dummyfound = false;
        for (int k = 0; k < j; k++) {
            if (frames[k] == refArr[i]){
                dummyfound = true;
            }
        }
        c='0';
        if(j%3==1)
            c='1';
        dualBits.replace(refArr[i], "1"+c);
        if (dummyfound)
            continue;
        frames[j] = refArr[i];

        pageFaults++;
        j++;
    }
    System.out.println();
    for (int p : frames)
        System.out.print(p + " ");
    System.out.println();

    for (; i < refArr.length; i++) {
        boolean inFrames = false;
        int replacmentInt = 0;
        c='0';
        if((i%3)==1)
            c='1';
        for (int j = 0; j < frames.length; j++)
            if (refArr[i] == frames[j])
                inFrames = true;
        if (inFrames) {
            continue;
        }
        boolean doubleZeroFound=false;
        for (int j = 0; j < frames.length; j++) {
            if (dualBits.get(frames[j]).equals("00") ) {
                replacmentInt = j;
                doubleZeroFound=true;
                break;
            }
        }
        if(!doubleZeroFound){
            boolean  zeroOneFound=false;
        for (int j=0;j<frames.length;j++){
            if (dualBits.get(frames[j]) .equals("01")) {
                replacmentInt = j;
                zeroOneFound=true;
                break;
            }
            else{
                dualBits.replace(frames[j],"0"+dualBits.get(frames[j]).charAt(1));
            }
        }
        if(!zeroOneFound)
        for (int j = 0; j < frames.length; j++) {
            if (dualBits.get(frames[j]).equals("00")) {
                replacmentInt = j;
                break;
            }
            }
        }
        dualBits.replace(refArr[i], "1"+c);
        frames[replacmentInt] = refArr[i];
        pageFaults++;
        for (int p : frames)
            System.out.print(p + " ");
        System.out.println();
    }
    return pageFaults;
}
  void print()
  {
      input();
      System.out.println("FIFO :");
      fifo();
      for(int i=0;i<nof;i++)
      {
          for(int j=0;j<nop;j++)
          {
              System.out.print(outputa[i][j]+"  ");
            
          }
          System.out.println();
       
      }
       System.out.println("no of faults :"+nofaaa);
       System.out.println("------------------------------------------------------------------------------------------------");
       System.out.println("LRU :");
      LRU();
      for(int i=0;i<nof;i++)
      {
          for(int j=0;j<nop;j++)
          {
              System.out.print(outputb[i][j]+"  ");
            
          }
          System.out.println();
       
      }
       System.out.println("no of faults :"+nofabb);
       System.out.println("------------------------------------------------------------------------------------------------");
       System.out.println("optimal :");
      optimal();
      for(int i=0;i<nof;i++)
      {
          for(int j=0;j<nop;j++)
          {
              System.out.print(outputc[i][j]+"  ");
            
          }
          System.out.println();
       
      }
       System.out.println("no of faults :"+nofacc);
       System.out.println("------------------------------------------------------------------------------------------------");
       System.out.println("Second Chance :");
      Secondchance();
      for(int i=0;i<nof;i++)
      {
          for(int j=0;j<nop;j++)
          {
              System.out.print(outputd[i][j]+"  ");
            
          }
          System.out.println();
       
      }
       System.out.println("no of faults :"+nofadd);
       System.out.println("------------------------------------------------------------------------------------------------");
       System.out.println("LFU :");
      LFU();
       System.out.println("The counters :");
      for (int i = 0; i < 99; i++) {
         
          System.out.print(Freq[i]+"  ");
      }
      System.out.println("  ");
      
      for(int i=0;i<nof;i++)
      {
          for(int j=0;j<nop;j++)
          {
              System.out.print(outpute[i][j]+"  ");
            
          }
          System.out.println();
       
      }
       System.out.println("no of faults :"+nofaee);
       System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("enhanced second chance:");
      int y=EnhancedSecondChance(Ref, nof);
   
      System.out.println("no of faults :"+y);
      
      
      
  }
  
}
public class OsAss2 {

    public static void main(String[] args) {
       Ass2 s=new Ass2();
       s.print();
    }
    
}
