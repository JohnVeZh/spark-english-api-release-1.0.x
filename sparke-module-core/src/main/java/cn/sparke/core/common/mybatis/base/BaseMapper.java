package cn.sparke.core.common.mybatis.base;

import com.github.pagehelper.Page;

/**
 * Created by zhangbowen on 2017/5/4.
 */
public interface BaseMapper<T> {
    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T getById(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    T get(T entity);

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    <R,P> Page<R> findList(P entity);

    /**
     * 查询列表总数
     *
     * @param entity
     * @return
     */
    int findTotal(T entity);
}
