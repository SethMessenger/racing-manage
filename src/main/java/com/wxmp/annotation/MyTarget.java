package com.wxmp.annotation;

import java.lang.annotation.Target;

/**
 * @author  xunbo.xu
 * @desc    自定义注解
 *          @Target 作用：描述该注解修饰的范围，可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。
 *          @Retention 作用：描述该注解的生命周期，表示在什么编译级别上保存该注解的信息。Annotation被保留的时间有长短：某些Annotation仅出现在源代码中，而被编译器丢弃；而另一些却被编译在class文件中；编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）
 *          @Documented 作用：生成javadoc文档的时候将该Annotation也写入到文档中
 *          @Inherited 作用：
 * @date 18/8/29
 */
//@Target()
public @interface MyTarget {
}
