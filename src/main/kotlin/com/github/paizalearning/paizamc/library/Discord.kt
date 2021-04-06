package com.github.paizalearning.paizamc.library;

import com.github.kittinunf.fuel.Fuel

class Discord {
    fun sendMessage(s: String) {
        val url = "https://discord.com/api/webhooks/..."
        val body = "{\"content\": \"$s\"}"
        Fuel.post(url).header(hashMapOf("Content-Type" to "application/json")).body(body).responseString { _, response, result ->
            result.fold({ _ ->
                // print(response.toString())
            }, { err ->
                print(err.toString())
            })
        }
    }
}
