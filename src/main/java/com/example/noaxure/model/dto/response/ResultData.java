package com.example.noaxure.model.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Getter
@NoArgsConstructor
public class ResultData {

    private Object data;


    private Integer status = 200;


    private Integer totalCount;


    private String code = "Ok";


    private String message = "Success";


    private Date timeStamp;

    private ResultData(Object data){
        this(data,0,null);
    }

    private ResultData(Integer totalCount){
        this(null,totalCount,null);
    }

    private ResultData(String code){
        this(null,0,code);
    }

    private ResultData(Object data, Integer totalCount){
        this(data,totalCount,null);
    }

    private ResultData(Object data, Integer totalCount,String code){
        this.data = data;
        this.totalCount = totalCount;
        this.code = code;
        this.timeStamp = new Date();
    }


    public static ResponseEntity<ResultData> ok(Object data){
        ResultData resultData = new ResultData(data);
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> ok(Integer totalCount){
        ResultData resultData = new ResultData(totalCount);
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> ok(Object data, Integer totalCount){
        ResultData resultData = new ResultData(data, totalCount);
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> ok(Object data, Integer totalCount, String code){
        ResultData resultData = new ResultData(data, totalCount, code);
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> ok(ResultData resultData){
        return ResponseEntity.ok(resultData);
    }

    public static ResponseEntity<ResultData> delete(){
        return ResponseEntity.noContent().build();
    }
}
