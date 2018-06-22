package cn.sparke.core.modules.cacheable.memcache;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MemcachedBuilder {
    private static MemcachedClient memcachedClient;

    public static MemcachedClient getInstance(String uid, String pwd, String url) {
        if (memcachedClient != null) {
            return memcachedClient;
        }
        // 指定验证机制，推荐PLAIN，
        // 部分客户端存在协议BUG，只能使用PLAIN协议(PlainCallbackHandler)
        AuthDescriptor ad = new AuthDescriptor(new String[]{"PLAIN"},
                new PlainCallbackHandler(uid, pwd)); // 用户名，密码

        try {
            memcachedClient = new MemcachedClient(new ConnectionFactoryBuilder()
                    .setProtocol(ConnectionFactoryBuilder.Protocol.BINARY) // 指定使用Binary协议
                    .setOpTimeout(1000)// 设置超时时间为100ms
                    .setAuthDescriptor(ad).build(), AddrUtil.getAddresses(url)); // 访问地址
        } catch (IOException e) {
            e.printStackTrace();
        }
        return memcachedClient;
    }

    public static MemcachedClient getInstance(String url, int port) {
        if (memcachedClient != null) {
            return memcachedClient;
        }
        try {
            memcachedClient = new MemcachedClient(new InetSocketAddress(url, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return memcachedClient;
    }

}
