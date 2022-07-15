package cn.tiakon.utils;

import org.junit.Assert;
import org.junit.Test;

public class PropertiesUtilTest {
    @Test
    public void getConnectionTest() {
        Assert.assertNotNull(JdbcUtil.getConnection());
    }
}
