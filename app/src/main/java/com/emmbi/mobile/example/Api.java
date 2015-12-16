package com.emmbi.mobile.example;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class Api {

	public static final String TAG = "Surve";

	public static final String BASE_URL = "http://someUrl.com";
	protected static final String PROTOCOL_CHARSET = "application/json; charset=utf-8";
	protected static final String MULTIPART_PROTOCOL_CHARSET = "multipart/form-data; charset=utf-8";
	protected static final String URL_ENCODE_PROTOCOL_CHARSET = "utf-8";

	protected static final String PARSE_APPLICATION_ID = "TODO";
	protected static final String PARSE_CLIENT_ID = "TODO";
	protected static final String PARSE_API_KEY = "TODO";

	private static Api instance = null;
	private Api() { }
	public static synchronized Api getInstance(Context c) {
		if (instance == null) {
			instance = new Api();
		}
		return instance;
	}

	private Map<String, String> getDefaultHeaders() {

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", PROTOCOL_CHARSET);
		headers.put("X-Parse-Session-Token", PARSE_CLIENT_ID);
		headers.put("X-Parse-Application-Id", PARSE_APPLICATION_ID);
		headers.put("X-Parse-REST-API-Key", PARSE_API_KEY);

		return headers;
	}

}
