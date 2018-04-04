package demo.com.gateway.biz;

import org.springframework.stereotype.Service;

import demo.com.common.biz.BaseBiz;
import demo.com.gateway.entity.GateLog;
import demo.com.gateway.mapper.GateLogMapper;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-07-01 14:36
 */
@Service
public class GateLogBiz extends BaseBiz<GateLogMapper,GateLog> {

    @Override
    public void insert(GateLog entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(GateLog entity) {
        mapper.insertSelective(entity);
    }
}
