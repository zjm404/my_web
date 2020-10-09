package cn.zhu4wp.myweb.util.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Author zjm
 * @Date 2020/3/19
 * @Description TODO
 * @Version 1.0
 */
public class FilesUtil {
    public static void deleteFiles(List<String> paths) throws IOException {
        for (String path : paths) {
            Files.delete(Paths.get(path));
        }
    }
}
