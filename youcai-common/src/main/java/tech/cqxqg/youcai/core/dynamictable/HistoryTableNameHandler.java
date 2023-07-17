package tech.cqxqg.youcai.core.dynamictable;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class HistoryTableNameHandler implements TableNameHandler {

    //用于记录哪些表可以使用该月份动态表名处理器（即哪些表按月分表）
    private List<String> tableNames;

    //构造函数，构造动态表名处理器的时候，传递tableNames参数
    public HistoryTableNameHandler(String ...tableNames) {
        this.tableNames = Arrays.asList(tableNames);
    }

    /**
     * 生成动态表名
     *
     * @param sql       当前执行 SQL
     * @param tableName 表名
     * @return String
     */
    @Override
    public String dynamicTableName(String sql, String tableName) {
        String suffix = TableNameContextHolder.getHistory();
        if(StringUtils.isEmpty(suffix)) {
            return tableName;
        }
        if (this.tableNames.contains(tableName)){
            return tableName + "_" + suffix;  //表名增加history后缀
        }
        return tableName;   //表名原样返回
    }
}