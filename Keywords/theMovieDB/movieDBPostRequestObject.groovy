package theMovieDB
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS


class movieDBPostRequestObject {
	
	String endpoint = "https://api.themoviedb.org"
	String requestMethod = “POST "
	/**
	* POST requests
	* @return
	*/
	public ResponseObject buildPostApiRequest1() {
		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}
	public ResponseObject buildPostApiRequest2() {
		RequestObject ro = new RestRequestObjectBuilder()
		.withRestUrl(endpoint)
		.withHttpHeaders(defaultHeaders)
		.withRestRequestMethod("POST")
		.withTextBodyContent(body)
		.build()
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}
}