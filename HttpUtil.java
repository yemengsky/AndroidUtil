import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
/**
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-1-16 下午3:03:30 <br/>
 *
 * @author YeMeng
 */
public class HttpUtil {
    private static AsyncHttpClient client = new AsyncHttpClient(); // 实例话对象
    static {
        client.setEnableRedirects(true);
        client.setTimeout(60000); // 设置链接超时，如果不设置，默认为10s
        if (!SpUtil.getStringSharedPerference("authorization", "").equals("")) {
            setAuthHeader();
        }
    }
    public static void get(String urlString, AsyncHttpResponseHandler res) // 用一个完整url获取一个string对象
    {
        ELog.e(urlString);
        client.get(urlString, res);
    }
    public static void get(String urlString, RequestParams params,
                           AsyncHttpResponseHandler res) // url里面带参数
    {
        ELog.e(urlString);
        client.get(urlString, params, res);
    }
    public static void get(String urlString, JsonHttpResponseHandler res) // 不带参数，获取json对象或者数组
    {
        ELog.e(urlString);
        client.get(urlString, res);
    }
    public static void get(String urlString, RequestParams params,
                           JsonHttpResponseHandler res) // 带参数，获取json对象或者数组
    {
        ELog.e(urlString);
        client.get(urlString, params, res);
    }
    public static void get(String uString, BinaryHttpResponseHandler bHandler) // 下载数据使用，会返回byte数据
    {
        ELog.e(uString);
        client.get(uString, bHandler);
    }
    public static void post(String urlString, AsyncHttpResponseHandler res) // 用一个完整url获取一个string对象
    {
        ELog.e(urlString);
        client.post(urlString, res);
    }
    public static void post(String urlString, RequestParams params,
                            AsyncHttpResponseHandler res) // url里面带参数
    {
        ELog.e(urlString);
        params.setContentEncoding("utf-8");
        client.post(urlString, params, res);
    }
    public static void post(String urlString, JsonHttpResponseHandler res) // 不带参数，获取json对象或者数组
    {
        ELog.e(urlString);
        client.post(urlString, res);
    }
    public static void post(String urlString, RequestParams params,
                            JsonHttpResponseHandler res) // 带参数，获取json对象或者数组
    {
        ELog.e(urlString);
        client.post(urlString, params, res);
    }
    public static void post(String uString, BinaryHttpResponseHandler bHandler) // 下载数据使用，会返回byte数据
    {
        ELog.e(uString);
        client.post(uString, bHandler);
    }
    public static void put(String urlString, AsyncHttpResponseHandler res) // 用一个完整url获取一个string对象
    {
        ELog.e(urlString);
        client.put(urlString, res);
    }
    public static void put(String urlString, RequestParams params,
                           AsyncHttpResponseHandler res) // url里面带参数
    {
        ELog.e(urlString);
        client.put(urlString, params, res);
    }
    public static void put(String urlString, JsonHttpResponseHandler res) // 不带参数，获取json对象或者数组
    {
        ELog.e(urlString);
        client.put(urlString, res);
    }
    public static void put(String urlString, RequestParams params,
                           JsonHttpResponseHandler res) // 带参数，获取json对象或者数组
    {
        ELog.e(urlString);
        client.put(urlString, params, res);
    }
    public static void put(String uString, BinaryHttpResponseHandler bHandler) // 下载数据使用，会返回byte数据
    {
        ELog.e(uString);
        client.put(uString, bHandler);
    }
    public static void delete(String urlString, AsyncHttpResponseHandler res) // 用一个完整url获取一个string对象
    {
        ELog.e(urlString);
        client.delete(urlString, res);
    }
    // public static void delete(String urlString, RequestParams params,
    // AsyncHttpResponseHandler res) // url里面带参数
    // {
    // client.delete(urlString, params, res);
    // }
    public static void delete(String urlString, JsonHttpResponseHandler res) // 不带参数，获取json对象或者数组
    {
        ELog.e(urlString);
        client.delete(urlString, res);
    }
    // public static void delete(String urlString, RequestParams params,
    // JsonHttpResponseHandler res) // 带参数，获取json对象或者数组
    // {
    // client.delete(urlString, params, res);
    // }
    public static void delete(String uString, BinaryHttpResponseHandler bHandler) // 下载数据使用，会返回byte数据
    {
        ELog.e(uString);
        client.delete(uString, bHandler);
    }
    public static AsyncHttpClient getClient() {
        return client;
    }
    public static AsyncHttpClient setAuthHeader() {
        client.removeHeader("Authorization");
        client.addHeader(
                "Authorization", SpUtil.getStringSharedPerference("authorization", ""));
        return client;
    }
}
