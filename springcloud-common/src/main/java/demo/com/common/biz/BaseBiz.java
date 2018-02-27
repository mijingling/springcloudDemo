package demo.com.common.biz;

import org.springframework.beans.factory.annotation.Autowired;

import demo.com.common.util.EntityUtils;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public abstract class BaseBiz<M extends Mapper<T>, T> {
    @Autowired
    protected M mapper;
    public void setMapper(M mapper){
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }


    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


//    public List<T> selectListByIds(List<Object> ids) {
//        return mapper.selectByIds(ids);
//    }


    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }


    public List<T> selectListAll() {
        return mapper.selectAll();
    }


//    public Long selectCountAll() {
//        return mapper.selectCount(null);
//    }


    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }


    public void insert(T entity) {
        EntityUtils.setCreateInfo(entity);
        mapper.insert(entity);
    }


    public void insertSelective(T entity) {
        EntityUtils.setCreateInfo(entity);
        mapper.insertSelective(entity);
    }


    public void delete(T entity) {
        mapper.delete(entity);
    }


    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }


    public void updateById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKey(entity);
    }


    public void updateSelectiveById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKeySelective(entity);

    }
    public  List<T> selectByExample(Object example){
        return mapper.selectByExample(example);
    }
    public int selectCountByExample(Object example){
        return mapper.selectCountByExample(example);
    }
//    public void deleteBatchByIds(List<Object> ids) {
//        mapper.batchDeleteByIds(ids);
//    }


//    public void updateBatch(List<T> entitys) {
//        mapper.batchUpdate(entitys);
//    }

}
