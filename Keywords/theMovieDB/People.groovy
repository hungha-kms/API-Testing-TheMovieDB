package theMovieDB

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

public class People {
	public static ResponseObject getDetails(int id){
		RequestObject reqObj = findTestObject('People/Get Details')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getCombinedCredits(int id){
		RequestObject reqObj = findTestObject('People/Get Combined Credits')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id + '/combined_credits'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getChanges(int id){
		RequestObject reqObj = findTestObject('People/Get Changes')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id + '/changes'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getPopular(){
		RequestObject reqObj = findTestObject('People/Get Popular')
		String urlStr = 'https://api.themoviedb.org/3/person/popular'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	
	public static ResponseObject getMovieCredits(int id){
		RequestObject reqObj = findTestObject('People/Get Movie Credits')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id + '/movie_credits'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}
	
	public static ResponseObject getTVCredits(int id){
		RequestObject reqObj = findTestObject('People/Get TV Credits')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id + '/tv_credits'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}
}
