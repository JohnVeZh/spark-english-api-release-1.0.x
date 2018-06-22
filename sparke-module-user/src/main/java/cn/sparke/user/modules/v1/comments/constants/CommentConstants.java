package cn.sparke.user.modules.v1.comments.constants;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface CommentConstants {
    interface TYPE {
        int NETWORK = 1;//网课
        int NEWS = 2;//资讯
        int ACTIVITY = 3;//活动
    }
    interface TERMINAL_TYPE { //请求设备类型（1.android 2.iOS 3.M站 4.PC 5.知米）
        int PC = 4;//PC
    }

    interface NETWORK_IS_FREE {
        int NO_FREE = 0;//收费
        int FREE =1;//免费
    }

}
