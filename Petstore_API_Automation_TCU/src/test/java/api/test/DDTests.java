package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.UserEndpoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=Dataproviders.class)
	public void testPostUser(String userID,String userName,String fname,String lname,String useremail, String pwd, String pnum) {
		
		User userpayload=new User();
		
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(pnum);
		
		
		
		
		Response response =UserEndpoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(),200);
		
		
	}

@Test(priority=2, dataProvider="UserNames", dataProviderClass=Dataproviders.class)
public void testDeleteUserByName(String userName) {
	

	
	Response response =UserEndpoints.deleteUser(userName);//uzername can't be updated

	Assert.assertEquals(response.getStatusCode(), 200);
	
	
}
}
