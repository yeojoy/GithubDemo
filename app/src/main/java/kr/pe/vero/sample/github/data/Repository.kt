package kr.pe.vero.sample.github.data

import android.os.Bundle

/**
 * @author vero
 * @since 2017. 10. 18.
 */
abstract class Repository<T> {

    abstract fun get(params: Bundle?): T

}