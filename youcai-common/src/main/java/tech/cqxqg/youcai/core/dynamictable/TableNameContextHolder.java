/**
 * Copyright (C), 2018 store
 * File Name: ChannelContextHolder.java
 * Encoding: UTF-8
 * Date: 18-9-13 上午9:17
 * History:
 */
package tech.cqxqg.youcai.core.dynamictable;


import java.util.Objects;
import java.util.Stack;

/**
 * 动态表上下文
 * @author colley.ma
 * @since 2022/10/28 09:28
 */
public class TableNameContextHolder {
    private static final ThreadLocal<HistoryContext> threadVar = ThreadLocal.withInitial(() -> new HistoryContext());

    public static void setHistoryTag(String history) {
        if(Objects.isNull(threadVar.get())){
            threadVar.set(new HistoryContext());
        }
        threadVar.get().setHistoryTag(history);
    }

    //删除当前请求线程的History数据
    public static void remove() {
       HistoryContext context =  threadVar.get();
       if(Objects.nonNull(context)){
           context.remove();
           if(context.isEmpty()){
               threadVar.remove();
           }
       }else{
           threadVar.remove();
       }
    }

    public static String getHistory() {
        HistoryContext context = threadVar.get();
        if(Objects.nonNull(context)){
            return context.getHistory();
        }
        return null;
    }

    public static class  HistoryContext {
        private Stack<String> historyTags = new Stack<>();
        private String getHistory() {
            if(historyTags.isEmpty()){
                return null;
            }
            return historyTags.peek();
        }

        public void  setHistoryTag(String history) {
            historyTags.push(history);
        }

        public  void remove() {
           if(isEmpty()){
               return;
           }
           historyTags.pop();
        }

        public boolean isEmpty() {
            return historyTags.isEmpty();
        }
    }
}

