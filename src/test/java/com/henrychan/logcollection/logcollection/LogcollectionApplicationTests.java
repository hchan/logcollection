package com.henrychan.logcollection.logcollection;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.henrychan.logcollection.dto.VarLogDTO;
import com.henrychan.logcollection.exception.UnknownException;
import com.henrychan.logcollection.service.VarLogService;

class LogcollectionApplicationTests {
	VarLogService varLogService = new VarLogService();
	@Test
	void mainTest() throws FileNotFoundException, UnknownException {
		List<VarLogDTO> result = varLogService.getLogs("messages", 99999, null);
		System.out.println(result.size());
	}

}
