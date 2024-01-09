package com.ecommerce.responseVo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
public class ResponseVO {

	private int statusCode;

	@Builder.Default
	private ResponseType responseType = ResponseType.SUCCESS;

	private String Message;

	private List<?> payloadList;

	private Object payload;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss a")
	private LocalDateTime time;

}
