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

public class TVEpisodesINProgress {
	public static ResponseObject deleteRating(int TVID, int seasonNo, int episodeNo){
		RequestObject reqObj = findTestObject('TV Episodes/Delete Rating')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episodeNo +'/rating'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getAccountStates(int TVID, int seasonNo, int episodeNo){
		RequestObject reqObj = findTestObject('TV Episodes/Get Account States')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episodeNo + '/account_states'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getChanges(int episodeNo){
		RequestObject reqObj = findTestObject('TV Episodes/Get Changes')
		String urlStr = 'https://api.themoviedb.org/3/tv/episode/' + episodeNo + '/changes'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getCredits(int TVID, int seasonNo, int episodeNo){
		RequestObject reqObj = findTestObject('TV Episodes/Get Credits')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episodeNo + '/credits'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getDetails(int TVID, int seasonNo, int episodeNo){
		 RequestObject reqObj = findTestObject('TV Episodes/Get Details')
		 String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episodeNo
		 reqObj.setRestUrl(urlStr)
		 List<TestObjectProperty> params = new ArrayList()
		 params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		 reqObj.setRestParameters(params)
		 return WS.sendRequest(reqObj)
	}

	public static ResponseObject getExternalIDs(int TVID, int seasonNo, int episodeNo){
		RequestObject reqObj = findTestObject('TV Episodes/Get External IDs')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episodeNo + '/external_ids'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getImages(int TVID, int seasonNo, int episodeNo){
		RequestObject reqObj = findTestObject('TV Episodes/Get Images')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episodeNo + '/images'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	
	public static ResponseObject getTranslations(int TVID, int seasonNo, int episodeNo){
		RequestObject reqObj = findTestObject('TV Episodes/Get Translations')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episode + '/translations'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getVideos(int TVID, int seasonNo, int episodeNo){
		RequestObject reqObj = findTestObject('TV Episodes/Get Videos')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episode + '/videos'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject rateTVEpisode(int TVID, int seasonNo, int episodeNo, float rating){
		RequestObject reqObj = findTestObject('TV Episodes/Rate TV Episode')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + TVID + '/season'+ seasonNo +'/episode' + episode + '/rating'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)

		String body = toJson(value: rating)
		reqObj.setBodyContent(new HttpTextBodyContent(body))

		return WS.sendRequest(reqObj)
	}
}
