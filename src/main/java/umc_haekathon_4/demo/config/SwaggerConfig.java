package umc_haekathon_4.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

/*    @Bean
    public OpenAPI UMCstudyAPI() {
        Info info = new Info()
                .title("UMC 6th Hackarthon API") // API의 제목
                .description("UMC 6th Hackarthon API 명세서") // API에 대한 설명
                .version("1.0.0"); // API의 버전

        String jwtSchemeName = "JWT TOKEN";
        // API 요청 헤더에 인증 정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        // SecuritySchemes 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat(jwtSchemeName));

        return new OpenAPI()
                .info(info)
                .addSecurityItem(securityRequirement)
                .components(components);
    }*/
    @Bean
    public OpenAPI memoryAPI() {
        Info apiInfo = new Info()
                .title("Memory Management API") // API의 제목
                .description("API to manage memories in UMC Hackathon Project") // API에 대한 설명
                .version("1.0.0"); // API의 버전

        String securitySchemeName = "Bearer Auth"; // 보안 스키마 이름 정의
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP) // HTTP 보안 스키마
                .scheme("bearer") // Bearer 유형
                .bearerFormat("JWT"); // JWT 형식 사용

        // 보안 요구 사항 추가
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(securitySchemeName);

        // 컴포넌트에 보안 스키마 등록
        Components components = new Components()
                .addSecuritySchemes(securitySchemeName, securityScheme);

        // OpenAPI 객체 생성 및 설정
        return new OpenAPI()
                .info(apiInfo)
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}