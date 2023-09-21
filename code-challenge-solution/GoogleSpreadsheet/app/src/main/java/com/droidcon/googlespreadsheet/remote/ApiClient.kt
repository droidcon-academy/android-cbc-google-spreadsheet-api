package com.droidcon.googlespreadsheet.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
	private const val BASE_URL = "https://sheets.googleapis.com/v4/spreadsheets/"

	private lateinit var retrofit: Retrofit
	private val client: Retrofit
		get() {
			val interceptor = HttpLoggingInterceptor()
			interceptor.level = HttpLoggingInterceptor.Level.BODY
			val client = OkHttpClient.Builder()
				.addInterceptor(interceptor)
				.connectTimeout(2, TimeUnit.MINUTES)
				.readTimeout(2, TimeUnit.MINUTES)
				.build()

			retrofit = Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(client)
				.build()

			return retrofit
		}

	val retrofitService: ApiInterface = client.create(ApiInterface::class.java)
}