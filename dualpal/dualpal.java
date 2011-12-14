/*
ID: zeng.aa1
LANG: JAVA
TASK: dualpal
 */

import java.io.*;
import java.util.*;

public class dualpal
{
    public static void main( String[] args ) throws IOException
    {
        Scanner sc = new Scanner( new File( "dualpal.in" ) );
        FileWriter fw = new FileWriter( "dualpal.out" );
        int N = sc.nextInt();
        int S = sc.nextInt();
        int c = 0;
        for ( int i = S + 1; c < N; i++ )
        {
            int ci = 0;
            for ( int b = 2; b <= 10; b++ )
                if ( isPalin( Integer.toString( i, b ) ) )
                    ci++;
            if ( ci >= 2 )
            {
                fw.write( String.format( "%d\n" , i ) );
                c++;
            }
        }
        sc.close();
        fw.close();
    }

    public static boolean isPalin( String num )
    {
        for ( int i = 0; i < num.length(); i++ )
            if ( num.charAt( i ) != num.charAt( num.length() - i - 1 ) )
                return false;
        return true;
    }
}