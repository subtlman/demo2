package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.atools.log.aspect.Log;
import com.example.demo.atools.resp.MyHandlerExceptionResolver;
import com.example.demo.atools.resp.ServiceResp;
//import com.sun.istack.internal.logging.Logger;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/07/02/11:29
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class Chat {
//    private static int LONG_BITS;
//    private static final Logger logger = Logger.getLogger(Chat.class);

    /**
     * 小妲己聊天api接口
     * @CrossOrigin 解决跨域访问
     * @return
     */
    @GetMapping("/api/{value}")
    @CrossOrigin
    public Object getChatPrint(@PathVariable String value){
        try {
            URL url = new URL("http://api.weijieyue.cn/api/xiaoai/api.php?msg="+value);
            String o = outputWord(url.openConnection().getInputStream()).toString();
            return JSON.parseObject(o).getString("text");
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static Object outputWord(InputStream inputStream){
        try {
            String result = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while(null != (line = br.readLine())){
                result += line;
            }
            br.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/api/demo")
    @Log
    public ServiceResp demo() {
        ServiceResp resp = new ServiceResp();
        resp.success(" 样例");
        return resp;
    }

    @GetMapping("/api/demo2")
    @Log
    public ServiceResp demo2(@RequestParam String param) {
        ServiceResp resp = new ServiceResp();
        resp.success(" 样例2");
        int i=1/0;
        return resp;
    }

    @GetMapping("/api/demo3")
    @Log
    public ServiceResp demo3(@RequestParam String param) {
        ServiceResp resp = new ServiceResp();
        resp.success(" 样例3");
        try {
            int i=1/0;
        } catch (Exception e) {
            return MyHandlerExceptionResolver.formatException(e);
        }
        return resp;
    }

    @GetMapping("/api/demo4")
    public ServiceResp getChatPrint2() {

        ServiceResp resp = new ServiceResp();
        resp.success(" chengg");
        try {
//            int i1 = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e.getBindingResult().getFieldError().getDefaultMessage());
//            return MyHandlerExceptionResolver.formatException(e);
        }finally {
//            System.out.println("1");
        }
        return resp;
    }

    @GetMapping("/api/demo5")
    public ServiceResp getChatPrint3() {

        ServiceResp resp = new ServiceResp();
        resp.success(" chengg");

            int i1 = 1 / 0;

        return resp;
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexString
     * @return
     */
    private static int LONG_BITS = 4;

    public static String convert(String numHex) {
        LONG_BITS = LONG_BITS*numHex.length();
        // String a HexaDecimal:
        int conHex = Integer.valueOf(numHex, 16);
        // Hex a Binary:
        String binary = Integer.toBinaryString(conHex);
        // Output:
        return completeDigits(binary);
    }

    public static String hexString2binaryString(String hexString) {
        String s = new BigInteger(hexString, 16).toString(2);
        boolean a = s.length() % 2 == 1;
        if (a){
            return "0"+new BigInteger(hexString, 16).toString(2);
        }
        return new BigInteger(hexString, 16).toString(2);

    }

    public static String completeDigits(String binNum) {
        for (int i = binNum.length(); i < LONG_BITS; i++) {
            binNum = "0" + binNum;
        }
        return binNum;
    }

    public static void swap(String[] arr,int i, int j) {
        String t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

//        while (true){
//            Scanner sc = new Scanner(System.in);
//            System.out.println("请输入：");
//            String name = sc.next();
//            try {
//                URL url = new URL("https://api.vvhan.com/api/en?type=sj");
//                String o = outputWord(url.openConnection().getInputStream()).toString();
//                System.out.println(o);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//
//
//        }

        String s=hexString2binaryString("666666666666666666666666");
        String[] array = new String[48];
        String s1;
        for (int i = 0; i<s.length()/4; i++) {
            s1 = s.substring(4 * i, 4 * i + 4);
            array[2*i] = s1.substring(2, 4);
            array[2*i+1] = s1.substring(0, 2);
        }
        System.out.println(Arrays.toString(array));

//        swap(array, 0, 1);
//        System.out.println(Arrays.toString(array));
//        System.out.println();
//        System.out.println(Math.random());
//        final Runnable random = Math::random;
//        System.out.println(random.toString());
//        final BiPredicate<String, CharSequence> contains = String::contains;
//        System.out.println(contains.test("你", new CharSequence() {
//            @Override
//            public int length() {
//                return 0;
//            }
//
//            @Override
//            public char charAt(int index) {
//                return 0;
//            }
//
//            @Override
//            public CharSequence subSequence(int start, int end) {
//                return null;
//            }
//        }));
//        int i1 =1/0;
//        try {
//            int i =1/0;
//        } catch (Exception e) {
////            logger.info("qww"+e);
//            e.printStackTrace();
//        }

//        try {
////            Runtime.getRuntime().exec("explorer http://www.baidu.com");
//            Runtime.getRuntime().exec("ping baidu.com");
//
////            java.net.URI uri = new java.net.URI("http://www.baidu.com?w=a&c=d");
////            java.awt.Desktop.getDesktop().browse(uri);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Chat chat = new Chat();
//        boolean a = true;
//        int b = 1;
//        while (a){
//
//            Scanner input = new Scanner(System.in);
//            System.out.println("第"+ b++ +"次对话");
//            System.out.print("某人：");
//            String ss = input.next();
//            if (ss.equals("exit")){
//                while (a){
//                    System.out.println("你是否退出（Y/N）");
//                    String next = new Scanner(System.in).next();
//                    if (next.equals("Y")){
//                        a=false;
//                    }else if (next.equals("N")){
//                        break;
//                    }
//                }
//            }else {
//                String s = new String(chat.getChatPrint(ss).toString().getBytes());
//                System.out.println("机器："+ s);
//            }
//        }
    }
}
