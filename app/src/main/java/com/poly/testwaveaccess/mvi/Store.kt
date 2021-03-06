package com.poly.testwaveaccess.mvi

import com.poly.testwaveaccess.common.Logger
import javax.inject.Inject

open class Store<S: State, W: Wish, E: Effect, N: News> @Inject constructor(
    val logger: Logger
) {
    lateinit var actor: Actor<S, W, E>
    lateinit var reducer: Reducer<S, E, N>
}