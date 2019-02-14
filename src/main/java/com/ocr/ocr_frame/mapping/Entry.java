package com.ocr.ocr_frame.mapping;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author:pan le
 * Date:2019/2/14
 * Time:10:07
 * 存储基本条目,不需要持久化
 */
@Builder
@Data
@NoArgsConstructor
public class Entry {
    private String title;
    private List<String> content;
    private List<Entry> entryLists;
}
