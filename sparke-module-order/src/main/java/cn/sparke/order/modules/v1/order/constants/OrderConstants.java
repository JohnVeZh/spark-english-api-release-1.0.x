package cn.sparke.order.modules.v1.order.constants;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public interface OrderConstants {
    int NEED_SEND = 1;//需要邮寄
    int UN_NEED_SEND = 0;//不需要邮寄
    int IS_POSTAGE = 1;//包邮
    int UN_IS_POSTAGE = 0;//不包邮
    int HAS_COLLECTION = 1;//拥有搭配
    int UN_HAS_COLLECTION = 0;//未拥有搭配

    int ORDER_TYPE_NETWORK = 1;
    int ORDER_TYPE_BOOK = 2;

    interface COUPON {
        int NORMAL = 1;
        int TAKE_UP = 2;//优惠券占用状态
    }

    interface USER_NETWORK {//用户网课关系
        int TYPE_ORDER = 4;
        int TYPE_REDEEM = 5;
    }

    interface PAY_TYPE {
        int NONE = 0;
        int ALI_PAY = 1;
        int WEI_XIN = 2;
        int REDEEM_CODE = 3;//兑换码
    }

    interface STATUS {
        int NOT_PAY = 1;//未支付
        int NOT_COMMENT = 4;//待评论
        int NOT_SEND = 2;//待发货
        int SEND = 3;//待收货
        int FINISH = 5;//已完成
        int CANCEL = 6;//已取消
    }

    interface ORDER_DETAIL {
        int REFUND_ING = 1;//退款中
        int IS_COMMENT = 1;//已评论
    }
}
