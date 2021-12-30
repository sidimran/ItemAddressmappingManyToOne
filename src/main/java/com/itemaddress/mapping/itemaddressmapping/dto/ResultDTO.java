package com.itemaddress.mapping.itemaddressmapping.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultDTO<T> {

	private String message;
	private T data;
	private List<T> listData;

}
