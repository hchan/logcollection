package com.henrychan.logcollection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VarLogDTO {
	private String line; // ... could decompose further, i.e. labels, timestamps

}
