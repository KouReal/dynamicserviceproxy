package dynamicproxyservice;

import com.alibaba.fastjson.JSONObject;

public interface CustomerService {
	public String regist(JSONObject params);
	public String login(JSONObject params);
	@AuthToken
	public String showpersonalinfo(JSONObject params);
}
