import java.net.URL

fun main() {
    println("Program executing.");

    sendRequest();

    println("Program has finished executing.");
}

private fun sendRequest() {
    val url = getEnvironmentVariable("TARGET_URL");
    val response = try {
        URL(url)
                .openStream()
                .bufferedReader()
                .use {
                    it.readText()
                }
    }
    catch(e: Exception) {
        println("Something went wrong sending a request.");
        return;
    }
    println(response);
}

private fun getEnvironmentVariable(variableName: String):String {
    val environmentVariable: String = System.getenv(variableName) ?: "";
    if (environmentVariable.equals("")) {
        println("Something went wrong retrieving an environment variable.");
        return "";
    }
    return environmentVariable;
}