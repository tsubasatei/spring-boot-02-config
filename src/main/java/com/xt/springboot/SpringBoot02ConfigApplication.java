package com.xt.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * @SpringBootApplication 标注一个主程序类，说明这是一个 Spring Boot 应用
 * @SpringBootApplication Spring Boot 应用标注在某个类上说明这个类是 SpringBoot的主配置类，
 * SpringBoot 就应该运行这个类的 main 方法来启动 SpringBoot 应用
 *
 *      @SpringBootConfiguration： SpringBoot 的配置类
 *      标注在某个类上，表示这是一个 SpringBoot 的配置类。
 *
 *          @Configuration： 配置类上来标注这个注解
 *          配置类 --- 配置文件
 *          配置类也是容器中的一个组件 @Component
 *
 *      @EnableAutoConfiguration： 开启自动配置功能
 *      以前我们需要配置的东西，SpringBoot 帮我们自动配置，
 *      @EnableAutoConfiguration 告诉 SpringBoot开启自动配置功能，这样自动配置才能生效
 *
 *          @AutoConfigurationPackage： 自动配置包
 *
 *              @Import(AutoConfigurationPackages.Registrar.class)：
 *                  Spring的底层注解@Import，给容器中导入一个组件；导入的组件由
 *                  AutoConfigurationPackages.Registrar.class指定
 *
 *           * 将主配置类（@SpringBootApplication 标注的类）的所在包及下面所有子包里面的所有组件扫描到 Spring 容器
 *
 *          @Import({EnableAutoConfigurationImportSelector.class})：给容器中导入组件
 *          将所有需要导入的组件以全类名的方式返回；这些组件就会被添加到容器中；
 *          会给容器中导入非常多的自动配置类（xxxAutoConfiguration）；就是给容器中导入这个场景需要的所有组件，
 *          并配置好这些组件；
 *
 *
 *       有了自动配置类，免去了我们手动编写配置注入功能组件等的工作；
 *            SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class,classLoader)；
 *
 *
 *      * Spring Boot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将
 *      这些值作为自动配置类导入到容器中，自动配置类就生效，帮我们进行自动配置工作；以前我们需要自己配置的东
 *      西，自动配置类都帮我们；
 *
 *      J2EE的整体整合解决方案和自动配置都在 spring-boot-autoconfigure-1.5.9.RELEASE.jar
 *
 */
 // @ImportResource: 导入 Spring 的配置文件让其生效
//@ImportResource(locations = {"classpath:beans.xml"})
@MapperScan("com.xt.springboot.mapper")
@SpringBootApplication
public class SpringBoot02ConfigApplication {

	/**
	 *  Spring 应用启动起来
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02ConfigApplication.class, args);
	}

}
