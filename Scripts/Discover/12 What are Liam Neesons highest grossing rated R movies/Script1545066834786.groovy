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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import theMovieDB.TheMovieDBCommon

RequestObject reqObj = findTestObject('Discover/Movie Discover')

List<TestObjectProperty> params = new ArrayList()
params.add(new TestObjectProperty('api_key', ConditionType.EQUALS, GlobalVariable.apiKey))
params.add(new TestObjectProperty('certification_country', ConditionType.EQUALS, "US"))
params.add(new TestObjectProperty('certification', ConditionType.EQUALS, 'R'))
params.add(new TestObjectProperty('sort_by', ConditionType.EQUALS, "revenue.desc"))
params.add(new TestObjectProperty('with_cast', ConditionType.EQUALS, "3896"))
reqObj.setRestParameters(params)
ResponseObject resObj = WS.sendRequest(reqObj)

TheMovieDBCommon.printDataValue(resObj, "What are Liam Neeson's highest grossing rated 'R' movies")

WS.verifyElementPropertyValue(resObj, 'results[17].title', 'Next of Kin')