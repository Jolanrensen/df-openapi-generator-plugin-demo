import guru.apis.apisGuru.apis.APIsApi
import kotlinx.coroutines.runBlocking
import org.jetbrains.kotlinx.dataframe.annotations.DisableInterpretation
import org.jetbrains.kotlinx.dataframe.api.NameValuePair
import org.jetbrains.kotlinx.dataframe.api.explode
import org.jetbrains.kotlinx.dataframe.api.filter
import org.jetbrains.kotlinx.dataframe.api.inferType
import org.jetbrains.kotlinx.dataframe.api.into
import org.jetbrains.kotlinx.dataframe.api.name
import org.jetbrains.kotlinx.dataframe.api.print
import org.jetbrains.kotlinx.dataframe.api.rename
import org.jetbrains.kotlinx.dataframe.api.toDataFrame
import org.jetbrains.kotlinx.dataframe.api.unfold
import org.jetbrains.kotlinx.dataframe.api.value
import kotlin.collections.map

fun main() {
    val api = APIsApi() // the auto-generated API

    // let's first get all providers by google
    val allProviders = runBlocking {
        api
            .getProviders() // one of the API endpoints, auto-generated as a typed function with KDocs!
            .body()
    }.data!!

    val googleProviders = allProviders
        .toDataFrame()
        .filter { "google" in value }

    googleProviders.print(borders = true, title = true, columnTypes = true)

    // then get all services related to google's providers
    val allServices = runBlocking {
        googleProviders.value.values().associateWith {
            api
                .getServices(provider = it)
                .body()
        }
    }
        .map { NameValuePair(it.key, it.value.data!!) }
        .let { @DisableInterpretation it.toDataFrame() }.inferType()

        .rename { name }.into("provider")
        .rename { value }.into("services")

        .explode { services }
        .rename { services }.into("service")
        .filter { service.isNotBlank() }

    allServices.print(borders = true, title = true, columnTypes = true, valueLimit = Int.MAX_VALUE)


    val apis = runBlocking {
        api
            .listAPIs()
            .body()
    }.map { NameValuePair(it.key, it.value) }
        .let { @DisableInterpretation it.toDataFrame() }.inferType()
        .rename { value }.into("apis")
        .unfold { apis }

    apis.print(borders = true, title = true, columnTypes = true)
}

