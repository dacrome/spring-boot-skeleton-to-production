# Spring Boot Skeleton to Production

Step-by-step creation of a Spring Boot app from skeleton to production. 

## [1-skeleton](https://github.com/dacrome/spring-boot-skeleton-to-production/tree/1-skeleton)

This is the first step to the creation of a production-ready Spring Boot App. Generated on start.spring.io and a few
modifications, the app only starts by has no endpoint or similar.

Modifications:
- Created this README
- build.gradle: Switched to new, incubating, plugin mechanism introduced in Gradle 2.1
- Removed JUnit Test
- Added jcenter Repository

## [2-first-endpoint](https://github.com/dacrome/spring-boot-skeleton-to-production/tree/2-first-endpoint)

With the second step, the app gets an endpoint: `/app-name`. This endpoint always respond with the plain text
`skeleton-to-production`.

## [3-configuration](https://github.com/dacrome/spring-boot-skeleton-to-production/tree/3-configuration)

The third step shows how a Spring Boot application can be configured. It is possible to configure an object with
`my.object` and the two properties `string` and `integer`. To request the configured properties three endpoints
exist:

- /my-object: Respond with the whole object
- /my-string: Only respond with the `string` property value
- /my-integer: Only respond with the `integer` property value

## [4-testing](https://github.com/dacrome/spring-boot-skeleton-to-production/tree/4-testing)

The fourth step introduces integration tests with Spock.

## [5-authentication](https://github.com/dacrome/spring-boot-skeleton-to-production/tree/5-authentication)

Authentication with OSIAM.

## [6-actuator](https://github.com/dacrome/spring-boot-skeleton-to-production/tree/6-actuator)

Introduce the Spring Boot Actuator: Monitoring, metrics, health checks. Count every request when calling
`/my-object`.
