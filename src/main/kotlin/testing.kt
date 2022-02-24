import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL


fun main() {
    println("Program executing.");
    sendRequest();
    println("Program has finished executing.");
}

private fun sendRequest() {
    val targetURL = getEnvironmentVariable("TARGET_URL");
    val url = URL(targetURL)
    val httpCon = url.openConnection() as HttpURLConnection
    httpCon.doOutput = true
    httpCon.requestMethod = "POST"
    val out = OutputStreamWriter(
        httpCon.outputStream
    )
    println(httpCon.responseCode)
    println(httpCon.responseMessage)
    out.close()
}

private fun getEnvironmentVariable(variableName: String):String {
    val environmentVariable: String = System.getenv(variableName) ?: "";
    if (environmentVariable == "") {
        println("Something went wrong retrieving an environment variable.");
        return "";
    }
    return environmentVariable;
}