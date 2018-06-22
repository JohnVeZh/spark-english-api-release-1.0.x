package cn.sparke.user.modules.v1.center.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.center.bean.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public interface CenterMapper extends BaseMapper {
    /**
     * 我的评论列表
     *
     * @return
     */
    Page<MyCommentBean> myCommentList(MyCommentBean commentBean);

    /**
     * 我的图书订单列表
     *
     * @return
     */
    Page<MyOrderBean<OrderDetailBean>> orderBookList(MyOrderBean productBean);

    /**
     * 我的网课订单列表
     *
     * @return
     */
    Page<MyOrderBean<OrderDetailNetworkBean>> orderNetworkList(MyOrderBean productBean);

    /**
     * 我的网课列表
     *
     * @param networkBean
     * @return
     */
    Page<MyNetworkCourseBean> myNetworkList(MyNetworkCourseBean networkBean);

    /**
     * 我的预约网课列表
     *
     * @param networkBean
     * @return
     */
    Page<MyNetworkCourseBean> myReservedCoursesList(MyNetworkCourseBean networkBean);

    /**
     * 我的网课详情-视频列表
     *
     * @return
     */
    List<MyNetworkCourseVideoBean> getMyNetworkCourseVideosList(@Param("courseId") String courseId, @Param("userId") String userId, @Param("isHide") Integer isHide);

    /**
     * 我的优惠券列表
     *
     * @return
     */
    Page<MyCouponBean> myCouponList(MyCouponBean myCouponBean);

    /**
     * 用户资料详情
     *
     * @param userId
     * @return
     */
    UserInfo userInfo(String userId);

    /**
     * 更新用户
     *
     * @param userInfo
     * @return
     */
    void updateUser(UserInfo userInfo);

    /**
     * 获取退款状态下的网课订单
     *
     * @param myOrderBean
     * @return
     */
    List<MyOrderBean<OrderDetailNetworkBean>> orderNetworkListByRefund(MyOrderBean myOrderBean, RowBounds rowBounds);

    long orderNetworkListByRefundTotal(MyOrderBean myOrderBean);

    List<UserHotSearchBean> getHotSearchList(@Param("searchType") Integer searchType);
}
