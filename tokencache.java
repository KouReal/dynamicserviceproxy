package dynamicproxyservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class tokencache {
	private static Logger logger = LoggerFactory.getLogger(tokencache.class);
	public boolean authtoken(String tid){
		if(tid!=null&&tid.equals("123456")){
			logger.info("tokenid is ok");
			return true;
		}
		logger.info("tokenid is false");
		return false;
	}
}
