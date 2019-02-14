package com.ocr.ocr_frame.service;

import com.ocr.ocr_frame.mapping.Entry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * author:pan le
 * Date:2019/2/14
 * Time:10:42
 * 递归解析基本条目,形成list数据集
 */
@Service
public class EntryAnalysis {

    @Value("${}")
    private String batchRegular;
    private Pattern batchPattern = Pattern.compile(batchRegular);

    @Value("${}")
    private String academicRegular;
    private Pattern academicPattern = Pattern.compile(academicRegular);

    @Value("${}")
    private String collegeRegular;
    private Pattern collegePattern = Pattern.compile(collegeRegular);

    @Value("${}")
    private String majorRegular;
    private Pattern majorPattern = Pattern.compile(majorRegular);

    private List<Entry> entries = new ArrayList<>();
    private List<List<Entry>> entryList = new ArrayList<>();

    // batch list
//    List<Entry> analysis(String content) {
//        Entry entry = new Entry();
//        List<String> cons = new ArrayList<>();
//        for (String str : content.split("\n")) {
//            if (batchPattern.matcher(str).find()) {
//                entry = Entry.builder().title(str).content(cons).build();
//                cons.clear();
//            } else {
//                cons.add(str);
//            }
//            entries.add(entry);
//        }
//        entryList.add(entries);
//        return entries;
//    }
    //







}
