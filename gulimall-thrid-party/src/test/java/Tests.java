import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest(classes = Tests.class)
public class Tests {
    static {

    }

   // @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint="oss-cn-chengdu.aliyuncs.com";
    //@Value("${spring.cloud.alicloud.oss.sts.access-key}")
    private String accessKeyId="LTAI4G1gU2eHjLGu3WpgsUbU";

    //@Value("${spring.cloud.alicloud.oss.sts.secret-key}")
    private String accessKeySecret="CwR1x39fEP3pwCMXmDis48YiuByNSa";


    @Test
    public void test() throws FileNotFoundException {


// 创建OSSClient实例。
            OSS oss = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream=new FileInputStream("C:\\Users\\李庆\\Pictures\\Saved Pictures\\k1.jpg");
      oss.putObject("gulimall-shoping","1.jpg",inputStream);
      oss.shutdown();
        System.out.println("上传完成。。");
    }
}
