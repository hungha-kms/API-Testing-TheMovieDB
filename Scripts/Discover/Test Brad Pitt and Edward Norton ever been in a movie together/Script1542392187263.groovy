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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObjectProperty
import theMovieDB.TheMovieDBCommon

RequestObject reqObj = findTestObject('Discover/Movie Discover')

List<TestObjectProperty> params = new ArrayList()
//params.add(new TestObjectProperty("api_key",ConditionType.EQUALS, GlobalVariable.apiKey))
params.add(new TestObjectProperty("with_genres",ConditionType.EQUALS, "18"))
params.add(new TestObjectProperty("sort_by",ConditionType.EQUALS, "vote_average.desc"))
params.add(new TestObjectProperty("vote_count.gte",ConditionType.EQUALS, "10"))
reqObj.setRestParameters(params)

String myStr = reqObj.getRestUrl()

//println("************ my URL: "+ myStr)


ResponseObject response1 = WS.sendRequest(reqObj)

TheMovieDBCommon.printDataValue(response1, "Discover/Movie Discover")


