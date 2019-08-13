package dynamicproxyservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
@MyService(value="CardInfo")
public class CardInfoServiceImpl implements CardInfoService{
	
	private static Logger logger = LoggerFactory.getLogger(CardInfoServiceImpl.class);
	@Override
	public String openaccount(JSONObject params) {
		logger.info("openaccount:{}",Thread.currentThread());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transferaccount(JSONObject params) {
		// TODO Auto-generated method stub
		logger.info("transferaccount:{}",Thread.currentThread());
		return null;
	}
	

	@Override
	public String showbalence(JSONObject params) {
		logger.info("showbalence:{}",Thread.currentThread());
		// TODO Auto-generated method stub
		return "balance:100000000000000000";
	}

	@Override
	public String login(JSONObject params) {
		logger.info("login:{}",Thread.currentThread());
		return "login";
	}

}
