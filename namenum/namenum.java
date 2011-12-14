/*
ID: zeng.aa1
LANG: JAVA
TASK: namenum
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class namenum
{
    static String[] patt =
    { "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY" };

    public static void main( String[] args ) throws IOException
    {
        Scanner di = new Scanner( new File( "dict.txt" ) );
        Scanner sc = new Scanner( new File( "namenum.in" ) );
        FileWriter fw = new FileWriter( "namenum.out" );
        String num = sc.nextLine();
        boolean none = true;
        while ( di.hasNextLine() )
        {
            String name = di.nextLine();
            Pattern p = Pattern.compile( pat( num ) );
            if ( Pattern.compile( pat( num ) ).matcher( name ).matches() )
            {
                fw.write( String.format( "%s\n", name ) );
                none = false;
            }
        }
        di.close();
        sc.close();
        if ( none )
            fw.write( "NONE\n" );
        fw.close();
    }

    public static String pat( String num )
    {
        StringBuilder sb = new StringBuilder();
        for ( char ch : num.toCharArray() )
            sb.append( "[" + patt[Integer.parseInt( String.valueOf( ch ) ) - 2]
                    + "]" );
        return sb.toString();
    }
}
