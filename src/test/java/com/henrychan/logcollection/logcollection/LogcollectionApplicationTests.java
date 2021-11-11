package com.henrychan.logcollection.logcollection;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.henrychan.logcollection.dto.VarLogDTO;
import com.henrychan.logcollection.exception.UnknownException;
import com.henrychan.logcollection.service.VarLogService;

class LogcollectionApplicationTests {
	VarLogService varLogService = new VarLogService();
	@Test
	void mainTest() throws FileNotFoundException, UnknownException {
		List<VarLogDTO> result = null;
		boolean foundException = false;
		try {
			result = varLogService.getLogs("messagesNotFound", 99999, null);
		} catch (Exception e) {
			foundException = true;
		}
		assertEquals(true, foundException);
		result = varLogService.getLogs("messages", 99999, null);
		assertEquals(101, result.size());
		
		result = varLogService.getLogs("messages", 5, null);
		assertEquals(5, result.size());
		
		result = varLogService.getLogs("messages", 9999, "10");  // matches "10" and "100"
		assertEquals(2, result.size());
	}

}
