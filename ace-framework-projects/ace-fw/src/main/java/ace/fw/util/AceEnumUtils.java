package ace.fw.util;

import ace.fw.enums.BaseEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/3 18:25
 * @description
 */
public final class AceEnumUtils {
    public static <T, E extends BaseEnum<T>> E getEnum(Class<E> enumClass, T code) {
        List<E> enumConstants = new ArrayList(Arrays.asList(enumClass.getEnumConstants()));
        E enumConstant = enumConstants.stream()
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .orElse(null);
        if (Objects.isNull(enumConstant)) {
            throw new IllegalArgumentException(enumClass.getName() + ",没有对应的code:" + code);
        }
        return enumConstant;
    }
}
