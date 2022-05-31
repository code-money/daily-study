package com.zyz.exception;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-28 21:46
 **/

public class SysException extends Exception {


    public SysException(String message) {
        this.message = message;
    }

    //存储提示信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}



