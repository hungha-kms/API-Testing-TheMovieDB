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

	public static ResponseObject getExternalIDs(int id){
		RequestObject reqObj = findTestObject('People/Get Images')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id + '/external_ids'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getImages(int id){
		RequestObject reqObj = findTestObject('People/Get Images')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id + '/images'
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

	public static ResponseObject getTaggedImages(int id){
		RequestObject reqObj = findTestObject('People/Get Tagged Images')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id + '/tagged_images'
		reqObj.setRestUrl(urlStr)
		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}

	public static ResponseObject getTranslations(int id){
		RequestObject reqObj = findTestObject('People/Get Translations')
		String urlStr = 'https://api.themoviedb.org/3/person/' + id + '/translations'
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

	public static ResponseObject getRandomReview(ResponseObject resObj){
		ResponseObject response1 = null
		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(resObj.getResponseBodyContent())
		int resultSize = dataValue.results.size() - 1

		if (resultSize >= 0) {
			int i = ((Math.random() * resultSize) as int)

			int reviewID = dataValue.results[i].id
			String mediaType = dataValue.results[i].media_type

			if (mediaType == "movie")
				response1 = Movie.getReviews(reviewID)
			else
				response1 = TVShow.getReviews(reviewID)
		}
		return response1
	}

	public static int getRandomPerson(ResponseObject resObj){
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

	public static PeopleData getRandomMediaID(ResponseObject resObj){
		PeopleData data = new PeopleData()
		def slurper = new groovy.json.JsonSlurper()
		def dataValue = slurper.parseText(resObj.getResponseBodyContent())

		if (dataValue.results == null)
			return null

		int resultSize = dataValue.results.size() - 1

		if (resultSize >= 0) {
			int i = ((Math.random() * resultSize) as int)
			resultSize = dataValue.results[i].known_for.size() - 1
			if (resultSize >= 0){
				i = ((Math.random() * resultSize) as int)
				if (dataValue.results[i].known_for[i].media_type == "tv")
					data.isMovie = false
				data.mediaID = dataValue.results[i].known_for[i].id
			}

			return data
		}
		return null
	}
}
