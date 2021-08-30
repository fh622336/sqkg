package com.kingdee.sqkg.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class RequestErrorInfo {
    private String ip;
    private String url;
    private String httpMethod;
    private String classMethod;
    private Object requestParams;
    private RuntimeException exception;
}
