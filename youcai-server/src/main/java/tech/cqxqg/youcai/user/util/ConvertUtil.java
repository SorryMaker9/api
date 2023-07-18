package tech.cqxqg.youcai.user.util;


import org.apache.commons.lang3.StringUtils;
import tech.cqxqg.youcai.user.constants.MultipleConstants;
import tech.cqxqg.youcai.user.constants.StockConstants;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 金额字段的转换
 */
public class ConvertUtil {

    /**
     * 排除字段
     */
    private static final Set<String> EXCLUDED_PROPERTIES = new HashSet();
    /**
     * 转换因子
     */
    private static final Map<String, BigDecimal> MULTIPLY_FACTORY = new HashMap();


    static {
        EXCLUDED_PROPERTIES.add("id");
        EXCLUDED_PROPERTIES.add("userId");
        EXCLUDED_PROPERTIES.add("securitiesFirmId");
        EXCLUDED_PROPERTIES.add("logo");
        EXCLUDED_PROPERTIES.add("customName");
        EXCLUDED_PROPERTIES.add("isDefault");
        EXCLUDED_PROPERTIES.add("hasShenzhenFee");
        EXCLUDED_PROPERTIES.add("hasShanghaiFee");
        EXCLUDED_PROPERTIES.add("countSecurities");
        EXCLUDED_PROPERTIES.add("countStocks");
        EXCLUDED_PROPERTIES.add("countFloorFunds");
        EXCLUDED_PROPERTIES.add("status");
        EXCLUDED_PROPERTIES.add("createdTime");
        EXCLUDED_PROPERTIES.add("updatedTime");
        EXCLUDED_PROPERTIES.add("countUsers");
    }

    static {
        MULTIPLY_FACTORY.put("stockMinFee", MultipleConstants.ONE_HUNDRED);
        MULTIPLY_FACTORY.put("stockCommissionRate", MultipleConstants.TEN_THOUSAND);
        MULTIPLY_FACTORY.put("fundMinFee", MultipleConstants.ONE_HUNDRED);
        MULTIPLY_FACTORY.put("fundCommissionRate", MultipleConstants.TEN_THOUSAND);
        MULTIPLY_FACTORY.put("financingDayRate", MultipleConstants.TEN_THOUSAND);
        MULTIPLY_FACTORY.put("investedAll", MultipleConstants.ONE_HUNDRED);
        MULTIPLY_FACTORY.put("investedCash", MultipleConstants.ONE_HUNDRED);
        MULTIPLY_FACTORY.put("investedFinancing", MultipleConstants.ONE_HUNDRED);
        MULTIPLY_FACTORY.put("investedLoans", MultipleConstants.ONE_HUNDRED);
        MULTIPLY_FACTORY.put("financingYearRate", MultipleConstants.TEN_THOUSAND);
        MULTIPLY_FACTORY.put("floorFundMinRate", MultipleConstants.ONE_HUNDRED);
    }

    public static <E, R> void convertProperties(E source, R destination) {
        String name = destination.getClass().getName();
        if (!StringUtils.isBlank(name)) {
            try {
                if (name.contains(StockConstants.TARGET_ENTITY)) {
                    //转换数据存入到数据库
                    convertToDB(source, destination);
                } else {
                    //转换数据展示前端
                    convertToDTO(source, destination);
                }
            } catch (IllegalAccessException var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    /**
     *  数据库转前端
     * @param source 数据库实体
     * @param destination 接收前端数据实体
     */
    private static <E, R> void convertToDTO(E source, R destination) throws IllegalAccessException {

        Field[] sourceFields = source.getClass().getDeclaredFields();

        Field[] destFields = destination.getClass().getDeclaredFields();


        for (Field sourceField : sourceFields) {

            String fieldName = sourceField.getName();

            if (EXCLUDED_PROPERTIES.contains(fieldName)){
                //跳过不需要转换的字段
                continue;
            }

            for (Field destField : destFields) {

                if (!fieldName.equals(destField.getName())){
                    continue;
                }

                sourceField.setAccessible(true);

                destField.setAccessible(true);

                Object value = sourceField.get(source);

                if (value instanceof Integer) {
                    destField.set(destination, convertAndDivide((Integer)value, MULTIPLY_FACTORY.get(fieldName)));
                }
                break;
            }
        }


    }

    /**
     *  前端转数据库
     * @param source 接收前端数据实体
     * @param destination 数据库实体
     */
    private static <E, R> void convertToDB(E source, R destination) throws IllegalAccessException {
        Field[] sourceFields = source.getClass().getDeclaredFields();

        Field[] destFields = destination.getClass().getDeclaredFields();


        for (Field sourceField : sourceFields) {

            String fieldName = sourceField.getName();

            if (EXCLUDED_PROPERTIES.contains(fieldName)){
                //跳过不需要转换的字段
                continue;
            }

            for (Field destField : destFields) {

                if (!fieldName.equals(destField.getName())){
                    continue;
                }

                sourceField.setAccessible(true);

                destField.setAccessible(true);

                Object value = sourceField.get(source);

                if (value instanceof BigDecimal) {
                    destField.set(destination, convertAndMultiply((BigDecimal) value, MULTIPLY_FACTORY.get(fieldName)));
                }
                break;
            }
        }

    }

    /**
     * 缩小倍数
     * @param value 数据库字段值
     * @param divisor 倍数
     * @return
     */
    private static BigDecimal convertAndDivide(Integer value, BigDecimal divisor) {

        if (value != null && divisor != null) {
            BigDecimal decimal = new BigDecimal(value);
            return decimal.divide(divisor);
        }

        return new BigDecimal(value);
    }

    /**
     * 扩大倍数
     * @param value 数据库字段值
     * @param multiplier 倍数
     * @return
     */
    private static Integer convertAndMultiply(BigDecimal value, BigDecimal multiplier) {

        if (value != null && multiplier != null){
            return value.multiply(multiplier).intValue();
        }

        return value.intValue();
    }

}
