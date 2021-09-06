import java.util.Scanner;

public class unlocker {

    static int[][] clk(int m, 
					int n, int mat[][],int strow,int stcol) 
	{  
		int row = strow, col = stcol; 
        int prev, curr; 
     
			prev = mat[row + 1][col]; 
	
			
			for (int i = col; i < n; i++) 
			{ 
				curr = mat[row][i]; 
				mat[row][i] = prev; 
				prev = curr; 
			} 
			row++; 
	
			
			for (int i = row; i < m; i++) 
			{ 
				curr = mat[i][n-1]; 
				mat[i][n-1] = prev; 
				prev = curr; 
			} 
			n--; 
	
			
				for (int i = n-1; i >= col; i--) 
				{ 
					curr = mat[m-1][i]; 
					mat[m-1][i] = prev; 
					prev = curr; 
				} 
			 
	         m--; 
	
			
				for (int i = m-1; i >= row; i--) 
				{ 
					curr = mat[i][col]; 
					mat[i][col] = prev; 
					prev = curr; 
				} 
		 
			col++; 
		
            return mat;
    }

    public static int[][] rtranti(int n,int m,int mat[][],int strow,int stcol) {
       // int R=n,C=m;
        int row=strow,col=stcol;
        int prev,curr;
       // System.out.println("row=> "+n+" col=> "+m);
        prev = mat[row+1][m-1];
        for(int i=m-1;i>=stcol;i--)
        {
            curr = mat[row][i];
            mat[row][i] = prev;
            prev = curr;
        }
        row++;
        for(int i=row;i<n;i++)
        {
            curr = mat[i][col];
            mat[i][col]=prev;
            prev = curr;
        }
        col++;
        for(int i=col;i<m;i++)
        {
            curr = mat[n-1][i];
            mat[n-1][i] = prev;
            prev = curr;
        }
        n--;
        for(int i=n-1;i>=row;i--)
        {
            curr = mat[i][m-1];
            mat[i][m-1] = prev;
            prev = curr;
        }
        m--;
        //System.out.println("________________________-");
        /* Print rotated matrix 
        for (int i = 0; i < R; i++) 
        { 
            for (int j = 0; j < C; j++) 
            System.out.print( mat[i][j] + " "); 
            System.out.print("\n"); 
        }*/
        return mat;
    }

    public static void display(int m[][],int row,int col){
      //  System.out.println("_____________________________________________");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int m[][] = new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                m[i][j] = sc.nextInt();
            }
        }

        int l = row<col?row/2:col/2;
        int a[] = new int[l];
        for(int i=0;i<l;i++)
        {
            a[i] = sc.nextInt();
        }

        int itr = a.length,k=0;
        int stcol = 0;
        int lcol = col;
        int strow = 0;
        int lrow = row;
       // int a=row,int b=col;
       // System.out.println("---------->>>>>"+itr); 
        while(itr-->0)
        {
            if(k%2==0)
            {
               // int retro = 
                //a[k]=
              //  System.out.println("a[k]=> "+a[k]);  ---
              int nofr = lrow-strow;
              int nofcol = lcol-stcol;
              int tbm=(nofcol*2)+((nofr-2)*2);
              a[k]=a[k]%tbm;
             // System.out.println("---------> "+tbm);
               while(a[k]-->0)
                {
                    
                   // System.out.println("rowxcol=> "+nofr+" x "+nofcol);
                  //  System.out.println("stcol=> "+stcol+"strow=> "+strow);
                  //  System.out.println("lrow=> "+lrow+" lcol=> "+lcol);
                   m = rtranti(lrow,lcol,m,strow,stcol); 
                 //  display(m, row, col);
                }
                stcol+=1;
                strow+=1;
                lcol-=1;
                lrow-=1;
                k++;
            }
            else{
                int nofr = lrow-strow;
                int nofcol = lcol-stcol;
                int tbm=(nofcol*2)+((nofr-2)*2);
               // System.out.println("---------> "+tbm);
                a[k]=a[k]%tbm;
                while(a[k]-->0)
                {
                    //int nofr = lrow-strow;
                   // int nofcol = lcol-stcol;
                 //   System.out.println("rowxcol=> "+nofr+" x "+nofcol);
                 //   System.out.println("stcol=> "+stcol+"strow=> "+strow);
                 //   System.out.println("lrow=> "+lrow+" lcol=> "+lcol);
                    m = clk(lrow,lcol,m,stcol,strow);
                  //  display(m,row,col);
                }
                stcol+=1;
                strow+=1;
                lcol-=1;
                lrow-=1;
                k++;
            }
        }
       display(m, row, col);
        sc.close();
    }
}