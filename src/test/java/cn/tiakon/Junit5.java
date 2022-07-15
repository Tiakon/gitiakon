package cn.tiakon;

import cn.tiakon.entity.Diary;
import cn.tiakon.entity.User;
import cn.tiakon.service.DiaryTypeService;
import cn.tiakon.service.UserService;
import cn.tiakon.service.impl.DiaryServiceImpl;
import cn.tiakon.service.impl.DiaryTypeServiceImpl;
import cn.tiakon.service.impl.UserServiceImpl;
import cn.tiakon.utils.MD5Util;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Hoictas on 2017/8/8.
 */
public class Junit5 {

    @Test
    void testUserService() {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUserName("tk");
        user.setPassword("tk");
        try {
            User login = userService.login(user);
            System.out.println(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Test
    void testMD5Util() {
        try {
            String encoderStrByMD5 = MD5Util.getEncoderStrByMD5("123");
            System.out.println(encoderStrByMD5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDiaryService() {
        try {
            DiaryServiceImpl diaryService = new DiaryServiceImpl();
            Diary diary = diaryService.diaryShow("78");
            //List<Diary> diaryList = diaryService.diaryList(0,5);
            //int diaryCount = diaryService.diaryCount();
            //System.out.println("diaryList:" + diaryCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDiaryTypeService() {
        DiaryTypeService diaryTypeService = new DiaryTypeServiceImpl();

    }

    @Test
    public void testuserSaveService() {
        try {
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setNickName("Tiakon");
            user.setImageName("boy");
            user.setMood("生活是一种态度。");
            user.setUserId(1);
            boolean b = userService.userSave(user);
            System.out.println(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSpit() {
        String s[] = "boy.jpg".split("\\.");
        for (int i = 0; i <s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
