package com.findmoreplus.common.exception;

import lombok.SneakyThrows;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

public class Assert {
    @SneakyThrows
    public static void isTrue(boolean expression, String msg) {
        if (expression) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isFalse(boolean expression, String msg) {
        if (!expression) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isNotBlank(String str, String msg) {
        if (StringUtils.hasText(str)) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isBlank(String str, String msg) {
        if (!StringUtils.hasText(str)) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isNotEmpty(Object[] str, String msg) {
        if (!ObjectUtils.isEmpty(str)) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isNotEmpty(Collection collection, String msg) {
        if (!CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isEmpty(Collection collection, String msg) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isNotEmpty(Map map, String msg) {
        if (!CollectionUtils.isEmpty(map)) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isNotNull(Object object, String msg) {
        if (object != null) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isNull(Object object, String msg) {
        if (object == null) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void isNotNull(Object[] objects, String msg) {
        if (!ObjectUtils.isEmpty(objects)) {
            throw new BusinessException(msg);
        }
    }

    @SneakyThrows
    public static void equals(Object obj1, Object obj2, String msg) {
        if (equals(obj1, obj2)) {
            throw new BusinessException(msg);
        }
    }

    //比较对象的相等
    public static boolean equals(final Object cs1, final Object cs2) {
        if (cs1 == cs2) {
            return true;
        }
        if (null == cs1||cs2==null) {
            return false;
        }
        if (cs1 instanceof String && cs2 instanceof String) {
            return cs1.equals(cs2);
        }
        return cs1.equals(cs2);
    }
}
