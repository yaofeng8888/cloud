package com.george.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Result.
 *
 * @author yaofeng 2020-12-14 15:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> {

	private Integer code;

	private String message;

	private T data;


	private ApiResult(Integer code,String message){
		this(code,message,null);
	}
}
