package cn.com.moyu3390.core.fileservice.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.com.moyu3390.core.fileservice.protocol.FileBurstInstruct;

/**
 * 断点信息
 * @author admin
 *
 */
public class CacheUtil {

    /**
     * 缓存文件传输进度，实现断点续传
     */
    public static Map<String, FileBurstInstruct> burstDataMap = new ConcurrentHashMap<>();

}
