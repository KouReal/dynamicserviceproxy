package dynamicproxyservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest

public class testproxyservice {
	Logger log = LoggerFactory.getLogger(testproxyservice.class);
	
	@Autowired
	private ServiceProxy sp;
	
	@Test
	public void testmultithread(){
		Thread[] ts = new Thread[4];
		String[] namearray = {"Customer","CardInfo"};
		String[] methodarray = {"showpersonalinfo","showbalence"};
		Thread temp = null;
		for(int i=0;i<4;++i){
			int j=i;
			int index = (i+1)%2==0 ? 0 : 1;
			int index2 = (i+1)%2==0 ? 1 : 0;
			temp = new Thread(new Runnable() {
				@Override
				public void run() {
					JSONObject jso = new JSONObject();
			    	jso.put("name", "mike"+j); 	 
			    	jso.put("tokenid", "1234567");
			    	try {
						sp.callservice(namearray[index], "login",jso );
						sp.callservice(namearray[index], methodarray[index],jso );
						sp.callservice(namearray[index2], methodarray[index2],jso );
					} catch (RpcErrorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			ts[i]=temp;
		}
		
		for(int i=0;i<4;++i){
			ts[i].start();
		}
		for(int i=0;i<4;++i){
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

    @Test
    public void test1(){
    	JSONObject jso = new JSONObject();
    	jso.put("name", "mike");
    	try {
			sp.callservice("Customer", "login",jso );
		} catch (RpcErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void test2(){
    	JSONObject jso = new JSONObject();
    	jso.put("name", "mike");
    	jso.put("tokenid", "1234567");
    	try {
			String result = (String) sp.callservice("Customer", "showpersonalinfo",jso );
			System.out.println(result);
		} catch (RpcErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void test3(){
    	JSONObject jso = new JSONObject();
    	jso.put("name", "jack");
    	jso.put("tokenid", "123456");
    	try {
			String result = (String) sp.callservice("CardInfo", "showbalence",jso );
			System.out.println(result);
		} catch (RpcErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
