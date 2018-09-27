package wx.realware.wx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Arrays;

public class CheckForWX {

	public static final String tooken = "joe_hqq168"; // 开发者自行定义Tooken
	public static final String grant_type = "client_credential";
	public static final String appid = "wx6b746c1803305e6e";//測試公眾號
	public static final String appsecret = "2e6af3013a63dba54b34a29b593a0f13";//第三方用户唯一凭证密钥，即appsecret
	public static String Access_token = "";

	/**
	 * 
返回码	说明
-1	系统繁忙，此时请开发者稍候再试
0	请求成功https请求方式: GET
https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
40001	AppSecret错误或者AppSecret不属于这个公众号，请开发者确认AppSecret的正确性
40002	请确保grant_type字段值为client_credential
40164	调用接口的IP地址不在白名单中，请在接口IP白名单中进行设置。（小程序及小游戏调用不要求IP地址在白名单内。）
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static String falshAccess_token() throws IOException, Exception
	{
		String url = "https://api.weixin.qq.com/cgi-bin/token?"
				+ "grant_type=client_credential&appid="+CheckForWX.appid+"&secret="+CheckForWX.appsecret;
		return reqestWXInterface(url);
        //10__g0s1AgoAKMzKcMI7ySHbZMxSRNsYbVMWjoHWFOdTSXw7ir_MZrFSUAs7nthe9ShZJhzbFY8CpYdFqfuqSVVnYFNWr4Z65OwDol5TvlGR5CEvnOtVnUM3_LInUsu9vXYgwv44GhANIc2qcvmSULdADAYAR
	}
	
	
	
	public static String reqestWXInterface(String url) throws Exception
	{
		URL localURL = new URL(url);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        
        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        }
        
        try {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            
        } finally {
            
            if (reader != null) {
                reader.close();
            }
            
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            
            if (inputStream != null) {
                inputStream.close();
            }
            
        }
        System.err.println(resultBuffer.toString());
        return resultBuffer.toString();
	}
	
	
	public static boolean checkSignature(String signature, 
			String timestamp, String nonce) {

		// 1.定义数组存放tooken，timestamp,nonce

		String[] arr = { tooken, timestamp, nonce };

		// 2.对数组进行排序
		Arrays.sort(arr);
		// 3.生成字符串
		StringBuffer sb = new StringBuffer();
		for (String s : arr) {
			sb.append(s);
		}
		String temp = getSha1(sb.toString());
		// 5.将加密后的字符串，与微信传来的加密签名比较，返回结果
		return temp.equals(signature);

	}

	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static void main(String args[])
	{
		try {
			CheckForWX.Access_token = falshAccess_token();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
