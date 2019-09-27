import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TestEntity {

    @JSONField(name = "TestField",format = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime testField;

    public static void main(String[] args) {
        //失败    09/11/2019 13:08:53
        //成功    09/13/2019 13:08:53
        String jsonString = "{" +
                            "\"TestField\":\"09/11/2019 13:08:53\"" +
                            "}";
        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println(jsonObject);
        TestEntity testEntity = jsonObject.toJavaObject(TestEntity.class);
        System.out.println(testEntity);
    }
}
