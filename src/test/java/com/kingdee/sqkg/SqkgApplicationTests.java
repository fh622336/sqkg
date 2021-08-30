package com.kingdee.sqkg;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.sqkg.domain.entity.CtBdBebankinfolog;
import com.kingdee.sqkg.mapper.CtBdBebankinfologMapper;
import com.kingdee.sqkg.util.HttpUtil;
import com.kingdee.sqkg.util.Xml2JsonUtil;
import com.kingdee.sqkg.util.easUtil;
import com.kingdee.sqkg.util.esbMdmUtil;
import lombok.SneakyThrows;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jdom.input.SAXBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;


@SpringBootTest
class SqkgApplicationTests {
    @Test
    void contextLoads() {
    }
}
