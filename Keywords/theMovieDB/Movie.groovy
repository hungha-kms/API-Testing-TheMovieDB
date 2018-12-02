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

public class Movie {
	public static ResponseObject deleteRating(int id){
		RequestObject reqObj = findTestObject('Movies/Delete Rating')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/rating'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getAccountStates(int id){
		RequestObject reqObj = findTestObject('Movies/Get Account States')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/account_states'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getAlternativeTitles(int id){
		RequestObject reqObj = findTestObject('Movies/Get Alternative Titles')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/alternative_titles'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getChanges(int id){
		RequestObject reqObj = findTestObject('Movies/Get Changes')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/changes'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getCredits(int id){
		RequestObject reqObj = findTestObject('Movies/Get Credits')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/credits'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getDetails(int id){
		RequestObject reqObj = findTestObject('Movies/Get Details')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getExternalIDs(int id){
		RequestObject reqObj = findTestObject('Movies/Get External IDs')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/external_ids'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getImages(int id){
		RequestObject reqObj = findTestObject('Movies/Get Images')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/images'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getKeywords(int id){
		RequestObject reqObj = findTestObject('Movies/Get Keywords')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/keywords'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getlatest(){
		RequestObject reqObj = findTestObject('Movies/Get Latest')
		String urlStr = 'https://api.themoviedb.org/3/movie/latest'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getLists(int id){
		RequestObject reqObj = findTestObject('Movies/Get Lists')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/lists'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getNowPlay(){
		RequestObject reqObj = findTestObject('Movies/Get Now Playing')
		String urlStr = 'https://api.themoviedb.org/3/movie/now_playing'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getPopular(){
		RequestObject reqObj = findTestObject('Movies/Get Popular')
		String urlStr = 'https://api.themoviedb.org/3/movie/popular'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getRecommendations(int id){
		RequestObject reqObj = findTestObject('Movies/Get Recommendations')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/recommendations'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getReleaseDates(int id){
		RequestObject reqObj = findTestObject('Movies/Get Release Dates')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/release_dates'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getReviews(int id){
		RequestObject reqObj = findTestObject('Movies/Get Reviews')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/reviews'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getSimilarMovies(int id){
		RequestObject reqObj = findTestObject('Movies/Get Similar Movies')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/similar'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getTopRated(){
		RequestObject reqObj = findTestObject('Movies/Get Top Rated')
		String urlStr = 'https://api.themoviedb.org/3/movie/top_rated'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getTranslations(int id){
		RequestObject reqObj = findTestObject('Movies/Get Translations')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/translations'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getTopRated(){
		RequestObject reqObj = findTestObject('Movies/Get Upcoming')
		String urlStr = 'https://api.themoviedb.org/3/movie/upcoming'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getVideos(int id){
		RequestObject reqObj = findTestObject('Movies/Get Videos')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/videos'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getRateMovie(int id, float rating){
		RequestObject reqObj = findTestObject('Movies/Rate Movie')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/rating'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		
		String body = toJson(value: rating)
		reqObj.setBodyContent(new HttpTextBodyContent(body))
		
		return WS.sendRequest(reqObj)
	}
}
