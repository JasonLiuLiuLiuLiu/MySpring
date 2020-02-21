package site.iblogs.annotation;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableEcho.class.getName());

        assert attributes != null;
        List<String> packages = Arrays.asList((String[]) attributes.get("packages"));

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(EchoBeanPostProcessor.class);
        beanDefinitionBuilder.addPropertyValue("packages", packages);
        registry.registerBeanDefinition(EchoBeanPostProcessor.class.getName(), beanDefinitionBuilder.getBeanDefinition());
    }
}
