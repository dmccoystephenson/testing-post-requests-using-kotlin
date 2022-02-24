import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL


fun main() {
    println("Executing...");
    sendRequest();
    println("Program has finished executing.");
}

private fun sendRequest() {
    println("Setting up http connection...");
    val targetURL = getEnvironmentVariable("TARGET_URL");
    val url = URL(targetURL)
    val httpCon = url.openConnection() as HttpURLConnection
    httpCon.doOutput = true
    httpCon.requestMethod = "POST"

    println("Instantiating OutputStreamWriter...")
    val out = OutputStreamWriter(
        httpCon.outputStream
    )

    // TODO: something here?

    println("\n=== Response ===")
    println("Code: " + httpCon.responseCode)
    println("Message: " + httpCon.responseMessage)
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