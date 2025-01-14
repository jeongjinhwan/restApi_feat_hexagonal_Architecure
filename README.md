# Getting Started
### 헥사고날 아키텍쳐
- application 안의 service를 기준으로, in/out port를 interface 구성하여, 유연성과 확장성을 고려한 구조.
- 기존의 mvc2 패턴과 비슷한 구조에서 영역을 명확화 하였다.

### 구조.
- 1단계.
java
  - com
    - sample
      - adapter (비지니스에 따른 in/out adapter)
      - application (실 비지니스 로직 구현체)
      - domain (비지니스 로직 객체)
- 2단계.
java
  - com
    - sample
      - adapter
        - in (in adapter 구현체)
        - out (out adapter 구현체)
      - application
        - port (내부/외부 에서 호출하는 interface)
        - service (실 비지니스 구현체체)
      - domain
        - Board.java (비지니스 로직 객체)
- 3단계.
java
  - com
    - sample
      - adapter
        - in
          - web
            - BoardController.java (web controller)
          - dto (web dto)
        - out
          - BoardRepository.java (port.out 구현체체)
          - vo (db vo)
      - application
        - port
          - in
            - IBoardUseCase.java (외부 호출 interface)
          - out
            - IBoardOutPort.java (내부 호출 interface)
        - service
          - BoardService.java (port.in 구현체체)
      - domain
        - Board.java (비지니스 로직 객체)

<details>
<summary>참고</summary>

### Reference Documentation
For further reference, please consider the following sections:
* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.1/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.1/gradle-plugin/packaging-oci-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.1/reference/using/devtools.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.1/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:
* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
</details>

