package theMovieDB

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static groovy.json.JsonOutput.toJson

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

public class TVSeasons {
	public static ResponseObject getDetails(int TVID, int seasonNo){
		RequestObject reqObj = findTestObject('TV Seasons/Get Details')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season/' + seasonNo
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getAccountStates(int TVID, int seasonNo){
		RequestObject reqObj = findTestObject('TV Seasons/Get Account States')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season/' + seasonNo + "/account_states"
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		TheMovieDBCommon common = new TheMovieDBCommon()
		String sessionID = common.getSessionID()
		params.add(new TestObjectProperty('session_id', ConditionType.EQUALS, sessionID))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getChanges(int seasonNo){
		RequestObject reqObj = findTestObject('TV Seasons/Get Changes')
		String urlStr = 'https://api.themoviedb.org/3/tv/season/' + seasonNo + "/changes"
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getCredits(int TVID, int seasonNo){
		RequestObject reqObj = findTestObject('TV Seasons/Get Credits')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season/' + seasonNo + "/credits"
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getExternalIDs(int TVID, int seasonNo){
		RequestObject reqObj = findTestObject('TV Seasons/Get External IDs')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season/' + seasonNo + "/external_ids"
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getImages(int TVID, int seasonNo){
		RequestObject reqObj = findTestObject('TV Seasons/Get External IDs')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season/' + seasonNo + "/images"
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getVideos(int TVID, int seasonNo){
		RequestObject reqObj = findTestObject('TV Seasons/Get External IDs')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season/' + seasonNo + "/videos"
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static int getRandomEpisodeNo(ResponseObject resObj){
		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(resObj.getResponseBodyContent())

		int resultSize = dataValue.episodes.size()

		if (resultSize > 0) {
			int i = ((Math.random() * resultSize) as int)
			if (i == 0)
				i = 1
			return i
		}
		return 1
	}
}
