package theMovieDB

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.eclipse.persistence.internal.oxm.record.json.JSONParser.value_return

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

public class Search {

	public static ResponseObject multiSearch(){
		return null
	}

	public static ResponseObject searchCompanies(){
		return null
	}

	public static ResponseObject searchCollection(){
		return null
	}

	public static ResponseObject searchKeywords(){
		return null
	}

	public static ResponseObject searchMovies(String queryString){
		RequestObject reqObj = findTestObject('Search/Search Movies')
		String urlStr = 'https://api.themoviedb.org/3/search/movie'
		reqObj.setRestUrl(urlStr)

		List<TestObjectProperty> params = new ArrayList()
		params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
		String[] queryStringArray = queryString.split('&')
		
		for (String values : queryStringArray){
			String[] valuesArray = values.split('=')
			params.add(new TestObjectProperty(valuesArray[0], ConditionType.EQUALS, valuesArray[1]))
		}

		reqObj.setRestParameters(params)
		return WS.sendRequest(reqObj)
	}
	
	// return -1 if getting no movie
	public static int getRandomMovieAterSearching(String querySearch){
		ResponseObject resObj = searchMovies(querySearch)
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

	public static ResponseObject searchPeople(){
		return null
	}

	public static ResponseObject searchTVShows(){
		return null
	}
}
