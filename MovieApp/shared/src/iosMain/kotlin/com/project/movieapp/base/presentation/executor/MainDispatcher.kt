package com.project.movieapp.base.presentation.executor

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.Foundation.NSRunLoop
import platform.Foundation.performBlock

actual class MainDispatcher {
    actual val dispatcher: CoroutineDispatcher = MainLoopDispatcher
}

object MainLoopDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        NSRunLoop.mainRunLoop().performBlock { block.run() }
    }
}