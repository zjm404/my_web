package cn.zhu4wp.myweb.util.paging;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @Author zjm
 * @Date 2020/3/5
 * @Description TODO
 * @Version 1.0
 */
public class GetPageable {
    public static Pageable getPageableByPageAndSize(Integer page,Integer size){
        if (page < 0 || page == null){
            page = 0;
        }
        if(size < 1 || size == null){
            size = 6;
        }
        Pageable pageable = PageRequest.of(page,size);
        return pageable;
    }
}
