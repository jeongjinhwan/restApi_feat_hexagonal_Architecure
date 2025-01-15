## list
1. [SLF4J(W): Class path contains multiple SLF4J providers.](#1.-SLF4J(W):-Class-path-contains-multiple-SLF4J-providers.)
2. [org.apache.httpcomponents.client5:httpclient5 버전 이슈](#2.-org.apache.httpcomponents.client5:httpclient5-버전-이슈)
---
## 1. SLF4J(W): Class path contains multiple SLF4J providers.
### Issue 
>SLF4J(W): Class path contains multiple SLF4J providers.
SLF4J(W): Found provider [org.slf4j.simple.SimpleServiceProvider@7d4793a8]
SLF4J(W): Found provider [ch.qos.logback.classic.spi.LogbackServiceProvider@449b2d27]
SLF4J(W): See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J(I): Actual provider is of type [org.slf4j.simple.SimpleServiceProvider@7d4793a8]
Exception in thread "main" java.lang.IllegalArgumentException: LoggerFactory is not a Logback LoggerContext but Logback is on the classpath. 
Either remove Logback or the competing implementation (class org.slf4j.simple.SimpleLoggerFactory loaded from file:/C:/Users/jh/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-simple/2.0.16/56d3d8e59293543780ad35af4ee4a5d9c111a588/slf4j-simple-2.0.16.jar). 
If you are using WebLogic you will need to add 'org.slf4j' to prefer-application-packages in WEB-INF/weblogic.xml: org.slf4j.simple.SimpleLoggerFactory
    at org.springframework.util.Assert.instanceCheckFailed(Assert.java:618)
### Resolution
 > 프로젝트 전체에서 slf4j-simple 라이브러리가 사용되지 않도록 설정합니다. 이를 통해 SLF4J 충돌을 방지하고, 빌드 프로세스를 보다 안정적으로 만들 수 있습니다.
 ```
configurations {
    ...
    all{ // 라이브 러리에서 중복 처리 되는 org.slf4j 제외.
        exclude group: 'org.slf4j', module: 'slf4j-simple'
    }
}
```

## 2. org.apache.httpcomponents.client5:httpclient5 버전 이슈
### Issue 
>Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2025-01-14T15:04:14.973+09:00 ERROR 6904 --- [board] [main] o.s.boot.SpringApplication : Application run failed
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'clientHttpRequestFactoryBuilder' defined in class path resource 
[org/springframework/boot/autoconfigure/http/client/HttpClientAutoConfiguration.class]: Failed to instantiate [org.springframework.boot.http.client.ClientHttpRequestFactoryBuilder]: 
Factory method 'clientHttpRequestFactoryBuilder' threw exception with message: org/apache/hc/client5/http/ssl/TlsSocketStrategy
    at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:657) ~[spring-beans-6.2.1.jar:6.2.1]
### Resolution
> 5.2.1 -> 5.4.1 로 변경

## 3. java.lang.NoSuchMethodError: org.yaml.snakeyaml.constructor.SafeConstructor: method 'void <init>()' not found
### Issue 
>
Execution failed for task ':openApiGenerate-server-board'.
There were issues with the specification. The option can be disabled via validateSpec (Maven/Gradle) or --skip-validate-spec (CLI).
   | Error count: 1, Warning count: 0
  Errors: 
        -org.yaml.snakeyaml.constructor.SafeConstructor: method 'void <init>()' not found
### Resolution
> 1.gradle 문법 오류.
2.java, gradle, openapi-generator version 호환성.
```
tasks.register("openApiGenerateServer") {
    print serverSwaggerMap.entrySet().stream().map({entry -> "openApiGenerate-server-${entry.key}"}).toArray()
    dependsOn(serverSwaggerMap.entrySet().stream().map({entry -> "openApiGenerate-server-${entry.key}"}).toArray())
}
```