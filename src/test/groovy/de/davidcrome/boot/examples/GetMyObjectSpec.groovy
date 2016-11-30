package de.davidcrome.boot.examples

class GetMyObjectSpec extends AbstractIntegrationTest {

    def 'get my object'() {

        when:
        def response = restClient().get(path: '/my-object')

        then:
        with(response.data) {
            string == 'test-string'
            integer == 100000
        }
    }

    def 'get my string'() {

        when:
        def response = restClient().get(path: '/my-string')

        then:
        with(response.data) {
            text == 'test-string'
        }
    }

    def 'get my integer'() {

        when:
        def response = restClient().get(path: '/my-integer')

        then:
        with(response) {
            data == 100000
        }
    }
}
