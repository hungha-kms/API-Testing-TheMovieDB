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
import theMovieDB.People
import theMovieDB.TheMovieDBCommon as TheMovieDBCommon

ResponseObject response1 = People.getPopular()
int personID = People.getRandomPerson(response1)
response1 = People.getMovieCredits(personID)

if (response1 != null) {
   	int resultSize = -1
	
	if (response1.getStatusCode() == 200){
		def slurper = new groovy.json.JsonSlurper()
		dataValue = slurper.parseText(response1.getResponseBodyContent())

		resultSize = (dataValue.cast.size() - 1)
	}
    if (resultSize >= 0) {
        i = ((Math.random() * resultSize) as int)
        response1 = Credits.getDetails(dataValue.cast[i].credit_id)

        TheMovieDBCommon.printDataValue(response1, 'Credits/Get Details')
		
    }else{
		println ("&&&&&&&&& No Credit &&&&&&&&&&&&")
    }
}else{
	println ("&&&&&&&&& No Movie Credit &&&&&&&&&&&&")
}


