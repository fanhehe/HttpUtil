package com.fanhehe.util;

import org.junit.Test;
import org.junit.Assert;

import java.util.Map;
import java.util.HashMap;
import com.fanhehe.httputil.http.HttpUtil;
import com.fanhehe.httputil.result.IResult;
import com.fanhehe.httputil.result.InvokeResult;

public class ApplicationTest {

    @Test
    public void evaluatesExpression2() {
    	ApiService service = new ApiService();

        IResult<Data> result = service.getIp();

    	if (result != null && result.isSuccess() && result.getData() != null) {
    		System.out.println(result.getData().toString());
    	} else {
    		System.out.println("=============================");
    	}
    }
}

class Data {}

class ApiService extends HttpUtil<Data> {
	public String getEndpoint() {
		return "api.map.baidu.com";
	}

	IResult<Data> getIp() {

        Map<String, String> params = new HashMap<>();

        params.put("output", "json");
        params.put("location", "嘉兴");
        params.put("ak", "5slgyqGDENN7Sy7pw29IUvrZ");

        return this.get("/telematics/v3/weather", params);
    }
}
