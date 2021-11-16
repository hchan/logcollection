package com.henrychan.logcollection.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
*
* @author Henry
*
* This test MUST have a file called /var/log/messages with 101 lines to work
* i.e.
* for ($i = 0; $i <= 100; $i++) {
*   print($i . "\n");
* } 
* or convert that logic to BeforeAll ;)
*
*/
public class ReversedLinesFileReaderTest {
	static ReversedLinesFileReader reversedLinesFileReader;
	
	@BeforeAll
	public static void setup() throws IOException {
		reversedLinesFileReader = new ReversedLinesFileReader(new File("/var/log/messages"));		
	}
	
	@Test
	public void mainTest() throws IOException {
		int lineCount = 0;
		String line;
		int expected = 100;
		while  ((line = reversedLinesFileReader.readLine()) != null) {
			assertEquals(expected, Integer.parseInt(line));
			lineCount++;
			expected--;
		}
		assertEquals(101, lineCount);		
	}
}
