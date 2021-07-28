package com.chenghua.extendslite;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalString {

    /**
     * 底层值
     */
    private final String value;

    public OptionalString(String value) {
        this.value = value;
    }

    /**
     * 对外的非空操作
     * @param consumer 执行语句
     */
    public void ifNotBlank(Consumer<String> consumer){
        if (StringUtils.isNotBlank(value)){
            consumer.accept(value);
        }
    }

    /**
     * 对外的非null操作
     * @param consumer 执行语句
     */
    public void ifNotNull(Consumer<String> consumer){
        if (value != null){
            consumer.accept(value);
        }
    }

    /**
     * 非空
     * @return
     */
    public boolean isNotNull(){
        return value != null;
    }

    /**
     * 非空白
     * @return
     */
    public boolean isNotBlank(){
        return StringUtils.isNotBlank(value);
    }

    /**
     * 直接获取值
     * @return
     */
    public String get(){
        return value;
    }

    /**
     * 为空时
     * @param replace
     * @return
     */
    public String notNullOrElse(String replace){
        return isNotNull() ? value : replace;
    }

    /**
     * 为空白时
     * @param replace
     * @return
     */
    public String notBlankOrElse(String replace){
        return isNotBlank() ? value : replace;
    }

    /**
     * 为空时
     * @param supplier
     * @return
     */
    public String notNullOrElseGet(Supplier<String> supplier){
        return isNotNull() ? value : supplier.get();
    }

    /**
     * 为空白时
     * @param supplier
     * @return
     */
    public String notBlankOrElseGet(Supplier<String> supplier){
        return isNotBlank() ? value : supplier.get();
    }

    /**
     * 为空时
     * @param supplier
     * @return
     */
    public String notNullOrElseThrow(Supplier<Exception> supplier) throws Exception {
        if (isNotNull()){
            return value;
        }
        throw supplier.get();
    }

    /**
     * 为空白时
     * @param supplier
     * @return
     */
    public String notBlankOrElseThrow(Supplier<Exception> supplier) throws Exception {
        if (isNotBlank()){
            return value;
        }
        throw supplier.get();
    }
}
