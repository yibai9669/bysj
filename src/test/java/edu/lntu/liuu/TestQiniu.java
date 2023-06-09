package edu.lntu.liuu;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
/**
 * @author LiuHaiyang
 * @date 2023-03-13 22:46
 * Life Goes On
 */
public class TestQiniu {
    public static void main(String[] args) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Zone.zone1());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "DzUm8Lm0P8o53rX0BA0bMrtVR8X2G-lSqfi8Oqts";
        String secretKey = "W8W_LAA5rOGPVdAc-vl2cSfEweU_VTLC_7RK3426";
        String bucket = "music1717";//空间名

        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "C:\\Users\\24364\\Pictures\\0fbb6ec5d168d24b5501425a204add96.jpeg";

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //存储空间的文件名
        String key = null;

        //身份认证
        Auth auth = Auth.create(accessKey, secretKey);
        //指定覆盖上传
        String upToken = auth.uploadToken(bucket,key);
        try {
            //上传
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //结果
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

    }
}
