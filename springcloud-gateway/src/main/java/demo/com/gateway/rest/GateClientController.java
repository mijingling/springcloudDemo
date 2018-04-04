package demo.com.gateway.rest;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

import demo.com.common.msg.ObjectRestResponse;
import demo.com.common.msg.TableResultResponse;
import demo.com.common.rest.BaseController;
import demo.com.gateway.biz.GateClientBiz;
import demo.com.gateway.entity.Element;
import demo.com.gateway.entity.GateClient;
import tk.mybatis.mapper.entity.Example;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-29 15:58
 */
@Controller
@RequestMapping("client")
public class GateClientController extends BaseController<GateClientBiz,GateClient> {
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<GateClient> page(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1")int offset, String name){
        Example example = new Example(GateClient.class);
        if(StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("name", "%" + name + "%");
            example.or().andLike("code", "%" + name + "%");
        }
        int count = baseBiz.selectCountByExample(example);
        PageHelper.startPage(offset, limit);
        return new TableResultResponse<GateClient>(count,baseBiz.selectByExample(example));
    }

    @RequestMapping(value = "/{id}/lock",method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse<GateClient> updateLock(GateClient entity){
        baseBiz.updateById(entity);
        return new ObjectRestResponse<GateClient>().rel(true);
    }

    @RequestMapping(value = "/{id}/service", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifiyServices(@PathVariable int id,String services){
        baseBiz.modifyClientServices(id, services);
        return new ObjectRestResponse().rel(true);
    }

    @RequestMapping(value = "/{id}/service", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<Element>> getServices(@PathVariable int id){
        return new ObjectRestResponse<List<Element>>().rel(true).result(baseBiz.getClientServices(id));
    }


}
