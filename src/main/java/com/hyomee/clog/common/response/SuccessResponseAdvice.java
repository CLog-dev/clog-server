package com.hyomee.clog.common.response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

// ✨ 모든 컨트롤러의 성공 응답을 통일된 JSON 구조로 감싸는 역할
@ControllerAdvice
public class SuccessResponseAdvice implements ResponseBodyAdvice<Object> {

    // ⚪ support(): controller 반환값을 beforeBodyWrite()에 보낼지 판단
    // ⚫ controller 반환값이 ApiResponse면 supports()는 false를 반환하고 beforeBodyWrite()가 호출되지 않고 그대로 반환
    // ⚫ controller 반환값이 ApiResponse가 아니면 supports()는 true를 반환하고 beforeBodyWrite()가 호출된 후 ApiResponse.ok()로 감싸서 JSON 형태로 반환
    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getParameterType().equals(ApiResponse.class);
    }

    // ⚪ beforeBodyWrite(): 응답을 감싸 JSON 반환
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // ⚫ 이미 ApiResponse면 그대로 반환
        if (body instanceof ApiResponse) {
            return body;
        }
        // ⚫ null은 ApiResponse로 감싼 뒤 반환
        if (body == null) {
            return ApiResponse.ok(null, SuccessCode.DEFAULT);
        }
        // ⚫ 일반 DTO는 ApiResponse로 감싼 뒤 반환
        return ApiResponse.ok(body, SuccessCode.DEFAULT);
    }
}