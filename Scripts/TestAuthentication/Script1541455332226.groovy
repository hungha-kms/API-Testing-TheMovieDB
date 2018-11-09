import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// Request token
response1 = WS.sendRequest(findTestObject('Authentication/Create Request Token'))

def slurper = new groovy.json.JsonSlurper()

def dataValue = slurper.parseText(response1.getResponseBodyContent())

def requestToken = dataValue.request_token

GlobalVariable.requestToken = requestToken

// Get approval for creating session by login informaiton
WS.sendRequest(findTestObject('Authentication/Create Session With Login'))

// Get session ID
RequestObject ro = new RequestObject('objectId')

String body = '{"dummyRequest":"yes"}'
String endpoint = 'https://api.themoviedb.org/3/authentication/session/new?'

GlobalVariable.apiKey = '7e5025325ed996a9f5b73d139c82d44b'

endpoint = ((endpoint + 'api_key=') + GlobalVariable.apiKey)

endpoint = ((endpoint + '&request_token=') + requestToken)

ro.setRestUrl(endpoint)

ro.setRestRequestMethod('POST')

ro.setBodyContent(new HttpTextBodyContent(body))
ResponseObject respObj = WS.sendRequest(ro)

dataValue = slurper.parseText(respObj.getResponseBodyContent())

def sessionID = dataValue.session_id

// Delete session ID

endpoint = 'https://api.themoviedb.org/3/authentication/session?'

endpoint = ((endpoint + 'api_key=') + GlobalVariable.apiKey)

endpoint = ((endpoint + '&session_id=') + sessionID)

ro.setRestUrl(endpoint)

ro.setRestRequestMethod('DELETE')

ro.setBodyContent(new HttpTextBodyContent(body))
respObj = WS.sendRequest(ro)

dataValue = slurper.parseText(respObj.getResponseBodyContent())

println ("***********Delete session result: " +dataValue.success)