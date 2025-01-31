## 목차
- [barnch](#Branch-적용-내용)
- [Application spec](#Application-spec)
- [hexagonal Architecure](#헥사고날-아키텍쳐)
- [openapi.generator](#openapigenerator)
  - [og gradle task 설정](#og-gradle-task-설정)
- [springdoc.swagger](#Swagger)
- [Feign Client](#Feign-Client)
  - [warning](#warning)
  - [fc gradle 설정](#fc-gradle-설정)
  - [Feign logging 설정](#Feign-logging-설정)
  - [end point 설정](#end-point-설정정)
- [test](#test)
## Branch 적용 내용
- applyHexagoanl
  - restapi, swagger, hexagonal Architecure.
- applyOpenapiGen
  - restapi, swagger, hexagonal Architecure, openapi-generator.
- applyFeignClient
  - restapi, swagger, hexagonal Architecure, openapi-generator, feignClient.
## Application spec
- java 23
- gradle 8.12
- springframework.boot 3.4.1
- openapi.generator 7.10.0
## 헥사고날 아키텍쳐
- application 안의 service를 기준으로, in/out port를 interface 구성하여, 유연성과 확장성을 고려한 구조.
- 기존의 mvc2 패턴과 비슷한 구조에서 영역을 명확화 하였다.
### 구조.
- 1단계.
```bash
├─java
│  └─com
│      └─sample
│          ├─adapter     (비지니스에 따른 in/out adapter)
│          ├─application (실 비지니스 로직 구현체)
│          └─domain      (비지니스 로직 객체)
```
- 2단계.
```bash
├─java
│  └─com
│      └─sample
│          ├─adapter
│          │  ├─in       (in adapter 구현체)
│          │  └─out      (out adapter 구현체)
│          ├─application
│          │  ├─port     (내부/외부 에서 호출하는 interface)
│          │  └─service  (실 비지니스 구현체)
│          └─domain
```
- 3단계.
```bash
├─java
│  └─com
│      └─sample
│          ├─adapter
│          │  ├─in
│          │  │  ├─dto
│          │  │  └─web
│          │  │          BoardController.java  (web controller)
│          │  └─out
│          │      └─repository
│          │              BoardRepository.java (port.out 구현체체)
│          ├─application
│          │  ├─port
│          │  │  ├─in
│          │  │  │      IBoardUseCase.java   (외부 호출 interface)
│          │  │  └─out
│          │  │          IBoardOutPort.java (내부 호출 interface)
│          │  └─service
│          │          BoardService.java     (port.in 구현체체)
│          └─domain
│                  Board.java               (비지니스 로직 객체)
```
## openapi.generator
- 오픈 소스, 확장성, 생산성, 서비스 개발 전 api in/out 정립.
### og gradle task 설정
build.gradle
```gradle
openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set("$rootDir/specs/petstore-v3.0.yaml")
    outputDir.set("$buildDir/generated")
    apiPackage.set("org.openapi.example.api")
    invokerPackage.set("org.openapi.example.invoker")
    modelPackage.set("org.openapi.example.model")
    configOptions.set([
        dateLibrary: "java8"
    ])
}
tasks.register('taskName', org.openapitools.generator.gradle.plugin.tasks.GenerateTask) { ... }
```
> https://openapi-generator.tech/docs/plugins#gradle

openApiGenerate 내부 옵션들.
> configuration option https://openapi-generator.tech/docs/generators/spring
## Swagger
- rest api 지원을 위한 swagger 적용 및 SecurityScheme 설정 추가.
## Feign Client
### warning
> As announced in Spring Cloud 2022.0.0 release blog entry, we’re now treating the Spring Cloud OpenFeign project as feature-complete. We are only going to be adding bugfixes and possibly merging some small community feature PRs. We suggest migrating over to Spring Interface Clients instead.
### fc gradle 설정
build.gradle
```gradle
plugins {
  id 'java'
  id 'org.springframework.boot' version '3.4.0'
  id 'io.spring.dependency-management' version '1.1.6'
}

repositories {
  mavenCentral()
}

ext {
  set('springCloudVersion', "2024.0.0")
}

dependencies {
    implementation 'org.springframework.cloud:spring-cloud-starter-openfeign'
}

dependencyManagement {
  imports {
    mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
  }
}
```
> gradle 설정 참고 https://spring.io/projects/spring-cloud
> 
> artifact 설정 참고 https://docs.spring.io/spring-cloud-openfeign/reference/spring-cloud-openfeign.html#netflix-feign-starter
### Feign logging 설정 
application.yml
```yaml
logging.level.project.user.UserClient: DEBUG
```
config.java
```java
@Configuration
public class FooConfiguration {
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
```
> 참고 [https://docs.spring.io/spring-cloud-openfeign/reference/spring-cloud-openfeign.html#feign-logging](https://docs.spring.io/spring-cloud-openfeign/reference/spring-cloud-openfeign.html#feign-logging)
### end point 설정
openApiGenerate 로 library: "spring-cloud" 변경하여, 자동으로 생성 됩니다.
xx.java
```java
@FeignClient(name="${kma.name:kma}", url="${kma.url:http://localhost}", configuration = ClientConfiguration.class)
```
xx.yml
```yml
kma:
  url: http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0
```
공식 문서와 다르게 설정을 하였지만, spEL 및 spring core 설정으로 위와 같이 적용이 가능.
```yml
spring:
  cloud:
    openfeign:
      client:
        config:
          feignName:
            url: http://remote-service.com
```
> 공식 설정 [https://docs.spring.io/spring-cloud-openfeign/reference/spring-cloud-openfeign.html#feign-logging](#https://docs.spring.io/spring-cloud-openfeign/reference/spring-cloud-openfeign.html#feign-logging)
>
> 적용 된 설정 [https://docs.spring.io/spring-boot/reference/features/external-config.html](#https://docs.spring.io/spring-boot/reference/features/external-config.html)
## Test
- test url
  - [http://localhost:7000/swagger-ui/index.html](http://localhost:7000/swagger-ui/index.html)
