package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {

    public Map<String,String> bookingDateMapper(String checkin,String checkout ){
        Map<String,String> bookingDatesMap = new HashMap<>(); // ilk önce iç map oluşturulur
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);
        return bookingDatesMap;
    }

    public Map<String,Object> expectedDataMapper (String firstname, String lastname,Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates,String additionalneeds){
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates",bookingdates);
        if(additionalneeds!=null){
            expectedDataMap.put("additionalneeds",additionalneeds);
        }
        return expectedDataMap;
    }
/*    Bu method da kullanılabilir! Ama her farklı parametre kombinasyonu için yeni metod ne kadar mantıklı olur?
    public Map<String,Object> expectedDataMapper (String firstname, String lastname,Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates){
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates",bookingdates);
        return expectedDataMap;
    }
 */
}

















