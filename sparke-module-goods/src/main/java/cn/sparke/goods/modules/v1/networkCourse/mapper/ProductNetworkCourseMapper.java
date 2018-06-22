package cn.sparke.goods.modules.v1.networkCourse.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.goods.modules.v1.networkCourse.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangye on 2017/7/12.
 */
public interface ProductNetworkCourseMapper extends BaseMapper<ProductNetworkCourseBean> {

    List<ProductNetworkCourseBean> findWebList(@Param("userId") String userId, @Param("searchType") String searchType, @Param("isFree") Integer isFree, @Param("sectionCode") Integer sectionCode);

    List<ProductNetworkCourseBean> findList(@Param("userId") String userId, @Param("courseType") String courseType, @Param("sectionCode") Integer sectionCode);

    ProductNetworkCourseBean getById(@Param("courseId") String courseId, @Param("userId") String userId);

    List<ProductNetworkCourseCatalogBean> getCatalogsList(@Param("courseId") String courseId);

    List<ProductNetworkCourseVideoBean> getVideosList(@Param("searchId") String searchId, @Param("searchType") String searchType, @Param("userId") String userId);

    List<ProductNetworkCourseTeacherBean> getTeachersList(@Param("courseId") String courseId);

    ProductNetworkCourseTeacherBean getTeacherDetails(@Param("teacherId") String teacherId);

    List<ProductNetworkCourseBean> getTeacherCourses(@Param("teacherId") String teacherId);

    int obtainNetworkCourse(UserNetworkCourseBean uncBean);

    int incrementNetworkCourseObtainCount(UserNetworkCourseBean uncBean);

    int createOrUpdateVideoPlaylog(ProductNetworkCoursePlaylogBean playlogBean);

    int getPreviewVideoCount(@Param("courseId") String courseId, @Param("ccVideoId") String ccVideoId);

    String getCourseFirstVideoCcId(@Param("courseId") String courseId);

    String getCourseFirstLiveCcId(@Param("courseId") String courseId);

    int videoAuthStatus(@Param("userId") String userId, @Param("courseId") String courseId, @Param("ccVideoId") String ccVideoId);

    int getCourseIsFreeOrFamousTeacher(@Param("courseId") String courseId);

    int getCourseFamousTeacher(@Param("courseId") String courseId);

    CCLiveUserBean getCcLiveUserInfo(@Param("userId") String userId);

    CCLiveUserBean liveAuthCourseStatus(@Param("userId") String userId, @Param("courseId") String courseId, @Param("liveRoomId") String liveRoomId);

    CCLiveUserBean liveAuthVideoStatus(@Param("userId") String userId, @Param("courseId") String courseId, @Param("liveRoomId") String liveRoomId);

    ProductNetworkCourseBean getProductInfo(@Param("searchId") String searchId, @Param("searchType")String searchType);

    ProductNetworkCourseBean orderState(@Param("productId") String productId, @Param("userId")String userId);
}