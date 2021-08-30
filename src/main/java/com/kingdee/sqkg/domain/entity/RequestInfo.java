package com.kingdee.sqkg.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class RequestInfo {
    private String ip;
    private String url;
    private String httpMethod;
    private String classMethod;
    private Object requestParams;
    private Object result;
    private Long timeCost;
}
