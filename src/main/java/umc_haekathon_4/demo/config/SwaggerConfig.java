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

    @Bean
    public OpenAPI treasureAPI() {
        Info info = new Info()
                .title("Treasure Box API")
                .description("Treasure Box API 명세서")
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

        return new OpenAPI()
                .info(info)
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}