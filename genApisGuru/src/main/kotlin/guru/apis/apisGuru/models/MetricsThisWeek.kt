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


import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Summary totals for the last 7 days
 *
 * @param added APIs added in the last week
 * @param updated APIs updated in the last week
 */


data class MetricsThisWeek (

    /* APIs added in the last week */
    @get:JsonProperty("added")
    val added: kotlin.Int? = null,

    /* APIs updated in the last week */
    @get:JsonProperty("updated")
    val updated: kotlin.Int? = null

) {


}

