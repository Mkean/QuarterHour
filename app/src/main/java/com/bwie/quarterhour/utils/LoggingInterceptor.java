package com.bwie.quarterhour.utils;

import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：王庆
 * 时间：2018/1/19
 */

public class LoggingInterceptor implements Interceptor {
    private static final String UA = "User-Agent";

    //拦截的方法
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取到请求
        Request request = chain.request();
        //获取请求的方式
        String method = request.method();
        //获取请求的路径
        String oldUrl = request.url().toString();

        Log.e("---拦截器", request.url() + "---" + request.method() + "--" + request.header("User-agent"));

        //要添加的公共参数...map
        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");

        if ("GET".equals(method)) {
            // 1.http://www.baoidu.com/login                --------？ key=value&key=value
            // 2.http://www.baoidu.com/login?               --------- key=value&key=value
            // 3.http://www.baoidu.com/login?mobile=11111    -----&key=value&key=value

            StringBuilder stringBuilder = new StringBuilder();//创建一个stringBuilder

            stringBuilder.append(oldUrl);

            if (oldUrl.contains("?")) {
                //?在最后面....2类型
                if (oldUrl.indexOf("?") == oldUrl.length() - 1) {

                } else {
                    //3类型...拼接上&
                    stringBuilder.append("&");
                }
            } else {
                //不包含? 属于1类型,,,先拼接上?号
                stringBuilder.append("?");
            }
            //添加公共参数....
            for (Map.Entry<String, String> entry : map.entrySet()) {
                //拼接
                stringBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }



            //删掉最后一个&符号
            if (stringBuilder.indexOf("&") != -1) {
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("&"));
            }

            String newUrl = stringBuilder.toString();//新的路径

            //拿着新的路径重新构建请求
            request = request.newBuilder()
                    .url(newUrl)
                    .build();


        } else if ("POST".equals(method)) {
            //先获取到老的请求的实体内容
            RequestBody oldRequestBody = request.body();//....之前的请求参数,,,需要放到新的请求实体内容中去

            //如果请求调用的是上面doPost方法
            if (oldRequestBody instanceof FormBody) {
                FormBody oldBody = (FormBody) oldRequestBody;

                //构建一个新的请求实体内容
                FormBody.Builder builder = new FormBody.Builder();
                //1.添加老的参数
                for (int i = 0; i < oldBody.size(); i++) {
                    builder.add(oldBody.name(i), oldBody.value(i));
                }
                //2.添加公共参数
                for (Map.Entry<String, String> entry : map.entrySet()) {

                    builder.add(entry.getKey(), entry.getValue());
                }

                FormBody newBody = builder.build();//新的请求实体内容

                //构建一个新的请求
                request = request.newBuilder()
                        .url(oldUrl)
                        .post(newBody)
                        .build();
            }
        }
        Log.e("拦截器----", request.url() + "---" + request.method() + "--" + request.header("User-agent"));
        Response response = chain.proceed(request);

        return response;
    }

    private String makeUA() {
        String s = Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
        return Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
    }
}
