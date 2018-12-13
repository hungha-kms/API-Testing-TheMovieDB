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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import theMovieDB.Credits
import theMovieDB.Movie
import theMovieDB.Reviews
import theMovieDB.TVSeasons
import theMovieDB.TVShow
import theMovieDB.TheMovieDBCommon as TheMovieDBCommon

ResponseObject response1 = TVShow.getTVAiringToday()

int TVID = TVShow.getRandomTV(response1)
response1 = TVShow.getDetails(TVID)
int seasonNo = TVShow.getRandomSeason(response1)
response1 = TVSeasons.getExternalIDs(TVID, seasonNo)

TheMovieDBCommon.printDataValue(response1, 'TV Seasons/Get External IDs for TVID: '+ TVID + "; season Number: "+ seasonNo)

