package theMovieDB

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonBuilder
import internal.GlobalVariable

public class TheMovieDBCommon {

	public String createRequestToken(){
		def response1 = WS.sendRequest(findTestObject('Authentication/Create Request Token'))

		def slurper = new groovy.json.JsonSlurper()

		def dataValue = slurper.parseText(response1.getResponseBodyContent())

		def requestToken = dataValue.request_token
		return requestToken
	}


	public String getSessionID(){
		// Request token

		def requestToken = createRequestToken()

		GlobalVariable.requestToken = requestToken;

		// Get approval for creating session by login informaiton
		def response1 = WS.sendRequest(findTestObject('Authentication/Create Session With Login'))

		// Get session ID
		RequestObject ro = new RequestObject('objectId')

		String body = '{"dummyRequest":"yes"}'
		String endpoint = 'https://api.themoviedb.org/3/authentication/session/new?'

		endpoint = ((endpoint + 'api_key=') + GlobalVariable.apiKey)

		endpoint = ((endpoint + '&request_token=') + requestToken)

		ro.setRestUrl(endpoint)

		ro.setRestRequestMethod('POST')

		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)

		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(respObj.getResponseBodyContent())

		String sessionID = dataValue.session_id

		return sessionID
	}
	public static String getGuestSessionID(){
		def response1 = WS.sendRequest(findTestObject('Authentication/Create Guest Session'))

		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(response1.getResponseBodyContent())

		String sessionID = dataValue.guest_session_id

		return sessionID
	}
	public static void printDataValue(ResponseObject respObj, String objRespositoryName){
		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(respObj.getResponseBodyContent())
		println("*********** "+ objRespositoryName +" **************")

		JsonBuilder jSon = new JsonBuilder(dataValue)
		println jSon.toPrettyString()
	}
}
