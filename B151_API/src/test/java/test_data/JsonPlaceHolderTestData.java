package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String,Object> expectedDataMapper(Integer userId,String title,Boolean completed){
        Map<String,Object> expectedData = new HashMap<>();
        if(userId!=null){
            expectedData.put("userId",userId);
        };
        if(title!=null){
            expectedData.put("title",title);
        };
        if(completed!=null){
            expectedData.put("completed",completed);
        };
        return expectedData;
    }
}

//Parametrelerin null gelme ihtimaline karsi if li ifadeleri olusturduk. Patch islemi icin
//Pojo class taki variable lara ulasimi kisitlamak icin private yaptik.(Encapsulation)
//get islemi ile assertion yaptik.