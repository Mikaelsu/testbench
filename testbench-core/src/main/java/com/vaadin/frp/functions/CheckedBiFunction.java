package com.vaadin.frp.functions;

import static com.vaadin.frp.ExceptionFunctions.message;

import java.util.function.BiFunction;

import com.vaadin.frp.model.Result;

/**
 *
 */
public interface CheckedBiFunction<T1, T2, R> extends BiFunction<T1, T2, Result<R>> {
  @Override
  default Result<R> apply(T1 t1 , T2 t2) {
    try {
      return Result.success(applyWithException(t1, t2));
    } catch (Exception e) {
      return Result.failure(message().apply(e));
    }
  }

  R applyWithException(T1 t1 , T2 t2) throws Exception;

}