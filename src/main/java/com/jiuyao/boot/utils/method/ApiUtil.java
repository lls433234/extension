package com.jiuyao.boot.utils.method;

import com.alibaba.fastjson.JSONObject;
import com.masget.api.security.AesEncryption;
import com.masget.api.security.HttpsUtil;
import com.masget.api.security.MD5Util;
import com.masget.api.security.TimeUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiUtil {
	private static final String FORMAT = "json";
	private static final String VERSION = "2.0";

	public static String methodInvoke(String openApiUrl, String appid,
			String session, String secretkey, String method, String data) {
		String result = "";
		try {
			String encryptdata = AesEncryption.Encrypt(data, secretkey,
					secretkey);
			String timestamp = TimeUtil.getTime();
			String signstr = MD5Util.string2MD5(secretkey + appid
					+ encryptdata + FORMAT + method + session + timestamp
					+ VERSION + secretkey);
			JSONObject requestObj = new JSONObject();
			requestObj.put("appid", appid);
			requestObj.put("method", method);
			requestObj.put("session", session);
			requestObj.put("format", FORMAT);
			requestObj.put("data", encryptdata);
			requestObj.put("v", VERSION);
			requestObj.put("timestamp", timestamp);
			requestObj.put("sign", signstr);
			log.info("请求内容==============，{}",requestObj.toJSONString());
			result = HttpsUtil.doSslPost(openApiUrl,
					requestObj.toJSONString(), "utf-8");
		} catch (Exception ex) {
			ex.printStackTrace();
			result = ex.getMessage();
		}
		return result;
	}

	public static String methodInvoke(String openApiUrl, String appid,
			String session, String secretkey, String method, String data,
			int redirectflag) {
		String result = "";
		try {
			String encryptdata = AesEncryption.Encrypt(data, secretkey,
					secretkey);
			String timestamp = TimeUtil.getTime();
			String signstr = MD5Util.string2MD5(secretkey + appid
					+ encryptdata + FORMAT + method + session + timestamp
					+ VERSION + secretkey);
			String getdata = "appid=" + appid + "&method=" + method
					+ "&session=" + session + "&format=" + FORMAT
					+ "&data=" + encryptdata + "&v=" + VERSION + "&timestamp="
					+ timestamp + "&sign=" + signstr + "&redirectflag="
					+ redirectflag;
			return openApiUrl + "?" + getdata;
		} catch (Exception ex) {
			ex.printStackTrace();
			result = ex.getMessage();
		}
		return result;
	}
}
