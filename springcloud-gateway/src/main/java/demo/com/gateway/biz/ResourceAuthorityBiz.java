package demo.com.gateway.biz;

import org.springframework.stereotype.Service;

import demo.com.common.biz.BaseBiz;
import demo.com.gateway.entity.ResourceAuthority;
import demo.com.gateway.mapper.ResourceAuthorityMapper;

/**
 * Created by Ace on 2017/6/19.
 */
@Service
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper,ResourceAuthority> {
}
