import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.io.FileType

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

def findUsingText(searchString) {
  def results = []
  def findFiles = new File("default/loqate/find")
  findFiles.eachFile(FileType.FILES) { file ->
    def findAddresses = new JsonSlurper().parse(file).Items
    for (findAddress in findAddresses) {
      if (findAddress.Text.toLowerCase().contains(searchString) || findAddress.Description.toLowerCase().contains(searchString)) {
        results << findAddress
      }
    }
  }
  return results
}

def findUsingContainer(container) {
  def results = []
  // Convert '|' to '-' to find file.
  def convertedContainerString = container.replaceAll('\\|', '-')
  def containerFile = new File("default/loqate/find/container/${convertedContainerString}.json")
  def containerAddresses = new JsonSlurper().parse(containerFile).Items
  for (containerAddress in containerAddresses) {
    results << containerAddress
  }
  return results
}

def retrieveAddress(id) {
  def results = []
  def retrieveFiles = new File("default/loqate/retrieve")
  retrieveFiles.eachFile(FileType.FILES) { file ->
    def findAddresses = new JsonSlurper().parse(file).Items

    for (findAddress in findAddresses) {
      if (findAddress.Id.toString().toLowerCase() == id) {
        results << findAddress
      }
    }
  }
  return results
}

def queryParams = uri.split("\\?").size() > 1 ? parseQueryParameters(uri.split("\\?")[1]) : [:]

def responseCode = 200
def responseStr = ''

def captureFindUri = /^.*find/
def captureRetrieveUri = /^.*retrieve/

def results = []
def containerParam = queryParams["Container"]
def searchString = queryParams["Text"].toString().toLowerCase()

if (uri =~ captureFindUri) {
  if (containerParam == null) {
    results = findUsingText(searchString)
  } else {
    results = findUsingContainer(containerParam)
  }
} else if (uri =~ captureRetrieveUri) {
  def idParam = queryParams["Id"].toString().toLowerCase()
  results = retrieveAddress(idParam)
}

def items = [Items: results]
responseStr = JsonOutput.toJson(items)

def result = [responseStr: responseStr, responseCode: responseCode]

return result