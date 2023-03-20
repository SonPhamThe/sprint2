package com.example.exam.utils;

import com.example.exam.dao.BaseResponseDao;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GenerateBaseResponse {
    public static BaseResponseDao successGetResponse(String msg, Object data) {
        return BaseResponseDao.builder()
                .code(HttpStatus.OK.value())
                .msg(msg)
                .data(new ArrayList<>(Collections.singletonList(data)))
                .status(ResponseStatus.SUCCESS.getValue())
                .time(new Date())
                .build();
    }

    public static BaseResponseDao noContentGetResponse(String msg, Object data) {
        return BaseResponseDao.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .msg(msg)
                .data(new ArrayList<Object>(Collections.singletonList(data)))
                .status(ResponseStatus.SUCCESS.getValue())
                .time(new Date())
                .build();
    }

    public static BaseResponseDao invalidField(String msg, Object data) {
        return BaseResponseDao.builder()
                .code(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .msg(msg)
                .data(new ArrayList<Object>(Collections.singletonList(data)))
                .status(ResponseStatus.FAIL.getValue())
                .time(new Date())
                .build();
    }

    public static BaseResponseDao notFound(String msg, Object data) {
        return BaseResponseDao.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .msg(msg)
                .data(new ArrayList<Object>(Collections.singletonList(data)))
                .status(ResponseStatus.FAIL.getValue())
                .time(new Date())
                .build();
    }
}
