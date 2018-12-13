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

public class Movie {

	@Keyword
	public static ResponseObject deleteRating(int id){
		RequestObject reqObj = findTestObject('Movies/Delete Rating')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/rating'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		params.add(new TestObjectProperty('guest_session_id', ConditionType.EQUALS, GlobalVariable.guestSessionID))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getAccountStates(int id){
		RequestObject reqObj = findTestObject('Movies/Get Account States')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/account_states'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getAlternativeTitles(int id){
		RequestObject reqObj = findTestObject('Movies/Get Alternative Titles')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/alternative_titles'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getChanges(int id){
		RequestObject reqObj = findTestObject('Movies/Get Changes')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/changes'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getCredits(int id){
		RequestObject reqObj = findTestObject('Movies/Get Credits')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/credits'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getDetails(int id){
		RequestObject reqObj = findTestObject('Movies/Get Details')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getExternalIDs(int id){
		RequestObject reqObj = findTestObject('Movies/Get External IDs')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/external_ids'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getImages(int id){
		RequestObject reqObj = findTestObject('Movies/Get Images')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/images'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getKeywords(int id){
		RequestObject reqObj = findTestObject('Movies/Get Keywords')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/keywords'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getlatest(){
		return WS.sendRequest(findTestObject('Movies/Get Latest'))
	}

	@Keyword
	public static ResponseObject getLists(int id){
		RequestObject reqObj = findTestObject('Movies/Get Lists')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/lists'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	@Keyword
	public static ResponseObject getNowPlay(){
		return WS.sendRequest(findTestObject('Movies/Get Now Playing'))
	}

	public static ResponseObject getPopular(){
		return WS.sendRequest(findTestObject('Movies/Get Popular'))
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
		return WS.sendRequest(findTestObject('Movies/Get Top Rated'))
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

	public static ResponseObject getUpComing(){
		return WS.sendRequest(findTestObject('Movies/Get Upcoming'))
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

	public static ResponseObject rateMovie(int id, float rating){
		RequestObject reqObj = findTestObject('Movies/Rate Movie')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/rating'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()

		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		params.add(new TestObjectProperty('guest_session_id', ConditionType.EQUALS, GlobalVariable.guestSessionID))
		reqObj.setRestParameters(params)

		String body = toJson(value: rating)
		reqObj.setBodyContent(new HttpTextBodyContent(body))

		return WS.sendRequest(reqObj)
	}

	//Return -1 if getting no movie
	public static int getRandomMovie(ResponseObject resObj){
		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(resObj.getResponseBodyContent())

		if (dataValue.results == null)
			return -1

		int resultSize = dataValue.results.size() - 1

		if (resultSize >= 0) {
			int i = ((Math.random() * resultSize) as int)
			return dataValue.results[i].id
		}
		return -1
	}

	//return null if getting no review
	public static String getRandomReview(ResponseObject resObj){
		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(resObj.getResponseBodyContent())

		if (dataValue.results == null)
			return null

		int resultSize = dataValue.results.size() - 1

		if (resultSize >= 0) {
			int i = ((Math.random() * resultSize) as int)
			return dataValue.results[i].id
		}
		return null
	}

	//return null if getting no review
	public static String getRandomCredit(ResponseObject resObj){
		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(resObj.getResponseBodyContent())

		if (dataValue.cast == null)
			return null

		int resultSize = dataValue.cast.size() - 1

		if (resultSize >= 0) {
			int i = ((Math.random() * resultSize) as int)
			return dataValue.cast[i].credit_id
		}
		return null
	}
}
