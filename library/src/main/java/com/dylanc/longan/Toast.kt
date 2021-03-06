@file:Suppress("unused")

package com.dylanc.longan

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import me.drakeet.support.toast.ToastCompat

/**
 * @author Dylan Cai
 */

inline fun toast(text: CharSequence?, duration: Int = Toast.LENGTH_SHORT, block: Toast.() -> Unit = {}): Toast =
  topActivity.toast(text, duration, block)

inline fun toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT, block: Toast.() -> Unit = {}): Toast =
  topActivity.toast(resId, duration, block)

inline fun longToast(text: CharSequence?, block: Toast.() -> Unit = {}): Toast =
  topActivity.longToast(text, block)

inline fun longToast(@StringRes resId: Int, block: Toast.() -> Unit = {}): Toast =
  topActivity.longToast(resId, block)

inline fun Context.toast(text: CharSequence?, duration: Int = Toast.LENGTH_SHORT, block: Toast.() -> Unit = {}): Toast =
  ToastCompat.makeText(context, text, duration).apply(block).apply { show() }

inline fun Context.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT, block: Toast.() -> Unit = {}): Toast =
  ToastCompat.makeText(context, getString(resId), duration).apply(block).apply { show() }

inline fun Context.longToast(text: CharSequence?, block: Toast.() -> Unit = {}): Toast =
  ToastCompat.makeText(context, text, Toast.LENGTH_LONG).apply(block).apply { show() }

inline fun Context.longToast(@StringRes resId: Int, block: Toast.() -> Unit = {}): Toast =
  ToastCompat.makeText(context, getString(resId), Toast.LENGTH_LONG).apply(block).apply { show() }