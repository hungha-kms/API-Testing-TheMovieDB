import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static groovy.json.JsonOutput.toJson
import internal.GlobalVariable as GlobalVariable
import theMovieDB.TheMovieDBCommon as TheMovieDBCommon

TheMovieDBCommon common = new TheMovieDBCommon()

String sessionID = common.getSessionID()

String body = null
ResponseObject response1
String movieID = null

RequestObject reqObj1 = findTestObject('List/Get Details')
String urlStr = "https://api.themoviedb.org/3/list/" + GlobalVariable.listID +"?"
reqObj1.setRestUrl(urlStr)

params = new ArrayList()
params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))
//params.add(new TestObjectProperty("session_id",ConditionType.EQUALS, sessionID))
//println("&&&&&&&&&&& params: " + params.size())
reqObj1.setRestParameters(params)
int itemCount = -1
response1 = WS.sendRequest(reqObj1)
if (response1.getStatusCode() != 200)
	response1 = WS.sendRequest(reqObj1)
TheMovieDBCommon.printDataValue(response1, "List/Get Details")
def slurper = new groovy.json.JsonSlurper()
def dataValue = null
println ("********** response1.getStatusCode(): "+response1.getStatusCode())
if (response1.getStatusCode() == 200){
	dataValue = slurper.parseText(response1.getResponseBodyContent())
	itemCount = dataValue.items.size()-1
}
println ("********** item count: "+ itemCount)

RequestObject reqObj = findTestObject('List/Remove Movie')
urlStr = "https://api.themoviedb.org/3/list/" + GlobalVariable.listID +"/remove_item?"
reqObj.setRestUrl(urlStr)

List<TestObjectProperty> params = new ArrayList()
params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))
params.add(new TestObjectProperty("session_id",ConditionType.EQUALS, sessionID))
reqObj.setRestParameters(params)

println ("********** dataValue: "+ dataValue)

if (itemCount >= 0){
	0.upto(itemCount){
		movieID = dataValue.items[it].id
		println ("********** Movie ID: "+ movieID)
		body = toJson(media_id: movieID)
		reqObj.setBodyContent(new HttpTextBodyContent(body))
				
		response1 = WS.sendRequest(reqObj)
		println ("********** response1.getStatusCode(): "+response1.getStatusCode())
		if (response1.getStatusCode() != 200)
			response1 = WS.sendRequest(reqObj)
		TheMovieDBCommon.printDataValue(response1, "List/Remove Movie")
	}
}	

response1 = WS.sendRequest(reqObj1)

TheMovieDBCommon.printDataValue(response1, "List/Get Details")