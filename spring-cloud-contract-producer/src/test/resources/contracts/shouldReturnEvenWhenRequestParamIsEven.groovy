import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "should return even when number input is even"

    request {
        method GET()
        url("/api/validate/number") {
            queryParameters {
                parameter("number", "2")
            }
        }
    }

    response {
        body("Even")
        status 200
    }
}