package de.davidcrome.boot.examples

import org.springframework.beans.factory.annotation.Autowired

class GetMyObjectDirtiesContextSpec extends AbstractIntegrationTest {

    @Autowired
    MyService myService

    def setup() {
        myService.myObject = new MyConfiguration.MyObject(string: 'dirty-string', integer: -1)
    }

    def 'get my object'() {

        when:
        def response = restClient().get(path: '/my-object')

        then:
        with(response.data) {
            string == 'dirty-string'
            integer == -1
        }
    }

    def 'get my string'() {

        when:
        def response = restClient().get(path: '/my-string')

        then:
        with(response.data) {
            text == 'dirty-string'
        }
    }

    def 'get my integer'() {

        when:
        def response = restClient().get(path: '/my-integer')

        then:
        with(response) {
            data == -1
        }
    }
}
