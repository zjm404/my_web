package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Folder;

import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-5
 * @Description TODO
 * @Version 1.0
 */
public interface FolderService {
    /**
     * 增加
     * @param folder
     * @return
     */
    public Folder add(Folder folder) throws Exception;

    /**
     * 删除
     * @param folderName
     */
    public void deleteByFolderName(String folderName) throws Exception;

    /**
     * 查询所有
     * @return
     */
    public List<Folder> selectAll();
}
