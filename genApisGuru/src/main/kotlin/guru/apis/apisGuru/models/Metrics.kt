/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package guru.apis.apisGuru.models

import guru.apis.apisGuru.models.MetricsThisWeek

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * List of basic metrics
 *
 * @param numSpecs Number of API definitions including different versions of the same API
 * @param numAPIs Number of unique APIs
 * @param numEndpoints Total number of endpoints inside all definitions
 * @param unreachable Number of unreachable (4XX,5XX status) APIs
 * @param invalid Number of newly invalid APIs
 * @param unofficial Number of unofficial APIs
 * @param fixes Total number of fixes applied across all APIs
 * @param fixedPct Percentage of all APIs where auto fixes have been applied
 * @param datasets Data used for charting etc
 * @param stars GitHub stars for our main repo
 * @param issues Open GitHub issues on our main repo
 * @param thisWeek 
 * @param numDrivers Number of methods of API retrieval
 * @param numProviders Number of API providers in directory
 */


data class Metrics (

    /* Number of API definitions including different versions of the same API */
    @get:JsonProperty("numSpecs")
    val numSpecs: kotlin.Int,

    /* Number of unique APIs */
    @get:JsonProperty("numAPIs")
    val numAPIs: kotlin.Int,

    /* Total number of endpoints inside all definitions */
    @get:JsonProperty("numEndpoints")
    val numEndpoints: kotlin.Int,

    /* Number of unreachable (4XX,5XX status) APIs */
    @get:JsonProperty("unreachable")
    val unreachable: kotlin.Int? = null,

    /* Number of newly invalid APIs */
    @get:JsonProperty("invalid")
    val invalid: kotlin.Int? = null,

    /* Number of unofficial APIs */
    @get:JsonProperty("unofficial")
    val unofficial: kotlin.Int? = null,

    /* Total number of fixes applied across all APIs */
    @get:JsonProperty("fixes")
    val fixes: kotlin.Int? = null,

    /* Percentage of all APIs where auto fixes have been applied */
    @get:JsonProperty("fixedPct")
    val fixedPct: kotlin.Int? = null,

    /* Data used for charting etc */
    @get:JsonProperty("datasets")
    val datasets: kotlin.collections.List<kotlin.Any>? = null,

    /* GitHub stars for our main repo */
    @get:JsonProperty("stars")
    val stars: kotlin.Int? = null,

    /* Open GitHub issues on our main repo */
    @get:JsonProperty("issues")
    val issues: kotlin.Int? = null,

    @get:JsonProperty("thisWeek")
    val thisWeek: MetricsThisWeek? = null,

    /* Number of methods of API retrieval */
    @get:JsonProperty("numDrivers")
    val numDrivers: kotlin.Int? = null,

    /* Number of API providers in directory */
    @get:JsonProperty("numProviders")
    val numProviders: kotlin.Int? = null

) {


}

