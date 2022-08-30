package com.example.demo.atools.resp;


/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: 返回对象实体类 return object entity class
 */
public final class ServiceResp<T> implements java.io.Serializable {

    /**
     * 响应编码:-1失败,0成功
     */
    private Integer code;
    /**
     * 响应信息描述
     */
    private String msg;
    /**
     * 响应内容
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ServiceResp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public ServiceResp() {
    }

    public static ServiceResp getInstance() {
        return new ServiceResp();
    }

    public ServiceResp error() {
        this.setCode(-1);
        this.setMsg("操作失败");
        this.setData(null);
        return this;
    }

    public ServiceResp error(String msg) {
        this.setCode(-1);
        this.setMsg(msg);
        this.setData(null);
        return this;
    }

    public ServiceResp error(int code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(null);
        return this;
    }

    public ServiceResp error(String msg, T data) {
        this.setCode(-1);
        this.setMsg(msg);
        this.setData(data);
        return this;
    }

    public ServiceResp success() {
        this.setCode(0);
        this.setMsg("操作成功");
        this.setData(null);
        return this;
    }

    public ServiceResp success(String msg) {
        this.setCode(0);
        this.setMsg(msg);
        this.setData(null);
        return this;
    }

    public ServiceResp success(T data, String msg) {
        this.setCode(0);
        this.setMsg(msg);
        this.setData(data);
        return this;
    }

    public ServiceResp success(T data) {
        this.setCode(0);
        this.setMsg("操作成功");
        this.setData(data);
        return this;
    }

    public boolean isSuccess() {
        return this.getCode() == 0 ? true : false;
    }

    public boolean hasRecord() {
        return isSuccess() && this.data != null ? true : false;
    }

}
