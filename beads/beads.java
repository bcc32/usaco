/*
ID: zeng.aa1
LANG: JAVA
TASK: beads
 */

import java.util.*;
import java.io.*;

public class beads
{
    public static int min( int a, int b )
    {
        return a < b ? a : b;
    }

    public static String shift( String beads )
    {
        StringBuffer sb = new StringBuffer();
        sb.append( beads.charAt( beads.length() - 1 ) );
        for ( int i = 0; i < beads.length() - 1; i++ )
            sb.append( beads.charAt( i ) );
        return sb.toString();
    }

    public static int count( String beads )
    {
        int fcount = 0, bcount = 0, c = 0;
        char colour = 'w';
        for ( int i = 0; i < beads.length(); i++ )
        {
            if ( beads.charAt( i ) == 'w' )
                c++;
            else if ( colour == 'w' )
            {
                colour = beads.charAt( i );
                c++;
            }
            else if ( beads.charAt( i ) == colour )
                c++;
            else
                break;
        }
        fcount = c;
        c = 0;
        colour = 'w';
        for ( int i = beads.length() - 1; i > 0; i-- )
        {
            if ( beads.charAt( i ) == 'w' )
                c++;
            else if ( colour == 'w' )
            {
                colour = beads.charAt( i );
                c++;
            }
            else if ( beads.charAt( i ) == colour )
                c++;
            else
                break;
        }
        bcount = c;
        return min( beads.length(), fcount + bcount );
    }

    public static void main( String[] args ) throws IOException
    {
        Scanner in = new Scanner( new File( "beads.in" ) );
        FileWriter fw = new FileWriter( "beads.out" );
        int N = in.nextInt();
        in.nextLine();
        String beads = in.nextLine();
        int m = 0, c;
        for ( int i = 0; i < beads.length(); i++ )
        {
            c = count( beads );
            if ( c > m ) m = c;
            beads = shift( beads );
        }
        fw.write( String.format( "%d\n", m ) );
        in.close();
        fw.close();
    }
}
