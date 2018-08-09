package com.wxmp.racingapi.netty;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author  xunbo.xu
 * @desc    用于配合Tomcat进行ws服务的加载
 * @date 18/8/8
 */
public class NettyStartListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //当Servlet 容器启动Web 应用时调用该方法。
        //在调用完该方法之后，容器再对Filter 初始化，并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。
        new MyThread().start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。
    }

    /**
     * 内部实现新线程启动 webSocket服务，如果在主线程中启动则会导致当前线程终止，无法启动Tomcat
     */
    class MyThread extends Thread
    {
        @Override
        public void run(){
            System.out.println("系统开始加载NETTY WEB-SOCKET服务");
            new WebSocketServer().run();
        }
    }
}
