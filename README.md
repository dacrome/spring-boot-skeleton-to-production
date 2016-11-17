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
