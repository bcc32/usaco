/*
ID: zeng.aa1
LANG: java
TASK: barn1
 */

import java.io.*;
import java.util.*;

public class barn1
{
    public static void main( String[] args ) throws IOException
    {
        Scanner sc = new Scanner( new File( "barn1.in" ) );
        FileWriter fw = new FileWriter( "barn1.out" );
        
        int M = sc.nextInt();
        int S = sc.nextInt();
        int C = sc.nextInt();
        
        int[] s = new int[S];
        int[] b = new int[S];
        for ( int i = 0; i < C; i++ )
            s[sc.nextInt() - 1] = 1;
        
        for ( int i = min( s ); i <= max( s ); i++ )
            b[i] = 1;
        for ( int n = 1; n < M; n++ )
        {
            int[] r = opt( b, s );
            if ( Arrays.equals( r, new int[2] ) )
                break;
            for ( int i = r[0]; i < r[1]; i++ )
                b[i] = 0;
        }
        
        fw.write( String.format( "%d\n", sum( b ) ) );
        sc.close();
        fw.close();
    }

    static int min( int[] a )
    {
        int m = 200;
        for ( int i = 0; i < a.length; i++ )
            if ( a[i] == 1 && a[i] < m ) m = a[i];
        return m;
    }

    static int max( int[] a )
    {
        int m = 0;
        for ( int i = 0; i < a.length; i++ )
            if ( a[i] == 1 && a[i] > m ) m = a[i];
        return m;
    }

    static int numboards( int[] a )
    {
        int c = 0;
        boolean board = false;
        for ( int i = 0; i < a.length; i++ )
        {
            if ( a[i] == 1 && !board )
            {
                c++;
                board = true;
            }
            else if ( a[i] == 0 ) board = false;
        }
        return c;
    }

    static int[] opt ( int[] a, int[] b )
    {
        int m = 0, x = 0, y = 0, s = 0;
        boolean r = false;
        for ( int i = 0; i < a.length; i++ )
        {
            if ( a[i] == 1 && b[i] == 0 && !r )
            {
                r = true;
                s = i;
            }
            else if ( ( a[i] == 0 || b[i] == 1) && r )
            {
                r = false;
                int d = i - s;
                if ( d > m )
                {
                    m = d;
                    x = s;
                    y = i;
                }
            }
        }
        if ( m == 0 )
            return new int[2];
        int[] R = {x, y};
        return R;
    }
    
    static int sum( int[] a )
    {
        int s = 0;
        for ( int i : a )
            s += i;
        return s;
    }
}
