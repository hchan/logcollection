package com.henrychan.logcollection.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.io.input.ReversedLinesFileReader;
import org.springframework.stereotype.Service;

import com.henrychan.logcollection.dto.VarLogDTO;
import com.henrychan.logcollection.exception.UnknownException;
import com.henrychan.logcollection.util.ReversedLinesFileReader;

@Service
public class VarLogService {
	public static File parentDir = new File("/var/log");

	public List<VarLogDTO> getLogs(String filename, Integer numEvents, String filter) throws FileNotFoundException, UnknownException {
		File file = new File(parentDir, filename);
		if (!file.exists()) {
			throw new FileNotFoundException(filename);
		}
		ReversedLinesFileReader reader = null;
		List<VarLogDTO> retval = new ArrayList<>();
		try {
			reader = new ReversedLinesFileReader(file, Charset.forName("utf-8"));			 
			for (int i = 0; i < numEvents; ) {
				String line = reader.readLine();
				if (line == null) break;
				if (filter == null || line.contains(filter)) {
					retval.add(new VarLogDTO(line));				
					i++;
				}
			}
		} 
		catch (Exception e) {
			throw new UnknownException(e);
		}
		
		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
		return retval;
	}

}
