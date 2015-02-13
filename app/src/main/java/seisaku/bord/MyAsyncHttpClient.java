package seisaku.bord;

import android.content.Context;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import org.apache.http.Header;

public class MyAsyncHttpClient extends AsyncHttpClient{

    RequestParams params;     // 送信パラメータ
    MyAsyncHttpResponseHandler myAsyncHttpResponseHandler = new MyAsyncHttpResponseHandler();
    final String MY_URL1 = "http://j12025.sangi01.net/cake3/app/webroot/post.php";     //URL
    final String MY_URL2 = "http://j12025.sangi01.net/cake3/app/webroot/post1.php";     //URL
    final String MY_URL3 = "http://j12025.sangi01.net/cake3/app/webroot/post2.php";     //URL

    public MyAsyncHttpClient(Context context) {
        myAsyncHttpResponseHandler.setContext(context);
    }

    @Override
    public RequestHandle post(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return super.post(url, params, responseHandler);
    }

    public void setParams(String id,String str) {
        params.put(id, str);//追加
    }

    public void newRequestParams() { // パラメータの初期化
        params = new RequestParams();
    }

    public RequestHandle access1() {
        return post(MY_URL1, params, myAsyncHttpResponseHandler);
    }
    public RequestHandle access2() {
        return post(MY_URL2, params, myAsyncHttpResponseHandler);
    }
    public RequestHandle access3() {
        return post(MY_URL3, params, myAsyncHttpResponseHandler);
    }
}

class MyAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onSuccess(int state, Header[] header, byte[] response) {//通信成功

        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFinish() {

        Toast.makeText(context, "Finish", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {// 通信失敗

        Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
    }
}
