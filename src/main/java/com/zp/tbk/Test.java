package com.zp.tbk;


import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: zhengpeng
 * @Date: 2019/4/7 12:16
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String url = "https://m.tb.cn/h.eZ2e3Sw?sm=a3da5f";
//        String url ="https://a.m.taobao.com/i577536759382.htm?price=77&sourceType=item&sourceType=item&suid=694fd554-35ec-4293-917e-c68e595a7978&ut_sk=1.XDmNJaeA7TYDAH%2FNPyFPVoUN_21646297_1554609249016.Copy.1&un=28956b9d7bd081ae762ef2865d2eb66f&share_crt_v=1&sp_tk=77+lRkJZdWJ6SWxDUk/vv6U=&cpp=1&shareurl=true&spm=a313p.22.1xn.1024034459898&short_name=h.eZUN6aU";
        System.out.println(getUrl(url, 1));
    }

    static String getUrl(String url, int count) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet(url);
        try {
            httpClient.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
            //将HttpContext对象作为参数传给execute()方法,则HttpClient会把请求响应交互过程中的状态信息存储在HttpContext中
            HttpResponse response = httpClient.execute(httpGet, httpContext);
            //获取重定向之后的主机地址信息,即"http://127.0.0.1:8088"
            HttpHost targetHost = (HttpHost) httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
            //获取实际的请求对象的URI,即重定向之后的"/blog/admin/login.jsp"
            HttpUriRequest realRequest = (HttpUriRequest) httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
//            System.out.println("URL:" + targetHost + realRequest.getURI());
            if (count == 2) {
                return (targetHost + realRequest.getURI().toString());
            }
            HttpEntity entity = response.getEntity();
            System.out.println(response.getStatusLine());
            if (null != entity) {
                String entityString = EntityUtils.toString(entity, ContentType.getOrDefault(entity).getCharset());
                Pattern pattern = Pattern.compile("'.*'");
                Matcher matcher = pattern.matcher(entityString);
                if (matcher.find()) {
                    String collegeId = matcher.group(0);
                    return getUrl(collegeId.substring(1, collegeId.length() - 1), 2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return null;
    }
}
