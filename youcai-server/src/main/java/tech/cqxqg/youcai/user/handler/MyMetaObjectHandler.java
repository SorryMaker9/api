package tech.cqxqg.youcai.user.handler;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler {

    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createdTime", LocalDateTime.now());
    }

    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updatedTime", LocalDateTime.now());
    }


}
