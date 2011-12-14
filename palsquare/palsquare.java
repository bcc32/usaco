/*
ID: zeng.aa1
LANG: JAVA
TASK: palsquare
 */

import java.io.*;
import java.util.*;

public class palsquare
{
    public static void main( String[] args ) throws IOException
    {
        Scanner sc = new Scanner( new File( "palsquare.in" ) );
        FileWriter fw = new FileWriter( "palsquare.out" );
        int B = sc.nextInt();
        for ( int i = 1; i <= 300; i++ )
            if ( isPalin( Integer.toString( i * i, B ) ) )
                fw.write( String.format( "%s %s\n", Integer.toString( i, B ).toUpperCase(), Integer.toString( i * i, B ).toUpperCase() ) );
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
