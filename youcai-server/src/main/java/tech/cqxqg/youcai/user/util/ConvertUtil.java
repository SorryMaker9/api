package tech.cqxqg.youcai.user.util;


import org.apache.commons.lang3.StringUtils;
import tech.cqxqg.youcai.user.constants.MultipleConstants;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConvertUtil {



    private static final Set<String> EXCLUDED_PROPERTIES = new HashSet();
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
        EXCLUDED_PROPERTIES.add("createTime");
        EXCLUDED_PROPERTIES.add("updateTime");
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
                if (name.contains("persistence.entity")) {
                    convertToDB(source, destination);
                } else {
                    convertToDTO(source, destination);
                }
            } catch (IllegalAccessException var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    private static <E, R> void convertToDTO(E source, R destination) throws IllegalAccessException {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] destFields = destination.getClass().getDeclaredFields();
        Field[] var4 = sourceFields;
        int var5 = sourceFields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field sourceField = var4[var6];
            String fieldName = sourceField.getName();
            if (!EXCLUDED_PROPERTIES.contains(fieldName)) {
                Field[] var9 = destFields;
                int var10 = destFields.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    Field destField = var9[var11];
                    if (fieldName.equals(destField.getName())) {
                        sourceField.setAccessible(true);
                        destField.setAccessible(true);
                        Object value = sourceField.get(source);
                        if (value instanceof Integer) {
                            destField.set(destination, convertAndDivide((Integer)value, (BigDecimal)MULTIPLY_FACTORY.get(fieldName)));
                        }
                        break;
                    }
                }
            }
        }

    }

    private static <E, R> void convertToDB(E source, R destination) throws IllegalAccessException {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] destFields = destination.getClass().getDeclaredFields();
        Field[] var4 = sourceFields;
        int var5 = sourceFields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field sourceField = var4[var6];
            String fieldName = sourceField.getName();
            if (!EXCLUDED_PROPERTIES.contains(fieldName)) {
                Field[] var9 = destFields;
                int var10 = destFields.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    Field destField = var9[var11];
                    if (fieldName.equals(destField.getName())) {
                        sourceField.setAccessible(true);
                        destField.setAccessible(true);
                        Object value = sourceField.get(source);
                        if (value instanceof BigDecimal) {
                            destField.set(destination, convertAndMultiply((BigDecimal)value, (BigDecimal)MULTIPLY_FACTORY.get(fieldName)));
                        }
                        break;
                    }
                }
            }
        }

    }

    private static BigDecimal convertAndDivide(Integer value, BigDecimal divisor) {
        if (value != null && divisor != null) {
            BigDecimal decimal = new BigDecimal(value);
            return decimal.divide(divisor);
        }

        return null;
    }

    private static Integer convertAndMultiply(BigDecimal value, BigDecimal multiplier) {

        if (value != null && multiplier != null){
            return value.multiply(multiplier).intValue();
        }

        return null;
    }

}
