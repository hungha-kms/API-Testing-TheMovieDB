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

public class TVShow {
	public static ResponseObject deleteRating(int id){
		RequestObject reqObj = findTestObject('TV/Delete Rating')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/rating'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getAccountStates(int id){
		RequestObject reqObj = findTestObject('TV/Get Account States')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/account_states'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getAlternativeTitles(int id){
		RequestObject reqObj = findTestObject('TV/Get Alternative Titles')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/alternative_titles'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getChanges(int id){
		RequestObject reqObj = findTestObject('TV/Get Changes')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/changes'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getContentRating(int id){
		RequestObject reqObj = findTestObject('TV/Get Content Rating')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/content_ratings'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}


	public static ResponseObject getCredits(int id){
		RequestObject reqObj = findTestObject('TV/Get Credits')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/credits'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getEpisodeGroups(int id){
		RequestObject reqObj = findTestObject('TV/Get Episode Groups')
		String urlStr = 'https://api.themoviedb.org/3/TV/' + id
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getExternalIDs(int id){
		RequestObject reqObj = findTestObject('TV/Get External IDs')
		String urlStr = 'https://api.themoviedb.org/3/TV/' + id + '/external_ids'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getImages(int id){
		RequestObject reqObj = findTestObject('TV/Get Images')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/images'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getKeywords(int id){
		RequestObject reqObj = findTestObject('TV/Get Keywords')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/keywords'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getlatest(){
		return WS.sendRequest(findTestObject('TV/Get Latest'))
	}

	public static ResponseObject getPopular(){
		return WS.sendRequest(findTestObject('TV/Get Popular'))
	}

	public static ResponseObject getRecommendations(int id){
		RequestObject reqObj = findTestObject('TV/Get Recommendations')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/recommendations'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getReviews(int id){
		RequestObject reqObj = findTestObject('TV/Get Reviews')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/reviews'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getScreenedTheatrically(int id){
		RequestObject reqObj = findTestObject('TV/Get Screened Theatrically')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/screened_theatrically'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getSimilarTVShows(int id){
		RequestObject reqObj = findTestObject('TV/Get Similar TV Shows')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/similar'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}


	public static ResponseObject getTopRated(){
		return WS.sendRequest(findTestObject('TV/Get Top Rated'))
	}

	public static ResponseObject getTranslations(int id){
		RequestObject reqObj = findTestObject('TV/Get Translations')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/translations'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getTVAiringToday(){
		return WS.sendRequest(findTestObject('TV/Get TV Airing Today'))
	}

	public static ResponseObject getTVOnTheAir(){
		return WS.sendRequest(findTestObject('TV/Get TV On The Air'))
	}
	public static ResponseObject getVideos(int id){
		RequestObject reqObj = findTestObject('TV/Get Videos')
		String urlStr = 'https://api.themoviedb.org/3/tv/' + id + '/videos'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject RateTVShow(int id, float rating){
		RequestObject reqObj = findTestObject('TV/Rate TV Show')
		String urlStr = 'https://api.themoviedb.org/3/movie/' + id + '/rating'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
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
