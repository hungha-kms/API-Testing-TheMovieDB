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
import theMovieDB.Lists
import theMovieDB.Movie
import theMovieDB.TheMovieDBCommon as TheMovieDBCommon

response1 = WS.sendRequest(findTestObject('Movies/Get Popular'))

int movieID = Movie.getRandomMovie(response1)

if (movieID != -1) {

    response1 = Movie.getLists(movieID)

    TheMovieDBCommon.printDataValue(response1, 'Movies/Get Lists')

    int listID = Movie.getRandomMovie(response1)

	if (listID != -1) {
        
        response1 = Lists.getDetails(listID)

        TheMovieDBCommon.printDataValue(response1, 'Lists/Get Details')
        
    }else{
	println ("&&&&&&&&& No List &&&&&&&&&&&&")
    }
}else{
	println ("&&&&&&&&& No Movie &&&&&&&&&&&&")
}

//response1 = WS.sendRequest(findTestObject('Reviews/Get Details'))

