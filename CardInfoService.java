package dynamicproxyservice;

import com.alibaba.fastjson.JSONObject;

public interface CardInfoService {
	public String openaccount(JSONObject params);
	public String transferaccount(JSONObject params);
	@AuthToken
	public String showbalence(JSONObject params);
	public String login(JSONObject params);
}
