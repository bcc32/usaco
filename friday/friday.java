/*
ID: zeng.aa1
LANG: JAVA
TASK: friday
 */

import java.util.*;
import java.io.*;

public class friday
{
    public static boolean isLeap( int year )
    {
        if ( year % 400 == 0 )
            return true;
        else if ( year % 100 == 0 )
            return false;
        else if ( year % 4 == 0 )
            return true;
        else
            return false;
    }

    public static void main( String[] args ) throws IOException
    {
        Scanner in = new Scanner( new File( "friday.in" ) );
        FileWriter fw = new FileWriter( "friday.out" );
        int[] t = { 0, 0, 0, 0, 0, 0, 0 };
        int i = 3, NP;
        NP = in.nextInt();
        for ( int year = 1900; year < 1900 + NP; year++ )
        {
            i = ( i + 3 ) % 7; t[i]++;
            i = ( i + 3 ) % 7; t[i]++;
            i = ( i + ( isLeap( year) ? 1 : 0) ) % 7; t[i]++;
            i = ( i + 3 ) % 7; t[i]++;
            i = ( i + 2 ) % 7; t[i]++;
            i = ( i + 3 ) % 7; t[i]++;
            i = ( i + 2 ) % 7; t[i]++;
            i = ( i + 3 ) % 7; t[i]++;
            i = ( i + 3 ) % 7; t[i]++;
            i = ( i + 2 ) % 7; t[i]++;
            i = ( i + 3 ) % 7; t[i]++;
            i = ( i + 2 ) % 7; t[i]++;
        }
        fw.write( String.format( "%d %d %d %d %d %d %d\n", t[6], t[0], t[1], t[2], t[3], t[4], t[5] ) );
        in.close();
        fw.close();
    }
}
