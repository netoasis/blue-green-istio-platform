def responseStr = ""
def responseCode = 404

def devicesUri = /^.*\/customer\/me\/devices(?:\?.*)?$/
def devicesWithIdUri = /^.*\/customer\/me\/devices\/([a-zA-Z0-9-]+)$/

def authenticationsUri = /^.*\/customer\/me\/authentications\/$/
def authenticationsWithIdUri = /^.*\/customer\/me\/authentications\/([a-zA-Z0-9-]+)(?:\?.*)?$/
def authenticationsInitiateUri = /^.*\/customer\/me\/authentications\/[a-zA-Z0-9-]+\/initiate(?:\?.*)?$/
def authenticationsValidateUri = /^.*\/customer\/me\/authentications\/[a-zA-Z0-9-]+\/validate(?:\?.*)?$/

def parseQueryParameters(String queryString) {
    def params = [:]
    if (queryString) {
        queryString.tokenize('&').each { param ->
            def (key, value) = param.split('=')
            // URL decode the parameter values
            params[key] = URLDecoder.decode(value, "UTF-8")
        }
    }
    return params
}

if (uri =~ devicesUri) {
    def customerNumber = header.getFirst("CUSTOMERNUMBER")
    if (customerNumber != null) {
        if (customerNumber == "000401") {
            responseCode = 401
        } else if (customerNumber == "000403") {
            responseCode = 403
        } else if (customerNumber == "000500") {
            responseCode = 500
        } else if (customerNumber == "999999") {
            responseCode = 503
        } else if (customerNumber == "111111") {
            responseCode = 200
            responseStr = """
{
    "href": "/customers/me",
    "etag": "bee4d36cfd",
    "values": [
        {
          "id": "-1133407349",
          "version": 0,
          "customerId": "${customerNumber}",
          "type": "SMS",
          "name": "Fred's Phone",
          "description": "Mobile device",
          "value": "+61438888888",
          "pushNotificationDevicePublicKey": null,
          "dateCreated": "${new Date()}"
        },
        {
          "id": "-1133407350",
          "version": 0,
          "customerId": "${customerNumber}",
          "type": "Push",
          "name": null,
          "description": "BankFast Authentication",
          "value": "-1133407350",
          "pushNotificationDevicePublicKey": null,
          "dateCreated": "${new Date()}"
        }
    ]
}
"""
        } else if (customerNumber == "987009") {
            responseCode = 200
            responseStr = """
{
    "href": "/customers/me",
    "etag": "bee4d36cfd",
    "values": [
        {
          "id": "-1133407349",
          "version": 0,
          "customerId": "${customerNumber}",
          "type": "SMS",
          "name": "Fred's Phone",
          "description": "Mobile device",
          "value": "+61438888888",
          "pushNotificationDevicePublicKey": null,
          "dateCreated": "${new Date()}"
        },
        {
          "id": "-1133407348",
          "version": 0,
          "customerId": "${customerNumber}",
          "type": "SMS",
          "name": "Fred's Phone",
          "description": "Mobile device",
          "value": "+61437777777",
          "pushNotificationDevicePublicKey": null,
          "dateCreated": "${new Date()}"
        },
        {
          "id": "-1133407347",
          "version": 0,
          "customerId": "${customerNumber}",
          "type": "SMS",
          "name": "Fred's Phone",
          "description": "Mobile device",
          "value": "+61436666666",
          "pushNotificationDevicePublicKey": null,
          "dateCreated": "${new Date()}"
        },
        {
          "id": "-1133407350",
          "version": 0,
          "customerId": "${customerNumber}",
          "type": "Push",
          "name": null,
          "description": "BankFast Authentication",
          "value": "-1133407350",
          "pushNotificationDevicePublicKey": null,
          "dateCreated": "${new Date()}"
        }
    ]
}
"""
        } else if (customerNumber != null && customerNumber == "916792") {
            responseCode = 200
            responseStr = """
{
    "href": "/customers/me",
    "etag": "bee4d36cfd",
    "values": [
        {
          "id": "-1133407349",
          "version": 0,
          "customerId": "${customerNumber}",
          "type": "Push",
          "name": null,
          "description": "BankFast Authentication",
          "value": "-1133407349",
          "pushNotificationDevicePublicKey": null,
          "dateCreated": "${new Date()}"
        }
    ]
}
"""
        } else {
            responseCode = 200
            responseStr = """
{
    "href": "/customers/me",
    "etag": "bee4d36cfd",
    "values": [
        {
          "id": "-1133407349",
          "version": 0,
          "customerId": "${customerNumber}",
          "type": "SMS",
          "name": "Fred's Phone",
          "description": "Mobile device",
          "value": "+61438888888",
          "pushNotificationDevicePublicKey": null,
          "dateCreated": "${new Date()}"
        }
    ]
}
"""
        }
    } else {
        responseCode = 400
    }
} else if (uri =~ devicesWithIdUri) {
    def customerNumber = header.getFirst("CUSTOMERNUMBER")
    def deviceId = uri.split("/")[-1]
    if (customerNumber != null) {
        if (deviceId == "FORBIDDENDEVICE") {
            responseCode = 403
        } else if (deviceId == "ERRORDEVICE") {
            responseCode = 500
        } else if (deviceId == "aad1sdgs59s75fdds3") {
            responseCode = 200
            responseStr = """
{
    "id": "${deviceId}",
    "version": 0,
    "customerId": "${customerNumber}",
    "type": "Push",
    "name": null,
    "description": "BankFast Authentication",
    "value": "${deviceId}",
    "pushNotificationDevicePublicKey": null,
    "dateCreated": "${new Date()}"
}
"""
        } else if (customerNumber == "999999") {
            responseCode = 503
        } else {
            responseCode = 200
            responseStr = """
{
    "id": "${deviceId}",
    "version": 0,
    "customerId": "${customerNumber}",
    "type": "SMS",
    "name": "Fred's Phone",
    "description": "Mobile device",
    "value": "+61438888888",
    "pushNotificationDevicePublicKey": null,
    "dateCreated": "${new Date()}"
}
"""
        }
    } else {
        responseCode = 400
    }
} else if (uri =~ authenticationsUri) {
    def customerNumber = header.getFirst("CUSTOMERNUMBER")
    if (customerNumber != null) {
        if (body.deviceId == "FORBIDDENDEVICE") {
            responseCode = 403
        } else if (body.deviceId == "ERRORAUTHDEVICE") {
            responseCode = 401
        } else if (customerNumber == "999999") {
            responseCode = 422
        } else {
            responseCode = 200
            responseStr = """
{
  "id": "e2e865c0-d45d-41e3-a865-c0d45d91e3b1",
  "customerId": "${customerNumber}",
  "title": "${body.title}",
  "body": "${body.body}",
  "referenceId": null,
  "referenceType": null,
  "type": "${body.type}",
  "status": "Created",
  "authenticationReference": "468sdfhsfd6543sd33h5dfg88h4d"
}
"""
        }
    } else {
        responseCode = 400
    }
} else if (uri =~ authenticationsWithIdUri) {
    def customerNumber = header.getFirst("CUSTOMERNUMBER")
    def authId = uri.split("\\?")[0].split("/")[-1]
    def queryParam = uri.split("\\?").size() > 1 ? parseQueryParameters(uri.split("\\?")[1]) : [:]
    def authType = queryParam["authType"]
    if (customerNumber != null && authType != null && (authType.equals("Email") || authType.equals("Push") || authType.equals("SMS") || authType.equals("Voice"))) {
        if (authId == "ERRORAUTH") {
            responseCode = 401
        } else if (authId == "ERRORFORBIDDEN") {
            responseCode = 403
        } else if (authId == "ERROR") {
            responseCode = 500
        } else if (customerNumber == "999999") {
            responseCode = 503
        } else {
            responseCode = 200
            responseStr = """
{
  "id": "e2e865c0-d45d-41e3-a865-c0d45d91e3b1",
  "customerId": "${customerNumber}",
  "title": null,
  "body": null,
  "referenceId": null,
  "referenceType": null,
  "type": "${authType}",
  "status": "Created",
  "authenticationReference": "468sdfhsfd6543sd33h5dfg88h4d"
}
"""
        }
    } else {
        responseCode = 400
    }
} else if (uri =~ authenticationsInitiateUri) {
    def customerNumber = header.getFirst("CUSTOMERNUMBER")
    def authId = uri.split("/")[-2]
    def queryParam = uri.split("\\?").size() > 1 ? parseQueryParameters(uri.split("\\?")[1]) : [:]
    def authenticationReference = queryParam["authenticationReference"]
    // Alternate every 10 seconds.
    def shouldRateLimit = ((System.currentTimeMillis() / 60000) as int) % 2 == 1
    if (customerNumber != null) {
        if (authId == "ERRORAUTH") {
            responseCode = 401
        } else if (authId == "ERRORFORBIDDEN") {
            responseCode = 403
        } else if (customerNumber == "999999") {
            responseCode = 422
        } else if (customerNumber == "999998" && shouldRateLimit) {
            responseCode = 429
        } else {
            responseCode = 200
            responseStr = """
{
  "id": "e2e865c0-d45d-41e3-a865-c0d45d91e3b1",
  "customerId": "${customerNumber}",
  "title": "${body.title}",
  "body": "${body.body}",
  "referenceId": null,
  "referenceType": null,
  "type": "${body.type}",
  "status": "Created",
  "authenticationReference": "${authenticationReference}"
}
"""
        }
    } else {
        responseCode = 400
    }
} else if (uri =~ authenticationsValidateUri) {
    def customerNumber = header.getFirst("CUSTOMERNUMBER")
    def authId = uri.split("/")[-2]
    if (customerNumber != null) {
        if (authId == "ERRORAUTH") {
            responseCode = 401
        } else if (authId == "ERRORFORBIDDEN") {
            responseCode = 403
        } else if (customerNumber == "999999") {
            responseCode = 422
        } else if (customerNumber == "999997") {
            responseCode = 429
        } else if (body.challengeResponse == "000000") {
            responseCode = 200
            responseStr = """
{
  "id": "e2e865c0-d45d-41e3-a865-c0d45d91f5we3",
  "customerId": "${customerNumber}",
  "title": "${body.title}",
  "body": "${body.body}",
  "referenceId": null,
  "referenceType": null,
  "type": "${body.type}",
  "status": "Declined",
  "authenticationReference": "468sdfhsfd6543sd33h5dfg88h4d"
}
"""
        } else if (body.challengeResponse == "000001") {
            responseCode = 200
            responseStr = """
{
  "id": "e2e865c0-d45d-41e3-a865-c0d45d91e3b1",
  "customerId": "${customerNumber}",
  "title": "${body.title}",
  "body": "${body.body}",
  "referenceId": null,
  "referenceType": null,
  "type": "${body.type}",
  "status": "Timeout",
  "authenticationReference": "468sdfhsfd6543sd33h5dfg88h4d"
}
"""
        } else if (body.challengeResponse == "000002") {
            responseCode = 200
            responseStr = """
{
  "id": "e2e865c0-d45d-41e3-a865-c0d45d91e3b1",
  "customerId": "${customerNumber}",
  "title": "${body.title}",
  "body": "${body.body}",
  "referenceId": null,
  "referenceType": null,
  "type": "${body.type}",
  "status": "Blocked",
  "authenticationReference": "468sdfhsfd6543sd33h5dfg88h4d"
}
"""
        } else {
            responseCode = 200
            responseStr = """
{
  "id": "e2e865c0-d45d-41e3-a865-c0d45d91e3b1",
  "customerId": "${customerNumber}",
  "title": "${body.title}",
  "body": "${body.body}",
  "referenceId": null,
  "referenceType": null,
  "type": "${body.type}",
  "status": "Approved",
  "authenticationReference": "468sdfhsfd6543sd33h5dfg88h4d"
}
"""
        }
    } else {
        responseCode = 400
    }
}

def result = [responseStr: responseStr, responseCode: responseCode]

return result