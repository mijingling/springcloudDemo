package demo.com.gateway.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.com.common.biz.BaseBiz;
import demo.com.gateway.entity.Element;
import demo.com.gateway.mapper.ElementMapper;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-23 20:27
 */
@Service
public class ElementBiz extends BaseBiz<ElementMapper,Element> {
    public List<Element> getAuthorityElementByUserId(String userId){
       return mapper.selectAuthorityElementByUserId(userId);
    }
    public List<Element> getAuthorityElementByUserId(String userId,String menuId){
        return mapper.selectAuthorityMenuElementByUserId(userId,menuId);
    }
}
