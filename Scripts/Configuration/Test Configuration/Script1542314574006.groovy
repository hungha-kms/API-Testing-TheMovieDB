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
import internal.GlobalVariable as GlobalVariable
import theMovieDB.TheMovieDBCommon as TheMovieDBCommon

response1 = WS.sendRequest(findTestObject('Configuration/Get API Configuration'))

TheMovieDBCommon.printDataValue(response1, 'Configuration/Get API Configuration')

response1 = WS.sendRequest(findTestObject('Configuration/Get Countries'))

TheMovieDBCommon.printDataValue(response1, 'Configuration/Get Countries')

response1 = WS.sendRequest(findTestObject('Configuration/Get Jobs'))

TheMovieDBCommon.printDataValue(response1, 'Configuration/Get Jobs')

response1 = WS.sendRequest(findTestObject('Configuration/Get Languages'))

TheMovieDBCommon.printDataValue(response1, 'Configuration/Get Languages')

response1 = WS.sendRequest(findTestObject('Configuration/Get Primary Translations'))

TheMovieDBCommon.printDataValue(response1, 'Configuration/Get Primary Translations')

response1 = WS.sendRequest(findTestObject('Configuration/Get Timezones'))

TheMovieDBCommon.printDataValue(response1, 'Configuration/Get Timezones')

