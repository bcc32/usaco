/*
ID: zeng.aa1
LANG: JAVA
TASK: milk
 */

import java.io.*;
import java.util.*;

class dealer implements Comparable
{
    public int prc;
    public int amt;
    
    public dealer()
    {
        this.prc = 0;
        this.amt = 0;
    }
    
    public int compareTo( Object obj )
    {
        dealer tmp = (dealer)obj;
        if ( this.prc < tmp.prc )
            return -1;
        else if ( this.prc > tmp.prc )
            return 1;
        else
            return 0;
    }
}

public class milk
{
    public static void main( String[] args ) throws IOException
    {
        Scanner sc = new Scanner( new File( "milk.in" ) );
        FileWriter fw = new FileWriter( "milk.out" );
        int N = sc.nextInt();
        int M = sc.nextInt();
        dealer[] dealers = new dealer[M];
        for ( int i = 0; i < M; i++ )
        {
            dealers[i] = new dealer();
            dealers[i].prc = sc.nextInt();
            dealers[i].amt = sc.nextInt();
        }
        Arrays.sort( dealers );
        int c = 0, m = 0;
        while ( c < N )
            for ( dealer d : dealers )
                if ( d.amt > 0 )
                {
                    int ata = d.amt;
                    if ( ata > N - c )
                    {
                        ata = N - c;
                    }
                    d.amt -= ata;
                    c += ata;
                    m += d.prc * ata;
                }
        fw.write( String.format( "%d\n", m ) );
        sc.close();
        fw.close();
    }
}