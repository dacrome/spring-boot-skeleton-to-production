package de.davidcrome.boot.examples

import groovyx.net.http.RESTClient
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class AbstractIntegrationTest extends Specification {

    @LocalServerPort
    def port

    def restClient() {
        new RESTClient("http://localhost:${port}") as Object
    }
}
