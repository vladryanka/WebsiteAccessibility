import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.*

suspend fun checkWebsite(url: String): Boolean = withContext(Dispatchers.IO) {
    try {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "HEAD"
        connection.connectTimeout = 5000
        connection.readTimeout = 5000
        connection.responseCode == HttpURLConnection.HTTP_OK
        true
    } catch (e: Exception) {
        false
    }
}

fun main(args: Array<String>) {
    runBlocking {
        val urlList = listOf(
            "https://www.google.com",
            "https://www.facebook.com",
            "https://www.github.com",
            "https://www.twitter.com",
            "https://www.instagram.com",
            "https://teach.vibelab.ru",
            "https://kotlinlang.org",
            "https://www.RuTracker.org",
            "https://vk.com",
            "https://vec.etu.ru"
        )
        val jobs = urlList.map { url ->
            GlobalScope.launch {
                if (checkWebsite(url))
                    println("Сайт [" + url + "] доступен")
                else println("Сайт [" + url + "] недоступен")
            }
        }

        jobs.forEach { it.join() }
    }

}

