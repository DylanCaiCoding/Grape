@file:Suppress("unused", "NOTHING_TO_INLINE", "FunctionName")

package com.dylanc.grape

/**
 * @author Dylan Cai
 */

interface Logger {
  val loggerTag: String get() = TAG
}

inline fun Logger(tag: String): Logger = object : Logger {
  override val loggerTag: String get() = tag
}

/**
 * Returns the simple class name.
 */
inline val Any.TAG: String
  get() {
    val tag = javaClass.simpleName
    return if (tag.length <= 23) tag else tag.substring(0, 23)
  }

typealias Log = com.orhanobut.logger.Logger

inline fun Logger.logVerbose(message: String) = Log.t(loggerTag).v(message)

inline fun Logger.logDebug(message: String) = Log.t(loggerTag).d(message)

inline fun Logger.logInfo(message: String) = Log.t(loggerTag).i(message)

inline fun Logger.logWarn(message: String) = Log.t(loggerTag).w(message)

inline fun Logger.logError(message: String) = Log.t(loggerTag).e(message)

inline fun Logger.logJson(json: String) = Log.t(loggerTag).json(json)

inline fun Logger.logXml(content: String) = Log.t(loggerTag).xml(content)

inline fun logVerbose(message: String) = Log.v(message)

inline fun logDebug(message: String) = Log.d(message)

inline fun logInfo(message: String) = Log.i(message)

inline fun logWarn(message: String) = Log.w(message)

inline fun logError(message: String) = Log.e(message)

inline fun logJson(json: String) = Log.json(json)

inline fun logXml(content: String) = Log.xml(content)