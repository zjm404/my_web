package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.FolderEssay;
import cn.zhu4wp.myweb.repository.FolderEssayRepository;
import cn.zhu4wp.myweb.service.FolderEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-5
 * @Description TODO
 * @Version 1.0
 */
@Service
public class FolderEssayServiceImpl  implements FolderEssayService {
    @Autowired
    private FolderEssayRepository folderEssayRepository;
    @Transactional(rollbackOn = Exception.class)
    @Override
    public FolderEssay add(FolderEssay folderEssay) throws Exception {
        return folderEssayRepository.saveAndFlush(folderEssay);
    }

    @Override
    public List<FolderEssay> selectAll() {
        return folderEssayRepository.findAll();
    }

    @Override
    public FolderEssay selectAllByEssayNameAndFolderName(String essayName, String folderName) {

        return folderEssayRepository.findAllByEssayNameAndAndFolderName(essayName,folderName);
    }

    @Override
    public List<FolderEssay> selectAllByFolderName(String folderName) {
        return folderEssayRepository.findAllByFolderName(folderName);
    }
}
