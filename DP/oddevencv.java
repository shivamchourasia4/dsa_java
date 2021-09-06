import java.util.ArrayList;
import java.util.Scanner;

public class oddevencv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int h = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=l;i<=h;i++)
        {
            al.add(i);
        }
        ArrayList<ArrayList<Integer> > sl = new ArrayList<ArrayList<Integer> >();
        int n = al.size();
        for(int i=0;i<k;i++)
        {
            
        }
    }
}
/*
from itertools import product
def reqsum(n):
  sum=0
  for i in range(len(n)):
      sum+=int(n[i])
  return sum
l,h = map(int,input().split())
r=int(input())
a=[]
for(i in range(l,h+1):
    a.append(str(i))
ans=0
nofp = product(a,repeat=r)
for i in nofp:
    if(reqsum(i)%2==0):
   		ans+=1 
print(ans%1000000007)*/