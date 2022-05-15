package com.zyz.mybatis.cfg;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 11:07
 * 用于封装执行的SQL语句和结果类型的全限定名
 **/

public class Mapper {
    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}



