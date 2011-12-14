/*
ID: zeng.aa1
LANG: JAVA
PROG: transform
 */

import java.io.*;
import java.util.*;

public class transform
{
    static int N;

    public static void main( String[] args ) throws IOException
    {
	Scanner sc = new Scanner( new File( "transform.in" ) );
	FileWriter fw = new FileWriter( "transform.out" );
	N = sc.nextInt();
	sc.nextLine();
	char[][] foo = new char[N][];
	char[][] bar = new char[N][];
	for ( int i = 0; i < N; i++ )
            foo[i] = sc.nextLine().toCharArray();
        for ( int i = 0; i < N; i++ )
            bar[i] = sc.nextLine().toCharArray();
        if ( eqv( rotate( foo ), bar ) )
            fw.write( "1\n" );
        else if ( eqv( rotate( rotate( foo ) ), bar ) )
            fw.write( "2\n" );
        else if ( eqv( rotate( rotate( rotate( foo ) ) ), bar ) )
            fw.write( "3\n" );
        else if ( eqv( flip( foo ) , bar ) )
            fw.write( "4\n" );
        else if ( eqv( flip( rotate( foo ) ) , bar ) || 
                eqv( flip( rotate( rotate( foo ) ) ), bar ) || 
                eqv( flip( rotate( rotate( rotate( foo ) ) ) ), bar ) )
            fw.write( "5\n" );
        else if ( eqv( foo, bar ) )
            fw.write( "6\n" );
        else
            fw.write( "7\n" );
        sc.close();
        fw.close();
    }

    public static boolean eqv( char[][] foo, char[][] bar )
    {
        for ( int i = 0; i < N; i++ )
            for ( int j = 0; j < N; j++ )
                if ( foo[i][j] != bar[i][j] )
                    return false;
        return true;
    }

    public static char[][] rotate( char[][] arr )
    {
        char[][] foo = new char[N][];
        for ( int i = 0; i < N; i++ )
            foo[i] = new char[N];
        for ( int i = 0; i < N; i++ )
            for( int j = 0; j < N; j++ )
                foo[i][j] = arr[j][i];
        return flip ( foo );
    }

    public static char[][] flip( char[][] arr )
    {
        char[][] foo = new char[N][];
        for ( int i = 0; i < N; i++ )
            foo[i] = new char[N];
        for ( int i = 0; i < N; i++ )
            for ( int j = 0; j < N; j++ )
                foo[i][j] = arr[i][N - j - 1];
        return foo;
    }
}
