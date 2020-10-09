package cn.zhu4wp.myweb.controller.rest;

import cn.zhu4wp.myweb.model.*;
import cn.zhu4wp.myweb.service.*;
import cn.zhu4wp.myweb.util.file.FilesUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static cn.zhu4wp.myweb.util.session.SessionUtil.getRequest;
import static cn.zhu4wp.myweb.util.session.SessionUtil.getSession;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

/**
 * @Author zhu4wp
 * @Date 2020/2/3
 * @Description TODO
 * @Version 1.0
 */
@RestController
public class EssayRestController {
    @Autowired
    private EssayService essayService;
    @Autowired
    private FolderService folderService;
    @Autowired
    private FolderEssayService folderEssayService;
    @Autowired
    private ImageService imageService;
    private List<Image> images = new LinkedList<>();
    @Autowired
    private CommentService commentService;
    @Value("${spring.servlet.multipart.location}")
    private String pathPre;

    @PostMapping(value = "/essay")
    public Map<String, Object> saveEssay(@RequestParam(value = "text") String text,
                                         @RequestParam(value = "title") String title,
                                         @RequestParam(value = "folder") String folderName) throws Exception {
        Map map = new HashMap<String, Object>();
        //创建文件夹
        Folder folder = new Folder();
        folder.setFolderName(folderName);

        folderService.add(folder);

        //添加文件
        Essay essay = new Essay();
        essay.setFolder(folderName);
        essay.setTime(new Date());
        essay.setEssayAuthorId(1);
        essay.setEssayName(title);
        essay.setEssayContent(text);

        essayService.add(essay);


        //FolderEssay 中间表添加数据
        FolderEssay folderEssay = new FolderEssay();
        folderEssay.setEssayName(title);
        folderEssay.setFolderName(folderName);
        folderEssayService.add(folderEssay);

        map.put("data", "成功");
        return map;
    }

    @DeleteMapping(value = "essay")
    public String deleteEssay(@RequestParam(value = "essayName") String essayName) throws Exception {
//        List<Image> images = imageService.selectAllByEssayName(essayName);
//
//
//        essayService.deleteEssayByEssayName(essayName);
        return "hello world";
    }

    @GetMapping(value = "/essay")
    public Essay findEssayByEssayName(@RequestParam(value = "essayName", required = true) String essayName) throws
            Exception {
        return essayService.selectEssayByEssayName(essayName);
    }

    @GetMapping(value = "/essays")
    public List<Essay> ShowAllEssays(@RequestParam(value = "page") Integer page) throws Exception {
        Page<Essay> essays = essayService.selectAll(page, 0);
        return essays.getContent();
    }

    @PostMapping("/upload")
    public Map<String, Object> uploadImage
            (@RequestParam(value = "editormd-image-file", required = false) MultipartFile file,@RequestParam(value = "essayName")String essayName) throws Exception {

        Map<String, Object> result = new HashMap<>();
        Path path = Paths.get(this.pathPre+essayName);
        if (Files.notExists(path) || !Files.isDirectory(path)){
            Files.createDirectory(path);
        }
        String fileName = System.currentTimeMillis() + Thread.currentThread().getId()+file.getOriginalFilename();
        String absolutePath = path +"/"+ fileName;
        String url1 = essayName+"/"+fileName;
        try (OutputStream out = new FileOutputStream(absolutePath)) {
            out.write(file.getBytes());
            result.put("success", 1);
            result.put("message", "成功");
            result.put("url", url1);
        } catch (FileNotFoundException e) {
            result.put("success", 0);
            result.put("message", "失败");
            result.put("url", "");
            e.printStackTrace();
        } catch (IOException e) {
            result.put("success", 0);
            result.put("message", "失败");
            result.put("url", "");
            e.printStackTrace();
        }
        return result;
    }
}
