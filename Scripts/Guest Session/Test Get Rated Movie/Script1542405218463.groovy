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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import theMovieDB.TheMovieDBCommon as TheMovieDBCommon

//Get Guest
String guestSessionID = TheMovieDBCommon.getGuestSessionID()

//String guestSessionID = "63c7980fa786c1e254b0c5a0feb74467"
println('********* Guest session id: ' + guestSessionID)

RequestObject reqObj = findTestObject('Movies/Rate Movie')

List<TestObjectProperty> params = new ArrayList()
params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))
params.add(new TestObjectProperty("guest_session_id",ConditionType.EQUALS, GlobalVariable.guestSessionID))
reqObj.setRestParameters(params)

//reqObj.setRestUrl(urlStr)

ResponseObject resp = WS.sendRequest(reqObj)
TheMovieDBCommon.printDataValue(resp, 'Movies/Rate Movie')

RequestObject reqObj1 = findTestObject('GuestSession/Get Rated Movie')

String urlStr = 'https://api.themoviedb.org/3/guest_session/' + GlobalVariable.guestSessionID + '/rated/movie'

reqObj1.setRestUrl(urlStr)

params = new ArrayList()
params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))
//params.add(new TestObjectProperty("guest_session_id",ConditionType.EQUALS, guestSessionID))
reqObj1.setRestParameters(params)

resp = WS.sendRequest(reqObj1)

TheMovieDBCommon.printDataValue(resp, 'GuestSession/Get Rated Movie')

WS.verifyElementPropertyValue(resp, 'results[0].id', '21')