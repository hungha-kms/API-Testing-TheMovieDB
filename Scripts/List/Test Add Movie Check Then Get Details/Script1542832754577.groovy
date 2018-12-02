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

//Test Get Created List
RequestObject reqObj = findTestObject('List/Add Movie')

List<TestObjectProperty> params = new ArrayList()
params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))
params.add(new TestObjectProperty("session_id",ConditionType.EQUALS, sessionID))
reqObj.setRestParameters(params)

String body = null
ResponseObject response1
String movieID = null

response1 = WS.sendRequest(findTestObject('Search/Search Movies'))
def slurper = new groovy.json.JsonSlurper()
def dataValue = slurper.parseText(response1.getResponseBodyContent())

int resultSize = dataValue.results.size()-1

0.upto(resultSize - 5){
	movieID = dataValue.results[it].id
	body = toJson(media_id: movieID)
	reqObj.setBodyContent(new HttpTextBodyContent(body))
	
	WS.sendRequest(reqObj)
	
}

//response1 = WS.sendRequest(findTestObject('List/Get Details'))
//TheMovieDBCommon.printDataValue(response1, "List/Get Details")

reqObj = findTestObject('List/Check Item Status')

0.upto(resultSize - 5){
	movieID = dataValue.results[it].id
	println ("************* Movie ID: "+movieID)
	params = new ArrayList()
	params.add(new TestObjectProperty("movie_id",ConditionType.EQUALS, movieID))
	reqObj.setRestParameters(params)
	response1 = WS.sendRequest(reqObj)
	//TheMovieDBCommon.printDataValue(response1, "List/Check Item Status")
	WS.verifyElementPropertyValue(response1, 'item_present', true)
}


//response1 = WS.sendRequest(findTestObject('List/Get Details'))
//TheMovieDBCommon.printDataValue(response1, "List/Get Details")