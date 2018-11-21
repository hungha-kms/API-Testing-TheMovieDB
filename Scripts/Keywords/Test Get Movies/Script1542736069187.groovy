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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import internal.GlobalVariable as GlobalVariable
import theMovieDB.TheMovieDBCommon

response1 = WS.sendRequest(findTestObject('Search/Search Keywords'))

def slurper = new groovy.json.JsonSlurper()
def dataValue = slurper.parseText(response1.getResponseBodyContent())
int randomNumber = (int)(Math.random() * (dataValue.results.size()-1))
def keywordID = dataValue.results[randomNumber].id

RequestObject ro = new RequestObject('objectId')

String body = '{"dummyRequest":"yes"}'
String endpoint = 'https://api.themoviedb.org/3/keyword/'+keywordID+'/movies?'

endpoint = ((endpoint + 'api_key=') + GlobalVariable.apiKey)

ro.setRestUrl(endpoint)

ro.setRestRequestMethod('GET')

ro.setBodyContent(new HttpTextBodyContent(body))
ResponseObject respObj = WS.sendRequest(ro)


TheMovieDBCommon.printDataValue(respObj, 'Keyword/Get Movies')
	