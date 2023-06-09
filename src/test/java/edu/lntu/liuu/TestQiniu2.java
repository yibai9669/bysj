package edu.lntu.liuu;

import edu.lntu.liuu.config.QiNiuUtil;

import java.io.UnsupportedEncodingException;

/**
 * @author LiuHaiyang
 * @date 2023-03-13 23:08
 * Life Goes On
 */
public class TestQiniu2 {
    public static void main(String[] args) {
        Boolean flag= QiNiuUtil.upload("C:\\Users\\24364\\Videos\\1.jpg","123",true);
        if(flag){
            try {
                System.out.println("获取文件访问路径:"+QiNiuUtil.fileUrl("123"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("上传失败!!");
        }
    }
}
/*第一行定义了一个名为 main 的公共静态方法，它是 Java 程序的入口点。它接受一个字符串数组作为参数，表示命令行参数。
第二行声明了一个布尔类型的变量 flag，并调用了 QiNiuUtil 类的 upload 方法，将一个本地视频文件上传到七牛云存储服务。upload 方法的第一个参数是文件路径，第二个参数是文件名，第三个参数是一个布尔值，表示是否覆盖已存在的同名文件。upload 方法返回一个布尔值，表示上传是否成功。
第三行判断 flag 的值是否为真。如果为真，表示上传成功，执行第四到第八行的代码块。如果为假，表示上传失败，执行第九行的代码。
第四行使用 try-catch 语句来处理可能抛出的异常。try 语句中的代码尝试执行正常的逻辑，catch 语句中的代码处理异常情况。
第五行使用 System 类的 out 属性的 println 方法来打印一条信息，表示获取文件访问路径。println 方法会在信息后面自动换行。
第六行调用了 QiNiuUtil 类的 fileUrl 方法，传入文件名作为参数，返回一个字符串，表示文件在七牛云存储服务上的访问地址。这个地址可能包含中文字符，所以需要使用 UnsupportedEncodingException 类来处理编码不支持的异常。
第七行捕获了 UnsupportedEncodingException 类型的异常，并将其转换为 RuntimeException 类型的异常，再抛出。RuntimeException 是一种未检查异常，不需要显式地声明或捕获。
第八行是 try-catch 语句的结束符号。
第九行是 if 语句的 else 分支，当 flag 的值为假时执行。它使用 System 类的 out 属性的 println 方法来打印一条信息，表示上传失败。*/