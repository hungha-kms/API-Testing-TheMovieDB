package theMovieDB

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Lists {
	public static ResponseObject addMovie(int listID, int movieID, String sessionID){
		RequestObject reqObj = findTestObject('List/Add Movie')
		String urlStr = "https://api.themoviedb.org/3/list/" + listID + "/add_item"
		reqObj.setRestUrl(urlStr)

		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))
		params.add(new TestObjectProperty("session_id",ConditionType.EQUALS, sessionID))
		reqObj.setRestParameters(params)

		String body = toJson(media_id: movieID)
		reqObj.setBodyContent(new HttpTextBodyContent(body))

		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getDetails(int listID){
		RequestObject reqObj = findTestObject('List/Get Details')
		String urlStr = "https://api.themoviedb.org/3/list/" + listID
		reqObj.setRestUrl(urlStr)

		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))

		reqObj.setRestParameters(params)

		return WS.sendRequest(reqObj)
	}
	
	public static ResponseObject checkItemStatus(int listID, int movieID){
		RequestObject reqObj = findTestObject('List/Check Item Status')
		String urlStr = "https://api.themoviedb.org/3/list/" + listID + "/item_status"
		reqObj.setRestUrl(urlStr)

		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))
		params.add(new TestObjectProperty("movie_id",ConditionType.EQUALS, movieID))

		reqObj.setRestParameters(params)

		return WS.sendRequest(reqObj)
	}
}
