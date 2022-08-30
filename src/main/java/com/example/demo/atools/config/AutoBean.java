package com.example.demo.atools.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description:
 */
@Configuration
public class AutoBean implements ApplicationContextAware {
    /**
     * springboot在使用Scheduled做定时任务出现Autowired注入空指针异常：
     *
     * 原因：
     * 因为Scheduled的加载时机要早于Autowired，定时任务会开启一个新的进程，
     * 而spring值会注入到初始的类中，但这个有值类并没有被使用，而是调用了无值的类。
     *
     * 解决：
     * ApplicationContextAware的作用是可以方便获取Spring容器ApplicationContext,从而可以获取容器内的Bean。
     * 其实我们看到---Aware就知道是干嘛用的了，就是属性注入的，
     * 但是这个ApplicationContextAware的不同地方在于，实现了这个接口的bean，
     * 当spring容器初始化的时候，会自动的将ApplicationContext注入进来。
     *
     * 使用：
     * 注入方式不用@Autowired，改成下面的代码注入
     * private final Service service= AutoBean.getBean(Service.class);
     *
     * 注意事项：
     * AutoBean的代码位置要在TestTask代码之前，启动服务时，代码的顺序，会影响到执行顺序，
     * 如果位置不正确，还是会导致service获取空指针。
     *
     * 定时任务：
     * cron表达式在线生成器 https://cron.qqe2.com
     * @Scheduled 修饰方法
     * @Component 修饰方法所在类
     * @EnableScheduling 修饰启动类
     *
     */

    /**
     * context object instance.
     */
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * get context.
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    /**
     * Get Bean by name.
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * Get Bean by class.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * Returns the specified Bean by name, and Clazz
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }


}
