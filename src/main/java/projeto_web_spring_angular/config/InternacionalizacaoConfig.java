package projeto_web_spring_angular.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizacaoConfig {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messsageSource = 
				new ReloadableResourceBundleMessageSource();
		
		messsageSource.setBasename("classpath:messages");
		messsageSource.setDefaultEncoding("ISO-8859-1");
		messsageSource.setDefaultLocale(Locale.getDefault());
		
		return messsageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		
		return bean;
		
	}
}
