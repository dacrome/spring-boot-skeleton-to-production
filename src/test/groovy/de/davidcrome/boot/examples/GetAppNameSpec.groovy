package de.davidcrome.boot.examples

class GetAppNameSpec extends AbstractIntegrationTest {

    def 'get app name'() {

        when:
        def response = restClient().get(path: '/app-name')

        then:
        response.data.text == 'skeleton-to-production'
    }
}
