package com.example.exam.dao;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class BaseResponseDao {
    private int code;
    private String status;
    private String msg;
    private Date time;
    private List<Object> data;
}
