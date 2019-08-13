package dynamicproxyservice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.runner.ReactiveWebApplicationContextRunner;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@MyService(value = "Customer")
@Component
public class CustomerServiceImpl implements CustomerService {
	public static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);	
	
	@Override
	public String regist(JSONObject params){
		logger.info("registok:thread{}",Thread.currentThread());
		return "registok";
	}
	@Override
	public String login(JSONObject params){
		logger.info("loginok:thread{}",Thread.currentThread());
		return "loginok";
	}
	
	@Override
	@AuthToken
	public String showpersonalinfo(JSONObject params){
		logger.info("showok:thread{}",Thread.currentThread());
		return "showok";
	}
	
	private void updatelogintoken(Long id) {
		//
	}
}
