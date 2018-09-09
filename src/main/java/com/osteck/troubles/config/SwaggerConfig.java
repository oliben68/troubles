package com.osteck.troubles.config;


import com.osteck.troubles.entities.FamilyMember;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ConfigurationProperties("swagger")
public class SwaggerConfig {

    private ApiInformation apiInformation;
    private LibraryInformation libraryInformation;
    private String basePath;
    private String basePackage;
    private ApplicationContext applicationContext;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    @Autowired
    public SwaggerConfig(ApiInformation apiInformation, LibraryInformation libraryInformation,
                         ApplicationContext applicationContext) {
        this.apiInformation = apiInformation;
        this.libraryInformation = libraryInformation;
        this.applicationContext = applicationContext;
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(String.format("%s-API-%s", this.libraryInformation.getName(),
                        this.apiInformation.getVersion()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        String titledName = StringUtils.capitalize(libraryInformation.getName());

        return new ApiInfoBuilder()
                .title(String.format("%s REST API", titledName))
                .description(String.format("%s (package version %s) REST API", titledName,
                        libraryInformation.getVersion()))
                .version(apiInformation.getVersion())
                .license(apiInformation.getLicense())
                .licenseUrl(apiInformation.getLicenseUrl())
                .contact(new Contact(
                        apiInformation.getContact().getName(),
                        apiInformation.getContact().getUrl(),
                        apiInformation.getContact().getEmail()))
                .build();
    }
/*
    private final Map<String, String> properties = new HashMap<>();

    @PostConstruct
    public void init() {
        AutowireCapableBeanFactory beanFactory = this.applicationContext.getAutowireCapableBeanFactory();
        for (String version: libraryInformation.getVersions()){
            beanFactory.autowireBean(new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(metaData()));
        }
        // iterate over properties and register new beans
    }
*/
}