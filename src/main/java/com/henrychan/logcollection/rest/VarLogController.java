package com.henrychan.logcollection.rest;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.henrychan.logcollection.dto.VarLogDTO;
import com.henrychan.logcollection.exception.UnknownException;
import com.henrychan.logcollection.service.VarLogService;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
public class VarLogController {
	private VarLogService varLogService;
	
		
	@GetMapping("/api/varlog")
	public List<VarLogDTO> get(
			@RequestParam(value = "filename", defaultValue = "messages") String filename, 
			@RequestParam(value = "numEvents", defaultValue = "10") Integer numEvents, 
			@RequestParam(value = "filter", defaultValue = "") String filter) throws FileNotFoundException, UnknownException {
		
		return varLogService.getLogs(filename, numEvents, filter);
	}
}
