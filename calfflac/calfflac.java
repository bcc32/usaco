/*
ID: zeng.aa1
LANG: JAVA
TASK: calfflac
 */

import java.io.*;
import java.util.*;

public class calfflac
{
    public static void main( String[] args ) throws IOException
    {
        Scanner sc = new Scanner( new File( "calfflac.in" ) );
        FileWriter fw = new FileWriter( "calfflac.out" );

        StringBuilder sb = new StringBuilder(); 
        while ( sc.hasNextLine() )
            sb.append( sc.nextLine() );
        String line = sb.toString();
        int m = 0, n = 0;

        for ( int i = 0; i < line.length(); i++ )
        {
            for ( int j = 1; i + j <= line.length(); j++ )
            {
                String s = line.substring( i, i + j ).toLowerCase();
                if ( s.charAt( 0 ) != s.charAt( s.length() - 1 ) )
                    continue;
                if ( isPalin( s ) && j > m )
                {
                    m = j;
                    n = i;
                }
            }
        }

        fw.write( String.format( "%d\n%s\n", cc( line.substring( n, n + m ) ), line.substring( n, n + m ) ) );
        sc.close();
        fw.close();
    }

    static boolean isPalin( String line )
    {
        StringBuilder sb = new StringBuilder();
        boolean started = false, ended = false;
        for ( char c : line.toCharArray() )
        {
            if ( c >= 'a' && c <= 'z' )
            {
                sb.append( c );
                started = true;
                ended = true;
            }
            else if ( !started )
                return false;
            else
                ended = false;
        }
        if ( !ended ) return false;
        String f = sb.toString();
        String b = sb.reverse().toString();
        return f.equals( b );
    }
    
    static int cc( String line )
    {
        int c = 0;
        for( char ch : line.toCharArray () )
        {
            if ( ch >= 'A' && ch <= 'Z' )
                c++;
            else if ( ch >= 'a' && ch <= 'z' )
                c++;
        }
        return c;
    }
}
