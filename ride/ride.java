/*
ID: zeng.aa1
LANG: JAVA
TASK: ride
 */

import java.util.*;
import java.io.*;

public class ride
{
	public static void main( String[] args ) throws IOException
	{
		Scanner in = new Scanner( new File( "ride.in") );
		FileWriter fw = new FileWriter( "ride.out" );
		String str1, str2;
		str1 = in.nextLine();
		str2 = in.nextLine();
		int p1 = 1, p2 = 1;
		for ( int i = 0; i < str1.length(); i++ )
			p1 *= (int)str1.charAt( i ) - 64;
		for ( int i = 0; i < str2.length(); i++ )
			p2 *= (int)str2.charAt( i ) - 64;
		if ( ( p1 - p2 ) % 47 == 0 )
			fw.write( "GO\n" );
		else
			fw.write( "STAY\n" );
		in.close();
		fw.close();
	}
}
