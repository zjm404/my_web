package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.FolderEssay;

import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-5
 * @Description TODO
 * @Version 1.0
 */
public interface FolderEssayService {
    /**
     * 增加
     * @param folderEssay
     * @return
     */
    public FolderEssay add(FolderEssay folderEssay) throws Exception;

    /**
     * 查询
     * @param folderName
     * @return
     */
    public List<FolderEssay> selectAllByFolderName(String folderName);

    public List<FolderEssay> selectAll();

    public FolderEssay selectAllByEssayNameAndFolderName(String essayName,String folderName);

}
