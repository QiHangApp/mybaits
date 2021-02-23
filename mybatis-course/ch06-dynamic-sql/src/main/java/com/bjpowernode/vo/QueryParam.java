package com.bjpowernode.vo;

/**
 * @author lqh
 * @date 2021/2/11 下午3:12
 */
public class QueryParam {

    private String paramName;
    private Integer paramAge;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamAge() {
        return paramAge;
    }

    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "paramName='" + paramName + '\'' +
                ", paramAge='" + paramAge + '\'' +
                '}';
    }
}
