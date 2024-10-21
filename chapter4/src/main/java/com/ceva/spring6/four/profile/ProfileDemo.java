package com.ceva.spring6.four.profile;

import com.ceva.spring6.four.profile.highschool.HighSchoolConfig;
import com.ceva.spring6.four.profile.kindergarten.KindergartenConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class ProfileDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(ProfileDemo.class);

    public static void main(String... args) {
        //var profile= System.getProperty("spring.profiles.active");
        var profile = "highschool";
        var ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles(profile); // establecemos el perfil activo
        //ctx.getEnvironment().setDefaultProfiles("kindergarten","highschool");
        ctx.register(HighSchoolConfig.class, KindergartenConfig.class);
        ctx.refresh();

        var foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        var lunchSet = foodProviderService.provideLunchSet();
        lunchSet.forEach(food -> LOGGER.info("Food: {}", food.getName()));
        ctx.close();
    }
}
