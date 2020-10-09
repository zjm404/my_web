package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.Folder;
import cn.zhu4wp.myweb.repository.FolderRepository;
import cn.zhu4wp.myweb.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-5
 * @Description TODO
 * @Version 1.0
 */
@Service
@Transactional
public class FolderServiceImpl implements FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Folder add(Folder folder) throws Exception{
        return folderRepository.saveAndFlush(folder);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteByFolderName(String folderName) throws Exception {
        folderRepository.deleteFolderByFolderName(folderName);
    }

    @Override
    public List<Folder> selectAll() {
        return folderRepository.findAll();
    }
}
