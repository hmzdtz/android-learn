package com.hmzdtz.libandroidlearn.util

import android.util.Log

object LogUtil {
    private const val TAG_PREFIX = "hmzdtz"

    @JvmStatic
    fun v(tag: String?, msg: String): Int {
        return Log.v("$TAG_PREFIX-$tag", msg)
    }

    /**
     * Send a [.VERBOSE] log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun v(tag: String?, msg: String?, tr: Throwable?): Int {
        return Log.v("$TAG_PREFIX-$tag", msg, tr)
    }

    /**
     * Send a [.DEBUG] log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun d(tag: String?, msg: String): Int {
        return Log.d("$TAG_PREFIX-$tag", msg)
    }

    /**
     * Send a [.DEBUG] log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun d(tag: String?, msg: String?, tr: Throwable?): Int {
        return Log.d("$TAG_PREFIX-$tag", msg, tr)
    }

    /**
     * Send an [.INFO] log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun i(tag: String?, msg: String): Int {
        return Log.i("$TAG_PREFIX-$tag", msg)
    }

    /**
     * Send a [.INFO] log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     */
    @JvmStatic
    fun i(tag: String?, msg: String?, tr: Throwable?): Int {
        return Log.i("$TAG_PREFIX-$tag", msg, tr)
    }

    /**
     * Send a [.WARN] log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun w(tag: String?, msg: String): Int {
        return Log.w("$TAG_PREFIX-$tag", msg)
    }

    /**
     * Send a [.WARN] log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun w(tag: String?, msg: String?, tr: Throwable?): Int {
        return Log.w("$TAG_PREFIX-$tag", msg, tr)
    }

    /**
     * Send a [.WARN] log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param tr An exception to log.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun w(tag: String?, tr: Throwable?): Int {
        return Log.w("$TAG_PREFIX-$tag", tr)
    }

    /**
     * Send an [.ERROR] log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun e(tag: String?, msg: String): Int {
        return Log.e("$TAG_PREFIX-$tag", msg)
    }

    /**
     * Send a [.ERROR] log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun e(tag: String?, msg: String?, tr: Throwable?): Int {
        return Log.e("$TAG_PREFIX-$tag", msg, tr)
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen.
     * The error will always be logged at level ASSERT with the call stack.
     * Depending on system configuration, a report may be added to the
     * [android.os.DropBoxManager] and/or the process may be terminated
     * immediately with an error dialog.
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun wtf(tag: String?, msg: String?): Int {
        return Log.wtf("$TAG_PREFIX-$tag", msg)
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to [.wtf], with an exception to log.
     * @param tag Used to identify the source of a log message.
     * @param tr An exception to log.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun wtf(tag: String?, tr: Throwable): Int {
        return Log.wtf("$TAG_PREFIX-$tag", tr)
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to [.wtf], with a message as well.
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.  May be null.
     * @return A positive value if the message was loggable (see [.isLoggable]).
     */
    @JvmStatic
    fun wtf(tag: String?, msg: String?, tr: Throwable?): Int {
        return Log.wtf("$TAG_PREFIX-$tag", msg, tr)
    }

    /**
     * Handy function to get a loggable stack trace from a Throwable
     *
     *
     * If any of the throwables in the cause chain is an `UnknownHostException`,
     * this returns an empty string.
     * @param tr An exception to log.
     */
    @JvmStatic
    fun getStackTraceString(tr: Throwable?): String {
        return Log.getStackTraceString(tr)
    }
}
