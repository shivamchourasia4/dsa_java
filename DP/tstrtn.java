import java.util.Scanner;
public class tstrtn {

   /* public static int[][] clk(int m[][],int stcol,int edcol,int strow,int edrow){
        int temp=0,beta=0,temp2=0;
        for(int i=strow;i<=edrow;i++)
        {
            for(int j=stcol;j<=edcol;j++)
            {
               // int temp,beta,temp2;
                if(i==stcol&&j==strow)
                {
                    beta=m[strow][stcol];
                    m[strow][stcol] = m[strow+1][stcol];
                    continue;
                }
                if(i==strow&&j>stcol)
                {
                     temp = m[i][j];
                    m[i][j] = beta;
                    beta=temp;
                    continue;
                }
                if((i>strow&&i<edrow)&&j==stcol)
                {
                     temp2 = m[i+1][j];
                    m[i][j] = temp2;
                }
                if(i>strow&&j==edcol)
                {
                    temp = m[i][j];
                    m[i][j] = beta;
                    beta = temp;
                }
                if(i==edrow)
                {
                    if(j==edrow-1)
                    {
                        m[i][j] = beta;
                    }
                    m[i][j]=m[i+1][j];
                }

            }
        }

        return m;
    }*/

    static void rotatematrix(int m, 
					int n, int mat[][]) 
	{   int R=m,C=n;
		int row = 0, col = 0; 
		int prev, curr; 

		/* 
		row - Staring row index 
		m - ending row index 
		col - starting column index 
		n - ending column index 
		i - iterator 
		*/
		//while (row < m && col < n) 
		//{ 
	
			//if (row + 1 == m || col + 1 == n) 
				//break; 
	
			// Store the first element of next 
			// row, this element will replace 
			// first element of current row 
			prev = mat[row + 1][col]; 
	
			// Move elements of first row 
			// from the remaining rows 
			for (int i = col; i < n; i++) 
			{ 
				curr = mat[row][i]; 
				mat[row][i] = prev; 
				prev = curr; 
			} 
			row++; 
	
			// Move elements of last column 
			// from the remaining columns 
			for (int i = row; i < m; i++) 
			{ 
				curr = mat[i][n-1]; 
				mat[i][n-1] = prev; 
				prev = curr; 
			} 
			n--; 
	
			// Move elements of last row 
			// from the remaining rows 
			//if (row < m) 
			//{ 
				for (int i = n-1; i >= col; i--) 
				{ 
					curr = mat[m-1][i]; 
					mat[m-1][i] = prev; 
					prev = curr; 
				} 
			//} 
	         m--; 
	
			// Move elements of first column 
			// from the remaining rows 
			//if (col < n) 
			//{
				for (int i = m-1; i >= row; i--) 
				{ 
					curr = mat[i][col]; 
					mat[i][col] = prev; 
					prev = curr; 
				} 
		//	} 
			col++; 
		//} 
            System.out.println("________________________-");
			// Print rotated matrix 
			for (int i = 0; i < R; i++) 
			{ 
				for (int j = 0; j < C; j++) 
				System.out.print( mat[i][j] + " "); 
				System.out.print("\n"); 
			} 
    }
    
    public static void rtranti(int n,int m,int mat[][]) {
        int R=n,C=m;
        int row=0,col=0;
        int prev,curr;

        prev = mat[row+1][m-1];
        for(int i=m-1;i>=0;i--)
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
        System.out.println("________________________-");
        // Print rotated matrix 
        for (int i = 0; i < R; i++) 
        { 
            for (int j = 0; j < C; j++) 
            System.out.print( mat[i][j] + " "); 
            System.out.print("\n"); 
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

    //int k=0;
      //  int stcol = 0;
      //  int edcol = col-1;
       // int strow = 0;
       // int edrow = row-1;
      //  m = clk(m,stcol,edcol,strow,edrow);
      //  display(m,row,col);
      //rotatematrix(row, col, m);
      rtranti(row,col,m);
}
}