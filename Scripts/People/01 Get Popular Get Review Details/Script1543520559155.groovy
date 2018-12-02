import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import theMovieDB.Movie
import theMovieDB.TheMovieDBCommon as TheMovieDBCommon

response1 = WS.sendRequest(findTestObject('People/Get Popular'))

def slurper = new groovy.json.JsonSlurper()

def dataValue = slurper.parseText(response1.getResponseBodyContent())

int resultSize = dataValue.results.size() - 1

if (resultSize >= 0) {
    int i = ((Math.random() * resultSize) as int)

    RequestObject reqObj = findTestObject('Movies/Get Reviews')

    String urlStr = ('https://api.themoviedb.org/3/movie/' + dataValue.results[i].id) + '/reviews'

    reqObj.setRestUrl(urlStr)

    println('************* Movies/Get Reviews URL: ' + urlStr)

    List<TestObjectProperty> params = new ArrayList()

    params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))

    reqObj.setRestParameters(params)

    response1 = WS.sendRequest(reqObj)

    TheMovieDBCommon.printDataValue(response1, 'Movies/Get Reviews')
	TheMovieDBCommon.printDataValue(Movie.getAccountStates(dataValue.results[i].id), 'Movie/Get Account States')
	resultSize = -1
	
	if (response1.getStatusCode() == 200){

		dataValue = slurper.parseText(response1.getResponseBodyContent())

		resultSize = (dataValue.results.size() - 1)
	}
    if (resultSize >= 0) {
        i = ((Math.random() * resultSize) as int)

        reqObj = findTestObject('Reviews/Get Details')

        urlStr = ('https://api.themoviedb.org/3/review/' + dataValue.results[i].id)

        reqObj.setRestUrl(urlStr)

        println('************* Reviews/Get Details URL: ' + urlStr)

        params = new ArrayList()

        params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))

        reqObj.setRestParameters(params)

        response1 = WS.sendRequest(reqObj)

        TheMovieDBCommon.printDataValue(response1, 'Reviews/Get Details')
		
    }else{
	println ("&&&&&&&&& No review &&&&&&&&&&&&")
    }
}else{
	println ("&&&&&&&&& No Now Play Movie &&&&&&&&&&&&")
}

//response1 = WS.sendRequest(findTestObject('Reviews/Get Details'))

