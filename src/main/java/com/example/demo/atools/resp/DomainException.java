package com.example.demo.atools.resp;


/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: 异常实体类 exception entity class
 */
public final class DomainException implements java.io.Serializable {
    /**
     * 文件名
     * file name
     */
    private String fileName;
    /**
     * 异常类型
     * exception type
     */
    private String exceptionType;
    /**
     * 是否本机方法
     * Is it a native method
     */
    private Boolean nativeMethod;
    /**
     * 13位时间戳
     * 13-bit timestamp
     */
    private Long time;
    /**
     * 错误方法
     * wrong way
     */
    private String methodName;
    /**
     * 错误类
     * error class
     */
    private String className;
    /**
     * 错误行数
     * number of error lines
     */
    private Integer lineNumber;

    public static DomainException getInstance() {
        return new DomainException();
    }

    public DomainException formatException(Exception e) {
        this.exceptionType = e + "";
        final StackTraceElement element = e.getStackTrace()[0];
        this.className = element.getClassName();
        this.methodName = element.getMethodName();
        this.fileName = element.getFileName();
        this.lineNumber = element.getLineNumber();
        this.nativeMethod = element.isNativeMethod();
        this.time = java.util.Calendar.getInstance().getTimeInMillis();
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "fileName='" + fileName + '\'' +
                ", exceptionType='" + exceptionType + '\'' +
                ", nativeMethod=" + nativeMethod +
                ", time='" + time + '\'' +
                ", methodName='" + methodName + '\'' +
                ", className='" + className + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public Boolean getNativeMethod() {
        return nativeMethod;
    }

    public void setNativeMethod(Boolean nativeMethod) {
        this.nativeMethod = nativeMethod;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}
