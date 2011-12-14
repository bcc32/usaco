//TOFIX

/*
ID: zeng.aa1
LANG: java
TASK: barn1
 */

import java.io.*;
import java.util.*;

class board
{
    int f, b;
    
    public board()
    {
        this.f = 0;
        this.b = 0;
    }
}

public class barn1
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner( new File( "barn1.in" ) );
        FileWriter fw = new FileWriter( "barn1.out" );
        
        int M = sc.nextInt();
        int S = sc.nextInt();
        int C = sc.nextInt();
        
        int[] s = new int[S];
        for ( int i = 0; i < C; i++ )
            s[sc.nextInt() - 1] = 1;

        board[] boards = new board[M];
        board[0] = new board();
        board[0].f = min( s );
        board[0].b = max( s );
        for ( int n = 1; n < M; n++ )
        {
            board excl = new board();
            
        }
    }
    
    static int min( int[] a )
    {
        int m = 200;
        for ( int i = 0; i < a.length; i++ )
            if ( a[i] == 1 && a[i] < m )
                m = a[i];
        return m;
    }
    
    static int max( int[] a )
    {
        int m = 0;
        for ( int i = 0; i < a.length; i++ )
            if ( a[i] == 1 && a[i] > m )
                m = a[i];
        return m;
    }
}