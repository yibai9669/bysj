package edu.lntu.liuu.controller;

import edu.lntu.liuu.common.FatalMessage;
import edu.lntu.liuu.common.ErrorMessage;
import edu.lntu.liuu.common.SuccessMessage;
import edu.lntu.liuu.config.QiNiuUtil;
import edu.lntu.liuu.constant.Constants;
import edu.lntu.liuu.domain.Singer;
import edu.lntu.liuu.service.impl.SingerServiceImpl;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class SingerController {

    @Autowired
    private SingerServiceImpl singerService;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/singerPic/**")
                    .addResourceLocations(Constants.SINGER_PIC_PATH);
        }
    }

    // 添加歌手
    @ResponseBody
    @RequestMapping(value = "/singer/add", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest req) {
        String name = req.getParameter("name").trim();
        String sex = req.getParameter("sex").trim();
        String birth = req.getParameter("birth").trim();
        String location = req.getParameter("location").trim();
        String introduction = req.getParameter("introduction").trim();
        String pic = "/img/avatorImages/user.jpg";
        Singer singer = new Singer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        singer.setPic(pic);

        boolean res = singerService.addSinger(singer);
        if (res) {
            return new SuccessMessage<Null>("添加成功").getMessage();
        } else {
            return new ErrorMessage("添加失败").getMessage();
        }
    }

    // 删除歌手
    @RequestMapping(value = "/singer/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest req) {
        String id = req.getParameter("id");

        boolean res = singerService.deleteSinger(Integer.parseInt(id));
        if (res) {
            return new SuccessMessage<Null>("删除成功").getMessage();
        } else {
            return new ErrorMessage("删除失败").getMessage();
        }
    }

    // 返回所有歌手
    @RequestMapping(value = "/singer", method = RequestMethod.GET)
    public Object allSinger() {
        return new SuccessMessage<List<Singer>>(null, singerService.allSinger()).getMessage();
    }

    // 根据歌手名查找歌手
    @RequestMapping(value = "/singer/name/detail", method = RequestMethod.GET)
    public Object singerOfName(HttpServletRequest req) {
        String name = req.getParameter("name").trim();

        return new SuccessMessage<List<Singer>>(null, singerService.singerOfName(name)).getMessage();
    }

    // 根据歌手性别查找歌手
    @RequestMapping(value = "/singer/sex/detail", method = RequestMethod.GET)
    public Object singerOfSex(HttpServletRequest req) {
        String sex = req.getParameter("sex").trim();

        return new SuccessMessage<List<Singer>>(null, singerService.singerOfSex(Integer.parseInt(sex))).getMessage();
    }

    // 更新歌手信息
    @ResponseBody
    @RequestMapping(value = "/singer/update", method = RequestMethod.POST)
    public Object updateSingerMsg(HttpServletRequest req) {
        String id = req.getParameter("id").trim();
        String name = req.getParameter("name").trim();
        String sex = req.getParameter("sex").trim();
        String birth = req.getParameter("birth").trim();
        String location = req.getParameter("location").trim();
        String introduction = req.getParameter("introduction").trim();

        Singer singer = new Singer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        singer.setId(Integer.parseInt(id));
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);

        boolean res = singerService.updateSingerMsg(singer);
        if (res) {
            return new SuccessMessage<Null>("修改成功").getMessage();
        } else {
            return new ErrorMessage("修改失败").getMessage();
        }
    }

    // 更新歌手头像
    @ResponseBody
    @RequestMapping(value = "/singer/avatar/update", method = RequestMethod.POST)
    public Object updateSingerPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id") int id) {
        String fileName = System.currentTimeMillis() + avatorFile.getOriginalFilename();
       /* String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + "singerPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }*/

       // File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String imgPath = "img/singerPic/" + fileName;
        boolean uploadResult = QiNiuUtil.uploadMultipartFile(avatorFile, imgPath, true);
        if (uploadResult){

            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(imgPath);

            boolean res = singerService.updateSingerPic(singer);

            if (res) {
                return new SuccessMessage<String>("上传成功", imgPath).getMessage();
            } else {
                return new ErrorMessage("上传失败").getMessage();
            }
        }
            return new FatalMessage("上传失败").getMessage();

    }

}
/*这篇代码是用 Java 语言编写的，它定义了一个 SingerController 类，用于处理歌手相关的请求。这个类有以下几个功能：

添加歌手：接收一个 HttpServletRequest 对象，从中获取歌手的姓名、性别、生日、地区和简介等信息，然后创建一个 Singer 对象，并调用 singerService 的 addSinger 方法将其保存到数据库中。如果成功，返回一个 SuccessMessage 对象，否则返回一个 ErrorMessage 对象。
删除歌手：接收一个 HttpServletRequest 对象，从中获取歌手的 id，然后调用 singerService 的 deleteSinger 方法将其从数据库中删除。如果成功，返回一个 SuccessMessage 对象，否则返回一个 ErrorMessage 对象。
返回所有歌手：调用 singerService 的 allSinger 方法获取所有歌手的列表，并返回一个 SuccessMessage 对象。
根据歌手名查找歌手：接收一个 HttpServletRequest 对象，从中获取歌手的 name，然后调用 singerService 的 singerOfName 方法根据姓名模糊查询匹配的歌手列表，并返回一个 SuccessMessage 对象。
根据歌手性别查找歌手：接收一个 HttpServletRequest 对象，从中获取歌手的 sex，然后调用 singerService 的 singerOfSex 方法根据性别查询匹配的歌手列表，并返回一个 SuccessMessage 对象。
更新歌手信息：接收一个 HttpServletRequest 对象，从中获取要修改的歌手的 id 和其他信息，然后创建一个 Singer 对象，并调用 singerService 的 updateSingerMsg 方法更新数据库中对应的记录。如果成功，返回一个 SuccessMessage 对象，否则返回一个 ErrorMessage 对象。
更新歌手头像：接收两个参数：avatorFile 和 id。avatorFile 是上传的文件对象，id 是要修改头像的歌手的 id。首先生成文件名和文件路径，并将文件保存到本地目录下。然后创建一个 Singer 对象，并设置其 pic 属性为图片路径。最后调用 singerService 的 updateSingerPic 方法更新数据库中对应的记录。如果成功，返回一个 SuccessMessage 对象并附上图片路径；否则根据异常情况返回不同类型的错误消息对象。
另外，在 SingerController 类上方还有一些注解和配置类：

@RestController 注解表示这是一个 RESTful 风格的控制器类。
@RequestMapping 注解表示映射请求路径和方法。
@ResponseBody 注解表示将方法返回值作为响应体发送给客户端。
@Autowired 注解表示自动注入依赖对象（singerService）。
MyPicConfig 类实现了 WebMvcConfigurer 接口，并重写了 addResourceHandlers 方法来配置静态资源映射规则。*/
/*
@ResponseBody 注解表示该方法的返回值是一个对象，会被转换为 JSON 格式的字符串并作为响应体返回给客户端1。
@RequestMapping 注解表示该方法处理的请求路径是 “/singer/avatar/update”，请求方法是 POST23。
@RequestParam 注解表示该方法接收两个请求参数，一个是名为 “file” 的文件类型参数，用于接收客户端上传的歌手头像文件，另一个是名为 “id” 的整数类型参数，用于接收客户端指定的歌手编号23。
String fileName = System.currentTimeMillis() + avatorFile.getOriginalFilename(); 这一行代码定义了一个字符串变量 fileName，用于存储上传文件的新文件名，由当前系统时间和原始文件名拼接而成。
String filePath = System.getProperty(“user.dir”) + System.getProperty(“file.separator”) + “img” + System.getProperty(“file.separator”) + “singerPic”; 这一行代码定义了一个字符串变量 filePath，用于存储上传文件的保存路径，由系统属性 user.dir（用户工作目录）和 file.separator（文件分隔符）以及固定的子目录名拼接而成。
File file1 = new File(filePath); 这一行代码创建了一个 File 对象 file1，用于表示上传文件的保存目录。
if (!file1.exists()) { file1.mkdir(); } 这两行代码判断 file1 是否存在，如果不存在则创建该目录。
File dest = new File(filePath + System.getProperty(“file.separator”) + fileName); 这一行代码创建了一个 File 对象 dest，用于表示上传文件的保存位置，由 filePath 和 fileName 拼接而成。
String imgPath = “/img/singerPic/” + fileName; 这一行代码定义了一个字符串变量 imgPath，用于存储上传文件的访问路径，由固定的子目录名和 fileName 拼接而成。
try { … } catch (IOException e) { … } 这两个代码块用于处理可能发生的输入输出异常1。
avatorFile.transferTo(dest); 这一行代码将上传文件从临时目录转移到指定的保存位置 dest1。
Singer singer = new Singer(); 这一行代码创建了一个 Singer 对象 singer，用于封装歌手信息。
singer.setId(id); singer.setPic(imgPath); 这两行代码给 singer 对象设置编号和头像属性。
boolean res = singerService.updateSingerPic(singer); 这一行代码调用 singerService 的 updateSingerPic 方法，将 singer 对象传递给该方法，并返回一个布尔值 res 表示更新操作是否成功。
if (res) { return new SuccessMessage<String>(“上传成功”, imgPath).getMessage(); } else { return new ErrorMessage(“上传失败”).getMessage(); } 这两行代码根据 res 的值返回不同的响应消息对象，如果 res 为 true，则返回一个 SuccessMessage 对象，并设置其内容为 “上传成功” 和 imgPath；如果 res 为 false，则返回一个 ErrorMessage 对象，并设置其内容为 “上传失败”。这些响应消息对象都会被转换为 JSON 格式的字符串并作为响应体返回给客户端1
* */