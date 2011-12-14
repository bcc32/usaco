/*
ID: zeng.aa1
LANG: JAVA
TASK: milk2
 */

import java.util.*;
import java.io.*;

public class milk2
{
//    public static boolean found( int[] array, int foo )
//    {
//        for ( int i = 0; i < array.length; i++ )
//            if ( array[i] == foo )
//                return true;
//        return false;
//    }

    public static int freq( int[] array, int foo )
    {
        int c = 0;
        for ( int i = 0; i < array.length; i++ )
            if ( array[i] == foo )
                c++;
        return c;
    }

    public static int max( int[] array )
    {
        int m = 0;
        for ( int i = 0; i < array.length; i++ )
            if ( array[i] > m )
                m = array[i];
        return m;
    }

    public static void main( String[] args ) throws IOException
    {
        Scanner in = new Scanner( new File( "milk2.in" ) );
        FileWriter fw = new FileWriter( "milk2.out" );

        int N = in.nextInt();
        in.nextLine();

        // List<Integer> listStart = new ArrayList<Integer>();
        // List<Integer> listFinish = new ArrayList<Integer>();
        int[] starts = new int[N];
        int[] finishes = new int[N];
        // HashSet<Integer> hashStart = new HashSet<Integer>();
        // HashSet<Integer> hashFinish = new HashSet<Integer>();

        for ( int i = 0; i < N; i++ )
        {
            StringTokenizer st = new StringTokenizer( in.nextLine() );
            // listStart.add( Integer.parseInt( st.nextToken() ) );
            // listFinish.add( Integer.parseInt( st.nextToken() ) );
            starts[i] = Integer.parseInt( st.nextToken() );
            finishes[i] = Integer.parseInt( st.nextToken() );
            // hashStart.add( Integer.parseInt( st.nextToken() ) );
            // hashFinish.add( Integer.parseInt( st.nextToken() ) );
        }
        
//        System.out.printf( "%d %d", listStart.size(), listFinish.size() );
        
        // int end = Collections.max( listFinish );
        int end = max( finishes );

        int numMilking = 0, trueStart = -1, trueMax = 0, falseStart = -1, falseMax = 0;

        boolean started = false;

        for ( int i = 0; i <= end + 1; i++ )
        {
//            // if ( listStart.contains( i ) )
//            // if ( found( starts, i ) )
//            if ( hashStart.contains( i ) )
//            {
//                started = true;
//                numMilking++;
//                System.out.printf( "%d\n", i );
//            }
//            // if ( listFinish.contains ( i ) )
//            // if ( found( finishes, i ) )
//            if ( hashFinish.contains( i ) )
//                numMilking--;
            // numMilking += Collections.frequency( listStart, i );
            // numMilking -= Collections.frequency( listFinish, i );
            numMilking += freq( starts, i );
            numMilking -= freq( finishes, i );
            
            if ( numMilking > 0 )
                started = true;

//            if ( i == 29964 )
//                System.out.printf( "numMilking: %d", numMilking );
            
            if ( numMilking == 0 && started && falseStart == -1 )
            {
                falseStart = i;
//                System.out.printf( "i: %d\n", i );
            }
            if ( falseStart != -1 && numMilking > 0 )
            {
                if ( i - falseStart > falseMax )
                {
                    falseMax = i - falseStart;
//                    assert( numMilking == 0 );
//                    System.out.printf( "i: %d\tfalseStart:%d\tfalseMax:%d\t%d\n", i, falseStart, falseMax, numMilking );
                }
                falseStart = -1;
            }

            if ( numMilking > 0 && trueStart == -1 )
                trueStart = i;
            if ( trueStart != -1 && numMilking == 0 )
            {
                if ( i - trueStart > trueMax )
                    trueMax = i - trueStart;
                trueStart = -1;
            }
        }

        fw.write( String.format( "%d %d\n", trueMax, falseMax ) );

        in.close();
        fw.close();
    }
}
