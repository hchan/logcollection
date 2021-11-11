package com.henrychan.logcollection.logcollection;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.henrychan.logcollection.dto.VarLogDTO;
import com.henrychan.logcollection.exception.UnknownException;
import com.henrychan.logcollection.service.VarLogService;

/**
 *
 * @author Henry
 *
 * This test MUST have a file called /var/log/messages with 101 lines to work
 * i.e.
 * for ($i = 0; $i <= 100; $i++) {
 *   print($i . "\n");
 * }
 *
 */
public class LogcollectionApplicationTests {
	static VarLogService varLogService = null;
	static List<VarLogDTO> result = null;
	
	
	@BeforeAll
	public static void init() {
		varLogService = new VarLogService();
	}
	
	@Test
	public void fileNotFound() throws FileNotFoundException, UnknownException {
		boolean foundException = false;
		try {
			result = varLogService.getLogs("messagesNotFound", 99999, null);
		} catch (Exception e) {
			foundException = true;
		}
		assertEquals(true, foundException);
		
	}
	
	@Test
	public void minOfFile() throws FileNotFoundException, UnknownException {
		result = varLogService.getLogs("messages", Integer.MAX_VALUE, null);
		assertEquals(101, result.size()); // the file /var/log/messages contains 101 lines (0->100 inclusive)
	}
	
	@Test
	public void happyCase() throws FileNotFoundException, UnknownException {
		result = varLogService.getLogs("messages", 5, null);
		assertEquals(5, result.size());
	}
	
	@Test
	public void filter()  throws FileNotFoundException, UnknownException {
		result = varLogService.getLogs("messages", 9999, "10");  // matches "10" and "100"
		assertEquals(2, result.size());
	}

}
