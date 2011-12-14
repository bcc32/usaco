/*
ID: zeng.aa1
LANG: JAVA
TASK: gift1
 */

import java.util.*;
import java.io.*;

public class gift1
{
    public static int find( String name, String[] names )
    {
        for ( int i = 0; i < names.length; i++ )
            if ( name.equals( names[i] ) )
                return i;
        
        return -1;
    }

    public static void main( String[] args ) throws IOException
    {
        Scanner in = new Scanner( new File( "gift1.in") );
        FileWriter fw = new FileWriter( "gift1.out" );
        
        int NP = in.nextInt();
        in.nextLine();
        
        String[] names = new String[NP];
        String name;
        int[] money = new int[NP];
        
        for ( int i = 0; i < NP; i++ )
            names[i] = in.nextLine();
        
        for ( int i = 0; i < NP; i++ )
        {
            name = in.nextLine();
            int j = find( name, names );
            StringTokenizer st = new StringTokenizer( in.nextLine() );
            int m = Integer.parseInt( st.nextToken() );
            int d = Integer.parseInt( st.nextToken() );
            for ( int k = 0; k < d; k++ )
            {
                name = in.nextLine();
                int u = find( name, names );
                money[j] -= m / d;
                money[u] += m / d;
            }
        }
        
        for ( int i = 0; i < NP; i++ )
            fw.write( String.format( "%s %d\n", names[i], money[i] ) );
        
        in.close();
        fw.close();
    }
}
