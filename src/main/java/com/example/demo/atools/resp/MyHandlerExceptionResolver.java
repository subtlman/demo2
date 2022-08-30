package com.example.demo.atools.resp;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: 处理程序异常解析器 Handler exception parser
 */
@RestControllerAdvice
public final class MyHandlerExceptionResolver {

    /**
     * Remarks:
     * 1、Automatically catch exceptions
     * 2、Manually catch exceptions
     * 3、Fill exception type
     * 4、Does not affect finally use
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public static ServiceResp formatException(Exception e) {

        if (e instanceof ArithmeticException) {
            return ServiceResp.getInstance().error(
                    "数学运算异常",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof NullPointerException) {
            return ServiceResp.getInstance().error(
                    "程序遇上了空指针",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof ClassNotFoundException) {
            return ServiceResp.getInstance().error(
                    "指定的类不存在",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof ArrayIndexOutOfBoundsException) {
            return ServiceResp.getInstance().error(
                    "数组下标越界",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof IllegalArgumentException) {
            return ServiceResp.getInstance().error(
                    "方法的参数错误",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof IllegalAccessException) {
            return ServiceResp.getInstance().error(
                    "没有访问权限",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof ClassCastException) {
            return ServiceResp.getInstance().error(
                    "类型强制转换异常",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof FileNotFoundException) {
            return ServiceResp.getInstance().error(
                    "文件未找到异常",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof NumberFormatException) {
            return ServiceResp.getInstance().error(
                    "字符串转换为数字异常",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof SQLException) {
            return ServiceResp.getInstance().error(
                    "操作数据库异常",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof IOException) {
            return ServiceResp.getInstance().error(
                    "输入输出异常",
                    DomainException.getInstance().formatException(e));
        } else if (e instanceof NoHandlerFoundException) {
            return ServiceResp.getInstance().error(
                    "路径不存在，请检查路径是否正确",
                    DomainException.getInstance().formatException(e));
        } else {
            return ServiceResp.getInstance().error(
                    "系统繁忙,请稍后再试",
                    DomainException.getInstance().formatException(e));
        }
    }
}